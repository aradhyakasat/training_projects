package com.visa.prj.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.visa.prj.entity.Event;
import com.visa.prj.service.EventService;

@Controller
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	@RequestMapping("eventForm.do")
	public String getEventForm(Model model) {
		model.addAttribute("event",new Event(0,"EVENT NAME",new Date(),"Bangalore"));
		return "eventForm.jsp";
	}
	
	@RequestMapping("addEvent.do")
	public String addEvent(@ModelAttribute("event") Event event, BindingResult errors) {
		//eventService.addEvent("msg","Event Added Successfully");
		if(errors.hasErrors()) {
			return "eventForm.jsp";
		}
		
		else {
			eventService.addEvent(event);
		return "redirect:index.jsp?msg=Event added successfully";
		}
		
	}
	
	@RequestMapping("eventRegisterForm.do")
	public String getRegistrationForm(Model model) {
		model.addAttribute("events",eventService.getOpenEvents());
		return "register.jsp";
	}
	
	@RequestMapping("register.do")
	public String register(HttpServletRequest req) {
		String email=req.getParameter("email");
		String evt=req.getParameter("evt");
		eventService.register(email,evt);
		return "index.jsp?msg=Registration Successfully!!";
	}
	
	@InitBinder
	public void registerBinder(WebDataBinder binder) {
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy hh:mm");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
	}

}
