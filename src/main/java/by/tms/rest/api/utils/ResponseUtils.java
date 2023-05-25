package by.tms.rest.api.utils;

import by.tms.rest.api.exception.ExceptionResponse;
import by.tms.rest.api.model.MessageResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ResponseUtils {

    public static final String CREATION_MESSAGE = "The %s have been successful created";
    public static final String UPDATE_MESSAGE = "The %s have been successful updated";
    public static final String DELETION_MESSAGE = "The %s have been successful deleted";
    public static final String NOT_FOUND_EXCEPTION_MESSAGE = "Object with this id wasn't found";
    public static final String DATA_INTEGRITY_VIOLATION_EXCEPTION_MESSAGE = "The input data does not correspond to the required";
    public static final String JPA_OBJECT_RETRIEVAL_FAILURE_EXCEPTION_MESSAGE = "The data entered violates the established requirements";

    public static <T> MessageResponse getSuccessResponse(String message, T t) {
        return new MessageResponse(String.format(message, getClassName(t)), t);
    }

    public static ExceptionResponse getExceptionResponse(String message, Exception exception) {
        return new ExceptionResponse(message, exception.getClass().getSimpleName());
    }


    private static <T> String getClassName(T t) {
        String className = t.getClass().getSimpleName().toLowerCase();
        return className.substring(0, className.length() - 3);
    }
}
