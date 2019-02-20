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
@Entity(name = "ORDER_DETAIL")
public class OrderDetail implements Serializable {

    @Column(name = "ORDER", nullable = false)
    private Order order;

    @Column(name = "PRODUCT", nullable = false)
    private Product product;

    @Column(name = "QUANTITY", nullable = false)
    private Integer quantity;
}
