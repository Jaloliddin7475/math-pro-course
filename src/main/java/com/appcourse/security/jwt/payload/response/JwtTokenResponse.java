package com.appcourse.security.jwt.payload.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JwtTokenResponse {

    private int statusCode;

    private String message;

    private String accessToken;

    private String refreshToken;
}
