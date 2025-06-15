//package ra.edu.service.admin;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import ra.edu.entity.admin.Technology;
//import ra.edu.repository.admin.TechnologyRepo;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class TechnologyServiceImpl implements TechnologyService {
//    private final TechnologyRepo technologyRepo;
//
//    @Override
//    public List<Technology> findAllTechnology() {
//        return technologyRepo.findAllTechnology();
//    }
//
//    @Override
//    public Technology findTechnologyById(int id) {
//        return technologyRepo.findTechnologyById(id);
//    }
//
//    @Override
//    public int saveTechnology(Technology technology) {
//        return technologyRepo.saveTechnology(technology);
//    }
//
//    @Override
//    public int updateTechnology(Technology technology) {
//        return technologyRepo.updateTechnology(technology);
//    }
//
//    @Override
//    public int deleteTechnology(int id) {
//        return technologyRepo.deleteTechnology(id);
//    }
//    @Override
//    public boolean existsByName(String name) {
//        return technologyRepo.existsByName(name);
//    }
//
//    @Override
//    public boolean existsByNameExcludingId(String name, int id) {
//        return technologyRepo.existsByNameExcludingId(name, id);
//    }
//
//
//}

package ra.edu.service.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ra.edu.entity.admin.Technology;
import ra.edu.repository.admin.TechnologyRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TechnologyServiceImpl implements TechnologyService {
    private final TechnologyRepo technologyRepo;

    @Override
    public List<Technology> findAllTechnologyWithPagination(int offset, int size) {
        return technologyRepo.findAllTechnologyWithPagination(offset, size);
    }

    @Override
    public long countAllTechnologies() {
        return technologyRepo.countAllTechnologies();
    }

    @Override
    public List<Technology> findAllTechnology() {
        return technologyRepo.findAllTechnology();
    }

    @Override
    public Technology findTechnologyById(int id) {
        return technologyRepo.findTechnologyById(id);
    }

    @Override
    public int saveTechnology(Technology technology) {
        return technologyRepo.saveTechnology(technology);
    }

    @Override
    public int updateTechnology(Technology technology) {
        return technologyRepo.updateTechnology(technology);
    }

    @Override
    public int deleteTechnology(int id) {
        return technologyRepo.deleteTechnology(id);
    }

    @Override
    public boolean existsByName(String name) {
        return technologyRepo.existsByName(name);
    }

    @Override
    public boolean existsByNameExcludingId(String name, int id) {
        return technologyRepo.existsByNameExcludingId(name, id);
    }
}