package com.f3pro.crudspring.controller;

import com.f3pro.crudspring.model.Course;
import com.f3pro.crudspring.reposotory.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;

    @GetMapping
    public List<Course> list() {
        return courseRepository.findAll();

    }
    @PostMapping
    public ResponseEntity<Course> create(@RequestBody Course course){

        course = courseRepository.save(course);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(course.getId()).toUri();
        return ResponseEntity.created(uri).body(course);


    }


}
