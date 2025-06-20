package ra.edu.service.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ra.edu.entity.admin.Application;
import ra.edu.repository.admin.ApplicationRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ApplicationServiceImpl implements ApplicationService {
    private final ApplicationRepo applicationRepo;

    @Override
    public List<Application> findAllWithPagination(int offset, int size) {
        return applicationRepo.findAllWithPagination(offset, size);
    }

    @Override
    public long countAll() {
        return applicationRepo.countAll();
    }

    @Override
    public Application findById(int id) {
        return applicationRepo.findById(id);
    }

    @Override
    public int save(Application application) {
        return applicationRepo.save(application);
    }

    @Override
    public int update(Application application) {
        return applicationRepo.update(application);
    }

    @Override
    public List<Application> findByProgressWithPagination(String progress, int offset, int size) {
        return applicationRepo.findByProgressWithPagination(progress, offset, size);
    }

    @Override
    public long countByProgress(String progress) {
        return applicationRepo.countByProgress(progress);
    }
}