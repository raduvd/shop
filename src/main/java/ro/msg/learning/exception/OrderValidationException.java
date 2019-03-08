package ro.msg.learning.exception;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by vancer at 2/28/2019
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Order validation failed.")
@NoArgsConstructor
@Data
public class OrderValidationException extends RuntimeException {

    private Errors errors;

    public OrderValidationException(Errors errors) {

        this.errors = errors;
    }
}
