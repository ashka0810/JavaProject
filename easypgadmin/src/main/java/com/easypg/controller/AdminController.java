package com.easypg.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.easypg.model.Admin;
import com.easypg.service.AdminService;
import com.easypg.controller.LoginController;
import com.easypg.dao.AdminDao;

@Controller
@RequestMapping("/admin")
@SessionAttributes("admin")
public class AdminController {

	@Autowired
	AdminService adminService;

	@Autowired
	AdminDao adminDao;

	@Autowired
	HttpSession session;

	@RequestMapping("/home")
	public String home() {
		return "home";
	}

	@RequestMapping("/adminList")
	public String adminList(Model model) {
		List<Admin> list = adminService.getAll();
		model.addAttribute("adminList", list);
		return "/admin/manageadmin";
	}

	@RequestMapping("/error")
	public String error() {
		return "error";
	}

	@RequestMapping("/adminRegistrationPage")
	public String registrationpage(Model model) {
		Admin admin = new Admin();
		model.addAttribute("admin", admin);
		model.addAttribute("edit", false);
		return "/admin/addadmin";
	}

	@RequestMapping("/addAdmin")
	public String registrationpage(@ModelAttribute("admin") Admin admin, BindingResult result, Model model
			) {
		long result1 = adminService.addAdmin(admin);
		return "redirect:/admin/adminList";
	}

	@RequestMapping("deleteAdmin/{id}")
	public String deleteAdmin(@PathVariable("id") int id) {

		adminService.deleteAdmin(id);
		return "redirect:/admin/adminList";
	}

	@RequestMapping("/editAdmin/{id}")
	public String editAdmin(@PathVariable("id") long id, ModelMap model) {
		Admin admin = adminService.getById(id);
		model.addAttribute("admin", admin);
		model.addAttribute("edit", true);
		return "/admin/addadmin";
	}
	
	@RequestMapping("/viewAdmin/{id}")
	public String viewAdmin(@PathVariable("id") int id, ModelMap model) {
		Admin admin = adminService.getById(id);
		model.addAttribute("viewdetails", admin);
		return "/admin/editadmin";
	}

	@RequestMapping("/viewProfile")
	public String viewProfile(Model model) {
		Admin admin = (Admin) session.getAttribute("admin");
		Admin madmin = adminService.getById(admin.getAdminId());
		model.addAttribute("viewdetails", admin);
		return "/admin/editadmin";
	}

	@RequestMapping("/updateAdmin")
	public String updateAdmin(@ModelAttribute("admin") Admin admin, BindingResult result, Model model
			) {
		long res = adminService.updateAdmin(admin);
		return "redirect:/admin/adminList";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String displayLogin(Model model) {
		model.addAttribute("login", new LoginController());
		return "login";
	}
}