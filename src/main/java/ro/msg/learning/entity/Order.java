package ro.msg.learning.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vancer at 2/12/2019
 */
@Data
@Entity(name = "SHOP_ORDER")
@EqualsAndHashCode(exclude={"shippedFromLocation","customer"})
@ToString(exclude={"shippedFromLocation","customer"})
public class Order extends Address {

    @Id
    @Column(name = "ID")
    private Long id;

    @ManyToOne(targetEntity = Location.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "SHIPPED_FROM_LOCATION", nullable = false)
    private Location shippedFromLocation;

    @ManyToOne(targetEntity = Customer.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "orderDetailCompositeKey.shopOrder", fetch = FetchType.LAZY)
    private List<OrderDetail> orderDetailList = new ArrayList<>();

}
