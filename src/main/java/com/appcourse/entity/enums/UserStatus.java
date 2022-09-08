package com.appcourse.entity.enums;

import lombok.Getter;

@Getter
public enum UserStatus {
    ACTIVE(1),
    BLOCKED(2),
    DELETED(3);

    public final int value;
    UserStatus (int value) {
        this.value = value;
    }
}
