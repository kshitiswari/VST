package com.webschool.vst.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.webschool.vst.model.StudentModel;
import com.webschool.vst.service.StudentServiceInterface;

@Controller
public class StudentController {

	@Autowired
	StudentServiceInterface studentService;
	@RequestMapping("/addStudent")
	public ModelAndView addStudent(StudentModel student) { 
		boolean success=studentService.addStudent(student);
		if(success)
			return new ModelAndView("testsuccess", "message", "Student Added");  
		else
			return new ModelAndView("testfail", "message", "Student Added Failed...!"); 
    }
	public StudentServiceInterface getStudentService() {
		return studentService;
	}
	public void setStudentService(StudentServiceInterface studentService) {
		this.studentService = studentService;
	}
	
	
	
}
