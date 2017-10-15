package bwphackstl17.unleashed.controllers.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import bwphackstl17.unleashed.base.BaseController;

@Controller
public class IndexController extends BaseController {
	
	@RequestMapping(value="/")
	public String index() {
		return "index";
	}

}
