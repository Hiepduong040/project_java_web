package ra.edu.entity.admin;

import ra.edu.entity.candidate.Candidate;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "application")
public class Application {

    public enum Progress {
        PENDING, HANDLING, INTERVIEWING, DONE
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

    private LocalDateTime interviewRequestDate;

    @Column(length = 100)
    private String interviewRequestResult;

    @Column(length = 255)
    private String interviewLink;

    private LocalDateTime interviewTime;

    @Column(length = 50)
    private String interviewResult;

    @Lob
    private String interviewResultNote;

    private LocalDateTime destroyAt;

    @Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createAt;

    @Column(columnDefinition = "DATETIME ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime updateAt;

    @Lob
    private String destroyReason;
}
