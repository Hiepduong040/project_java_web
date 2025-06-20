package ra.edu.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ra.edu.dto.admin.RecruitmentPositionDTO;
import ra.edu.entity.admin.RecruitmentPosition;
import ra.edu.entity.admin.RecruitmentPositionTechnology;
import ra.edu.entity.admin.Technology;
import ra.edu.service.admin.RecruitmentPositionService;
import ra.edu.service.admin.TechnologyService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin/recruitment")
public class RecruitmentPositionController {
    private final RecruitmentPositionService recruitmentPositionService;
    private final TechnologyService technologyService;

    public RecruitmentPositionController(RecruitmentPositionService recruitmentPositionService, TechnologyService technologyService) {
        this.recruitmentPositionService = recruitmentPositionService;
        this.technologyService = technologyService;
    }

    @GetMapping
    public String recruitmentPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "7") int size,
            @RequestParam(required = false) String search,
            Model model) {
        int offset = page * size;
        List<RecruitmentPosition> positions = search != null && !search.isEmpty()
                ? recruitmentPositionService.findByNameContainingWithPagination(search, offset, size)
                : recruitmentPositionService.findAllWithPagination(offset, size);
        long totalItems = search != null && !search.isEmpty()
                ? recruitmentPositionService.countByNameContaining(search)
                : recruitmentPositionService.countAll();
        int totalPages = (int) Math.ceil((double) totalItems / size);

        List<Technology> technologies = technologyService.findAllTechnology();
        model.addAttribute("positions", positions);
        model.addAttribute("newPosition", new RecruitmentPositionDTO());
        model.addAttribute("technologies", technologies);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("search", search);

        return "admin/recruitment";
    }

    @PostMapping("/add")
    public String addPosition(
            @Valid @ModelAttribute("newPosition") RecruitmentPositionDTO positionDTO,
            BindingResult result,
            RedirectAttributes redirectAttributes,
            Model model) {
        if (recruitmentPositionService.existsByName(positionDTO.getName())) {
            result.rejectValue("name", "duplicate", "Tên vị trí đã tồn tại");
        }

        if (result.hasErrors()) {
            model.addAttribute("newPosition", positionDTO);
            model.addAttribute("technologies", technologyService.findAllTechnology());
            model.addAttribute("positions", recruitmentPositionService.findAllWithPagination(0, 7));
            model.addAttribute("currentPage", 0);
            model.addAttribute("totalPages", (int) Math.ceil((double) recruitmentPositionService.countAll() / 7));
            model.addAttribute("errorMessage", "Vui lòng kiểm tra lại các trường dữ liệu!");
            return "admin/recruitment";
        }

        RecruitmentPosition position = new RecruitmentPosition();
        position.setName(positionDTO.getName());
        position.setDescription(positionDTO.getDescription());
        position.setMinSalary(positionDTO.getMinSalary());
        position.setMaxSalary(positionDTO.getMaxSalary());
        position.setMinExperience(positionDTO.getMinExperience());
        position.setExpiredDate(positionDTO.getExpiredDate());

        if (positionDTO.getTechnologyIds() != null) {
            List<RecruitmentPositionTechnology> rptList = positionDTO.getTechnologyIds().stream()
                    .map(techId -> {
                        RecruitmentPositionTechnology rpt = new RecruitmentPositionTechnology();
                        Technology tech = new Technology();
                        tech.setId(techId);
                        rpt.setTechnology(tech);
                        rpt.setRecruitmentPosition(position);
                        return rpt;
                    }).collect(Collectors.toList());
            position.setRecruitmentTechnologies(rptList);
        }

        recruitmentPositionService.save(position);
        redirectAttributes.addFlashAttribute("successMessage", "Thêm vị trí thành công!");
        return "redirect:/admin/recruitment";
    }

