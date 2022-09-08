package com.appcourse.entity.enums;

import com.appcourse.exception.DataNotFoundException;

public enum CourseType {
    FAST (1),
    BOOTCAMP(2);

    public final  int flag;

    CourseType (int flag) {
        this.flag = flag;
    }

    public static CourseType getCourseType (String courseType) {
        for (CourseType courseType1 : CourseType.values()) {
            if (courseType1.name().equals(courseType)) {
                return courseType1;
            }
        }
        throw DataNotFoundException.of("Course type", courseType);
    }
}
