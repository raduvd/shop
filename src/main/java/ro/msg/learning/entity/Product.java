package ro.msg.learning.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vancer at 2/12/2019
 */
@Data
@EqualsAndHashCode(exclude = {"productCategory", "supplier"})
@ToString(exclude = {"productCategory", "supplier"})
@Entity(name = "PRODUCT")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,
        property = "@id")
@AllArgsConstructor()
@NoArgsConstructor
public class Product implements Serializable {

    public Product(Long id) {
        this.id = id;
    }

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_sequence")
    @SequenceGenerator(name = "product_sequence", sequenceName = "product_sequence", allocationSize = 1, initialValue = 1000)
    private Long id;

    @Column(name = "NAME", nullable = false, length = 50)
    private String name;

    @Column(name = "DESCRIPTION", length = 1000)
    private String description;

    @Column(name = "PRICE", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "WEIGHT", nullable = false, precision = 10, scale = 2)
    private Double weight;

    @ManyToOne(targetEntity = ProductCategory.class)
    @JoinColumn(name = "PRODUCT_CATEGORY", nullable = false)
    private ProductCategory productCategory;

    @ManyToOne(targetEntity = Supplier.class)
    @JoinColumn(name = "SUPPLIER", nullable = false)
    private Supplier supplier;

    @OneToMany(mappedBy = "orderDetailCompositeKey.product")
    private List<OrderDetail> orderDetailList = new ArrayList<>();

    @OneToMany(mappedBy = "stockCompositeKey.product")
    private List<Stock> productList = new ArrayList<>();
}
