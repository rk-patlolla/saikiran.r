package com.campusguidedemo.app.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.campusguidedemo.app.pojo.Student;
import com.campusguidedemo.app.service.CourseService;
import com.campusguidedemo.app.service.StudentService;
import com.campusguidedemo.app.utils.MessagesProperties;

/*@RequestMapping("StudentController")*/
@RestController
public class StudentController {
	@Autowired
	StudentService studentService;
	@Autowired
	CourseService courseService;
	@Autowired
	private MessagesProperties messageP;
	public static final Logger logger = LoggerFactory.getLogger(StudentController.class);

	@RequestMapping("/studenthome")
	public ModelAndView studenthome(Model model, Principal principal) {
		UserDetails userDetails = (UserDetails) ((Authentication) principal).getPrincipal();
		model.addAttribute("userDetails", userDetails.getUsername());
		return new ModelAndView("studenthome");
	}

	@PreAuthorize("hasAnyRole'USER'")
	@RequestMapping("/student")
	public ModelAndView student(@ModelAttribute("Student") Student student, Model model) {
		model.addAttribute("course", getCourse());
		return new ModelAndView("student");
	}

	@RequestMapping(value = "addstudent", method = RequestMethod.POST)
	public ModelAndView addstudent(@ModelAttribute("Student") @Valid Student student, BindingResult error,
			Model model) {
		if (error.hasErrors()) {
			return new ModelAndView("redirect:/student");
		}

		try {
			studentService.addStudent(student);
		} catch (Exception e) {
			return new ModelAndView("redirect:/student");
		}
		model.addAttribute("MESSAGE", "SUCESSFULLY REGISTERED PLEASE LOGIN");
		return new ModelAndView("index");
	}

	@RequestMapping("/viewStudentDetails")
	public ModelAndView getstudent() {
		return new ModelAndView("viewStudentDetails", "student", studentService.getStudent());
	}

	@RequestMapping("/aviewStudentDetails")
	public ModelAndView admingetstudent() {
		return new ModelAndView("aviewStudentDetails", "student", studentService.getStudent());
	}

	@RequestMapping("getStudent")
	public ModelAndView getStudentNameList(@ModelAttribute("Student") Student student) {

		return new ModelAndView("getStudentByName", "studentslist", studentService.getStudentByName());
	}

	@RequestMapping("getStudentDetailsById")
	public ModelAndView getStudentById(@ModelAttribute("Student") Student student, Model model) {
		logger.info("IDXXXgetSTudentDetails__________" + student.getsId());
		model.addAttribute("course", getCourse());
		model.addAttribute("studentslist", studentService.getStudentByName());
		return new ModelAndView("aviewStudentDetailsById", "Student", studentService.getStudentById(student));
	}

	@RequestMapping("/getSStudentDetailsById")
	public ModelAndView getSStudentById(Principal principal, @ModelAttribute("Student") Student student, Model model) {
		UserDetails userDetails = (UserDetails) ((Authentication) principal).getPrincipal();

		Long Id = studentService.getStudentsId(userDetails.getUsername());
		student.setsId(Id);
		model.addAttribute("course", getCourse());
		return new ModelAndView("getAndUpdateStudentDetail", "Student", studentService.getStudentById(student));
	}

	@RequestMapping(value = "updatestudent", method = RequestMethod.POST)
	public ModelAndView updateStudentById(@ModelAttribute("Student") @Valid Student student, BindingResult error,
			Model model) {
		if (error.hasErrors()) {
			return new ModelAndView("redirect:/getStudentDetailsById");
		}
		try {
			Student updateStudentById = studentService.updateStudentById(student);
			if (updateStudentById != null) {
				model.addAttribute("MSG", messageP.getUpdateSuccessMsg());
			}
		} catch (Exception e) {
			model.addAttribute("MSG", messageP.getUpdateErrorMsg());
		}
		return new ModelAndView("redirect:/getStudent");
	}

	@RequestMapping(value = "searchByMobileNo")
	public void searchByMobileNo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String res = studentService.checkMobileNoForReg(request.getParameter("mobileNo"));
		if (res != null) {
			response.setContentType("text/html");
			response.getWriter().print("available");
			PrintWriter out = response.getWriter();
			out.flush();
		}

	}

	private Map<Long, String> getCourse() {
		return courseService.getCourse();

	}
}
