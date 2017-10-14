package bwphackstl17.smartneighborhood.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import bwphackstl17.smartneighborhood.base.BaseController;

@Controller
public class IndexController extends BaseController {
	
	@RequestMapping(value="/")
	public String index() {
		return "index";
	}

}
