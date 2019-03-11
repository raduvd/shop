package ro.msg.learning.transitionobject.google;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by vancer at 3/11/2019
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Element {

    private Distance distance;

    private Duration duration;
}