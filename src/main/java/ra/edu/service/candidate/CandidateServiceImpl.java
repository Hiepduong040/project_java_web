package ra.edu.service.candidate;

import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import ra.edu.entity.candidate.Candidate;
import ra.edu.repository.candidate.CandidateRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidateServiceImpl implements CandidateService {
    private final CandidateRepo candidateRepo;

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

    @Override
    public Candidate findById(int id) {
        return candidateRepo.findById(id);
    }

    @Override
    public void save(Candidate candidate) {
        candidateRepo.save(candidate);
    }

    @Override
    public void saveOrUpdate(Candidate candidate) {
        candidateRepo.save(candidate);
    }

    @Override
    public Candidate findByEmail(String email) {
        return candidateRepo.findByEmail(email);
    }

    @Override
    public Candidate findByEmailAndPassword(String email, String password) {
        Candidate candidate = candidateRepo.findByEmail(email);
        if (candidate != null && BCrypt.checkpw(password, candidate.getPassword())) {
            return candidate;
        }
        return null;
    }

    @Override
    public Candidate findByEmailAndToken(String email, String token) {
        Candidate candidate = candidateRepo.findByEmail(email);
        if (candidate != null && token.equals(candidate.getRememberToken())) {
            return candidate;
        }
        return null;
    }
}