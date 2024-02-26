package am.itspace.student_management.service;

import am.itspace.student_management.entity.User;
import am.itspace.student_management.entity.UserRole;
import am.itspace.student_management.exceptions.EmailIsPresentException;
import am.itspace.student_management.exceptions.PasswordNotMuchException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface UserService {

    User register(User user, MultipartFile multipartFile, String confirmPassword) throws IOException, EmailIsPresentException, PasswordNotMuchException;
    User save(User user);
    User update(User user, MultipartFile multipartFile) throws IOException;
    Optional<User> findById(int id);
    List<User> findUserByUserType(UserRole userRole);
    void deletePicture(int id);
}
