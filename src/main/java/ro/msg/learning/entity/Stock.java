package ro.msg.learning.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created by vancer at 2/12/2019
 */
@Data
@Entity(name = "STOCK")
public class Stock implements Serializable {

    @Column(name = "PRODUCT", nullable = false)
    private Product product;

    @Column(name = "LOCATION", nullable = false)
    private Location location;

    @Column(name = "QUANTITY", nullable = false)
    private Integer quantity;
}
