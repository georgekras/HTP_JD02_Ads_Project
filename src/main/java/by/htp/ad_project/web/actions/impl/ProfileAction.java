package by.htp.ad_project.web.actions.impl;

import static by.htp.ad_project.web.util.WebConstantDeclaration.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.htp.ad_project.domain.User;
import by.htp.ad_project.service.UserService;
import by.htp.ad_project.web.util.FormUtil;

@Controller
@RequestMapping(value = "/profile_action")
public class ProfileAction {

    private static final String MSG_PROFILE_UPDATED = "Your profile updated.";
	
	@Autowired
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String viewProfile(HttpServletRequest request, HttpSession session) {
		session = request.getSession();
		Object o = session.getAttribute("user");
		if (o == null) {
			return REDIRECT_TO + "/main_action";
		} else
			return PAGE_USER_PROFILE;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String profile(HttpServletRequest request, HttpSession session) {
		session = request.getSession();
		Object o = session.getAttribute("user");
		User user = (User) o;
		String password = FormUtil.getString(request, REQUEST_PARAM_USER_PASSWORD);
		String phoneNumber = FormUtil.getString(request, REQUEST_PARAM_USER_PHONENUMBER);
		user.setPassword(password);
		user.setPhoneNumber(phoneNumber);
		userService.update(user);
		request.setAttribute(REQUEST_MSG_SUCCESS, MSG_PROFILE_UPDATED);
		return PAGE_USER_PROFILE;
	}

}
