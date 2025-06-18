package ra.edu.repository.candidate;

import ra.edu.entity.candidate.Candidate;

import java.util.List;

public interface CandidateRepo {
    List<Candidate> findAllWithPagination(int offset, int size);
    long countAll();
    List<Candidate> findAllWithFilters(int offset, int size, String search, String technology, String gender, String age, String experience);
    long countAllWithFilters(String search, String technology, String gender, String age, String experience);
    Candidate findById(int id);

    void save(Candidate candidate);
//    Candidate findByRememberToken(String token);
    Candidate findByEmail(String email);
}




//package ra.edu.repository.candidate;
//
//import ra.edu.entity.candidate.Candidate;
//
//import java.util.List;
//
//public interface CandidateRepo {
//    List<Candidate> findAllWithPagination(int offset, int size);
//    long countAll();
//    List<Candidate> findAllWithFilters(int offset, int size, String search, String technology, String gender, String age, String experience);
//    long countAllWithFilters(String search, String technology, String gender, String age, String experience);
//    Candidate findById(int id);
//    void save(Candidate candidate);
//}
//
//
