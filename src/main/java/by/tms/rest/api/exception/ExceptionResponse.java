package by.tms.rest.api.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ExceptionResponse {

    private final Long timestamp = System.currentTimeMillis();
    private String message;
    private String type;
}
