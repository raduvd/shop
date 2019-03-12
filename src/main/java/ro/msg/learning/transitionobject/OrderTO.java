package ro.msg.learning.transitionobject;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Map;

/**
 * Created by vancer at 2/27/2019
 */
@Data
public class OrderTO {

    @NotNull
    private Date date;

    @NotNull
    @NotEmpty
    private String country;

    @NotNull
    @NotEmpty
    private String city;

    @NotNull
    @NotEmpty
    private String county;

    @NotNull
    @NotEmpty
    private String streetAddress;

    @NotNull
    @NotEmpty
    private Map<Long, Integer> productIdQuantityMap;
}
