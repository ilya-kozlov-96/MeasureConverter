package by.bsu.kozlov;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IncorrectInputException extends RuntimeException {
    public IncorrectInputException() {
    }

    public IncorrectInputException(String message) {
        super("Incorrect input!");
    }
}
