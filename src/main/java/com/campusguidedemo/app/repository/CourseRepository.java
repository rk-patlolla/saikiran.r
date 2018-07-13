package com.campusguidedemo.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campusguidedemo.app.pojo.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
