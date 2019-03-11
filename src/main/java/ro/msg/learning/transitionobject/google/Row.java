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
public class Row {

    private List<Element> elements;
}
