package ro.msg.learning.entity;

import lombok.Data;
import ro.msg.learning.entity.composite.StockCompositeKey;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created by vancer at 2/12/2019
 */
@Data
@Entity(name = "STOCK")
public class Stock implements Serializable {

    @EmbeddedId
    private StockCompositeKey stockCompositeKey;

    @Column(name = "QUANTITY", nullable = false)
    private Integer quantity;
}
