package com.campusguide.app.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.campusguide.app.pojo.Student;
import com.campusguide.app.repository.StudentRepository;
@Repository
public class StudentImpl implements StudentDao {
	@Autowired
	StudentRepository studentRepository;

	@Override
	public Student addStudent(Student student) {
		Student saved = studentRepository.save(student);
		return saved;
	}

	@Override
	public List<Student> getStudents() {
      List<Student> st=studentRepository.findAll();
		return st;
	}

}
