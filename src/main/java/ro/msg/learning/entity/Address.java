package ro.msg.learning.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by vancer at 2/12/2019
 */
@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class Address implements Serializable {

    @Column(name = "COUNTRY", nullable = false, length = 50)
    private String country;

    @Column(name = "CITY", length = 50)
    private String city;

    @Column(name = "COUNTY", length = 50)
    private String county;

    @Column(name = "STREET_ADDRESS", nullable = false, length = 510)
    private String streetAddress;

    public String toString() {

        return String.join(",", Arrays.asList(streetAddress, city, county, country));
    }

}
