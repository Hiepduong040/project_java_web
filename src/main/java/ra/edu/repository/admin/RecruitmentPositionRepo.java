package ra.edu.repository.admin;

import ra.edu.entity.admin.RecruitmentPosition;

import java.util.List;

public interface RecruitmentPositionRepo {
    List<RecruitmentPosition> findAllWithPagination(int offset, int size);
    long countAll();
    List<RecruitmentPosition> findAll();
    RecruitmentPosition findById(int id);
    int save(RecruitmentPosition position);
    int update(RecruitmentPosition position);
    int delete(int id);
    boolean existsByName(String name);
    boolean existsByNameExcludingId(String name, int id);
    List<RecruitmentPosition> findByNameContainingWithPagination(String search, int offset, int size);
    long countByNameContaining(String search);
}