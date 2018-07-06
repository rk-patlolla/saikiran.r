package com.campusguide.app.service;

import java.util.List;

import com.campusguide.app.pojo.Course;

public interface CourseService {
	
	
	public Course addCousrse(Course course);
	public List<Course> viewCourse();
	public String deleteCoursebyId(Long cId);
	public Course updateCourse(Course course);
}
