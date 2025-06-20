package ra.edu.dto.admin;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class ApplicationDTO {
    private int id;
    private int candidateId;
    private int recruitmentPositionId;
    private String cvUrl;
    private String progress; // Enum: PENDING, HANDLING, INTERVIEWING, DONE, FINISHED
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime interviewDateRequest;
    private String candidateConfirmed; // CONFIRMED or NOT_CONFIRMED
    private String interviewUrl;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime interviewDate;
    private String interviewResult; // PASSED, FAILED, WAITING
    private String resultNote;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime createdAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime updatedAt;
    private String status; // ACTIVE, REJECTED, CANCELED
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime canceledAt;
    private boolean isDeleted;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime deletedAt;
    private String canceledReason;
    private Integer firstViewedBy; // id của admin đầu tiên xem

    public String getCanceledAtFormatted() {
        if (canceledAt == null) return "";
        return canceledAt.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }

    public String getDeletedAtFormatted() {
        if (deletedAt == null) return "";
        return deletedAt.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }

    public String getInterviewDateFormatted() {
        if (interviewDate == null) return "";
        return interviewDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }

    public String getInterviewDateRequestFormatted() {
        if (interviewDateRequest == null) return "";
        return interviewDateRequest.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }

    public String getCreatedAtFormatted() {
        if (createdAt == null) return "";
        return createdAt.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }

    public String getUpdatedAtFormatted() {
        if (updatedAt == null) return "";
        return updatedAt.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }
}