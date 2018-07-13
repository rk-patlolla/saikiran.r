package com.campusguidedemo.app.service;

import java.util.List;
import java.util.Map;

import com.campusguidedemo.app.pojo.Course;

public interface CourseService {

	public Course addCousrse(Course course);

	public List<Course> viewCourse();

	public Boolean deleteCoursebyId(Course course);

	public Course updateCourse(Course course);

	/* public Map<Long, String> getStudents(); */

	public Map<Long, String> getCourse();
}
