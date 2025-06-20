package ra.edu.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ra.edu.dto.admin.ApplicationDTO;
import ra.edu.entity.admin.Application;
import ra.edu.entity.admin.RecruitmentPosition;
import ra.edu.entity.candidate.Candidate;
import ra.edu.service.admin.ApplicationService;
import ra.edu.service.admin.RecruitmentPositionService;
import ra.edu.service.candidate.CandidateService;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin/application")
public class ApplicationController {
    private final ApplicationService applicationService;
    private final RecruitmentPositionService recruitmentPositionService;
    private final CandidateService candidateService;

    public ApplicationController(ApplicationService applicationService,
                                 RecruitmentPositionService recruitmentPositionService,
                                 CandidateService candidateService) {
        this.applicationService = applicationService;
        this.recruitmentPositionService = recruitmentPositionService;
        this.candidateService = candidateService;
    }

    @GetMapping
    public String getApplicationPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(required = false) String progress,
            Model model) {
        int offset = page * size;
        List<Application> applications;
        long totalItems;

        if (progress != null && !progress.isEmpty()) {
            applications = applicationService.findByProgressWithPagination(progress, offset, size);
            totalItems = applicationService.countByProgress(progress);
        } else {
            applications = applicationService.findAllWithPagination(offset, size);
            totalItems = applicationService.countAll();
        }

        int totalPages = (int) Math.ceil((double) totalItems / size);

        model.addAttribute("applications", applications);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("progress", progress);

        return "admin/application";
    }

    @PostMapping("/delete/{id}")
    public String deleteApplication(
            @PathVariable("id") int id,
            @RequestParam("canceledReason") String canceledReason,
            RedirectAttributes redirectAttributes) {
        Application application = applicationService.findById(id);
        if (application == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "Ứng dụng không tồn tại!");
            return "redirect:/admin/application";
        }

        application.setStatus(Application.Status.CANCELED);
        application.setCanceledReason(canceledReason);
        application.setCanceledAt(LocalDateTime.now());
        application.setDeleted(true);
        application.setDeletedAt(LocalDateTime.now());

        int result = applicationService.update(application);
        if (result > 0) {
            redirectAttributes.addFlashAttribute("successMessage", "Hủy ứng dụng thành công!");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Không thể hủy ứng dụng!");
        }
        return "redirect:/admin/application";
    }

    @PostMapping("/interview/{id}")
    public String scheduleInterview(
            @PathVariable("id") int id,
            @RequestParam("interviewUrl") String interviewUrl,
            @RequestParam("interviewDate") String interviewDate,
            RedirectAttributes redirectAttributes) {
        Application application = applicationService.findById(id);
        if (application == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "Ứng dụng không tồn tại!");
            return "redirect:/admin/application";
        }

        try {
            application.setInterviewUrl(interviewUrl);
            application.setInterviewDate(LocalDateTime.parse(interviewDate));
            application.setProgress(Application.Progress.INTERVIEWING);
            int result = applicationService.update(application);
            if (result > 0) {
                redirectAttributes.addFlashAttribute("successMessage", "Lên lịch phỏng vấn thành công!");
            } else {
                redirectAttributes.addFlashAttribute("errorMessage", "Không thể lên lịch phỏng vấn!");
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Lỗi định dạng thời gian phỏng vấn!");
        }
        return "redirect:/admin/application";
    }

    @PostMapping("/approve/{id}")
    public String approveInterview(
            @PathVariable("id") int id,
            @RequestParam("interviewResult") String interviewResult,
            @RequestParam("resultNote") String resultNote,
            RedirectAttributes redirectAttributes) {
        Application application = applicationService.findById(id);
        if (application == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "Ứng dụng không tồn tại!");
            return "redirect:/admin/application";
        }

        try {
            application.setInterviewResult(Application.InterviewResult.valueOf(interviewResult));
            application.setResultNote(resultNote);
            application.setProgress(Application.Progress.DONE);
            int result = applicationService.update(application);
            if (result > 0) {
                redirectAttributes.addFlashAttribute("successMessage", "Phê duyệt phỏng vấn thành công!");
            } else {
                redirectAttributes.addFlashAttribute("errorMessage", "Không thể phê duyệt phỏng vấn!");
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Lỗi dữ liệu kết quả phỏng vấn!");
        }
        return "redirect:/admin/application";
    }
}