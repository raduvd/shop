package ro.msg.learning.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by vancer at 2/12/2019
 */
@Data
@Entity(name = "CUSTOMER")
public class Customer implements Serializable {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "USER_NAME", nullable = false)
    private String username;
}
