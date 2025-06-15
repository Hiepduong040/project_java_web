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
        List<Technology> technologyList = new ArrayList<>();
        try {
            Query<Technology> query = session.createQuery("FROM Technology", Technology.class);
            query.setFirstResult(offset);
            query.setMaxResults(size);
            technologyList = query.getResultList();
            return technologyList;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return technologyList;
    }

    @Override
    public long countAllTechnologies() {
        Session session = sessionFactory.openSession();
        try {
            return session.createQuery("SELECT COUNT(t) FROM Technology t", Long.class).uniqueResult();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return 0;
    }

    @Override
    public List<Technology> findAllTechnology() {
        Session session = sessionFactory.openSession();
        List<Technology> technologyList = new ArrayList<>();
        try {
            Query<Technology> query = session.createQuery("FROM Technology", Technology.class);
            technologyList = query.getResultList();
            return technologyList;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return technologyList;
    }

    @Override
    public Technology findTechnologyById(int id) {
        Session session = sessionFactory.openSession();
        try {
            return session.get(Technology.class, id);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return null;
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
        } finally {
            session.close();
        }
        return 0;
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
        } finally {
            session.close();
        }
        return 0;
    }

    @Override
    public int deleteTechnology(int id) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Technology technology = session.get(Technology.class, id);
            if (technology != null) {
                session.delete(technology);
                session.getTransaction().commit();
                return 1;
            }
        } catch (Exception ex) {
            session.getTransaction().rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return 0;
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