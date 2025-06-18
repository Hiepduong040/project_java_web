package ra.edu.entity.candidate;

import lombok.Getter;
import lombok.Setter;
import ra.edu.entity.admin.Application;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "candidate")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 100, nullable = false, unique = true)
    private String email;

    @Column(length = 255, nullable = false)
    private String password;

    @Column(length = 20)
    private String phone;

    @Column(columnDefinition = "INT")
    private Integer experience;

    @Column(length = 10)
    private String gender;

    @Column(length = 20, columnDefinition = "VARCHAR(20) DEFAULT 'active'")
    private String status;

    @Lob
    private String description;

    private LocalDate dob;

    @Column(name = "remember_token")
    private String rememberToken;

    // tai toan bo de tranh loi lazy-loader
    @OneToMany(mappedBy = "candidate", fetch = FetchType.EAGER)
    private List<CandidateTechnology> candidateTechnologies;
    @OneToMany(mappedBy = "candidate", fetch = FetchType.LAZY)
    private List<Application> applications;
}
