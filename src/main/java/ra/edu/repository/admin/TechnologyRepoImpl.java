//package ra.edu.repository.admin;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;
//import org.springframework.stereotype.Repository;
//import ra.edu.entity.admin.Technology;
//
//import javax.persistence.EntityManager;
//import javax.transaction.Transactional;
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//@Transactional
//public class TechnologyRepoImpl implements TechnologyRepo {
//    private final SessionFactory sessionFactory;
//    private final EntityManager entityManager;
//
//    public TechnologyRepoImpl(SessionFactory sessionFactory, EntityManager entityManager) {
//        this.sessionFactory = sessionFactory;
//        this.entityManager = entityManager;
//    }
//
//    @Override
//    public List<Technology> findAllTechnology() {
//        Session session = sessionFactory.openSession();
//        List<Technology> technologyList = new ArrayList<>();
//        try {
//            Query<Technology> query = session.createQuery("FROM Technology", Technology.class);
//            technologyList = query.getResultList();
//            return technologyList;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return technologyList;
//    }
//
//    @Override
//    public Technology findTechnologyById(int id) {
//        Session session = sessionFactory.openSession();
//        try {
//            return session.get(Technology.class, id);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return null;
//    }
//
//    @Override
//    public int saveTechnology(Technology technology) {
//        Session session = sessionFactory.openSession();
//        try {
//            session.beginTransaction();
//            session.save(technology);
//            session.getTransaction().commit();
//            return 1;
//        } catch (Exception ex) {
//            session.getTransaction().rollback();
//            ex.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return 0;
//    }
//
//    @Override
//    public int updateTechnology(Technology technology) {
//        Session session = sessionFactory.openSession();
//        try {
//            session.beginTransaction();
//            session.update(technology);
//            session.getTransaction().commit();
//            return 1;
//        } catch (Exception ex) {
//            session.getTransaction().rollback();
//            ex.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return 0;
//    }
//
//    @Override
//    public int deleteTechnology(int id) {
//        Session session = sessionFactory.openSession();
//        try {
//            session.beginTransaction();
//            Technology technology = session.get(Technology.class, id);
//            if (technology != null) {
//                session.delete(technology);
//                session.getTransaction().commit();
//                return 1;
//            }
//        } catch (Exception ex) {
//            session.getTransaction().rollback();
//            ex.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return 0;
//    }
//    @Override
//    public boolean existsByName(String name) {
//        Session session = sessionFactory.openSession();
//        try {
//            Long count = session.createQuery(
//                            "SELECT COUNT(t) FROM Technology t WHERE LOWER(t.name) = :name", Long.class)
//                    .setParameter("name", name.toLowerCase())
//                    .uniqueResult();
//            return count != null && count > 0;
//        } finally {
//            session.close();
//        }
//    }
//
//    @Override
//    public boolean existsByNameExcludingId(String name, int id) {
//        Session session = sessionFactory.openSession();
//        try {
//            Long count = session.createQuery(
//                            "SELECT COUNT(t) FROM Technology t WHERE LOWER(t.name) = :name AND t.id <> :id", Long.class)
//                    .setParameter("name", name.toLowerCase())
//                    .setParameter("id", id)
//                    .uniqueResult();
//            return count != null && count > 0;
//        } finally {
//            session.close();
//        }
//    }
//
//
//
//}

