//package ra.edu.service.auth;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.mindrot.jbcrypt.BCrypt;
//import org.springframework.stereotype.Service;
//import ra.edu.entity.auth.Admin;
//import ra.edu.repository.auth.AuthRepo;
//@Service
//@RequiredArgsConstructor
//@Slf4j
//public class AuthServiceImpl implements AuthService {
//    private final AuthRepo authRepo;
//
//    @Override
//    public Admin login(String email, String password) {
//        Admin admin = authRepo.findByEmail(email);
//        if (admin != null) {
//            if (password.equals(admin.getPassword())) {
//                return admin;
//            } else {
//                log.debug("Password does not match for user: {}", email);
//            }
//        } else {
//            log.debug("User not found with email: {}", email);
//        }
//        return null;
//    }
//
//}


package ra.edu.service.auth;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import ra.edu.entity.auth.Admin;
import ra.edu.repository.auth.AuthRepo;
@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {
    private final AuthRepo authRepo;

    @Override
    public Admin login(String email, String password) {
        Admin admin = authRepo.findByEmail(email);
        if (admin != null) {
            if (BCrypt.checkpw(password, admin.getPassword())) {
                return admin;
            } else {
                log.debug("Password does not match for user: {}", email);
            }
        } else {
            log.debug("User not found with email: {}", email);
        }
        return null;
    }
    @Override
    public void saveOrUpdate(Admin admin) {
        authRepo.saveOrUpdate(admin);
    }




}