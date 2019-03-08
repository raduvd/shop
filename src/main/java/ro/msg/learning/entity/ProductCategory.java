package ro.msg.learning.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by vancer at 2/12/2019
 */

@Data
@Entity(name = "PRODUCT_CATEGORY")
public class ProductCategory implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_category_sequence")
    @SequenceGenerator(name = "product_category_sequence", sequenceName = "product_category_sequence", allocationSize = 1, initialValue = 1000)
    private Long id;

    @Column(name = "NAME", nullable = false, length = 50)
    private String name;

    @Column(name = "DESCRIPTION", length = 1000)
    private String description;

    @OneToMany(mappedBy = "productCategory")
    private List<Product> productList = new ArrayList<>();
}

