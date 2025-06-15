package ra.edu.repository.candidate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ra.edu.entity.candidate.Candidate;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CandidateRepoImpl implements CandidateRepo {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Candidate> findAllWithPagination(int offset, int size) {
        Session session = sessionFactory.openSession();
        try {
            Query<Candidate> query = session.createQuery("FROM Candidate", Candidate.class);
            query.setFirstResult(offset);
            query.setMaxResults(size);
            return query.getResultList();
        } finally {
            session.close();
        }
    }

    @Override
    public long countAll() {
        Session session = sessionFactory.openSession();
        try {
            return session.createQuery("SELECT COUNT(c) FROM Candidate c", Long.class).uniqueResult();
        } finally {
            session.close();
        }
    }

    @Override
    public List<Candidate> findAllWithFilters(int offset, int size, String search, String technology, String gender, String age, String experience) {
        Session session = sessionFactory.openSession();
        try {
            String hql = "FROM Candidate c WHERE 1=1";
            if (search != null && !search.isEmpty()) {
                hql += " AND (LOWER(c.name) LIKE LOWER(:search) OR LOWER(c.email) LIKE LOWER(:search))";
            }
            if (technology != null && !technology.isEmpty()) {
                hql += " AND EXISTS (SELECT 1 FROM c.candidateTechnologies ct JOIN ct.technology t WHERE t.id = :technology)";
            }
            if (gender != null && !gender.isEmpty()) {
                hql += " AND c.gender = :gender";
            }
            if (age != null && !age.isEmpty()) {
                if ("18-25".equals(age)) hql += " AND YEAR(c.dob) BETWEEN 2000 AND 2007";
                else if ("26-35".equals(age)) hql += " AND YEAR(c.dob) BETWEEN 1990 AND 1999";
                else if ("36+".equals(age)) hql += " AND YEAR(c.dob) <= 1989";
            }
            if (experience != null && !experience.isEmpty()) {
                if ("4+".equals(experience)) hql += " AND c.experience >= 4";
                else hql += " AND c.experience = :experience";
            }

            Query<Candidate> query = session.createQuery(hql, Candidate.class);
            if (search != null && !search.isEmpty()) {
                query.setParameter("search", "%" + search + "%");
            }
            if (technology != null && !technology.isEmpty()) {
                query.setParameter("technology", Integer.parseInt(technology));
            }
            if (gender != null && !gender.isEmpty()) {
                query.setParameter("gender", gender);
            }
            if (experience != null && !experience.isEmpty() && !"4+".equals(experience)) {
                query.setParameter("experience", Integer.parseInt(experience));
            }
            query.setFirstResult(offset);
            query.setMaxResults(size);
            return query.getResultList();
        } finally {
            session.close();
        }
    }

    @Override
    public long countAllWithFilters(String search, String technology, String gender, String age, String experience) {
        Session session = sessionFactory.openSession();
        try {
            String hql = "SELECT COUNT(c) FROM Candidate c WHERE 1=1";
            if (search != null && !search.isEmpty()) {
                hql += " AND (LOWER(c.name) LIKE LOWER(:search) OR LOWER(c.email) LIKE LOWER(:search))";
            }
            if (technology != null && !technology.isEmpty()) {
                hql += " AND EXISTS (SELECT 1 FROM c.candidateTechnologies ct JOIN ct.technology t WHERE t.id = :technology)";
            }
            if (gender != null && !gender.isEmpty()) {
                hql += " AND c.gender = :gender";
            }
            if (age != null && !age.isEmpty()) {
                if ("18-25".equals(age)) hql += " AND YEAR(c.dob) BETWEEN 2000 AND 2007";
                else if ("26-35".equals(age)) hql += " AND YEAR(c.dob) BETWEEN 1990 AND 1999";
                else if ("36+".equals(age)) hql += " AND YEAR(c.dob) <= 1989";
            }
            if (experience != null && !experience.isEmpty()) {
                if ("4+".equals(experience)) hql += " AND c.experience >= 4";
                else hql += " AND c.experience = :experience";
            }

            Query<Long> query = session.createQuery(hql, Long.class);
            if (search != null && !search.isEmpty()) {
                query.setParameter("search", "%" + search + "%");
            }
            if (technology != null && !technology.isEmpty()) {
                query.setParameter("technology", Integer.parseInt(technology));
            }
            if (gender != null && !gender.isEmpty()) {
                query.setParameter("gender", gender);
            }
            if (experience != null && !experience.isEmpty() && !"4+".equals(experience)) {
                query.setParameter("experience", Integer.parseInt(experience));
            }
            return query.uniqueResult();
        } finally {
            session.close();
        }
    }
}