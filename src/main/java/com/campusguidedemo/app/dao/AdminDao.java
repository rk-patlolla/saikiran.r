package com.campusguidedemo.app.dao;

import java.util.List;
import com.campusguidedemo.app.pojo.Course;

public interface AdminDao {

	public Course addCourse(Course course);

	public List<Course> getCourseDetails();

	public String deleteCoursebyid(Long cId);

	public Course updateCourse(Course course);

}
