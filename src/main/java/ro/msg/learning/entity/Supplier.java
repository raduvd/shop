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
@Entity(name = "SUPPLIER")
public class Supplier implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "supplier_sequence")
    @SequenceGenerator(name = "supplier_sequence", sequenceName = "supplier_sequence", allocationSize = 1, initialValue = 1000)
    private Long id;

    @Column(name = "NAME", nullable = false, length = 50)
    private String name;

    @OneToMany(mappedBy = "supplier")
    private List<Product> productList = new ArrayList<>();
}

