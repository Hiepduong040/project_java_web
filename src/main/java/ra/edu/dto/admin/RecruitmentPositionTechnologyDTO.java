package ra.edu.dto.admin;

import lombok.Data;

@Data
public class RecruitmentPositionTechnologyDTO {
    private Long id; // Nếu bảng trung gian có ID riêng
    private int recruitmentPositionId;
    private int technologyId;
}
