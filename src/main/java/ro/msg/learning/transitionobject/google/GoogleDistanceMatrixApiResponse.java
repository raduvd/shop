package ro.msg.learning.transitionobject.google;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by vancer at 3/11/2019
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoogleDistanceMatrixApiResponse implements Comparable<GoogleDistanceMatrixApiResponse> {

    private List<Row> rows;

    private List<String> destination_addresses;

    private List<String> origin_addresses;

    @Override
    public int compareTo(GoogleDistanceMatrixApiResponse googleDistanceMatrixApiResponse) {

        final Integer argumentDistance = googleDistanceMatrixApiResponse.rows.get(0).getElements().get(0).getDistance().getValue();
        final Integer currentDistance = this.rows.get(0).getElements().get(0).getDistance().getValue();
        return currentDistance - argumentDistance;
    }
}
