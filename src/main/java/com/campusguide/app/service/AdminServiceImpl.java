package com.campusguide.app.service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusguide.app.controller.CampusguideController;
import com.campusguide.app.dao.AdminDao;
import com.campusguide.app.dao.StudentDao;
import com.campusguide.app.pojo.Course;
import com.campusguide.app.pojo.Student;
@Service
public class AdminServiceImpl implements AdminService {
	public static final Logger logger = LoggerFactory.getLogger(AdminService.class);
    @Autowired
	AdminDao adminDao;
    @Autowired
   	StudentDao studentDao;
	@Override
	public Course addCousrse(Course course) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		course.setCreatedDate(timestamp);
		course.setUpdatedDate(timestamp);
		Course coursesaved=adminDao.addCourse(course);
		return coursesaved;
	}
	@Override
	public List<Course> viewCourse() {
	List<Course> courselist=adminDao.getCourseDetails();
		return courselist;
	}
	@Override
	public String deleteCoursebyId(Long cId) {
		adminDao.deleteCoursebyid(cId);
		return "deleted";
	}
	@Override
	public Course updateCourse(Course course) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		course.setUpdatedDate(timestamp);
		Course courseupdated=adminDao.updateCourse(course);
		return courseupdated;
	}
	@Override
	public Map<Long, String> getStudents() {
	List<Student> st=studentDao.getStudents();
	Map<Long,String> mp= new HashMap<>();
	st.stream().forEach(s->mp.put(s.getsId(), s.getStudentName()));
		return mp;
	}
	@Override
	public Map<Long, String> getCourse() {
	/*	Here getting CourseDetails for getting id and course name*/
		List<Course> ct=adminDao.getCourseDetails();
		Map<Long,String> mp= new HashMap<>();
		ct.stream().forEach(s->mp.put(s.getcId(), s.getCourseName()));
			return mp;
	}

}
