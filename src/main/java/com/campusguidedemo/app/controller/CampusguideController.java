package com.campusguidedemo.app.controller;

import java.security.Principal;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import com.campusguidedemo.app.pojo.Course;
import com.campusguidedemo.app.service.CourseService;
import com.campusguidedemo.app.utils.MessagesProperties;

/* @RequestMapping("CampusguideController") */
@RestController
public class CampusguideController {
	@Autowired
	CourseService courseService;
	@Autowired
	private MessagesProperties messageP;

	public static final Logger logger = LoggerFactory.getLogger(CampusguideController.class);

	@GetMapping("/boot")
	public ModelAndView view() {
		ModelAndView view = new ModelAndView("boot");
		return view;
	}

	@GetMapping("/resgistration")
	public ModelAndView registration() {
		ModelAndView view = new ModelAndView("resgistration");
		return view;
	}

	@GetMapping("/accessDenied")
	public ModelAndView accessDenied() {
		ModelAndView view = new ModelAndView("accesDenied");
		return view;
	}
	/*
	 * @RequestMapping(value="/login", method = RequestMethod.POST) public
	 * ModelAndView login(@AuthenticationPrincipal final UserDetails details) {
	 * 
	 * String username = details.getUsername(); Collection<? extends
	 * GrantedAuthority> authorities = details.getAuthorities();
	 * List<GrantedAuthority> authoritiesList = new
	 * ArrayList<GrantedAuthority>(authorities); String authority="";
	 * if(authoritiesList.size()==1) { authority =
	 * String.valueOf(authoritiesList.get(0)); } String redirectview="";
	 * 
	 * if(authority.equals("ROLE_ADMIN")) { redirectview="admin"; } else{
	 * redirectview="studenthome"; }
	 * 
	 * return new ModelAndView(redirectview);
	 * 
	 * }
	 */

	/*
	 * @RequestMapping(value="login",method=RequestMethod.POST)
	 * 
	 * public ModelAndView login() {
	 * 
	 * 
	 * return new ModelAndView("admin");
	 * 
	 * }
	 */

	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("index");
		return view;
	}
	@GetMapping("/customlogin")
	public ModelAndView customlogin() {
		ModelAndView view = new ModelAndView("customlogin");
		return view;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	   public ModelAndView login(Model model, String error, String logout) {
	       if (error != null)
	           model.addAttribute("errorMsg", "Invalid Credentials");

	       if (logout != null)
	           model.addAttribute("msg", "You have been logged out successfully.");

	       return new ModelAndView("customlogin");
	   }

	@GetMapping("/userlogin")
	public ModelAndView admin(Model model, Principal principal)  {

		String page= "";
		String message="";
		UserDetails userDetails = (UserDetails) ((Authentication) principal).getPrincipal();
			String authority = userDetails.getAuthorities().toString();
			authority = authority.substring(1, authority.length() - 1);
			if (authority.equalsIgnoreCase("ROLE_ADMIN")) {
				page = "/admin";
				
			} else if (authority.equalsIgnoreCase("ROLE_USER")) {
				page = "/studenthome";
			} else {
				page = "/customlogin";
				message = "Bad Credentials";
				model.addAttribute("errMsg", message);
			}
		
		ModelAndView view = new ModelAndView(page);
		return view;
	}

	@RequestMapping("/addCourse")
	public ModelAndView addCourse(@ModelAttribute("Course") Course course) {
		return new ModelAndView("addCourse", "command", new Course());
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public ModelAndView saveCourse(@ModelAttribute("Course") @Valid Course course, BindingResult error, Model model) {
		if (error.hasErrors()) {
			return new ModelAndView("addCourse");
		}

		try {
			Course addCousrse = courseService.addCousrse(course);

			if (addCousrse != null) {
				model.addAttribute("MSG", messageP.getSaveSuccessMsg());
			}
		} catch (Exception e) {
			model.addAttribute("MSG", messageP.getSaveErrorMsg());
		}

		logger.debug("------------------------>>>>>>>>Check addedcourse" + course.getcId());
		return new ModelAndView("addCourse");
	}

	@RequestMapping("/viewCourse")
	public ModelAndView viewCourse() {
		return new ModelAndView("viewCourse", "Course", courseService.viewCourse());
	}

	@RequestMapping("/editCourse")
	public ModelAndView editCourse() {
		return new ModelAndView("editCourse", "Course", courseService.viewCourse());
	}

	@DeleteMapping("/deleteCourse/{cId}")
	public ModelAndView deleteCourse(@PathVariable Long cId, Model model, Course course) {
		course.setcId(cId);
		Boolean coursebyId = courseService.deleteCoursebyId(course);
		String message = "";
		String page = "";
		if (coursebyId == true) {
			message = "Deleted Sucessfully";
			page = "/editCourse";
		} else {
			message = "Cannot Delete This Data";
			page = "/editCourse";
		}

		model.addAttribute("errMsg", message);
		logger.info("MESSAGE------->" + message);
		RedirectView redirectView = new RedirectView(page);
		redirectView.setExposePathVariables(false);
		return new ModelAndView(redirectView);
	}

	@RequestMapping("/updateCourse")
	public ModelAndView updateCourse(@Valid Course course, BindingResult BindingResult) {
		courseService.updateCourse(course);
		return new ModelAndView("redirect:/editCourse");
	}

	// @RequestMapping("asignstudentcourse")
	// public ModelAndView getStudent(@ModelAttribute("StudentCourse") StudentCourse
	// studentcourse, Model model) {
	// Map<Long, String> studentmp = courseService.getStudents();
	// Map<Long, String> coursemp = courseService.getCourse();
	// model.addAttribute("corse", coursemp);
	// model.addAttribute("student", studentmp);
	// return new ModelAndView("asignstudent");
	// }

}
