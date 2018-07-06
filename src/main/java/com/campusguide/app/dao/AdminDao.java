package com.campusguide.app.dao;

import java.util.List;

import com.campusguide.app.pojo.Course;
import com.campusguide.app.pojo.Student;

public interface AdminDao {
	
	
	public Course addCourse(Course course);
	public List<Course> getCourseDetails();
	public String deleteCoursebyid(Long cId);
	public Course updateCourse(Course course);

}
