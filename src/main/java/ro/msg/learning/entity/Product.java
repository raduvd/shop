package ro.msg.learning.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vancer at 2/12/2019
 */
@Data
@EqualsAndHashCode(exclude={"productCategory","supplier"})
@ToString(exclude={"productCategory", "supplier"})
@Entity(name = "PRODUCT")
public class Product implements Serializable {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", nullable = false, length = 50)
    private String name;

    @Column(name = "DESCRIPTION", length = 1000)
    private String description;

    @Column(name = "PRICE", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "WEIGHT", nullable = false, precision = 10, scale = 2)
    private Double weight;

    @ManyToOne(targetEntity = ProductCategory.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_CATEGORY", nullable = false)
    private ProductCategory productCategory;

    @ManyToOne(targetEntity = Supplier.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "SUPPLIER", nullable = false)
    private Supplier supplier;

    @OneToMany(mappedBy = "orderDetailCompositeKey.product", fetch = FetchType.LAZY)
    private List<OrderDetail> orderDetailList = new ArrayList<>();

    @OneToMany(mappedBy = "stockCompositeKey.product", fetch = FetchType.LAZY)
    private List<Stock> productList = new ArrayList<>();
}
