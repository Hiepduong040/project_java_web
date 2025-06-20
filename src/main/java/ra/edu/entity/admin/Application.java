//package ra.edu.entity.admin;
//
//import ra.edu.entity.candidate.Candidate;
//import lombok.Getter;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.time.LocalDateTime;
//
//@Entity
//@Getter
//@Setter
//@Table(name = "application")
//public class Application {
//
//    public enum Progress {
//        PENDING, HANDLING, INTERVIEWING, DONE
//    }
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    @ManyToOne
//    @JoinColumn(name = "candidate_id", nullable = false)
//    private Candidate candidate;
//
//    @ManyToOne
//    @JoinColumn(name = "recruitment_position_id", nullable = false)
//    private RecruitmentPosition recruitmentPosition;
//
//    @Column(length = 255, nullable = false)
//    private String cvUrl;
//
//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false)
//    private Progress progress = Progress.PENDING;
//
//    private LocalDateTime interviewRequestDate;
//
//    @Column(length = 100)
//    private String interviewRequestResult;
//
//    @Column(length = 255)
//    private String interviewLink;
//
//    private LocalDateTime interviewTime;
//
//    @Column(length = 50)
//    private String interviewResult;
//
//    @Lob
//    private String interviewResultNote;
//
//    private LocalDateTime destroyAt;
//
//    @Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
//    private LocalDateTime createAt;
//
//    @Column(columnDefinition = "DATETIME ON UPDATE CURRENT_TIMESTAMP")
//    private LocalDateTime updateAt;
//
//    @Lob
//    private String destroyReason;
//}



package ra.edu.entity.admin;

import lombok.Getter;
import lombok.Setter;
import ra.edu.entity.candidate.Candidate;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Getter
@Setter
@Table(name = "application")
public class Application {

    public enum Progress {
        PENDING, HANDLING, INTERVIEWING, DONE, FINISHED
    }

    public enum Status {
        ACTIVE, REJECTED, CANCELED
    }

    public enum ConfirmStatus {
        CONFIRMED, NOT_CONFIRMED
    }

    public enum InterviewResult {
        PASSED, FAILED, WAITING
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "candidate_id", nullable = false)
    private Candidate candidate;

    @ManyToOne
    @JoinColumn(name = "recruitment_position_id", nullable = false)
    private RecruitmentPosition recruitmentPosition;

    @Column(length = 255, nullable = false)
    private String cvUrl;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Progress progress = Progress.PENDING;

    private LocalDateTime interviewDateRequest;

    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private ConfirmStatus candidateConfirmed = ConfirmStatus.NOT_CONFIRMED;

    @Column(length = 255)
    private String interviewUrl;

    private LocalDateTime interviewDate;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private InterviewResult interviewResult = InterviewResult.WAITING;

    @Lob
    private String resultNote;

    @Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(columnDefinition = "DATETIME ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Status status = Status.ACTIVE;

    private LocalDateTime canceledAt;

    private boolean isDeleted = false;

    private LocalDateTime deletedAt;

    @Lob
    private String canceledReason;
    public String getInterviewDateFormatted() {
        if (interviewDate == null) return "";
        return interviewDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
    private Integer firstViewedBy; // Lưu id của admin đầu tiên xem
}
