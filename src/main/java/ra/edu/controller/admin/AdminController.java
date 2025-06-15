package ra.edu.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @GetMapping("/admin")
    public String index() {
        return "admin/layout"; // Trả về layout chính
    }
    @GetMapping("/admin/dashboard")
    public String dashboard() {
        return "admin/dashboard";
    }
//    @GetMapping("/admin/technology")
//    public String technology() {
//        return "admin/technology"; // Trả về technology.html
//    }

}
