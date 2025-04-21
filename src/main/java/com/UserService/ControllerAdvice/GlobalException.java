package com.UserService.ControllerAdvice;

import com.UserService.Exception.AdminException;
import com.UserService.Response.BaseApiResponse;
import com.UserService.Response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Manav Rajput Java Developer
 */
@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(AdminException.class)
    public ResponseEntity<BaseResponse> handleEmailServiceException(AdminException ex, Throwable cause) {
        return new ResponseEntity<>(new BaseResponse(0, String.valueOf(ex.getStatus().value()), ex.getMessage()),  ex.getStatus());
    }

}
