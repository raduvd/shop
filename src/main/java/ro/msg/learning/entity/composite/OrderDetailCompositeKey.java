package ro.msg.learning.entity.composite;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import ro.msg.learning.entity.Order;
import ro.msg.learning.entity.Product;

import javax.persistence.Embeddable;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,
        property = "@id")
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailCompositeKey implements Serializable {

    @ManyToOne(targetEntity = Order.class)
    @JoinColumn(name = "SHOP_ORDER", nullable = false)
    private Order shopOrder;

    @ManyToOne(targetEntity = Product.class)
    @JoinColumn(name = "PRODUCT", nullable = false)
    private Product product;
}
