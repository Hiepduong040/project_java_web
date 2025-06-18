package ra.edu.repository.candidate;

import ra.edu.entity.candidate.CandidateTechnology;

public interface CandidateTechnologyRepo {
    void deleteByCandidateId(int candidateId);
    void save(CandidateTechnology candidateTechnology);
}
