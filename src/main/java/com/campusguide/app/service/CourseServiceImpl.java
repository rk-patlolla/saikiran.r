package com.campusguide.app.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusguide.app.dao.CourseDao;
import com.campusguide.app.pojo.Course;
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
	CourseDao coursedao;
	@Override
	public Course addCousrse(Course course) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		course.setCreatedDate(timestamp);
		course.setUpdatedDate(timestamp);
		Course coursesaved=coursedao.addCourse(course);
		return coursesaved;
	}
	@Override
	public List<Course> viewCourse() {
	List<Course> courselist=coursedao.viewCourse();
		return courselist;
	}
	@Override
	public String deleteCoursebyId(Long cId) {
		coursedao.deleteCoursebyid(cId);
		return "deleted";
	}
	@Override
	public Course updateCourse(Course course) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		course.setUpdatedDate(timestamp);
		Course courseupdated=coursedao.updateCourse(course);
		return courseupdated;
	}

}
