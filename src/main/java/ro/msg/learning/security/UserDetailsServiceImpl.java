package ro.msg.learning.security;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ro.msg.learning.entity.User;
import ro.msg.learning.repository.dao.UserRepository;
import ro.msg.learning.repository.dao.UserRoleRepository;

import java.util.List;

/**
 * Created by vancer at 3/7/2019
 */
@Service
@NoArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    private UserRoleRepository userRoleRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {

        final User user = userRepository.findByUserName(username);
        if (user == null)
            throw new UsernameNotFoundException("No user was found with username: " + username);
        final List<String> userRoleList = userRoleRepository.findRolesByUserName(username);

        return new CustomUserDetails(user, userRoleList);
    }
}
