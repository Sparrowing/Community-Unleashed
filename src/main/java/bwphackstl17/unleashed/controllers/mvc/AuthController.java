package bwphackstl17.unleashed.controllers.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bwphackstl17.unleashed.base.BaseController;
import bwphackstl17.unleashed.entities.User;
import bwphackstl17.unleashed.util.Helpers;

@Controller
public class AuthController extends BaseController {
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String registerGet() {
		return "register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerPost(HttpServletRequest request) {
		
		boolean error = false;
		
		// Retrieve form fields
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String verify   = request.getParameter("verify");
		
		
		// Error-checking
		
		// Validate username
		if (Helpers.isBlankField(username))
			error = true;
		
		else if (!User.isValidUsername(username))
			error = true;
		
		else if (userRepo.findByUsername(username) != null)
			error = true;
		
		
		// Validate password
		if (Helpers.isBlankField(password))
			error = true;
		
		else if (!User.isValidPassword(password))
			error = true;
		
		
		// Validate verification field
		if (Helpers.isBlankField(verify))
			error = true;
		else if (!verify.equals(password))
			error = true;
		
		
		// Re-render page
		
		// If no errors, proceed to create user
		if (!error) {
			
			User newUser = new User(username, password);
			userRepo.save(newUser);
			setSessionLogin(request.getSession(), newUser);
			
			return "redirect:/";
		}
		
		return "register";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginGet() {
		return "login_form";
	}
	
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginPost(HttpServletRequest request) {

		boolean error = false;
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if (Helpers.isBlankField(password))
			error = true;
		
		if (Helpers.isBlankField(username))
			error = true;
		
		if (!error) {
			
			User usernameMatch = userRepo.findByUsername(username);
			
			if (usernameMatch == null)
				error = true;
			else if (!usernameMatch.isPasswordMatch(password))
				error = true;
			
			else {
				setSessionLogin(request.getSession(), usernameMatch);
				return "redirect:/";
			}
			
		}
		
		
		// If there were any errors, code spills down to here
		
		// Re-render page with errors
		return "login_form";
		
	}

}
