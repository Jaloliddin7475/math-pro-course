package com.appcourse.entity;

import com.appcourse.audit.Auditable;
import com.appcourse.entity.enums.CourseType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "course")
public class Course extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,unique = true)
    private String name;

    private String description;

    private float duration;

    @Enumerated(value = EnumType.STRING)
    private CourseType courseType;


}
