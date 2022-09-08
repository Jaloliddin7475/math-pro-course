package com.appcourse.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class APIException extends RuntimeException{

    public APIException (String message) {super(message);}
}
