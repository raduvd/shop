package ro.msg.learning.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;


/**
 * Created by vancer at 2/12/2019
 */

@Data
@Entity(name = "PRODUCT_CATEGORY")
public class ProductCategory implements Serializable {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;
}

