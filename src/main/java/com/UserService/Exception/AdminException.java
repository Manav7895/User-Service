package com.UserService.Exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * @author Manav Rajput Java Developer
 */
@Getter
public class AdminException extends RuntimeException {
    private HttpStatus status;

    public AdminException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
