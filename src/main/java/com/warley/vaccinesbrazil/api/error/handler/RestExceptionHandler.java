package com.warley.vaccinesbrazil.api.error.handler;

import com.warley.vaccinesbrazil.api.error.ExceptionFilters;
import com.warley.vaccinesbrazil.api.error.UserNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Date;
import java.util.Set;

@RestControllerAdvice
@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ExceptionFilters> handlerUserNotFoundException(UserNotFoundException userNotFoundException) {
        ExceptionFilters notFound = ExceptionFilters.ExceptionFiltersBuilder.newBuilder()
                .title("User Not Found!")
                .timeStamp(new Date().getTime())
                .details(userNotFoundException.getMessage())
                .devMsg(userNotFoundException.getClass().getName())
                .status(HttpStatus.BAD_REQUEST.value())
                .build();
        return new ResponseEntity<>(notFound, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ExceptionFilters> handlerUserNotFoundException(ConstraintViolationException constraintViolationException) {

        StringBuilder message = new StringBuilder();
        Set<ConstraintViolation<?>> violations = constraintViolationException.getConstraintViolations();
        for (ConstraintViolation<?> violation : violations) {
            message.append(violation.getMessage().concat(";"));
        }

        ExceptionFilters constraintViolation = ExceptionFilters.ExceptionFiltersBuilder.newBuilder()
                .title("Invalid Arguments!")
                .timeStamp(new Date().getTime())
                .details(message.toString())
                .devMsg(constraintViolationException.getClass().getName())
                .status(HttpStatus.BAD_REQUEST.value())
                .build();
        return new ResponseEntity<>(constraintViolation, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ExceptionFilters> handlerUserNotFoundException(DataIntegrityViolationException dataIntegrityViolationException) {
        ExceptionFilters integrityViolation = ExceptionFilters.ExceptionFiltersBuilder.newBuilder()
                .title("Unique Constraints Violation!")
                .timeStamp(new Date().getTime())
                .details("It's not possible to save an existing email or cpf!")
                .devMsg(dataIntegrityViolationException.getClass().getName())
                .status(HttpStatus.BAD_REQUEST.value())
                .build();
        return new ResponseEntity<>(integrityViolation, HttpStatus.BAD_REQUEST);
    }

}
