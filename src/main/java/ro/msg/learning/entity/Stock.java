package ro.msg.learning.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"stockCompositeKey"})
public class Stock implements Serializable {

    public Stock(Stock stock) {

        this.stockCompositeKey = stock.stockCompositeKey;
        this.quantity = stock.quantity;
    }

    @EmbeddedId
    private StockCompositeKey stockCompositeKey;

    @Column(name = "QUANTITY", nullable = false)
    private Integer quantity;

    @JsonProperty("productId")
    public Long getProductId() {

        return stockCompositeKey.getProduct().getId();
    }

    @JsonProperty("locationId")
    public Long getLocationId() {

        return stockCompositeKey.getLocation().getId();
    }
}
