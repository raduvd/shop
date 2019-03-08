package ro.msg.learning.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vancer at 2/12/2019
 */
@Data
@Entity(name = "SHOP_ORDER")
@EqualsAndHashCode(exclude = {"shippedFromLocation", "customer"})
@ToString(exclude = {"shippedFromLocation", "customer"})
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,
        property = "@id")
public class Order implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shop_order_sequence")
    @SequenceGenerator(name = "shop_order_sequence", sequenceName = "shop_order_sequence", allocationSize = 1, initialValue = 1000)
    private Long id;

    @ManyToOne(targetEntity = Location.class)
    @JoinColumn(name = "SHIPPED_FROM_LOCATION", nullable = false)
    private Location shippedFromLocation;

    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name = "CUSTOMER", nullable = false)
    private Customer customer;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "orderDetailCompositeKey.shopOrder")
    private List<OrderDetail> orderDetailList = new ArrayList<>();

}
