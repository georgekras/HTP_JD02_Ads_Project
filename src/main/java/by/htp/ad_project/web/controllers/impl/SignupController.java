package by.htp.ad_project.web.controllers.impl;

import java.util.Map;

import static by.htp.ad_project.web.util.WebConstantDeclaration.*;

import javax.servlet.http.HttpSession;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import by.htp.ad_project.domain.User;
import by.htp.ad_project.service.UserService;
import by.htp.ad_project.web.util.HttpRequestParamValidator;
import by.htp.ad_project.web.util.ValidateNullParamException;

@Controller
@RequestMapping(value = "/signup_action")
public class SignupController {

	private static final String MSG_NO_SINGUP_USER = "Can't sign up. Check your inputs.";
	private static final String MSG_USER_DUPLICATE = "User with this login or email already exists.";

	@Autowired
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String signUp() {
		return PAGE_USER_SIGNUP;
	}

	@RequestMapping(method = RequestMethod.POST)
	private String authorization(@RequestParam Map<String, String> params, HttpSession session, Model model) {
		String login = params.get(REQUEST_PARAM_USER_LOGIN);
		String password = params.get(REQUEST_PARAM_USER_PASSWORD);
		String email = params.get(REQUEST_PARAM_USER_EMAIL);
		String nickname = params.get(REQUEST_PARAM_USER_NICKNAME);
		String phonenumber = params.get(REQUEST_PARAM_USER_PHONENUMBER);

		try {
			HttpRequestParamValidator.validateRequestParamStringNotNull(login, password, email, nickname, phonenumber);
			User user = new User(0, login, email, password, nickname, phonenumber, 2);
			userService.create(user);
			session.setAttribute(REQUEST_PARAM_USER, user);
			return REDIRECT_TO + "/profile_action";
		} catch (ValidateNullParamException e) {
			model.addAttribute(REQUEST_MSG, MSG_NO_SINGUP_USER);
			return PAGE_USER_SIGNUP;
		} catch (ConstraintViolationException e) {
			model.addAttribute(REQUEST_MSG, MSG_USER_DUPLICATE);
			return PAGE_USER_SIGNUP;
		}
	}
}
