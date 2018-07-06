package com.campusguide.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campusguide.app.pojo.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
