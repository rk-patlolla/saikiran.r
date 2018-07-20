package com.campusguidedemo.app.service;

import java.util.List;
import java.util.Map;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.campusguidedemo.app.pojo.Student;

public interface StudentService {

	public Student addStudent(Student student);

	public List<Student> getStudent();

	public Student getStudentById(Student student);

	public Student updateStudentById(Student student);

	public Map<Long, String> getStudentByName();

	public Long getStudentsId(String studentName);

	/* using this same method user existance while logging in */
	public String checkMobileNoForReg(String mobileNo)throws UsernameNotFoundException;
	


}