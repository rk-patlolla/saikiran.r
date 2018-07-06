package com.campusguide.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusguide.app.dao.StudentDao;
import com.campusguide.app.pojo.Student;
@Service
public class StudentServiceImpl implements StudentService{
@Autowired
	StudentDao studentDao;
	@Override
	public Student addStudent(Student student) {
		Student studentadded=studentDao.addStudent(student);
		return studentadded;
	}
}
