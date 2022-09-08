package com.appcourse.payload.request.user;

import com.appcourse.service.marker.Creationable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserRegisterRequest implements Creationable {

    private String username;

    private String password;

    private long courseId;

    private String roleName;
}
