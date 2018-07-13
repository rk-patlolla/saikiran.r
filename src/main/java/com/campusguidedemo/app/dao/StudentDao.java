package com.campusguidedemo.app.dao;

import java.util.List;

import com.campusguidedemo.app.pojo.Student;

public interface StudentDao {

	
	public Student addStudent(Student student);
	public List<Student> getStudents();
	
}
