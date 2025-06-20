package ra.edu.repository.admin;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ra.edu.entity.admin.RecruitmentPosition;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class RecruitmentPositionRepoImpl implements RecruitmentPositionRepo {
    private static final Logger logger = LoggerFactory.getLogger(RecruitmentPositionRepoImpl.class);
    private final SessionFactory sessionFactory;
    private final EntityManager entityManager;

    public RecruitmentPositionRepoImpl(SessionFactory sessionFactory, EntityManager entityManager) {
        this.sessionFactory = sessionFactory;
        this.entityManager = entityManager;
    }

    @Override
    public List<RecruitmentPosition> findAllWithPagination(int offset, int size) {
        Session session = sessionFactory.openSession();
        try {
            Query<RecruitmentPosition> query = session.createQuery(
                    "SELECT rp FROM RecruitmentPosition rp LEFT JOIN FETCH rp.recruitmentTechnologies rpt LEFT JOIN FETCH rpt.technology WHERE rp.name NOT LIKE '%_deleted'",
                    RecruitmentPosition.class);
            query.setFirstResult(offset);
            query.setMaxResults(size);
            return query.getResultList();
        } catch (Exception ex) {
            logger.error("Error fetching positions with pagination: {}", ex.getMessage(), ex);
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
                            "SELECT COUNT(rp) FROM RecruitmentPosition rp WHERE rp.name NOT LIKE '%_deleted'", Long.class)
                    .uniqueResult();
        } catch (Exception ex) {
            logger.error("Error counting all positions: {}", ex.getMessage(), ex);
            return 0;
        } finally {
            session.close();
        }
    }

    @Override
    public List<RecruitmentPosition> findAll() {
        Session session = sessionFactory.openSession();
        try {
            Query<RecruitmentPosition> query = session.createQuery(
                    "FROM RecruitmentPosition rp LEFT JOIN FETCH rp.recruitmentTechnologies rpt LEFT JOIN FETCH rpt.technology WHERE rp.name NOT LIKE '%_deleted'",
                    RecruitmentPosition.class);
            return query.getResultList();
        } catch (Exception ex) {
            logger.error("Error fetching all positions: {}", ex.getMessage(), ex);
            return new ArrayList<>();
        } finally {
            session.close();
        }
    }

    @Override
    public RecruitmentPosition findById(int id) {
        Session session = sessionFactory.openSession();
        try {
            Query<RecruitmentPosition> query = session.createQuery(
                    "SELECT rp FROM RecruitmentPosition rp LEFT JOIN FETCH rp.recruitmentTechnologies rpt LEFT JOIN FETCH rpt.technology WHERE rp.id = :id AND rp.name NOT LIKE '%_deleted'",
                    RecruitmentPosition.class);
            query.setParameter("id", id);
            return query.uniqueResult();
        } catch (Exception ex) {
            logger.error("Error finding position by id {}: {}", id, ex.getMessage(), ex);
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public int save(RecruitmentPosition position) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(position);
            session.getTransaction().commit();
            return 1;
        } catch (Exception ex) {
            session.getTransaction().rollback();
            logger.error("Error saving position: {}", ex.getMessage(), ex);
            return 0;
        } finally {
            session.close();
        }
    }
    @Override
    public int update(RecruitmentPosition position) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();

            // Xóa các bản ghi cũ trong recruitment_position_technology
            session.createQuery("DELETE FROM RecruitmentPositionTechnology WHERE recruitmentPosition.id = :id")
                    .setParameter("id", position.getId())
                    .executeUpdate();

            // Cập nhật position
            session.update(position);
            session.getTransaction().commit();
            return 1;
        } catch (Exception ex) {
            session.getTransaction().rollback();
            logger.error("Error updating position: {}", ex.getMessage(), ex);
            return 0;
        } finally {
            session.close();
        }
    }

    @Override
    public int delete(int id) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            RecruitmentPosition position = session.get(RecruitmentPosition.class, id);
            if (position == null) {
                return 0;
            }

            Long applicationCount = session.createQuery(
                            "SELECT COUNT(a) FROM Application a WHERE a.recruitmentPosition.id = :id", Long.class)
                    .setParameter("id", id)
                    .uniqueResult();

            Long rptCount = session.createQuery(
                            "SELECT COUNT(rpt) FROM RecruitmentPositionTechnology rpt WHERE rpt.recruitmentPosition.id = :id", Long.class)
                    .setParameter("id", id)
                    .uniqueResult();

            if ((applicationCount != null && applicationCount > 0) || (rptCount != null && rptCount > 0)) {
                position.setName(position.getName() + "_deleted");
                session.update(position);
                session.getTransaction().commit();
                return 1;
            } else {
                session.delete(position);
                session.getTransaction().commit();
                return 1;
            }
        } catch (Exception ex) {
            session.getTransaction().rollback();
            logger.error("Error deleting position id {}: {}", id, ex.getMessage(), ex);
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
                            "SELECT COUNT(rp) FROM RecruitmentPosition rp WHERE LOWER(rp.name) = :name AND rp.name NOT LIKE '%_deleted'", Long.class)
                    .setParameter("name", name.toLowerCase())
                    .uniqueResult();
            return count != null && count > 0;
        } catch (Exception ex) {
            logger.error("Error checking existence by name {}: {}", name, ex.getMessage(), ex);
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean existsByNameExcludingId(String name, int id) {
        Session session = sessionFactory.openSession();
        try {
            Long count = session.createQuery(
                            "SELECT COUNT(rp) FROM RecruitmentPosition rp WHERE LOWER(rp.name) = :name AND rp.id <> :id AND rp.name NOT LIKE '%_deleted'", Long.class)
                    .setParameter("name", name.toLowerCase())
                    .setParameter("id", id)
                    .uniqueResult();
            return count != null && count > 0;
        } catch (Exception ex) {
            logger.error("Error checking existence by name {} excluding id {}: {}", name, id, ex.getMessage(), ex);
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public List<RecruitmentPosition> findByNameContainingWithPagination(String search, int offset, int size) {
        Session session = sessionFactory.openSession();
        try {
            Query<RecruitmentPosition> query = session.createQuery(
                    "SELECT rp FROM RecruitmentPosition rp LEFT JOIN FETCH rp.recruitmentTechnologies rpt LEFT JOIN FETCH rpt.technology " +
                            "WHERE rp.name NOT LIKE '%_deleted' AND LOWER(rp.name) LIKE :search",
                    RecruitmentPosition.class);
            query.setParameter("search", "%" + search.toLowerCase() + "%");
            query.setFirstResult(offset);
            query.setMaxResults(size);
            return query.getResultList();
        } catch (Exception ex) {
            logger.error("Error searching positions by name {}: {}", search, ex.getMessage(), ex);
            return new ArrayList<>();
        } finally {
            session.close();
        }
    }

    @Override
    public long countByNameContaining(String search) {
        Session session = sessionFactory.openSession();
        try {
            return session.createQuery(
                            "SELECT COUNT(rp) FROM RecruitmentPosition rp WHERE rp.name NOT LIKE '%_deleted' AND LOWER(rp.name) LIKE :search",
                            Long.class)
                    .setParameter("search", "%" + search.toLowerCase() + "%")
                    .uniqueResult();
        } catch (Exception ex) {
            logger.error("Error counting positions by name {}: {}", search, ex.getMessage(), ex);
            return 0;
        } finally {
            session.close();
        }
    }
}