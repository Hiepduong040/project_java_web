package ra.edu.dto.candidate;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
public class CandidateDTO {
    private int id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password is required")
    @Length(min = 6, message = "Password must be at least 6 characters")
    private String password;

    @NotBlank(message = "Confirm password is required")
    @Length(min = 6, message = "Confirm password must be at least 6 characters")
    private String confirmPassword;

    private String phone;

    private Integer experience; // Sử dụng Integer thay vì int để cho phép null

    private String gender; // Không cần @NotBlank

    private String status = "Active"; // Default status

    private String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob; // Không cần @NotNull
}
