package ra.edu.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ra.edu.dto.admin.TechnologyDTO;
import ra.edu.entity.admin.Technology;
import ra.edu.service.admin.TechnologyService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/technology")
public class TechnologyController {

    private final TechnologyService technologyService;

    public TechnologyController(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @GetMapping
    public String technologyPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size, // Số mục trên mỗi trang
            @RequestParam(required = false) String search,
            Model model) {

        // Tính toán offset và limit cho phân trang thủ công
        int offset = page * size;
        List<Technology> technologies = technologyService.findAllTechnologyWithPagination(offset, size);
        long totalItems = technologyService.countAllTechnologies();
        int totalPages = (int) Math.ceil((double) totalItems / size);

        model.addAttribute("technologies", technologies);
        model.addAttribute("newTechnology", new TechnologyDTO());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        return "admin/technology";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("technologyDto", new TechnologyDTO());
        return "admin/addTechnology";
    }

    @PostMapping("/add")
    public String addTechnology(
            @Valid @ModelAttribute("technologyDto") TechnologyDTO technologyDTO,
            BindingResult result,
            RedirectAttributes redirectAttributes,
            Model model) {

        if (technologyService.existsByName(technologyDTO.getName())) {
            result.rejectValue("name", "duplicate", "Technology name already exists");
        }

        if (result.hasErrors()) {
            model.addAttribute("technologyDto", technologyDTO);
            return "admin/addTechnology";
        }

        Technology technology = new Technology();
        technology.setName(technologyDTO.getName());
        technologyService.saveTechnology(technology);

        redirectAttributes.addFlashAttribute("successMessage", "Technology added successfully!");
        return "redirect:/admin/technology";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Technology technology = technologyService.findTechnologyById(id);
        if (technology == null) {
            return "redirect:/admin/technology";
        }

        TechnologyDTO dto = new TechnologyDTO();
        dto.setId(technology.getId());
        dto.setName(technology.getName());
        model.addAttribute("technologyDto", dto);
        return "admin/editTechnology";
    }

    @PostMapping("/update/{id}")
    public String updateTechnology(
            @PathVariable("id") int id,
            @Valid @ModelAttribute("technologyDto") TechnologyDTO technologyDTO,
            BindingResult result,
            RedirectAttributes redirectAttributes,
            Model model) {

        if (technologyService.existsByNameExcludingId(technologyDTO.getName(), id)) {
            result.rejectValue("name", "duplicate", "Technology name already exists");
        }

        if (result.hasErrors()) {
            model.addAttribute("technologyDto", technologyDTO);
            return "admin/editTechnology";
        }

        Technology technology = new Technology();
        technology.setId(id);
        technology.setName(technologyDTO.getName());
        technologyService.updateTechnology(technology);

        redirectAttributes.addFlashAttribute("successMessage", "Technology updated successfully!");
        return "redirect:/admin/technology?page=0&size=5"; // Quay lại trang đầu tiên sau khi cập nhật
    }

    @GetMapping("/delete/{id}")
    public String deleteTechnology(
            @PathVariable("id") int id,
            RedirectAttributes redirectAttributes) {

        int result = technologyService.deleteTechnology(id);
        if (result > 0) {
            redirectAttributes.addFlashAttribute("successMessage", "Technology deleted successfully!");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Failed to delete technology!");
        }
        return "redirect:/admin/technology?page=0&size=5"; // Quay lại trang đầu tiên sau khi xóa
    }
}



//
//package ra.edu.controller.admin;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//import ra.edu.dto.admin.TechnologyDTO;
//import ra.edu.entity.admin.Technology;
//import ra.edu.service.admin.TechnologyService;
//
//import javax.validation.Valid;
//import java.util.List;
//
//@Controller
//@RequestMapping("/admin/technology")
//public class TechnologyController {
//
//    private final TechnologyService technologyService;
//
//    public TechnologyController(TechnologyService technologyService) {
//        this.technologyService = technologyService;
//    }
//
//    @GetMapping
//    public String technologyPage(
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "10") int size,
//            @RequestParam(required = false) String search,
//            Model model) {
//
//        model.addAttribute("technologies", technologyService.findAllTechnology());
//        model.addAttribute("newTechnology", new TechnologyDTO());
//        return "admin/technology";
//    }
//
//    @GetMapping("/add")
//    public String showAddForm(Model model) {
//        model.addAttribute("technologyDto", new TechnologyDTO());
//        return "admin/addTechnology";
//    }
//
//    @PostMapping("/add")
//    public String addTechnology(
//            @Valid @ModelAttribute("technologyDto") TechnologyDTO technologyDTO,
//            BindingResult result,
//            RedirectAttributes redirectAttributes,
//            Model model) {
//
//        if (technologyService.existsByName(technologyDTO.getName())) {
//            result.rejectValue("name", "duplicate", "Technology name already exists");
//        }
//
//        if (result.hasErrors()) {
//            model.addAttribute("technologyDto", technologyDTO);
//            return "admin/addTechnology";
//        }
//
//        Technology technology = new Technology();
//        technology.setName(technologyDTO.getName());
//        technologyService.saveTechnology(technology);
//
//        redirectAttributes.addFlashAttribute("successMessage", "Technology added successfully!");
//        return "redirect:/admin/technology";
//    }
//
//
//
//
//    @GetMapping("/edit/{id}")
//    public String showEditForm(@PathVariable("id") int id, Model model) {
//        Technology technology = technologyService.findTechnologyById(id);
//        if (technology == null) {
//            return "redirect:/admin/technology";
//        }
//
//        TechnologyDTO dto = new TechnologyDTO();
//        dto.setId(technology.getId());
//        dto.setName(technology.getName());
//        model.addAttribute("technologyDto", dto);
//        return "admin/editTechnology";
//    }
//
//    @PostMapping("/update/{id}")
//    public String updateTechnology(
//            @PathVariable("id") int id,
//            @Valid @ModelAttribute("technologyDto") TechnologyDTO technologyDTO,
//            BindingResult result,
//            RedirectAttributes redirectAttributes,
//            Model model) {
//
//        // Check trùng tên nhưng bỏ qua bản ghi đang sửa
//        if (technologyService.existsByNameExcludingId(technologyDTO.getName(), id)) {
//            result.rejectValue("name", "duplicate", "Technology name already exists");
//        }
//
//        if (result.hasErrors()) {
//            model.addAttribute("technologyDto", technologyDTO);
//            return "admin/editTechnology";
//        }
//
//        Technology technology = new Technology();
//        technology.setId(id);
//        technology.setName(technologyDTO.getName());
//        technologyService.updateTechnology(technology);
//
//        redirectAttributes.addFlashAttribute("successMessage", "Technology updated successfully!");
//        return "redirect:/admin/technology";
//    }
//
//
//    @GetMapping("/delete/{id}")
//    public String deleteTechnology(
//            @PathVariable("id") int id,
//            RedirectAttributes redirectAttributes) {
//
//        int result = technologyService.deleteTechnology(id);
//        if (result > 0) {
//            redirectAttributes.addFlashAttribute("successMessage", "Technology deleted successfully!");
//        } else {
//            redirectAttributes.addFlashAttribute("errorMessage", "Failed to delete technology!");
//        }
//        return "redirect:/admin/technology";
//    }



