package ra.edu.dto.admin;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class TechnologyDTO {
    private Integer id;

    @NotBlank(message = "Technology name must not be empty")
    @Size(min = 3, max = 10, message = "Technology name must be between 3 and 10 characters")
    private String name;
}
