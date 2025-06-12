package ra.edu.entity.admin;

import lombok.Getter;
import lombok.Setter;
import ra.edu.entity.candidate.CandidateTechnology;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "technology")
public class Technology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true, length = 100)
    private String name;

    @OneToMany(mappedBy = "technology", fetch = FetchType.LAZY)
    private List<CandidateTechnology> candidateTechnologies;

    @OneToMany(mappedBy = "technology", fetch = FetchType.LAZY)
    private List<RecruitmentPositionTechnology> recruitmentTechnologies;
}

