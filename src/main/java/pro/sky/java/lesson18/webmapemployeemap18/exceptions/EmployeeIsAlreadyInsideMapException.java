package pro.sky.java.lesson18.webmapemployeemap18.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeIsAlreadyInsideMapException extends RuntimeException{

    public EmployeeIsAlreadyInsideMapException() {
    }

    public EmployeeIsAlreadyInsideMapException(String message) {
        super(message);
    }

    public EmployeeIsAlreadyInsideMapException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
