package com.f3pro.crudspring.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("_id")
    private Long id;

    @Column(length = 115, nullable = false)
    private String name;

    @Column(nullable = false, length = 20)
    private String category;
}
