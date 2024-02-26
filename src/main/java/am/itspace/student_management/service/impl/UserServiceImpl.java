package am.itspace.student_management.service.impl;

import am.itspace.student_management.entity.User;
import am.itspace.student_management.entity.UserRole;
import am.itspace.student_management.exceptions.EmailIsPresentException;
import am.itspace.student_management.exceptions.PasswordNotMuchException;
import am.itspace.student_management.repository.UserRepository;
import am.itspace.student_management.service.UserService;
import am.itspace.student_management.util.MultipartUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${student_management.picture.upload.directory}")
    private String uploadDirectory;

    @Override
    public User register(User user, MultipartFile multipartFile, String confirmPassword) throws IOException, EmailIsPresentException, PasswordNotMuchException, IOException {
        Optional<User> userByEmail = userRepository.findByEmail(user.getEmail());

        if (userByEmail.isPresent()) {
            throw new EmailIsPresentException("Email is already in use");
        } else if (!user.getPassword().equals(confirmPassword)) {
            throw new PasswordNotMuchException("Passwords do not match");
        }

        MultipartUtil.processImageUpload(user, multipartFile, uploadDirectory);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user, MultipartFile multipartFile) throws IOException {
        MultipartUtil.processImageUpload(user, multipartFile, uploadDirectory);
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findUserByUserType(UserRole userRole) {
        return userRepository.findUserByUserRole(userRole);
    }

    @Override
    public void deletePicture(int id) {
        Optional<User> byId = userRepository.findById(id);
        byId.ifPresent(user -> {
            String picName = user.getPicName();

            if (picName != null) {
                user.setPicName(null);
                userRepository.save(user);
            }

            File file = new File(uploadDirectory, picName);
            if (file.exists()) {
                file.delete();
            }
        });
    }
}