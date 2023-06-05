package by.tms.rest.api.exception;

import static by.tms.rest.api.utils.ResponseUtils.CITY_NOT_FOUND_EXCEPTION_MESSAGE;
import static by.tms.rest.api.utils.ResponseUtils.DATA_INTEGRITY_VIOLATION_EXCEPTION_MESSAGE;
import static by.tms.rest.api.utils.ResponseUtils.HTTP_NOT_READABLE_EXCEPTION_MESSAGE;
import static by.tms.rest.api.utils.ResponseUtils.JPA_OBJECT_RETRIEVAL_FAILURE_EXCEPTION_MESSAGE;
import static by.tms.rest.api.utils.ResponseUtils.METHOD_ARGUMENT_NOT_VALID_EXCEPTION_MESSAGE;
import static by.tms.rest.api.utils.ResponseUtils.NOT_FOUND_EXCEPTION_MESSAGE;
import static by.tms.rest.api.utils.ResponseUtils.getErrorValidationMessages;
import static by.tms.rest.api.utils.ResponseUtils.getExceptionResponse;

import by.tms.rest.api.model.BaseResponse;
import by.tms.rest.api.model.ErrorValidationResponse;
import by.tms.rest.api.model.ExceptionResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    private ResponseEntity<BaseResponse> handleException(NotFoundException exception) {
        ExceptionResponse response = getExceptionResponse(NOT_FOUND_EXCEPTION_MESSAGE, exception);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CityNotFoundException.class)
    private ResponseEntity<BaseResponse> handleException(CityNotFoundException exception) {
        ExceptionResponse response = getExceptionResponse(CITY_NOT_FOUND_EXCEPTION_MESSAGE, exception);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    private ResponseEntity<BaseResponse> handleException(DataIntegrityViolationException exception) {
        ExceptionResponse response = getExceptionResponse(DATA_INTEGRITY_VIOLATION_EXCEPTION_MESSAGE, exception);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(JpaObjectRetrievalFailureException.class)
    private ResponseEntity<BaseResponse> handleException(JpaObjectRetrievalFailureException exception) {
        ExceptionResponse response = getExceptionResponse(JPA_OBJECT_RETRIEVAL_FAILURE_EXCEPTION_MESSAGE, exception);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    private ResponseEntity<BaseResponse> handleException(HttpMessageNotReadableException exception) {
        ExceptionResponse response = getExceptionResponse(HTTP_NOT_READABLE_EXCEPTION_MESSAGE, exception);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<BaseResponse> handleException(MethodArgumentNotValidException exception) {
        ErrorValidationResponse errorValidationResponse = new ErrorValidationResponse(getErrorValidationMessages(exception), METHOD_ARGUMENT_NOT_VALID_EXCEPTION_MESSAGE);
        return new ResponseEntity<>(errorValidationResponse, HttpStatus.BAD_REQUEST);
    }
}
