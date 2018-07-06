package com.campusguide.app.dao;

import java.util.List;

import com.campusguide.app.pojo.Course;

public interface CourseDao {
	
	
	public Course addCourse(Course course);
	public List<Course> viewCourse();
	public String deleteCoursebyid(Long cId);
	public Course updateCourse(Course course);

}
