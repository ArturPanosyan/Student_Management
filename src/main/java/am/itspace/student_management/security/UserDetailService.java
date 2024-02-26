package am.itspace.student_management.security;

import am.itspace.student_management.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (userRepository.findByEmail(username).isEmpty()) {
            throw new UsernameNotFoundException("User with " + username + " dose not exists!");
        }
        return new SpringUser(userRepository.findByEmail(username).get());
    }
}
