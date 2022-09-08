package com.appcourse.exception.handler;


import com.appcourse.exception.DataNotFoundException;
import com.appcourse.payload.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<?> handleNotFoundException (DataNotFoundException exception, WebRequest webRequest) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(APIResponse.error(exception.getMessage(),HttpStatus.NOT_FOUND));
    }
}
