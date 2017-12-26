package com.webschool.vst.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	
	@RequestMapping("/test")
	public ModelAndView helloWorld() {  
		// dummy comment
        String message = "HELLO SPRING MVC HOW R U";  
        return new ModelAndView("test", "message", message);  
    }  
	

}
