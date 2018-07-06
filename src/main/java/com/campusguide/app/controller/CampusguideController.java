package com.campusguide.app.controller;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.campusguide.app.pojo.Course;
import com.campusguide.app.service.CourseService;

@Controller
@RequestMapping("/CampusguideController")

public class CampusguideController {
@Autowired	
CourseService courseService;

	
	@GetMapping("/boot")
	   public ModelAndView view() {
		ModelAndView view=new ModelAndView("boot");
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
		courseService.addCousrse(course);
		List<Course> courselist=courseService.viewCourse();
		return new ModelAndView("viewCourse","Course",courselist);
	}
	@RequestMapping("/viewCourse")
	   public ModelAndView viewCourse() {
		List<Course> courselist=courseService.viewCourse();
		return new ModelAndView("viewCourse","Course",courselist);  
		}
	@RequestMapping("/editCourse")
	   public ModelAndView editCourse() {
		List<Course> courselist=courseService.viewCourse();
		return new ModelAndView("editCourse","Course",courselist);  
		}
	
	@RequestMapping("/deleteCourse/{cId}")
     public String deleteCourse(@PathVariable Long cId,Model model) {
		courseService.deleteCoursebyId(cId);
		List<Course> courselist=courseService.viewCourse();
		model.addAttribute("Course", courselist);
		return "editCourse";
     	}
	@RequestMapping("/updateCourse")
	   public ModelAndView updateCourse(@Valid Course course,BindingResult BindingResult) {
		courseService.updateCourse(course);
		List<Course> courselist=courseService.viewCourse();
		return new ModelAndView("editCourse","Course",courselist);  
		}
}
