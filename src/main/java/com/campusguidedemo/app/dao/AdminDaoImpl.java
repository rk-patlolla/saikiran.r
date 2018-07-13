package com.campusguidedemo.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.campusguidedemo.app.pojo.Course;
import com.campusguidedemo.app.repository.CourseRepository;

@Repository
public class AdminDaoImpl implements AdminDao {
	@Autowired
	CourseRepository courseRepository;

	@Override
	public Course addCourse(Course course) {
		Course coursesaved = courseRepository.save(course);
		return coursesaved;
	}

	@Override
	public List<Course> getCourseDetails() {
		List<Course> courselist = courseRepository.findAll();
		return courselist;
	}

	@Override
	public String deleteCoursebyid(Long cId) {
		try {
			courseRepository.deleteById(cId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "deleted";
	}

	@Override
	public Course updateCourse(Course course) {
		Course courseupdated = courseRepository.save(course);
		return courseupdated;
	}

}
