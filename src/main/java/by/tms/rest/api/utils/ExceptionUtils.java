package by.tms.rest.api.utils;

import by.tms.rest.api.exception.ExceptionResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ExceptionUtils {

    public static final String NOT_FOUND_EXCEPTION_MESSAGE = "Object with this id wasn't found";
    public static final String DATA_INTEGRITY_VIOLATION_EXCEPTION_MESSAGE = "The input data does not correspond to the required";
    public static final String JPA_OBJECT_RETRIEVAL_FAILURE_EXCEPTION_MESSAGE = "The data entered violates the established requirements";

    public static ExceptionResponse getResponse(String message, Exception exception) {
        return new ExceptionResponse(message, exception.getClass().getSimpleName());
    }
}
