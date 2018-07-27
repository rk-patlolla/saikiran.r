package com.campusguidedemo.app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.campusguidedemo.app.pojo.Course;
import com.campusguidedemo.app.repository.CourseRepository;
import com.campusguidedemo.app.repository.StudentRepository;

@Service
public class CourseServiceImpl implements CourseService {
	public static final Logger logger = LoggerFactory.getLogger(CourseService.class);
	@Autowired
	CourseRepository courseRes;
	@Autowired
	StudentRepository studentRes;

	@Override
	public Course addCousrse(Course course) {
		return courseRes.save(course);
	}

	@Override
	public List<Course> viewCourse() {
		return courseRes.findAll();
	}

	@Override
	public Boolean deleteCoursebyId(Course course) {
		try {
			courseRes.deleteById(course.getcId());
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public Course updateCourse(Course course) {
	
		return courseRes.save(course);
	}

	/*
	 * @Override public Map<Long, String> getStudents() { List<Student> st =
	 * studentRes.findAll(); Map<Long, String> mp = new HashMap<>();
	 * st.stream().forEach(s -> mp.put(s.getsId(), s.getStudentName())); return mp;
	 * }
	 */

	@Override
	public Map<Long, String> getCourse() {
		/* Here getting CourseDetails for getting id and course name */
		List<Course> ct = courseRes.findAll();
		Map<Long, String> mp = new HashMap<>();
		ct.stream().forEach(s -> mp.put(s.getcId(), s.getCourseName() + "  " + s.getCourseType()));
		return mp;
	}

}
