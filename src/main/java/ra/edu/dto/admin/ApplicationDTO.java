package ra.edu.dto.admin;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Data
public class ApplicationDTO {
    private int id;
    private int candidateId;
    private int recruitmentPositionId;
    private String cvUrl;
    private MultipartFile cvFile;
    private String progress; // Enum: pending, handling, interviewing, done
    private LocalDateTime interviewRequestDate;
    private String interviewRequestResult;
    private String interviewLink;
    private LocalDateTime interviewTime;
    private String interviewResult;
    private String interviewResultNote;
    private LocalDateTime destroyAt;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private String destroyReason;
}
