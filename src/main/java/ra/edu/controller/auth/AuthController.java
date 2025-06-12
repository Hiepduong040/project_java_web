package ra.edu.controller.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.edu.dto.auth.AuthDTO;
import ra.edu.entity.auth.Admin;
import ra.edu.service.auth.AuthService;

import org.springframework.validation.BindingResult;
import javax.validation.Valid;
import javax.servlet.http.*;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @GetMapping("/admin_login")
    public String loginForm(Model model,
                            @CookieValue(value = "rememberEmailAdmin", defaultValue = "") String email) {
        AuthDTO authDTO = new AuthDTO();
        authDTO.setEmail(email); // Đặt sẵn email nếu đã lưu trong cookie
        model.addAttribute("auth", authDTO);
        return "auth/admin_login";
    }

    @PostMapping("/admin_login")
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

        Admin admin = authService.login(authDTO.getEmail(), authDTO.getPassword());
        if (admin == null) {
            model.addAttribute("error", "Invalid email or password");
            return "auth/admin_login";
        }

        // Tạo session mới
        HttpSession session = request.getSession();
        session.setAttribute("admin", admin);

        // Ghi nhớ email vào cookie (UI tiện lợi)
        Cookie emailCookie = new Cookie("rememberEmailAdmin", authDTO.getEmail());
        emailCookie.setMaxAge("on".equals(rememberMe) ? 7 * 24 * 60 * 60 : 0);
        emailCookie.setPath("/");
        response.addCookie(emailCookie);

        // ✅ Thêm: Tạo remember_token nếu chọn ghi nhớ đăng nhập
        if ("on".equals(rememberMe)) {
            String token = UUID.randomUUID().toString();
            admin.setRememberToken(token);
            authService.saveOrUpdate(admin); // Cập nhật token vào DB

            Cookie tokenCookie = new Cookie("remember_token", token);
            tokenCookie.setMaxAge(7 * 24 * 60 * 60);
            tokenCookie.setPath("/");
            response.addCookie(tokenCookie);
        }

        return "redirect:/admin/dashboard";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session,
                         HttpServletRequest request,
                         HttpServletResponse response) {
        Admin admin = (Admin) session.getAttribute("admin");

        // ✅ Nếu đã đăng nhập, xóa token khỏi DB
        if (admin != null) {
            admin.setRememberToken(null);
            authService.saveOrUpdate(admin);
        }

        session.invalidate();

        // Xóa các cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("rememberEmailAdmin".equals(cookie.getName())
                        || "remember_token".equals(cookie.getName())) {
                    cookie.setValue(null);
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                }
            }
        }

        return "redirect:/admin_login";
    }
}
