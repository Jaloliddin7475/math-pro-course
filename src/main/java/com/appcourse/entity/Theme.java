package com.appcourse.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Theme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private int orderNumber;

    @ManyToOne
    private Video video;

    @ManyToMany
    private List<Test> tests;

    @ManyToOne
    private Bob bob;

    @ManyToOne
    private Attachment attachment;
}
