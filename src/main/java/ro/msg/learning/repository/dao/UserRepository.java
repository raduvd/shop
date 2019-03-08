package ro.msg.learning.repository.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.entity.User;

/**
 * Created by vancer at 2/19/2019
 */

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName (String username);
}
