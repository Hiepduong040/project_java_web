package ra.edu.controller.auth;

import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ra.edu.dto.auth.AuthDTO;
import ra.edu.entity.auth.Admin;
import ra.edu.entity.candidate.Candidate;
import ra.edu.service.auth.AuthService;
import ra.edu.service.candidate.CandidateService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final CandidateService candidateService;

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
            // Tạo token và lưu vào cookies
            String token = UUID.randomUUID().toString();

            // Lưu token vào database
            candidate.setRememberToken(token);
            candidateService.saveOrUpdate(candidate);

            // Tạo cookies
            Cookie tokenCookie = new Cookie("remember_token", token);
            tokenCookie.setMaxAge("on".equals(rememberMe) ? 7 * 24 * 60 * 60 : -1); // -1: session cookie
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

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        // Xóa thông tin remember token từ database nếu có
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

        // Xóa tất cả cookies liên quan
        String[] cookieNames = {"rememberEmail", "remember_token", "userName"};
        for (String cookieName : cookieNames) {
            Cookie cookie = new Cookie(cookieName, null);
            cookie.setMaxAge(0);
            cookie.setPath("/");
            response.addCookie(cookie);
        }

        return "redirect:/login";
    }
}


