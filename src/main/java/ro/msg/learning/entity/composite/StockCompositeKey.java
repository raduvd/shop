package ro.msg.learning.entity.composite;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import ro.msg.learning.entity.Location;
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
@EqualsAndHashCode(exclude = {"location", "product"})
@ToString(exclude = {"location", "product"})
@AllArgsConstructor
public class StockCompositeKey implements Serializable {

    @ManyToOne(targetEntity = Product.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT", nullable = false)
    private Product product;

    @ManyToOne(targetEntity = Location.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "LOCATION", nullable = false)
    private Location location;
}
