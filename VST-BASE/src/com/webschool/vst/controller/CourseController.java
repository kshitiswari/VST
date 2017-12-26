package com.webschool.vst.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.webschool.vst.model.CourseModel;
import com.webschool.vst.service.CourseServiceInterface;

@Controller	

public class CourseController {

@Autowired
	CourseServiceInterface courseService;
	@RequestMapping("/addCourse")
	public ModelAndView addCourse(CourseModel course) { 
		boolean success=courseService.addCourse(course);
		if(success)
			return new ModelAndView("testsuccess", "message", "Course Added");  
		else
			return new ModelAndView("testfail", "message", "Course Adding Failed...!"); 
    }
	
	@RequestMapping("/viewCourse")
	public ModelAndView viewCourse() {
		List<CourseModel> courseList =courseService.viewCourse();
		ModelAndView mav=new ModelAndView("courses", "courseList", courseList);
		for(CourseModel model:courseList)
			System.out.println(model);
		return mav;
		
			//return new ModelAndView("testfail", "message", courseList.get(0).getCoursename()); 
    }
	public CourseServiceInterface getCourseService() {
		return courseService;
	}
	public void setCourseService(CourseServiceInterface courseService) {
		this.courseService = courseService;
	}
	
}
