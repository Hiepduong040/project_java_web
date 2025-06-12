package ra.edu.entity.admin;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "recruitment_position_technology")
public class RecruitmentPositionTechnology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "recruitment_position_id", nullable = false)
    private RecruitmentPosition recruitmentPosition;

    @ManyToOne
    @JoinColumn(name = "technology_id", nullable = false)
    private Technology technology;
}

