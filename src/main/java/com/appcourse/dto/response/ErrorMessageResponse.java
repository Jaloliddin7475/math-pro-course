package com.appcourse.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ErrorMessageResponse {

    private int statusCode;
    private Date timeStamp;
    private String message;
    private String description;

    public ErrorMessageResponse (int statusCode, Date timeStamp, String message, String description) {
        this.statusCode = statusCode;
        this.timeStamp = timeStamp;
        this.description = description;
        this.message = message;
    }
}
