package ra.edu.dto.admin;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
public class RecruitmentPositionDTO {
    private int id;
    private String name;
    private String description;
    private BigDecimal minSalary;
    private BigDecimal maxSalary;
    private int minExperience;
    private LocalDate createdDate;
    private LocalDate expiredDate;
    private List<Integer> technologyIds; // Nếu bạn muốn gửi các tech ID đi kèm
}