//    @PostMapping("/update/{id}")
//    public String updatePosition(
//            @PathVariable("id") int id,
//            @Valid @ModelAttribute("positionDto") RecruitmentPositionDTO positionDTO,
//            BindingResult result,
//            RedirectAttributes redirectAttributes,
//            Model model) {
//        if (recruitmentPositionService.existsByNameExcludingId(positionDTO.getName(), id)) {
//            result.rejectValue("name", "duplicate", "Tên vị trí đã tồn tại");
//        }
//
//        if (result.hasErrors()) {
//            model.addAttribute("positionDto", positionDTO);
//            model.addAttribute("technologies", technologyService.findAllTechnology());
//            model.addAttribute("errorMessage", "Vui lòng kiểm tra lại các trường dữ liệu!");
//            return "admin/editRecruitment";
//        }
//
//        RecruitmentPosition position = recruitmentPositionService.findById(id);
//        if (position == null) {
//            redirectAttributes.addFlashAttribute("errorMessage", "Vị trí không tồn tại");
//            return "redirect:/admin/recruitment";
//        }
//
//        position.setName(positionDTO.getName());
//        position.setDescription(positionDTO.getDescription());
//        position.setMinSalary(positionDTO.getMinSalary());
//        position.setMaxSalary(positionDTO.getMaxSalary());
//        position.setMinExperience(positionDTO.getMinExperience());
//        position.setExpiredDate(positionDTO.getExpiredDate());
//
//        if (positionDTO.getTechnologyIds() != null) {
//            List<RecruitmentPositionTechnology> rptList = positionDTO.getTechnologyIds().stream()
//                    .map(techId -> {
//                        RecruitmentPositionTechnology rpt = new RecruitmentPositionTechnology();
//                        Technology tech = new Technology();
//                        tech.setId(techId);
//                        rpt.setTechnology(tech);
//                        rpt.setRecruitmentPosition(position);
//                        return rpt;
//                    }).collect(Collectors.toList());
//            position.setRecruitmentTechnologies(rptList);
//        } else {
//            position.setRecruitmentTechnologies(null);
//        }
//
//        recruitmentPositionService.update(position);
//        redirectAttributes.addFlashAttribute("successMessage", "Cập nhật vị trí thành công!");
//        return "redirect:/admin/recruitment?page=0&size=7";
//    }

    @PostMapping("/update/{id}")
    public String updatePosition(
            @PathVariable("id") int id,
            @Valid @ModelAttribute("positionDto") RecruitmentPositionDTO positionDTO,
            BindingResult result,
            RedirectAttributes redirectAttributes,
            Model model) {
        if (recruitmentPositionService.existsByNameExcludingId(positionDTO.getName(), id)) {
            result.rejectValue("name", "duplicate", "Tên vị trí đã tồn tại");
        }

        if (result.hasErrors()) {
            model.addAttribute("positionDto", positionDTO);
            model.addAttribute("technologies", technologyService.findAllTechnology());
            model.addAttribute("errorMessage", "Vui lòng kiểm tra lại các trường dữ liệu!");
            return "admin/editRecruitment";
        }

        RecruitmentPosition position = recruitmentPositionService.findById(id);
        if (position == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "Vị trí không tồn tại");
            return "redirect:/admin/recruitment";
        }

        position.setName(positionDTO.getName());
        position.setDescription(positionDTO.getDescription());
        position.setMinSalary(positionDTO.getMinSalary());
        position.setMaxSalary(positionDTO.getMaxSalary());
        position.setMinExperience(positionDTO.getMinExperience());
        position.setExpiredDate(positionDTO.getExpiredDate());

        // Xóa tất cả công nghệ cũ
        if (position.getRecruitmentTechnologies() != null) {
            position.getRecruitmentTechnologies().clear(); // Xóa các bản ghi cũ thông qua Hibernate
        }

        // Thêm công nghệ mới
        if (positionDTO.getTechnologyIds() != null && !positionDTO.getTechnologyIds().isEmpty()) {
            List<RecruitmentPositionTechnology> rptList = positionDTO.getTechnologyIds().stream()
                    .map(techId -> {
                        RecruitmentPositionTechnology rpt = new RecruitmentPositionTechnology();
                        Technology tech = new Technology();
                        tech.setId(techId);
                        rpt.setTechnology(tech);
                        rpt.setRecruitmentPosition(position);
                        return rpt;
                    }).collect(Collectors.toList());
            position.setRecruitmentTechnologies(rptList);
        }

        recruitmentPositionService.update(position);
        redirectAttributes.addFlashAttribute("successMessage", "Cập nhật vị trí thành công!");
        return "redirect:/admin/recruitment?page=0&size=7";
    }
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        RecruitmentPosition position = recruitmentPositionService.findById(id);
        if (position == null) {
            return "redirect:/admin/recruitment?errorMessage=Vị trí không tồn tại";
        }

        RecruitmentPositionDTO dto = new RecruitmentPositionDTO();
        dto.setId(position.getId());
        dto.setName(position.getName());
        dto.setDescription(position.getDescription());
        dto.setMinSalary(position.getMinSalary());
        dto.setMaxSalary(position.getMaxSalary());
        dto.setMinExperience(position.getMinExperience());
        dto.setCreatedDate(position.getCreatedDate());
        dto.setExpiredDate(position.getExpiredDate());
        dto.setTechnologyIds(
                position.getRecruitmentTechnologies().stream()
                        .map(rpt -> rpt.getTechnology().getId())
                        .collect(Collectors.toList())
        );

        model.addAttribute("positionDto", dto);
        model.addAttribute("technologies", technologyService.findAllTechnology());
        return "admin/editRecruitment";
    }

    @GetMapping("/delete/{id}")
    public String deletePosition(
            @PathVariable("id") int id,
            RedirectAttributes redirectAttributes) {
        RecruitmentPosition position = recruitmentPositionService.findById(id);
        if (position == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "Vị trí không tồn tại!");
            return "redirect:/admin/recruitment?page=0&size=7";
        }

        int result = recruitmentPositionService.delete(id);
        if (result > 0) {
            if (position.getName().endsWith("_deleted")) {
                redirectAttributes.addFlashAttribute("successMessage", "Đánh dấu xóa vị trí thành công!");
            } else {
                redirectAttributes.addFlashAttribute("successMessage", "Xóa vị trí thành công!");
            }
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Không thể xóa vị trí do có liên kết!");
        }
        return "redirect:/admin/recruitment?page=0&size=7";
    }
}