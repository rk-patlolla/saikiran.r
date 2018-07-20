package com.campusguidedemo.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.campusguidedemo.app.pojo.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
/*	@Query("SELECT sId FROM student  where studentName = :studentName")*/
   /*Long  getstudentsId(@Param("studentName") String student_name);*/

	//Student findByStudentName(String studentName);
	Student findUserByMobileNo(String mobileNo);
}
