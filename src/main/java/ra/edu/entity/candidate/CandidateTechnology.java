package ra.edu.entity.candidate;

import lombok.Getter;
import lombok.Setter;
import ra.edu.entity.admin.Technology;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "candidate_technology")
public class CandidateTechnology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "candidate_id", nullable = false)
    private Candidate candidate;

    @ManyToOne
    @JoinColumn(name = "technology_id", nullable = false)
    private Technology technology;
}
