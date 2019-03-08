package ro.msg.learning.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by vancer at 2/12/2019
 */
@Data
@Entity(name = "USER_ROLE")
public class UserRole implements Serializable {

    @Id
    @Column(name = "USER_ROLE_ID")
    private Long userRoleId;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "USER", nullable = false)
    private User user;

    @Column(name = "ROLE")
    private String role;


}

