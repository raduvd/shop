package ro.msg.learning.entity.composite;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import ro.msg.learning.entity.Location;
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
@EqualsAndHashCode(exclude = {"location", "product"})
@ToString(exclude = {"location", "product"})
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,
        property = "@id")
public class StockCompositeKey implements Serializable {

    @ManyToOne(targetEntity = Product.class)
    @JoinColumn(name = "PRODUCT", nullable = false)
    private Product product;

    @ManyToOne(targetEntity = Location.class)
    @JoinColumn(name = "LOCATION", nullable = false)
    private Location location;
}
