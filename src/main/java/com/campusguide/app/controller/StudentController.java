package com.campusguide.app.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.campusguide.app.pojo.Student;
import com.campusguide.app.service.StudentService;

@Controller

public class StudentController {
	@Autowired
	StudentService studentService;
	public static final Logger logger = LoggerFactory.getLogger(StudentController.class);
	@RequestMapping("/student")

	public ModelAndView student(@ModelAttribute("Student") Student student) {
		ModelAndView view = new ModelAndView("student");
		return view;
	}
   
	@RequestMapping(value = "addstudent", method = RequestMethod.POST)
	public ModelAndView addstudent(@ModelAttribute("Student") Student student) {
		studentService.addStudent(student);
		return new ModelAndView("student");
	}

}
