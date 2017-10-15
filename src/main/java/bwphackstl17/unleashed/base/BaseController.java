package bwphackstl17.unleashed.base;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import bwphackstl17.unleashed.entities.User;
import bwphackstl17.unleashed.entities.access.EventRepository;
import bwphackstl17.unleashed.entities.access.UserRepository;

public class BaseController {
	
	@Autowired
	protected EventRepository eventRepo;
	
	@Autowired
	protected UserRepository userRepo;
	
	protected static User user;
	
	protected static final String userSessionKey = "user_id";
	
	/*
	 * Returns the currently logged in user if there is one, else null
	 */
	protected User getSessionLogin(HttpSession session) {
		Integer userId = (Integer)session.getAttribute(userSessionKey);
		return userId == null ? null : userRepo.findById(userId);
	}
	
	/*
	 * Logs provided user into the session
	 */
	protected void setSessionLogin(HttpSession session, User user) {
		session.setAttribute(userSessionKey, user.getId());
		BaseController.user = user;
	}

}
