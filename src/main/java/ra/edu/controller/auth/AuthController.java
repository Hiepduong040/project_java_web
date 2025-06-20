package ra.edu.controller.auth;

import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ra.edu.dto.auth.AuthDTO;
import ra.edu.entity.admin.Technology;
import ra.edu.entity.auth.Admin;
import ra.edu.entity.candidate.Candidate;
import ra.edu.entity.candidate.CandidateTechnology;
import ra.edu.service.auth.AuthService;
import ra.edu.service.candidate.CandidateService;
import ra.edu.service.candidate.CandidateTechnologyService;
import ra.edu.service.admin.TechnologyService;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    private final AuthService authService;
    private final CandidateService candidateService;
    private final TechnologyService technologyService;
    private final CandidateTechnologyService candidateTechnologyService;

    @GetMapping("/login")
    public String loginForm(Model model,
                            @CookieValue(value = "rememberEmail", defaultValue = "") String email) {
        AuthDTO authDTO = new AuthDTO();
        authDTO.setEmail(email);
        model.addAttribute("auth", authDTO);
        return "auth/admin_login";
    }

    @PostMapping("/login")
    public String login(
            @ModelAttribute("auth") @Valid AuthDTO authDTO,
            BindingResult bindingResult,
            @RequestParam(required = false) String rememberMe,
            HttpServletRequest request,
            HttpServletResponse response,
            Model model) {
        if (bindingResult.hasErrors()) {
            return "auth/admin_login";
        }

        // Kiểm tra trong bảng admin
        Admin admin = authService.login(authDTO.getEmail(), authDTO.getPassword());
        if (admin != null) {
            if ("on".equals(rememberMe)) {
                String token = UUID.randomUUID().toString();
                admin.setRememberToken(token);
                authService.saveOrUpdate(admin);

                Cookie tokenCookie = new Cookie("remember_token", token);
                tokenCookie.setMaxAge(7 * 24 * 60 * 60);
                tokenCookie.setPath("/");
                tokenCookie.setHttpOnly(true);
                tokenCookie.setSecure(true);
                response.addCookie(tokenCookie);
            }

            Cookie emailCookie = new Cookie("rememberEmail", authDTO.getEmail());
            emailCookie.setMaxAge("on".equals(rememberMe) ? 7 * 24 * 60 * 60 : 0);
            emailCookie.setPath("/");
            emailCookie.setHttpOnly(true);
            emailCookie.setSecure(true);
            response.addCookie(emailCookie);

            return "redirect:/admin/dashboard";
        }

        // Kiểm tra trong bảng candidate
        Candidate candidate = candidateService.findByEmailAndPassword(authDTO.getEmail(), authDTO.getPassword());
        if (candidate != null) {
            String token = UUID.randomUUID().toString();
            candidate.setRememberToken(token);
            candidateService.saveOrUpdate(candidate);

            Cookie tokenCookie = new Cookie("remember_token", token);
            tokenCookie.setMaxAge("on".equals(rememberMe) ? 7 * 24 * 60 * 60 : -1);
            tokenCookie.setPath("/");
            tokenCookie.setHttpOnly(true);
            tokenCookie.setSecure(true);
            response.addCookie(tokenCookie);

            Cookie emailCookie = new Cookie("rememberEmail", candidate.getEmail());
            emailCookie.setMaxAge("on".equals(rememberMe) ? 7 * 24 * 60 * 60 : -1);
            emailCookie.setPath("/");
            response.addCookie(emailCookie);

            Cookie nameCookie = new Cookie("userName", candidate.getName());
            nameCookie.setMaxAge("on".equals(rememberMe) ? 7 * 24 * 60 * 60 : -1);
            nameCookie.setPath("/");
            response.addCookie(nameCookie);

            return "redirect:/home";
        }

        model.addAttribute("error", "Email hoặc mật khẩu không đúng");
        return "auth/admin_login";
    }

    @GetMapping("/home")
    public String getHomePage(
            @CookieValue(value = "rememberEmail", defaultValue = "") String email,
            @CookieValue(value = "remember_token", defaultValue = "") String token,
            Model model) {
        if (!email.isEmpty() && !token.isEmpty()) {
            Candidate candidate = candidateService.findByEmailAndToken(email, token);
            if (candidate != null) {
                model.addAttribute("userName", candidate.getName());
                return "candidate/home";
            }
        }
        model.addAttribute("userName", null);
        return "candidate/home";
    }

    @GetMapping("/information")
    public String getInformation(
            @CookieValue(value = "rememberEmail", defaultValue = "") String email,
            @CookieValue(value = "remember_token", defaultValue = "") String token,
            Model model) {
        if (!email.isEmpty() && !token.isEmpty()) {
            Candidate candidate = candidateService.findByEmailAndToken(email, token);
            if (candidate != null) {
                model.addAttribute("userName", candidate.getName());
                model.addAttribute("candidate", candidate);
                model.addAttribute("allTechnologies", technologyService.findAllTechnology());
                List<Integer> selectedTechnologyIds = candidate.getCandidateTechnologies()
                        .stream()
                        .map(ct -> ct.getTechnology().getId())
                        .collect(Collectors.toList());
                model.addAttribute("selectedTechnologyIds", selectedTechnologyIds);
                System.out.println("Selected Technology IDs: " + selectedTechnologyIds);
                return "candidate/information";
            }
        }
        return "redirect:/login";
    }

    @PostMapping("/information/update")
    @Transactional
    public String updateInformation(
            @ModelAttribute("candidate") @Valid Candidate candidate,
            BindingResult bindingResult,
            @RequestParam(value = "technologies", required = false) List<Integer> technologyIds,
            @CookieValue(value = "rememberEmail", defaultValue = "") String email,
            @CookieValue(value = "remember_token", defaultValue = "") String token,
            HttpServletResponse response,
            Model model,
            RedirectAttributes redirectAttributes
    ) {
        if (email.isEmpty() || token.isEmpty()) {
            return "redirect:/login";
        }

        Candidate existingCandidate = candidateService.findByEmailAndToken(email, token);
        if (existingCandidate == null) {
            return "redirect:/login";
        }

        model.addAttribute("userName", existingCandidate.getName());
        model.addAttribute("candidate", existingCandidate);
        model.addAttribute("allTechnologies", technologyService.findAllTechnology());
        List<Integer> selectedTechnologyIds = existingCandidate.getCandidateTechnologies()
                .stream()
                .map(ct -> ct.getTechnology().getId())
                .collect(Collectors.toList());
        model.addAttribute("selectedTechnologyIds", selectedTechnologyIds);

        if (bindingResult.hasErrors()) {
            model.addAttribute("error", "Vui lòng kiểm tra lại thông tin nhập vào.");
            return "candidate/information";
        }

        if (technologyIds == null || technologyIds.isEmpty()) {
            model.addAttribute("error", "Vui lòng chọn ít nhất một công nghệ.");
            return "candidate/information";
        }

        try {
            // Update candidate information
            existingCandidate.setName(candidate.getName());
            existingCandidate.setExperience(candidate.getExperience());
            existingCandidate.setGender(candidate.getGender());
            existingCandidate.setDob(candidate.getDob());
            existingCandidate.setDescription(candidate.getDescription());

            // Save technology IDs to cookie with URL encoding
            String techIdsString = technologyIds.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(","));
            String encodedTechIds = URLEncoder.encode(techIdsString, StandardCharsets.UTF_8.toString());
            Cookie techCookie = new Cookie("selectedTechIds", encodedTechIds);
            techCookie.setMaxAge(7 * 24 * 60 * 60);
            techCookie.setPath("/");
            techCookie.setHttpOnly(true);
            techCookie.setSecure(true);
            response.addCookie(techCookie);

            // Save candidate ID to cookie
            Cookie candidateIdCookie = new Cookie("candidateId", String.valueOf(existingCandidate.getId()));
            candidateIdCookie.setMaxAge(7 * 24 * 60 * 60);
            candidateIdCookie.setPath("/");
            candidateIdCookie.setHttpOnly(true);
            candidateIdCookie.setSecure(true);
            response.addCookie(candidateIdCookie);

            // Delete existing CandidateTechnology records
            candidateTechnologyService.deleteByCandidateId(existingCandidate.getId());

            // Decode cookie value and insert new CandidateTechnology records
            String decodedTechIds = URLDecoder.decode(encodedTechIds, StandardCharsets.UTF_8.toString());
            String[] techIdArray = decodedTechIds.split(",");
            for (String techId : techIdArray) {
                Integer technologyId = Integer.parseInt(techId.trim());
                Technology technology = technologyService.findTechnologyById(technologyId);
                if (technology == null) {
                    model.addAttribute("error", "Công nghệ với ID " + technologyId + " không tồn tại.");
                    return "candidate/information";
                }
                CandidateTechnology candidateTechnology = new CandidateTechnology();
                candidateTechnology.setCandidate(existingCandidate);
                candidateTechnology.setTechnology(technology);
                candidateTechnologyService.save(candidateTechnology);
            }

            candidateService.saveOrUpdate(existingCandidate);
            model.addAttribute("success", "Cập nhật thông tin thành công.");
            selectedTechnologyIds = technologyIds;
//            model.addAttribute("selectedTechnologyIds", selectedTechnologyIds);
            redirectAttributes.addFlashAttribute("success", "Cập nhật thông tin thành công.");
            return "redirect:/information";

        } catch (Exception e) {
            model.addAttribute("error", "Lỗi khi cập nhật thông tin: " + e.getMessage());
            return "redirect:/information";

        }
    }

    @PostMapping("/information/change-password")
    @Transactional
    public String changePassword(
            @RequestParam(value = "oldPassword", required = false) String oldPassword,
            @RequestParam(value = "newPassword", required = false) String newPassword,
            @RequestParam(value = "confirmPassword", required = false) String confirmPassword,
            @CookieValue(value = "rememberEmail", defaultValue = "") String email,
            @CookieValue(value = "remember_token", defaultValue = "") String token,
            Model model,
            RedirectAttributes redirectAttributes) {
        if (email.isEmpty() || token.isEmpty()) {
            return "redirect:/login";
        }

        Candidate existingCandidate = candidateService.findByEmailAndToken(email, token);
        if (existingCandidate == null) {
            return "redirect:/login";
        }

        model.addAttribute("userName", existingCandidate.getName());
        model.addAttribute("candidate", existingCandidate);
        model.addAttribute("allTechnologies", technologyService.findAllTechnology());
        List<Integer> selectedTechnologyIds = existingCandidate.getCandidateTechnologies()
                .stream()
                .map(ct -> ct.getTechnology().getId())
                .collect(Collectors.toList());
        model.addAttribute("selectedTechnologyIds", selectedTechnologyIds);

        if (oldPassword == null || oldPassword.isEmpty()) {
            model.addAttribute("error", "Vui lòng nhập mật khẩu cũ.");
            return "candidate/information";
        }
        if (!BCrypt.checkpw(oldPassword, existingCandidate.getPassword())) {
            model.addAttribute("error", "Mật khẩu cũ không chính xác.");
            return "candidate/information";
        }
        if (newPassword == null || newPassword.isEmpty()) {
            model.addAttribute("error", "Vui lòng nhập mật khẩu mới.");
            return "candidate/information";
        }
        if (!newPassword.equals(confirmPassword)) {
            model.addAttribute("error", "Xác nhận mật khẩu không khớp.");
            return "candidate/information";
        }

        try {
            existingCandidate.setPassword(BCrypt.hashpw(newPassword, BCrypt.gensalt()));
            candidateService.saveOrUpdate(existingCandidate);
            redirectAttributes.addFlashAttribute("success", "Đổi mật khẩu thành công.");
            return "redirect:/information";

        } catch (Exception e) {
            model.addAttribute("error", "Lỗi khi đổi mật khẩu: " + e.getMessage());
            return "redirect:/information";

        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        String email = null;
        String token = null;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("rememberEmail".equals(cookie.getName())) {
                    email = cookie.getValue();
                } else if ("remember_token".equals(cookie.getName())) {
                    token = cookie.getValue();
                }
            }
        }

        if (email != null && token != null) {
            Candidate candidate = candidateService.findByEmailAndToken(email, token);
            if (candidate != null) {
                candidate.setRememberToken(null);
                candidateService.saveOrUpdate(candidate);
            }
        }

        String[] cookieNames = {"rememberEmail", "remember_token", "userName", "selectedTechIds", "candidateId"};
        for (String cookieName : cookieNames) {
            Cookie cookie = new Cookie(cookieName, null);
            cookie.setMaxAge(0);
            cookie.setPath("/");
            response.addCookie(cookie);
        }

        return "redirect:/login";
    }
}