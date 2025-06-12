package ra.edu.interceptor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import ra.edu.entity.auth.Admin;
import ra.edu.repository.auth.AuthRepo;

import javax.servlet.http.*;
@Component
@RequiredArgsConstructor
public class AdminAuthInterceptor implements HandlerInterceptor {

    private final AuthRepo authRepo;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        HttpSession session = request.getSession(false);

        // ✅ Nếu đã đăng nhập thì cho qua
        if (session != null && session.getAttribute("admin") != null) {
            return true;
        }

        // ✅ Nếu chưa đăng nhập, kiểm tra cookie token
        Cookie[] cookies = request.getCookies();
        String rememberToken = null;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("remember_token".equals(cookie.getName())) {
                    rememberToken = cookie.getValue();
                    break;
                }
            }
        }

        if (rememberToken != null) {
            Admin admin = authRepo.findByRememberToken(rememberToken);
            if (admin != null) {
                // ✅ Khôi phục phiên làm việc
                session = request.getSession(true);
                session.setAttribute("admin", admin);
                return true;
            }
        }

        // ✅ Nếu không có session và không tìm được token thì redirect
        response.sendRedirect("/admin_login");
        return false;
    }
}
