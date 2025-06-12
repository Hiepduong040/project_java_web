package ra.edu.dto.candidate;

import lombok.Data;

@Data
public class CandidateTechnologyDTO {
    private Long id; // Nếu có ID riêng
    private int candidateId;
    private int technologyId;
}
