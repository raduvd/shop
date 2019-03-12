package ro.msg.learning.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by vancer at 2/12/2019
 */
@Data
@Entity(name = "REVENUE")
public class Revenue implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "revenue_sequence")
    @SequenceGenerator(name = "revenue_sequence", sequenceName = "revenue_sequence", allocationSize = 1, initialValue = 1000)
    private Long id;

    @ManyToOne(targetEntity = Location.class)
    @JoinColumn(name = "LOCATION", nullable = false)
    private Location location;

    @Temporal(value = TemporalType.DATE)
    @Column(name = "DATE")
    private Date date;

    @Column(name = "SUM", nullable = false, precision = 10, scale = 2)
    private BigDecimal sum;
}
