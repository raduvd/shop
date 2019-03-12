package ro.msg.learning.repository.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.entity.Revenue;

/**
 * Created by vancer at 2/19/2019
 */

public interface RevenueRepository extends JpaRepository<Revenue, Long> {
}
