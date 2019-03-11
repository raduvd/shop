package ro.msg.learning.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vancer at 2/12/2019
 */
@Data
@Entity(name = "LOCATION")
@NoArgsConstructor
@AllArgsConstructor
public class Location implements Serializable {

    public Location(Long id) {
        this.id = id;
    }

    public Location(Location location) {
        this.id = location.id;
        this.name = location.name;
        this.orderList = location.orderList;
        this.stockList = location.stockList;
        this.address = location.address;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "location_sequence")
    @SequenceGenerator(name = "location_sequence", sequenceName = "location_sequence", allocationSize = 1, initialValue = 1000)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", nullable = false, length = 50)
    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "shippedFromLocation")
    private List<Order> orderList = new ArrayList<>();

    @OneToMany(mappedBy = "stockCompositeKey.location")
    private List<Stock> stockList = new ArrayList<>();
}
