package ra.edu.service.candidate;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ra.edu.entity.candidate.CandidateTechnology;
import ra.edu.repository.candidate.CandidateTechnologyRepo;

@Service
@RequiredArgsConstructor
public class CandidateTechnologyServiceImpl implements CandidateTechnologyService {

    private final CandidateTechnologyRepo candidateTechnologyRepo;

    @Override
    public void deleteByCandidateId(int candidateId) {
        candidateTechnologyRepo.deleteByCandidateId(candidateId);
    }

    @Override
    public void save(CandidateTechnology candidateTechnology) {
        candidateTechnologyRepo.save(candidateTechnology);
    }
}
