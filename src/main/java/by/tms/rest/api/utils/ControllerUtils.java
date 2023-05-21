package by.tms.rest.api.utils;

import by.tms.rest.api.exception.NotFoundException;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ControllerUtils {

    public static <T> void throwExceptionWhenNull(T object) {
        if (object == null) {
            throw new NotFoundException("Sorry, but NotFoundException!");
        }
    }
}
