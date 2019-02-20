package ro.msg.learning.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by vancer at 2/12/2019
 */
@Data
@Entity(name = "PRODUCT")
public class Product implements Serializable {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PRICE", nullable = false, precision = 10,scale = 2)
    private BigDecimal price;

    @Column(name = "WEIGHT", nullable = false, precision = 10, scale = 2)
    private Double weight;

    @Column(name = "PRODUCT_CATEGORY", nullable = false)
    private Long productCategory;

    @Column(name = "SUPPLIER", nullable = false)
    private Long supplier;
}
