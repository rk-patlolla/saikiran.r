package com.campusguidedemo.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.campusguidedemo.app.pojo.Student;
import com.campusguidedemo.app.repository.StudentRepository;
@Repository
public class StudentImpl implements StudentDao {
	@Autowired
	StudentRepository studentRepository;

	@Override
	public Student addStudent(Student student) {
		Student saved=new Student();
		try {
			saved = studentRepository.save(student);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return saved;
	}

	@Override
	public List<Student> getStudents() {
      List<Student> st=studentRepository.findAll();
		return st;
	}

}
