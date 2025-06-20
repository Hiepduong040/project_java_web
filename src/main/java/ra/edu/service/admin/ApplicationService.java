package ra.edu.service.admin;

import ra.edu.entity.admin.Application;

import java.util.List;

public interface ApplicationService {
    List<Application> findAllWithPagination(int offset, int size);
    long countAll();
    Application findById(int id);
    int save(Application application);
    int update(Application application);
    List<Application> findByProgressWithPagination(String progress, int offset, int size);
    long countByProgress(String progress);
}