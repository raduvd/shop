package ro.msg.learning.entity;

import lombok.Data;
import ro.msg.learning.entity.composite.OrderDetailCompositeKey;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created by vancer at 2/12/2019
 */
@Data
@Entity(name = "ORDER_DETAIL")
public class OrderDetail implements Serializable {

    @EmbeddedId
    private OrderDetailCompositeKey orderDetailCompositeKey;

    @Column(name = "ORDER_QUANTITY", nullable = false)
    private Integer orderQuantity;
}
