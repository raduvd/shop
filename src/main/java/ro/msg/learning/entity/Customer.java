package ro.msg.learning.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vancer at 2/12/2019
 */
@Data
@Entity(name = "CUSTOMER")
public class Customer implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_sequence")
    @SequenceGenerator(name = "customer_sequence", sequenceName = "customer_sequence", allocationSize = 1, initialValue = 1000)
    private Long id;

    @Column(name = "FIRST_NAME", nullable = false, length = 50)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false, length = 50)
    private String lastName;

    @Column(name = "USER_NAME", nullable = false, length = 50)
    private String username;

    @OneToMany(mappedBy = "customer")
    private List<Order> orderList = new ArrayList<>();
}
