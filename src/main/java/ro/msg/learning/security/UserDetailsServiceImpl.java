package ro.msg.learning.security;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ro.msg.learning.entity.User;
import ro.msg.learning.entity.UserRole;
import ro.msg.learning.repository.dao.UserRepository;

import java.util.List;

/**
 * Created by vancer at 3/7/2019
 */
@Service
@NoArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {

        final User user = userRepository.findByUserName(username);
        if (user == null)
            throw new UsernameNotFoundException("No user was found with username: " + username);
        final List<UserRole> userRoleList = user.getUserRoleList();

        return new CustomUserDetails(user, userRoleList);
    }
}
