package ro.msg.learning.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Created by vancer at 2/12/2019
 */
@Data
@MappedSuperclass
public class Address implements Serializable {

    @Column(name = "COUNTRY", nullable = false)
    private String country;

    @Column(name = "CITY")
    private String city;

    @Column(name = "COUNTY")
    private String county;

    @Column(name = "STREET_ADDRESS", nullable = false)
    private String streetAddress;

}
