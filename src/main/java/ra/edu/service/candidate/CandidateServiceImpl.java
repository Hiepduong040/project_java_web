package ra.edu.service.candidate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.edu.entity.candidate.Candidate;
import ra.edu.repository.candidate.CandidateRepo;

import java.util.List;

@Service
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    private CandidateRepo candidateRepo;

    @Override
    public List<Candidate> findAllCandidatesWithPagination(int offset, int size) {
        return candidateRepo.findAllWithPagination(offset, size);
    }

    @Override
    public long countAllCandidates() {
        return candidateRepo.countAll();
    }

    @Override
    public List<Candidate> findAllCandidatesWithFilters(int offset, int size, String search, String technology, String gender, String age, String experience) {
        return candidateRepo.findAllWithFilters(offset, size, search, technology, gender, age, experience);
    }

    @Override
    public long countAllCandidatesWithFilters(String search, String technology, String gender, String age, String experience) {
        return candidateRepo.countAllWithFilters(search, technology, gender, age, experience);
    }
}