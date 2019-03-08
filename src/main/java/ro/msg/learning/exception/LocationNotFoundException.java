package ro.msg.learning.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by vancer at 2/28/2019
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No Location was found.")
public class LocationNotFoundException extends RuntimeException {

}
