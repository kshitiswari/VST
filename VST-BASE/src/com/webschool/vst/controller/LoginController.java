package com.webschool.vst.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.webschool.vst.model.LoginModel;
import com.webschool.vst.service.LoginServiceImpl;
import com.webschool.vst.service.LoginServiceInterface;

@Controller
public class LoginController {
	@Autowired
	
	LoginServiceInterface loginService;
	@RequestMapping("/addUser")
	public ModelAndView addUser(LoginModel user) { 
		boolean success=loginService.addUser(user);
		if(success)
			return new ModelAndView("testsuccess", "message", "User Added");  
		else
			return new ModelAndView("testfail", "message", "User Added Failed...!"); 
    }
	public void setLoginService(LoginServiceImpl loginService) {
		this.loginService = loginService;
	}  
	
	@RequestMapping("/login")
	public ModelAndView login(LoginModel user) { 
		 LoginModel userdataFromDB=loginService.login(user.getUserid());
		 if(userdataFromDB!=null){
			 if(user.getPassword().equals(userdataFromDB.getPassword()))
				 return new ModelAndView("testsuccess", "message", "User Found");
			 else
				 return new ModelAndView("testfail", "message", "UserId or Password invalid!");
			 
		 }else
			 return new ModelAndView("testfail", "message", "User Does not exist!");
    }
	
	
}


/*
@Controller
public class TestController {
	
	@RequestMapping("/test")
	public ModelAndView helloWorld() {  
        String message = "HELLO SPRING MVC HOW R U";  
        return new ModelAndView("test", "message", message);  
    }  
	

*/