package ra.edu.controller.auth;

import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ra.edu.dto.candidate.CandidateDTO;
import ra.edu.entity.candidate.Candidate;
import ra.edu.service.candidate.CandidateService;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/candidate")
public class CandidateAuthController {

    private final CandidateService candidateService;

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("candidate", new CandidateDTO());
        model.addAttribute("error", ""); // Khởi tạo mặc định để tránh lỗi Thymeleaf
        return "auth/candidate_register";
    }

    @PostMapping("/register")
    public String register(
            @ModelAttribute("candidate") @Valid CandidateDTO candidateDTO,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            return "auth/candidate_register";
        }

        // Kiểm tra mật khẩu và confirm password khớp
        if (!candidateDTO.getPassword().equals(candidateDTO.getConfirmPassword())) {
            model.addAttribute("error", "Passwords do not match");
            return "auth/candidate_register";
        }

        // Kiểm tra email đã tồn tại
        Candidate existingCandidate = candidateService.findByEmail(candidateDTO.getEmail());
        if (existingCandidate != null) {
            model.addAttribute("error", "Email already exists");
            return "auth/candidate_register";
        }

        // Tạo candidate mới
        Candidate candidate = new Candidate();
        candidate.setName(candidateDTO.getName());
        candidate.setEmail(candidateDTO.getEmail());
        candidate.setPassword(BCrypt.hashpw(candidateDTO.getPassword(), BCrypt.gensalt()));
        // Các trường khác để trống hoặc null
        candidate.setPhone(null);
        candidate.setExperience(null);
        candidate.setGender(null);
        candidate.setStatus("Active"); // Mặc định status
        candidate.setDescription(null);
        candidate.setDob(null);

        // Lưu vào cơ sở dữ liệu
        candidateService.save(candidate);

        model.addAttribute("success", "Registration successful! Please log in.");
        return "redirect:/auth/login"; // Giả định có endpoint login
    }
}