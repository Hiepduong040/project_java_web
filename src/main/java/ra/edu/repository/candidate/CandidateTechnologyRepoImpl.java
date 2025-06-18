package ra.edu.repository.candidate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ra.edu.entity.candidate.CandidateTechnology;

import javax.transaction.Transactional;

@Repository
@Transactional
public class CandidateTechnologyRepoImpl implements CandidateTechnologyRepo {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void deleteByCandidateId(int candidateId) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.createQuery("DELETE FROM CandidateTechnology ct WHERE ct.candidate.id = :candidateId")
                    .setParameter("candidateId", candidateId)
                    .executeUpdate();
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    @Override
    public void save(CandidateTechnology candidateTechnology) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(candidateTechnology);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }
}

