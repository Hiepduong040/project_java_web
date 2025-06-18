package ra.edu.service.auth;

import ra.edu.entity.auth.Admin;

public interface AuthService {
    Admin login(String email, String password);
    void saveOrUpdate(Admin admin);
//    Admin findByEmail(String email);
//    Admin findByToken(String token);
}
