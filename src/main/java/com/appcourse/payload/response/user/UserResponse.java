package com.appcourse.payload.response.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserResponse {

    private long id;
    private String username;
    private String password;
    private String roles;
    private String userStatus;
    private LocalDate startDate;
    private LocalDate endDate;

}
