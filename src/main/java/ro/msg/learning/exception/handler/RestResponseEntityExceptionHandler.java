package ro.msg.learning.exception.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ro.msg.learning.exception.GoogleDistanceMatrixException;
import ro.msg.learning.exception.LocationNotFoundException;
import ro.msg.learning.exception.OrderValidationException;

/**
 * Created by vancer at 3/4/2019
 */
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {LocationNotFoundException.class})
    protected ResponseEntity<Object> handleConflict(LocationNotFoundException ex, WebRequest request) {

        String bodyOfResponse = "No Location was found.";
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = {OrderValidationException.class})
    protected ResponseEntity<Object> handleConflict(OrderValidationException ex, WebRequest request) {

        String bodyOfResponse = ex.toString();
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value = {GoogleDistanceMatrixException.class})
    protected ResponseEntity<Object> handleConflict(GoogleDistanceMatrixException ex, WebRequest request) {

        String bodyOfResponse = ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}

