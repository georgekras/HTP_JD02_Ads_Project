package by.htp.ad_project.web.actions.impl;

import java.util.Map;

import static by.htp.ad_project.web.util.WebConstantDeclaration.*;

import javax.servlet.http.HttpSession;

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
@RequestMapping(value = "/login_action")
public class SpringMVCLoginAction {

	@Autowired
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String login(@RequestParam Map<String, String> params, Model model) {
		return "login";
	}

	@RequestMapping(method = RequestMethod.POST)
	private String authorization(@RequestParam Map<String, String> params, HttpSession session, Model model) {
		String login = params.get(REQUEST_PARAM_USER_LOGIN);
		String password = params.get(REQUEST_PARAM_USER_PASSWORD);
		try {
			HttpRequestParamValidator.validateRequestParamStringNotNull(login, password);
			User user = userService.loginRead(login, password);
			HttpRequestParamValidator.validateRequestParamObjectNotNull(user);
			session.setAttribute(REQUEST_PARAM_USER, user);
			return REDIRECT_TO + "/profile_action";
		} catch (ValidateNullParamException e) {
			//TODO msg to const
			model.addAttribute(REQUEST_MSG, "No user.");
			return "login";
		}

	}
}
