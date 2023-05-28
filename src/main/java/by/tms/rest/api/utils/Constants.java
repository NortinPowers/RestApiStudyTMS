package by.tms.rest.api.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Constants {

    public static final String STUDENT_NAMES_VALIDATION_PATTERN = "^[a-zA-Z][a-zA-Z-`_.]{1,30}$";
    public static final String CITY_NAMES_VALIDATION_PATTERN = "[A-Za-z\\s]{1,40}";
}
