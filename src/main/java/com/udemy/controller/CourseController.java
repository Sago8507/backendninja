package com.udemy.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.udemy.entity.Course;
import com.udemy.service.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {

	private static final String COURSES_VIEW = "courses";
	private static final Log LOG = LogFactory.getLog(CourseController.class);
	
	@Autowired
	@Qualifier("courseService")
	private CourseService courseService;
	
	@GetMapping("/listcourses")
	public ModelAndView listAllCourses(){
		LOG.info("call: CourseController.listAllCourses()");
		ModelAndView mav = new ModelAndView(COURSES_VIEW);
		mav.addObject("courses", courseService.listAllCourse());
		mav.addObject("course", new Course());
		return mav;
	}
	
	@PostMapping("addcourse")
	public RedirectView addCourse(@ModelAttribute("course") Course course){
		courseService.addCourse(course);
		return new RedirectView("/"+COURSES_VIEW+"/listcourses");
	}

//	@PostMapping("addcourse")
//	public String addCourse(@ModelAttribute("course") Course course){
//		LOG.info("call: CourseController.addCourse() -- Param: " + course.toString());
//		courseService.addCourse(course);
//		return "redirect:/"+COURSES_VIEW+"/listcourses";
//	}
	
}
