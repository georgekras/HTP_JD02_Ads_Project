package by.htp.ad_project.web.actions.impl;

import static by.htp.ad_project.web.util.WebConstantDeclaration.*;

import javax.servlet.http.HttpServletRequest;

import by.htp.ad_project.domain.User;
import by.htp.ad_project.service.UserService;
import by.htp.ad_project.web.actions.BaseAction;
import by.htp.ad_project.web.util.FormUtil;
import by.htp.ad_project.web.util.HttpRequestParamValidator;
import by.htp.ad_project.web.util.SessionUser;
import by.htp.ad_project.web.util.ValidateNullParamException;

public class LoginAction implements BaseAction {

	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public String executeAction(HttpServletRequest request) {
		
		String login = request.getParameter(REQUEST_PARAM_USER_LOGIN);
		String password = request.getParameter(REQUEST_PARAM_USER_PASSWORD);
		
		if (!FormUtil.isPost(request)) {
			return PAGE_USER_LOGIN;
		} else {
			try {
				HttpRequestParamValidator.validateRequestParamStringNotNull(login, password);
				User user = userService.loginRead(login, password);
				HttpRequestParamValidator.validateRequestParamObjectNotNull(user);
				SessionUser.addUserSession(request, user);
				return PAGE_USER_MAIN;
			} catch (ValidateNullParamException e) {
				request.setAttribute(REQUEST_MSG, "No user");
				return PAGE_USER_LOGIN;
			}
		}

	}
}
