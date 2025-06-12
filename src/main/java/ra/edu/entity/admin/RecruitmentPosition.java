package ra.edu.entity.admin;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "recruitment_position")
public class RecruitmentPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100, nullable = false)
    private String name;

    @Lob
    private String description;

    @Column(precision = 12, scale = 2)
    private BigDecimal minSalary;

    @Column(precision = 12, scale = 2)
    private BigDecimal maxSalary;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int minExperience;

    @Column(columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private LocalDate createdDate;

    @Column(nullable = false)
    private LocalDate expiredDate;

    @OneToMany(mappedBy = "recruitmentPosition", fetch = FetchType.LAZY)
    private List<RecruitmentPositionTechnology> recruitmentTechnologies;

    @OneToMany(mappedBy = "recruitmentPosition", fetch = FetchType.LAZY)
    private List<Application> applications;
}
