package by.tms.rest.api.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static by.tms.rest.api.utils.ExceptionUtils.DATA_INTEGRITY_VIOLATION_EXCEPTION_MESSAGE;
import static by.tms.rest.api.utils.ExceptionUtils.JPA_OBJECT_RETRIEVAL_FAILURE_EXCEPTION_MESSAGE;
import static by.tms.rest.api.utils.ExceptionUtils.NOT_FOUND_EXCEPTION_MESSAGE;
import static by.tms.rest.api.utils.ExceptionUtils.getResponse;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    private ResponseEntity<ExceptionResponse> handleNotFoundException(NotFoundException exception) {
        ExceptionResponse response = getResponse(NOT_FOUND_EXCEPTION_MESSAGE, exception);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    private ResponseEntity<ExceptionResponse> handleDataIntegrityViolationException(DataIntegrityViolationException exception) {
        ExceptionResponse response = getResponse(DATA_INTEGRITY_VIOLATION_EXCEPTION_MESSAGE, exception);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(JpaObjectRetrievalFailureException.class)
    private ResponseEntity<ExceptionResponse> handleJpaObjectRetrievalFailureException(JpaObjectRetrievalFailureException exception) {
        ExceptionResponse response = getResponse(JPA_OBJECT_RETRIEVAL_FAILURE_EXCEPTION_MESSAGE, exception);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
