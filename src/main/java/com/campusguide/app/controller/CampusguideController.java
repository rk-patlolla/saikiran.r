package com.campusguide.app.controller;



import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.campusguide.app.pojo.Course;
import com.campusguide.app.service.AdminService;

@Controller

public class CampusguideController {
@Autowired	
AdminService adminService;

public static final Logger logger = LoggerFactory.getLogger(CampusguideController.class);
	@GetMapping("/boot")
	   public ModelAndView view() {
		ModelAndView view=new ModelAndView("boot");
			return view;
		}
	@GetMapping("/resgistration")
	   public ModelAndView registration() {
		ModelAndView view=new ModelAndView("resgistration");
			return view;
		}
	@GetMapping("/index")
	   public ModelAndView index() {
		ModelAndView view=new ModelAndView("index");
			return view;
		}
	
	@GetMapping("/admin")
	   public ModelAndView admin() {
		ModelAndView view=new ModelAndView("admin");
			return view;
		}
	@RequestMapping("/addCourse")
	   public ModelAndView addCourse() {
		return new ModelAndView("addCourse","command",new Course());  
		}
	@RequestMapping(value="save", method = RequestMethod.POST)
	public  ModelAndView saveCourse(Course course) {
		adminService.addCousrse(course);
		logger.debug("------------------------>>>>>>>>Check addedcourse"+course.getcId());
		List<Course> courselist=adminService.viewCourse();
		return new ModelAndView("viewCourse","Course",courselist);
	}
	@RequestMapping("/viewCourse")
	   public ModelAndView viewCourse() {
		List<Course> courselist=adminService.viewCourse();
		return new ModelAndView("viewCourse","Course",courselist);  
		}
	@RequestMapping("/editCourse")
	   public ModelAndView editCourse() {
		List<Course> courselist=adminService.viewCourse();
		return new ModelAndView("editCourse","Course",courselist);  
		}
	
	@RequestMapping("/deleteCourse/{cId}")
     public String deleteCourse(@PathVariable Long cId,Model model) {
		adminService.deleteCoursebyId(cId);
		List<Course> courselist=adminService.viewCourse();
		model.addAttribute("Course", courselist);
		return "editCourse";
     	}
	@RequestMapping("/updateCourse")
	   public ModelAndView updateCourse(@Valid Course course,BindingResult BindingResult) {
		adminService.updateCourse(course);
		List<Course> courselist=adminService.viewCourse();
		return new ModelAndView("editCourse","Course",courselist);  
		}
	@RequestMapping("asignstudentcourse")
	public ModelAndView getStudent(Model model) {
		Map<Long, String> studentmp=adminService.getStudents();
		Map<Long, String> coursemp=adminService.getCourse();
        model.addAttribute("corse", coursemp);
        model.addAttribute("student", studentmp);
		return new ModelAndView("asignstudent");
	}
}
