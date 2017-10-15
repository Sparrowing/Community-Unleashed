package bwphackstl17.smartneighborhood.controllers.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bwphackstl17.smartneighborhood.base.BaseController;
import bwphackstl17.smartneighborhood.entities.Event;

@RestController
public class EventsController extends BaseController {
	
	@RequestMapping(value="/events")
	public List<Event> test(HttpServletRequest req) {
		
		String idParam = req.getParameter("id");
		
		// If there's an id parameter
		if (idParam != null) {
			int id;
			
			try {
				id = Integer.parseInt(idParam);
			} catch (NumberFormatException e) {
				return null;
			}
			
			return eventRepo.findById(id);
		}
		
		// If no id specified return all
		return eventRepo.findAll();
	}

}
