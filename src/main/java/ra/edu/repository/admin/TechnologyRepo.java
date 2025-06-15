//package ra.edu.repository.admin;
//
//import ra.edu.entity.admin.Technology;
//
//import java.util.List;
//public interface TechnologyRepo {
//    List<Technology> findAllTechnology();
//
//    Technology findTechnologyById(int id);
//
//    int saveTechnology(Technology technology);
//
//    int updateTechnology(Technology technology);
//
//    int deleteTechnology(int id);
//
//    boolean existsByName(String name);
//    boolean existsByNameExcludingId(String name, int id);
//
//}



package ra.edu.repository.admin;

import ra.edu.entity.admin.Technology;

import java.util.List;

public interface TechnologyRepo {
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