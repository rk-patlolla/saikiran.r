package com.campusguidedemo.app.service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.campusguidedemo.app.pojo.Student;
import com.campusguidedemo.app.repository.StudentRepository;
import com.campusguidedemo.app.utils.ResourceNotFoundException;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentRepository studentRes;
	@Autowired
	EntityManager entityManager;
	public static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

	@Override
	public Student addStudent(Student student) {
		Student studentadded = new Student();
		try {
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			student.setCreated(timestamp);
			student.setUpdated(timestamp);
			student.setStudentpassword(new BCryptPasswordEncoder().encode(student.getStudentpassword()));
			studentadded = studentRes.save(student);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentadded;
	}

	@Override
	public List<Student> getStudent() {
		return studentRes.findAll();
	}

	@Override
	public Map<Long, String> getStudentByName() {
		/* Here getting CourseDetails for getting id and course name */
		List<Student> ct = studentRes.findAll();
		Map<Long, String> mp = new HashMap<>();
		ct.stream().forEach(s -> mp.put(s.getsId(),
				s.getStudentName() + "  " + s.getMobileNo() + "  " + s.getCourse().getCourseName()));
		return mp;
	}

	@Override
	public Student getStudentById(Student student) {
		logger.info("ID AT SERVICW" + student.getsId());
		return studentRes.findById(student.getsId())
				.orElseThrow(() -> new ResourceNotFoundException("student", "student", student.getsId()));
	}

	@Override
	public Student updateStudentById(Student student) {
		logger.info("IDXXXXXXXXXXXXXXXXXXXXXXXXXXXX__________" + student.getsId());
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		student.setUpdated(timestamp);
		return studentRes.save(student);
	}

	@Transactional
	@Override
	public Long getStudentsId(String studentName) {
		logger.info("MESSAGE " + studentName);
		String queryStr = "SELECT s.sId FROM Student s where s.studentName ='" + studentName + "'";
		Query query = entityManager.createQuery(queryStr);
		logger.info("MESSAGE " + query);
		Long id = (Long) query.getSingleResult();
		logger.info("MESSAGE " + id);
		return new Long(id.longValue());
	}

	@Override
	public String checkMobileNoForReg(String mobileNo)throws UsernameNotFoundException {
		Query query = null;
		try {
			String qureyStr = "Select s.mobileNo FROM Student s where s.mobileNo like '%"+mobileNo+"%'";
			query = entityManager.createQuery(qureyStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  (String) query.getSingleResult();
	}



}
