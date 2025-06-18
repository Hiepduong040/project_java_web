package ra.edu.service.candidate;

import ra.edu.entity.candidate.CandidateTechnology;

public interface CandidateTechnologyService {
        void deleteByCandidateId(int candidateId);
        void save(CandidateTechnology candidateTechnology);
}
