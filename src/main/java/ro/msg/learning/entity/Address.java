package ro.msg.learning.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by vancer at 2/12/2019
 */
@Data
@Embeddable
public class Address implements Serializable {

    @Column(name = "COUNTRY", nullable = false, length = 50)
    private String country;

    @Column(name = "CITY", length = 50)
    private String city;

    @Column(name = "COUNTY", length = 50)
    private String county;

    @Column(name = "STREET_ADDRESS", nullable = false, length = 510)
    private String streetAddress;

}
