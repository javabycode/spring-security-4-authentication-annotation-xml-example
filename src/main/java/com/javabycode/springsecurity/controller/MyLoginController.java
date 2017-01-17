package com.javabycode.springsecurity.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyLoginController {

	
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String welcomeView(ModelMap model) {
		model.addAttribute("message", "Welcome to my site. This is Spring Security Example");
		return "index";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminView(ModelMap model) {
		model.addAttribute("userName", getUserName());
		return "admin";
	}

	@RequestMapping(value = "/root", method = RequestMethod.GET)
	public String rootView(ModelMap model) {
		model.addAttribute("userName", getUserName());
		return "root";
	}

	@RequestMapping(value="/logout", method = RequestMethod.GET)
	   public String logoutView (HttpServletRequest request, HttpServletResponse response) {
	      Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      if (auth != null){    
	         new SecurityContextLogoutHandler().logout(request, response, auth);
	      }
	      return "index";
	   }

	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String errorView(ModelMap model) {
		model.addAttribute("userName", getUserName());
		return "error";
	}
	
	private String getUserName(){
		String userName = null;
		Object credential = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (credential instanceof UserDetails) {
			userName = ((UserDetails)credential).getUsername();
		} else {
			userName = credential.toString();
		}
		return userName;
	}
}