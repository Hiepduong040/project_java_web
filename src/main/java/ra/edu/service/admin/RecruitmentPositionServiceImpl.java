package ra.edu.service.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ra.edu.entity.admin.RecruitmentPosition;
import ra.edu.repository.admin.RecruitmentPositionRepo;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class RecruitmentPositionServiceImpl implements RecruitmentPositionService {
    private final RecruitmentPositionRepo recruitmentPositionRepo;

    @Override
    public List<RecruitmentPosition> findAllWithPagination(int offset, int size) {
        return recruitmentPositionRepo.findAllWithPagination(offset, size);
    }

    @Override
    public long countAll() {
        return recruitmentPositionRepo.countAll();
    }

    @Override
    public List<RecruitmentPosition> findAll() {
        return recruitmentPositionRepo.findAll();
    }

    @Override
    public RecruitmentPosition findById(int id) {
        return recruitmentPositionRepo.findById(id);
    }

    @Override
    public int save(RecruitmentPosition position) {
        if (position.getCreatedDate() == null) {
            position.setCreatedDate(LocalDate.now());
        }
        return recruitmentPositionRepo.save(position);
    }

    @Override
    public int update(RecruitmentPosition position) {
        if (position.getCreatedDate() == null) {
            position.setCreatedDate(LocalDate.now());
        }
        return recruitmentPositionRepo.update(position);
    }

    @Override
    public int delete(int id) {
        return recruitmentPositionRepo.delete(id);
    }

    @Override
    public boolean existsByName(String name) {
        return recruitmentPositionRepo.existsByName(name);
    }

    @Override
    public boolean existsByNameExcludingId(String name, int id) {
        return recruitmentPositionRepo.existsByNameExcludingId(name, id);
    }

    @Override
    public List<RecruitmentPosition> findByNameContainingWithPagination(String search, int offset, int size) {
        return recruitmentPositionRepo.findByNameContainingWithPagination(search, offset, size);
    }

    @Override
    public long countByNameContaining(String search) {
        return recruitmentPositionRepo.countByNameContaining(search);
    }
}