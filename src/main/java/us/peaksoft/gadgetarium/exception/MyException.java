package us.peaksoft.gadgetarium.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class MyException {
    private final String message;
    private final HttpStatus httpStatus;

}