package ra.edu.repository.admin;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ra.edu.entity.admin.Application;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class ApplicationRepoImpl implements ApplicationRepo {
    private final SessionFactory sessionFactory;
    private final EntityManager entityManager;
    private static final Logger logger = LoggerFactory.getLogger(ApplicationRepoImpl.class);

    public ApplicationRepoImpl(SessionFactory sessionFactory, EntityManager entityManager) {
        this.sessionFactory = sessionFactory;
        this.entityManager = entityManager;
    }

    @Override
    public List<Application> findAllWithPagination(int offset, int size) {
        Session session = sessionFactory.openSession();
        try {
            Query<Application> query = session.createQuery(
                    "SELECT a FROM Application a LEFT JOIN FETCH a.candidate c LEFT JOIN FETCH a.recruitmentPosition rp WHERE a.isDeleted = false",
                    Application.class);
            query.setFirstResult(offset);
            query.setMaxResults(size);
            return query.getResultList();
        } catch (Exception ex) {
            logger.error("Error fetching applications with pagination: {}", ex.getMessage(), ex);
            return new ArrayList<>();
        } finally {
            session.close();
        }
    }

    @Override
    public long countAll() {
        Session session = sessionFactory.openSession();
        try {
            return session.createQuery(
                            "SELECT COUNT(a) FROM Application a WHERE a.isDeleted = false", Long.class)
                    .uniqueResult();
        } catch (Exception ex) {
            logger.error("Error counting applications: {}", ex.getMessage(), ex);
            return 0;
        } finally {
            session.close();
        }
    }

    @Override
    public Application findById(int id) {
        Session session = sessionFactory.openSession();
        try {
            Query<Application> query = session.createQuery(
                    "SELECT a FROM Application a LEFT JOIN FETCH a.candidate c LEFT JOIN FETCH a.recruitmentPosition rp WHERE a.id = :id AND a.isDeleted = false",
                    Application.class);
            query.setParameter("id", id);
            return query.uniqueResult();
        } catch (Exception ex) {
            logger.error("Error finding application by id {}: {}", id, ex.getMessage(), ex);
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public int save(Application application) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(application);
            session.getTransaction().commit();
            return 1;
        } catch (Exception ex) {
            session.getTransaction().rollback();
            logger.error("Error saving application: {}", ex.getMessage(), ex);
            return 0;
        } finally {
            session.close();
        }
    }

    @Override
    public int update(Application application) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(application);
            session.getTransaction().commit();
            return 1;
        } catch (Exception ex) {
            session.getTransaction().rollback();
            logger.error("Error updating application: {}", ex.getMessage(), ex);
            return 0;
        } finally {
            session.close();
        }
    }

    @Override
    public List<Application> findByProgressWithPagination(String progress, int offset, int size) {
        Session session = sessionFactory.openSession();
        try {
            Query<Application> query = session.createQuery(
                    "SELECT a FROM Application a LEFT JOIN FETCH a.candidate c LEFT JOIN FETCH a.recruitmentPosition rp WHERE a.isDeleted = false AND a.progress = :progress",
                    Application.class);
            query.setParameter("progress", Application.Progress.valueOf(progress));
            query.setFirstResult(offset);
            query.setMaxResults(size);
            return query.getResultList();
        } catch (Exception ex) {
            logger.error("Error searching applications by progress {}: {}", progress, ex.getMessage(), ex);
            return new ArrayList<>();
        } finally {
            session.close();
        }
    }

    @Override
    public long countByProgress(String progress) {
        Session session = sessionFactory.openSession();
        try {
            return session.createQuery(
                            "SELECT COUNT(a) FROM Application a WHERE a.isDeleted = false AND a.progress = :progress",
                            Long.class)
                    .setParameter("progress", Application.Progress.valueOf(progress))
                    .uniqueResult();
        } catch (Exception ex) {
            logger.error("Error counting applications by progress {}: {}", progress, ex.getMessage(), ex);
            return 0;
        } finally {
            session.close();
        }
    }
}