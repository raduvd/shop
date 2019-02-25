package ro.msg.learning.entity.composite;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import ro.msg.learning.entity.Order;
import ro.msg.learning.entity.Product;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by vancer at 2/21/2019
 */
@Data
@Embeddable
@EqualsAndHashCode(exclude = {"shopOrder", "product"})
@ToString(exclude = {"shopOrder", "product"})
public class OrderDetailCompositeKey implements Serializable {

    @ManyToOne(targetEntity = Order.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "SHOP_ORDER", nullable = false)
    private Order shopOrder;

    @ManyToOne(targetEntity = Product.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT", nullable = false)
    private Product product;
}
