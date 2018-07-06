package com.campusguide.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.campusguide.app.pojo.Course;
import com.campusguide.app.repository.AdminRepository;

@Repository
public class AdminDaoImpl implements AdminDao {
	@Autowired
	AdminRepository adminRepository;

	@Override
	public Course addCourse(Course course) {
		Course coursesaved = adminRepository.save(course);
		return coursesaved;
	}

	@Override
	public List<Course> getCourseDetails() {
		List<Course> courselist = adminRepository.findAll();
		return courselist;
	}

	@Override
	public String deleteCoursebyid(Long cId) {
		try {
			adminRepository.deleteById(cId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "deleted";
	}

	@Override
	public Course updateCourse(Course course) {
		Course courseupdated = adminRepository.save(course);
		return courseupdated;
	}

}
