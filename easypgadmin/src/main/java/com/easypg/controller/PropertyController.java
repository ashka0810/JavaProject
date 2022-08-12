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
import org.springframework.web.multipart.MultipartFile;

import com.easypg.model.Property;
import com.easypg.service.PropertyService;

import com.easypg.controller.LoginController;
import com.easypg.dao.PropertyDao;

@Controller
@RequestMapping("/property")

public class PropertyController {

	@Autowired
	PropertyService propertyService;

	@Autowired
	PropertyDao propertyDao;

	@Autowired
	HttpSession session;

	@RequestMapping("/home")
	public String home() {
		return "home";
	}

	@RequestMapping("/error")
	public String error() {
		return "error";
	}

	@RequestMapping("/propertyList")

	public String propertylist(Model model) {
		List<Property> list = propertyService.getAll();
		model.addAttribute("propertyList", list);
		return "/property/listedproperty";
	}

	@RequestMapping("/submit")
	public String submitproperty(Model model) {
		Property property = new Property();
		model.addAttribute("property", property);
		model.addAttribute("edit", false);
		return "/property/addproperty";
	}

	@RequestMapping("/deleteProperty/{id}")
	public String deleteProperty(@PathVariable("id") long id) {

		propertyService.deleteProperty(id);

		return "redirect:/property/propertyList";
	}

}