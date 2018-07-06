package com.campusguide.app.dao;

import java.util.List;

import com.campusguide.app.pojo.Student;

public interface StudentDao {

	
	public Student addStudent(Student student);
	public List<Student> getStudents();
}
