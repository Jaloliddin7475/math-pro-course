package com.appcourse.payload.request.user;


import com.appcourse.service.marker.Modifiable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserUpdateRequest implements Modifiable {

    private String username;
    private String password;
    private String roles;
    private long courseId;
    private String userStatus;
}
