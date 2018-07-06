package com.campusguide.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campusguide.app.pojo.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
