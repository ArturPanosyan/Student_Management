package am.itspace.student_management.security;

import am.itspace.student_management.entity.User;
import org.springframework.security.core.authority.AuthorityUtils;

public class SpringUser extends org.springframework.security.core.userdetails.User {

    private User user;

    public SpringUser(User user) {
        super(user.getEmail(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getUserRole().name()));
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}