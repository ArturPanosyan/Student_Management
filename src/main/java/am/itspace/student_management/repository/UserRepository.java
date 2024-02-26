package am.itspace.student_management.repository;

import am.itspace.student_management.entity.User;
import am.itspace.student_management.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);
    List<User> findUserByUserRole(UserRole userRole);
}
