package ra.edu.repository.auth;

import ra.edu.entity.auth.Admin;

public interface AuthRepo {
    Admin findByEmail(String email);
    Admin findByRememberToken(String token);

    void saveOrUpdate(Admin admin);
}
