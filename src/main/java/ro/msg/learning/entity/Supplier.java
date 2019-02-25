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
    private Long id;

    @Column(name = "NAME", nullable = false, length = 50)
    private String name;

    @OneToMany(mappedBy = "supplier", fetch = FetchType.LAZY)
    private List<Product> supplierList = new ArrayList<>();
}

