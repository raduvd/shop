package ro.msg.learning.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by vancer at 2/12/2019
 */
@Data
@Entity(name = "ORDER")
public class Order extends Address {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "SHIPPED_FROM_LOCATION", nullable = false)
    private Location shippedFromLocation;

    @Column(name = "CUSTOMER", nullable = false)
    private Customer customer;

}
