package ra.edu.service.admin;

import ra.edu.entity.admin.Technology;

import java.util.List;

public interface TechnologyService {
    List<Technology> findAllTechnologyWithPagination(int offset, int size);
    long countAllTechnologies();

    List<Technology> findAllTechnology();

    Technology findTechnologyById(int id);
    int saveTechnology(Technology technology);
    int updateTechnology(Technology technology);
    int deleteTechnology(int id);
    boolean existsByName(String name);
    boolean existsByNameExcludingId(String name, int id);
//    long countTechnologies(String search);
}


//package ra.edu.service.admin;
//
//import ra.edu.entity.admin.Technology;
//
//import java.util.List;
//
//public interface TechnologyService {
//    List<Technology> findAllTechnology();
//
//    Technology findTechnologyById(int id);
//
//    int saveTechnology(Technology technology);
//
//    int updateTechnology(Technology technology);
//
//    int deleteTechnology(int id);
//    boolean existsByName(String name);
//
//    boolean existsByNameExcludingId(String name, int id);
//
//}
