package pro.sky.java.lesson18.webmapemployeemap18.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeIsNotFoundException extends RuntimeException {

    public EmployeeIsNotFoundException() {
    }

    public EmployeeIsNotFoundException(String message) {
        super(message);
    }

    public EmployeeIsNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }


}
