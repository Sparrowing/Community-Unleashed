package bwphackstl17.smartneighborhood.controllers.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventsController {
	
	// TODO stub

	@RequestMapping(value="/test")
	public String test(@RequestParam(value="name", defaultValue="World") String name) {
		return "Hello, " + name + "!";
	}

}
