package com.campusguide.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.campusguide.app.pojo.Course;
import com.campusguide.app.repository.CourseRepository;
@Repository
public class CourseDaoImpl implements CourseDao {
   @Autowired
	CourseRepository courserepository;
	@Override
	public Course addCourse(Course course) {
		Course coursesaved=courserepository.save(course);
		return coursesaved;
	}
	@Override
	public List<Course> viewCourse() {
		List<Course> courselist=courserepository.findAll();
		return courselist;
	}
	@Override
	public String deleteCoursebyid(Long cId) {
		try {
			courserepository.deleteById(cId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "deleted";
	}
	@Override
	public Course updateCourse(Course course) {
		Course courseupdated=courserepository.save(course);
		return courseupdated;
	}


}
