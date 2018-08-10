package com.visa.prj.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.visa.prj.entity.User;
import com.visa.prj.service.EventService;

@Controller
public class UserController {
	@Autowired
	private UserValidator validator;
	
	@Autowired
	private EventService eventService;
	
	@RequestMapping("addUserForm.do")
	public String getUserForm(Model model) {
		model.addAttribute("user", new User());
		return  "userForm.jsp";
	}
	
	@RequestMapping("addUser.do")
	public String addUser(@ModelAttribute("user") User u, BindingResult errors) {
		validator.validate(u, errors);
		if(errors.hasErrors()) {
			return "userForm.jsp";
		}
		else {
		System.out.println(u.getId());
		System.out.println(u.getFirstName());
		System.out.println(u.getLastName());
		System.out.println(u.getEmail());
		System.out.println(u.getPhone());
		eventService.insertUser(u);
		return "redirect:index.jsp";
		}

		
		
	}
	
}
