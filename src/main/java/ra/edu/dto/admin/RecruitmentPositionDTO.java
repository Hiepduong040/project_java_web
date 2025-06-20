package ra.edu.dto.admin;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Data
public class RecruitmentPositionDTO {
    private int id;

    @NotBlank(message = "Tên không được để trống")
    @Size(max = 100, message = "Tên không được vượt quá 100 ký tự")
    private String name;

    private String description;

    @NotNull(message = "Lương tối thiểu không được để trống")
    @DecimalMin(value = "0.0", inclusive = false, message = "Lương tối thiểu phải lớn hơn 0")
    private BigDecimal minSalary;

    @NotNull(message = "Lương tối đa không được để trống")
    @DecimalMin(value = "0.0", inclusive = false, message = "Lương tối đa phải lớn hơn 0")
    private BigDecimal maxSalary;

    @NotNull(message = "Kinh nghiệm tối thiểu không được để trống")
    @Min(value = 0, message = "Kinh nghiệm tối thiểu phải lớn hơn hoặc bằng 0")
    private Integer minExperience;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdDate;

    @NotNull(message = "Ngày hết hạn không được để trống")
    @FutureOrPresent(message = "Ngày hết hạn phải là hiện tại hoặc tương lai")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate expiredDate;

    @NotEmpty(message = "Phải chọn ít nhất một công nghệ")
    private List<Integer> technologyIds;

    private List<String> technologies;

    public String getCreatedDateFormatted() {
        if (createdDate == null) return "";
        return createdDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public String getExpiredDateFormatted() {
        if (expiredDate == null) return "";
        return expiredDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}