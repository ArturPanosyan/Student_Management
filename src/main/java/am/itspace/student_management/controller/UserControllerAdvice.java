package am.itspace.student_management.controller;

import am.itspace.student_management.entity.User;
import am.itspace.student_management.security.SpringUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class UserControllerAdvice {

    @ModelAttribute("currentUser")
    public User currentUser(@AuthenticationPrincipal SpringUser springUser){
        if(springUser != null){
            return springUser.getUser();
        }
        return null;
    }
}
