package ra.edu.controller.candidate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ra.edu.entity.candidate.Candidate;
import ra.edu.service.candidate.CandidateService;
import ra.edu.service.admin.TechnologyService;

import java.util.List;

@Controller
@RequestMapping("/admin/candidate")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private TechnologyService technologyService;

    @GetMapping
    public String candidatePage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String search,
            @RequestParam(required = false) String technology,
            @RequestParam(required = false) String gender,
            @RequestParam(required = false) String age,
            @RequestParam(required = false) String experience,
            Model model) {

        int offset = page * size;
        List<Candidate> candidates = candidateService.findAllCandidatesWithFilters(offset, size, search, technology, gender, age, experience);
        long totalItems = candidateService.countAllCandidatesWithFilters(search, technology, gender, age, experience);
        int totalPages = (int) Math.ceil((double) totalItems / size);

        model.addAttribute("candidates", candidates);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("technologies", technologyService.findAllTechnology());
        model.addAttribute("search", search);
        // Add other filter values to maintain them in the form
        model.addAttribute("technology", technology);
        model.addAttribute("gender", gender);
        model.addAttribute("age", age);
        model.addAttribute("experience", experience);
        return "admin/candidate";
    }

    @PostMapping("/toggle-status")
    public String toggleCandidateStatus(@RequestParam("id") int id) {
        Candidate candidate = candidateService.findById(id);
        if (candidate != null) {
            candidate.setStatus(candidate.getStatus().equals("Active") ? "Deactivate" : "Active");
            candidateService.save(candidate);
        }
        return "redirect:/admin/candidate";
    }
}



//package ra.edu.controller.candidate;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import ra.edu.entity.candidate.Candidate;
//import ra.edu.service.candidate.CandidateService;
//import ra.edu.service.admin.TechnologyService;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/admin/candidate")
//public class CandidateController {
//
//    @Autowired
//    private CandidateService candidateService;
//
//    @Autowired
//    private TechnologyService technologyService;
//
//    @GetMapping
//    public String candidatePage(
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "7") int size,
//            @RequestParam(required = false) String search,
//            @RequestParam(required = false) String technology,
//            @RequestParam(required = false) String gender,
//            @RequestParam(required = false) String age,
//            @RequestParam(required = false) String experience,
//            Model model) {
//
//        int offset = page * size;
//        List<Candidate> candidates = candidateService.findAllCandidatesWithFilters(offset, size, search, technology, gender, age, experience);
//        long totalItems = candidateService.countAllCandidatesWithFilters(search, technology, gender, age, experience);
//        int totalPages = (int) Math.ceil((double) totalItems / size);
//
//        model.addAttribute("candidates", candidates);
//        model.addAttribute("currentPage", page);
//        model.addAttribute("totalPages", totalPages);
//        model.addAttribute("technologies", technologyService.findAllTechnology());
//        model.addAttribute("search", search);
//        // Add other filter values to maintain them in the form
//        model.addAttribute("technology", technology);
//        model.addAttribute("gender", gender);
//        model.addAttribute("age", age);
//        model.addAttribute("experience", experience);
//        return "admin/candidate";
//    }
//
//    @PostMapping("/toggle-status")
//    public String toggleCandidateStatus(@RequestParam("id") int id) {
//        Candidate candidate = candidateService.findById(id);
//        if (candidate != null) {
//            candidate.setStatus(candidate.getStatus().equals("Active") ? "Deactivate" : "Active");
//            candidateService.save(candidate);
//        }
//        return "redirect:/admin/candidate";
//    }
//}
//
