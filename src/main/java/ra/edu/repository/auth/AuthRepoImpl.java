package ra.edu.repository.auth;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ra.edu.entity.auth.Admin;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class AuthRepoImpl implements AuthRepo {

    @Autowired
    private SessionFactory sessionFactory;

    // ✅ Thêm để dùng EntityManager
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Admin findByEmail(String email) {
        Session session = sessionFactory.openSession();
        try {
            return session.createQuery("FROM Admin WHERE email = :email", Admin.class)
                    .setParameter("email", email)
                    .uniqueResult();
        } finally {
            session.close();
        }
    }

    @Override
    public Admin findByRememberToken(String token) {
        Session session = sessionFactory.openSession();
        try {
            return session.createQuery("FROM Admin WHERE rememberToken = :token", Admin.class)
                    .setParameter("token", token)
                    .uniqueResult();
        } finally {
            session.close();
        }
    }

    @Override
    public void saveOrUpdate(Admin admin) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.merge(admin);  // update entity detached
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }


}
