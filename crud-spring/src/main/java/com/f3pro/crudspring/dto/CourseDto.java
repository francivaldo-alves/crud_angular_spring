package com.f3pro.crudspring.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CourseDto implements Serializable {
    private final Long id;
    private final String name;
    private final String category;
}
