package com.campusguidedemo.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campusguidedemo.app.pojo.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
