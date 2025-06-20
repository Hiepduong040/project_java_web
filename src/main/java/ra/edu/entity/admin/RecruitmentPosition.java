//
//
//package ra.edu.entity.admin;
//
//import lombok.Data;
//
//import javax.persistence.*;
//import java.math.BigDecimal;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.List;
//
//@Entity
//@Table(name = "recruitment_position")
//@Data
//public class RecruitmentPosition {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    @Column(length = 100, nullable = false)
//    private String name;
//
//    @Column(columnDefinition = "TEXT")
//    private String description;
//
//    @Column(name = "min_salary", precision = 12, scale = 2)
//    private BigDecimal minSalary;
//
//    @Column(name = "max_salary", precision = 12, scale = 2)
//    private BigDecimal maxSalary;
//
//    @Column(name = "min_experience")
//    private int minExperience;
//
//    @Column(name = "created_date")
//    private LocalDate createdDate;
//
//    @Column(name = "expired_date", nullable = false)
//    private LocalDate expiredDate;
//
//    @OneToMany(mappedBy = "recruitmentPosition", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<RecruitmentPositionTechnology> recruitmentTechnologies;
//
//    public String getCreatedDateFormatted() {
//        if (createdDate == null) return "";
//        return createdDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//    }
//}


package ra.edu.entity.admin;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "recruitment_position")
@Data
public class RecruitmentPosition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "min_salary", precision = 12, scale = 2)
    private BigDecimal minSalary;

    @Column(name = "max_salary", precision = 12, scale = 2)
    private BigDecimal maxSalary;

    @Column(name = "min_experience")
    private int minExperience;

    @Column(name = "created_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdDate;

    @Column(name = "expired_date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate expiredDate;

//    @OneToMany(mappedBy = "recruitmentPosition", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<RecruitmentPositionTechnology> recruitmentTechnologies;

    public String getCreatedDateFormatted() {
        if (createdDate == null) return "";
        return createdDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
    @OneToMany(mappedBy = "recruitmentPosition", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecruitmentPositionTechnology> recruitmentTechnologies = new ArrayList<>();
}