package com.easypguser.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.easypguser.model.User;
import com.easypguser.service.LoginService;

@Controller
@RequestMapping("/user")
@SessionAttributes("user")
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping("/login")
	public String loginPage()
	{
		return "login";
	}
	@RequestMapping("/loggingIn")
	public String login(@ModelAttribute("log") User user,Model model)
	{
		User newUser=loginService.login(user);
		if(newUser==null)
		{
			model.addAttribute("errorMsg", "Wrong Username or Password...!!!");
			return "redirect:/user/login";
		}
		model.addAttribute("user",newUser);
		return "redirect:/user/home";
	}
	
}
