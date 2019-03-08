package ro.msg.learning.repository.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ro.msg.learning.entity.UserRole;

import java.util.List;

/**
 * Created by vancer at 2/19/2019
 */

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    @Query("SELECT ur.role FROM USER_ROLE ur, USER u WHERE u.userName = ?1 and ur.user = u.userId")
    List<String> findRolesByUserName(String userName);
}
