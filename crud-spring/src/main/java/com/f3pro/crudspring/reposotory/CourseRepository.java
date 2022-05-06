package com.f3pro.crudspring.reposotory;

import com.f3pro.crudspring.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CourseRepository extends JpaRepository<Course, Long> {
}