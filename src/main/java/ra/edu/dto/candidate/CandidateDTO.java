package ra.edu.dto.candidate;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Data
public class CandidateDTO {
    private int id;
    private String name;
    private String email;
    private String password;
    private String phone;
    private int experience;
    private String gender;
    private String status;
    private String description;
    private LocalDate dob;
}
