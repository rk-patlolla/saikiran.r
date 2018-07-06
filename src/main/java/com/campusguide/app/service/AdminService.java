package com.campusguide.app.service;

import java.util.List;
import java.util.Map;

import com.campusguide.app.pojo.Course;

public interface AdminService {

	public Course addCousrse(Course course);

	public List<Course> viewCourse();

	public String deleteCoursebyId(Long cId);

	public Course updateCourse(Course course);

	public Map<Long, String> getStudents();
	
	public Map<Long, String> getCourse();
}
