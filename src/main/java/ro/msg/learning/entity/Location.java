package ro.msg.learning.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vancer at 2/12/2019
 */
@Data
@Entity(name = "LOCATION")
public class Location extends Address {
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", nullable = false, length = 50)
    private String name;

    @OneToMany(mappedBy = "shippedFromLocation", fetch = FetchType.LAZY)
    private List<Order> orderList = new ArrayList<>();

    @OneToMany(mappedBy = "stockCompositeKey.location", fetch = FetchType.LAZY)
    private List<Stock> stockList = new ArrayList<>();
}