package ra.edu.repository.admin;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ra.edu.entity.admin.Technology;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class TechnologyRepoImpl implements TechnologyRepo {
    private final SessionFactory sessionFactory;
    private final EntityManager entityManager;

    public TechnologyRepoImpl(SessionFactory sessionFactory, EntityManager entityManager) {
        this.sessionFactory = sessionFactory;
        this.entityManager = entityManager;
    }

    @Override
    public List<Technology> findAllTechnologyWithPagination(int offset, int size) {
        Session session = sessionFactory.openSession();
        try {
            Query<Technology> query = session.createQuery(
                    "FROM Technology t WHERE t.name NOT LIKE '%_deleted'", Technology.class);
            query.setFirstResult(offset);
            query.setMaxResults(size);
            return query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        } finally {
            session.close();
        }
    }

    @Override
    public long countAllTechnologies() {
        Session session = sessionFactory.openSession();
        try {
            return session.createQuery(
                            "SELECT COUNT(t) FROM Technology t WHERE t.name NOT LIKE '%_deleted'", Long.class)
                    .uniqueResult();
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        } finally {
            session.close();
        }
    }

    @Override
    public List<Technology> findAllTechnology() {
        Session session = sessionFactory.openSession();
        try {
            Query<Technology> query = session.createQuery(
                    "FROM Technology t WHERE t.name NOT LIKE '%_deleted'", Technology.class);
            return query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        } finally {
            session.close();
        }
    }

    @Override
    public Technology findTechnologyById(int id) {
        Session session = sessionFactory.openSession();
        try {
            return session.get(Technology.class, id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public int saveTechnology(Technology technology) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(technology);
            session.getTransaction().commit();
            return 1;
        } catch (Exception ex) {
            session.getTransaction().rollback();
            ex.printStackTrace();
            return 0;
        } finally {
            session.close();
        }
    }

    @Override
    public int updateTechnology(Technology technology) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(technology);
            session.getTransaction().commit();
            return 1;
        } catch (Exception ex) {
            session.getTransaction().rollback();
            ex.printStackTrace();
            return 0;
        } finally {
            session.close();
        }
    }

    @Override
    public int deleteTechnology(int id) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Technology technology = session.get(Technology.class, id);
            if (technology == null) {
                return 0;
            }

            // Check if technology is used in candidate_technology
            Long candidateCount = session.createQuery(
                            "SELECT COUNT(ct) FROM CandidateTechnology ct WHERE ct.technology.id = :id", Long.class)
                    .setParameter("id", id)
                    .uniqueResult();

            // Check if technology is used in recruitment_position_technology
            Long recruitmentCount = session.createQuery(
                            "SELECT COUNT(rpt) FROM RecruitmentPositionTechnology rpt WHERE rpt.technology.id = :id", Long.class)
                    .setParameter("id", id)
                    .uniqueResult();

            if ((candidateCount != null && candidateCount > 0) || (recruitmentCount != null && recruitmentCount > 0)) {
                // Soft delete: append _deleted to name
                technology.setName(technology.getName() + "_deleted");
                session.update(technology);
                session.getTransaction().commit();
                return 1;
            } else {
                // Hard delete if not used
                session.delete(technology);
                session.getTransaction().commit();
                return 1;
            }
        } catch (Exception ex) {
            session.getTransaction().rollback();
            ex.printStackTrace();
            return 0;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean existsByName(String name) {
        Session session = sessionFactory.openSession();
        try {
            Long count = session.createQuery(
                            "SELECT COUNT(t) FROM Technology t WHERE LOWER(t.name) = :name", Long.class)
                    .setParameter("name", name.toLowerCase())
                    .uniqueResult();
            return count != null && count > 0;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean existsByNameExcludingId(String name, int id) {
        Session session = sessionFactory.openSession();
        try {
            Long count = session.createQuery(
                            "SELECT COUNT(t) FROM Technology t WHERE LOWER(t.name) = :name AND t.id <> :id", Long.class)
                    .setParameter("name", name.toLowerCase())
                    .setParameter("id", id)
                    .uniqueResult();
            return count != null && count > 0;
        } finally {
            session.close();
        }
    }
}


// v2
//package ra.edu.repository.admin;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;
//import org.springframework.stereotype.Repository;
//import ra.edu.entity.admin.Technology;
//
//import javax.persistence.EntityManager;
//import javax.transaction.Transactional;
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//@Transactional
//public class TechnologyRepoImpl implements TechnologyRepo {
//    private final SessionFactory sessionFactory;
//    private final EntityManager entityManager;
//
//    public TechnologyRepoImpl(SessionFactory sessionFactory, EntityManager entityManager) {
//        this.sessionFactory = sessionFactory;
//        this.entityManager = entityManager;
//    }
//
//    @Override
//    public List<Technology> findAllTechnologyWithPagination(int offset, int size) {
//        Session session = sessionFactory.openSession();
//        List<Technology> technologyList = new ArrayList<>();
//        try {
//            Query<Technology> query = session.createQuery("FROM Technology", Technology.class);
//            query.setFirstResult(offset);
//            query.setMaxResults(size);
//            technologyList = query.getResultList();
//            return technologyList;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return technologyList;
//    }
//
//    @Override
//    public long countAllTechnologies() {
//        Session session = sessionFactory.openSession();
//        try {
//            return session.createQuery("SELECT COUNT(t) FROM Technology t", Long.class).uniqueResult();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return 0;
//    }
//
//    @Override
//    public List<Technology> findAllTechnology() {
//        Session session = sessionFactory.openSession();
//        List<Technology> technologyList = new ArrayList<>();
//        try {
//            Query<Technology> query = session.createQuery("FROM Technology", Technology.class);
//            technologyList = query.getResultList();
//            return technologyList;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return technologyList;
//    }
//
//    @Override
//    public Technology findTechnologyById(int id) {
//        Session session = sessionFactory.openSession();
//        try {
//            return session.get(Technology.class, id);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return null;
//    }
//
//    @Override
//    public int saveTechnology(Technology technology) {
//        Session session = sessionFactory.openSession();
//        try {
//            session.beginTransaction();
//            session.save(technology);
//            session.getTransaction().commit();
//            return 1;
//        } catch (Exception ex) {
//            session.getTransaction().rollback();
//            ex.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return 0;
//    }
//
//    @Override
//    public int updateTechnology(Technology technology) {
//        Session session = sessionFactory.openSession();
//        try {
//            session.beginTransaction();
//            session.update(technology);
//            session.getTransaction().commit();
//            return 1;
//        } catch (Exception ex) {
//            session.getTransaction().rollback();
//            ex.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return 0;
//    }
//
//    @Override
//    public int deleteTechnology(int id) {
//        Session session = sessionFactory.openSession();
//        try {
//            session.beginTransaction();
//            Technology technology = session.get(Technology.class, id);
//            if (technology != null) {
//                session.delete(technology);
//                session.getTransaction().commit();
//                return 1;
//            }
//        } catch (Exception ex) {
//            session.getTransaction().rollback();
//            ex.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return 0;
//    }
//
//    @Override
//    public boolean existsByName(String name) {
//        Session session = sessionFactory.openSession();
//        try {
//            Long count = session.createQuery(
//                            "SELECT COUNT(t) FROM Technology t WHERE LOWER(t.name) = :name", Long.class)
//                    .setParameter("name", name.toLowerCase())
//                    .uniqueResult();
//            return count != null && count > 0;
//        } finally {
//            session.close();
//        }
//    }
//
//    @Override
//    public boolean existsByNameExcludingId(String name, int id) {
//        Session session = sessionFactory.openSession();
//        try {
//            Long count = session.createQuery(
//                            "SELECT COUNT(t) FROM Technology t WHERE LOWER(t.name) = :name AND t.id <> :id", Long.class)
//                    .setParameter("name", name.toLowerCase())
//                    .setParameter("id", id)
//                    .uniqueResult();
//            return count != null && count > 0;
//        } finally {
//            session.close();
//        }
//    }
//}