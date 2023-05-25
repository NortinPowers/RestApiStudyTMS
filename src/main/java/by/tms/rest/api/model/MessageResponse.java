package by.tms.rest.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class MessageResponse {

    private final Long timestamp = System.currentTimeMillis();
    private String message;
    @JsonIgnore
    private Object object;
}
