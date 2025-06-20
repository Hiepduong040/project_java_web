package ra.edu.service.candidate;

import ra.edu.entity.candidate.Candidate;

import java.util.List;

public interface CandidateService {
    List<Candidate> findAllCandidatesWithPagination(int offset, int size);
    long countAllCandidates();
    List<Candidate> findAllCandidatesWithFilters(int offset, int size, String search, String technology, String gender, String age, String experience);
    long countAllCandidatesWithFilters(String search, String technology, String gender, String age, String experience);
    Candidate findById(int id);
    void save(Candidate candidate);
    void saveOrUpdate(Candidate candidate);
    Candidate findByEmail(String email);
    Candidate findByEmailAndPassword(String email, String password);
    Candidate findByEmailAndToken(String email, String token);
}


