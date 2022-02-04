package xyx.ruhshan.suburb.infrastructure.web.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import xyx.ruhshan.suburb.core.location.exception.InvalidSuburbListException;
import xyx.ruhshan.suburb.infrastructure.web.response.ErrorResponse;


@Slf4j
@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler({InvalidSuburbListException.class})
    public ResponseEntity<ErrorResponse> handleInvalidSuburbListException(InvalidSuburbListException ex) {
        log.error("InvalidSuburbListException: {}", ex.getMessage());

        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({DataIntegrityViolationException.class})
    public ResponseEntity<ErrorResponse> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        log.error("DataIntegrityViolationException: {}", ex.getMessage());

        ErrorResponse errorResponse = new ErrorResponse("Request violates data integrity constraints");
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
