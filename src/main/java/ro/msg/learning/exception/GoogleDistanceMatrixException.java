package ro.msg.learning.exception;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by vancer at 2/28/2019
 */
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
@NoArgsConstructor
public class GoogleDistanceMatrixException extends RuntimeException {

    public GoogleDistanceMatrixException(String message) {
        super(message);
    }
}
