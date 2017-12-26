package com.webschool.vst.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.webschool.vst.model.LoginModel;
import com.webschool.vst.model.StudentModel;
import com.webschool.vst.service.StudentServiceInterface;

@Controller
public class StudentController {

	@Autowired
	StudentServiceInterface studentService;
	@RequestMapping("/addStudent")
	public ModelAndView addStudent(HttpServletRequest request,StudentModel student) { 
		HttpSession session=request.getSession();
		LoginModel login=(LoginModel)session.getAttribute("USER");
		// setting user Id from session
		student.setUserid(login.getUserid());
		
		
		boolean success=studentService.addStudent(student);
		if(success)
			return new ModelAndView("Success", "message", "Student Added");  
		else
			return new ModelAndView("Failure", "message", "Student Added Failed...!"); 
    }
	
	@RequestMapping("/registerStudent")
	public ModelAndView registerStudent(HttpServletRequest request,StudentModel registerstudent) { 
		
		HttpSession session=request.getSession();
		LoginModel login=(LoginModel)session.getAttribute("USER");
		if(login==null)
			return new ModelAndView("login","pageName","course");//, "registerstudent", registerstudent);
			
		else
		
			return new ModelAndView("studentregister", "registerstudent", registerstudent);
    }
	
	public StudentServiceInterface getStudentService() {
		return studentService;
	}
	public void setStudentService(StudentServiceInterface studentService) {
		this.studentService = studentService;
	}
	
	
	
}
