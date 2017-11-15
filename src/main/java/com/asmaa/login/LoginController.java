package com.asmaa.login;
 


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginController {
 
     

	  @Autowired
	  UserDetailsService userDetailsService;
	  @RequestMapping(value = "/login", method = RequestMethod.GET)
	  public ModelAndView showLogin(@RequestParam(name="error",required=false) String error,@RequestParam(name="success_reg",required=false) String success_reg) {
	    ModelAndView mav = new ModelAndView("login");
	   if(error!=null)
	   {
		   mav.addObject("message","Invalid Username and password");
	   }
	   if(success_reg!=null)
	   {
		   mav.addObject("success_reg","true");
	   }
	    mav.addObject("title", "Login");
	    	    return mav;
	  }
	
}