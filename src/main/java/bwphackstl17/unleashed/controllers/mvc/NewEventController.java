package bwphackstl17.unleashed.controllers.mvc;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bwphackstl17.unleashed.base.BaseController;
import bwphackstl17.unleashed.entities.Event;

@Controller
public class NewEventController extends BaseController {
	
	@RequestMapping(value="/new", method=RequestMethod.GET)
	public String newEventGet() {
		return "new_event";
	}
	
	@RequestMapping(value="/new", method=RequestMethod.POST)
	public String newEventPost(HttpServletRequest request, Model model) {
		
		// Get values
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		double lat = Double.parseDouble(request.getParameter("latitude"));
		double lng = Double.parseDouble(request.getParameter("longitude"));
		@SuppressWarnings("deprecation")
		Date startTime = new Date(Date.parse(request.getParameter("time")));
		int duration = Integer.parseInt(request.getParameter("duration"));
		
		// Make new event object
		Event newEvent = new Event(name, description, lat, lng, startTime, duration);
		
		// Save new event
		eventRepo.save(newEvent);
		
		return "redirect:/";
	}

}
