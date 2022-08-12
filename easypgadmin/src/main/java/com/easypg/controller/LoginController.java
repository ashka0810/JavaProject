package com.easypg.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.easypg.model.Admin;
import com.easypg.service.LoginService;

@Controller
@RequestMapping("/admin")
@SessionAttributes("admin")
public class LoginController {

	@Autowired
	LoginService loginService;

	@Autowired
	HttpSession session;

	@RequestMapping("/login")
	public String loginPage() {
		return "login";
	}

	@RequestMapping("/loggingIn")
	public String login(@ModelAttribute("log") Admin admin, Model model) {
		Admin newAdmin = loginService.login(admin);
		if (newAdmin == null) {
			model.addAttribute("errorMsg", "Wrong Username or Password...!!!");
			return "redirect:/admin/login";
		}
		model.addAttribute("admin", newAdmin);
		return "redirect:/admin/home";
	}

}
