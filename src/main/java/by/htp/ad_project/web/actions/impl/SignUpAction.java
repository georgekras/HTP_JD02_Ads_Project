package by.htp.ad_project.web.actions.impl;

import static by.htp.ad_project.web.util.WebConstantDeclaration.*;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.exception.ConstraintViolationException;

import by.htp.ad_project.domain.User;
import by.htp.ad_project.service.UserService;
import by.htp.ad_project.web.actions.BaseAction;
import by.htp.ad_project.web.util.FormUtil;
import by.htp.ad_project.web.util.HttpRequestParamValidator;
import by.htp.ad_project.web.util.SessionUser;
import by.htp.ad_project.web.util.ValidateNullParamException;

public class SignUpAction implements BaseAction{

	
    private UserService userService;

    public void setUserService(UserService userService) {
	this.userService = userService;
    }

	@Override
	public String executeAction(HttpServletRequest request) {

		if (!FormUtil.isPost(request)) {
		    return PAGE_USER_SIGNUP;
		} else {

			String login = request.getParameter(REQUEST_PARAM_USER_LOGIN);
			String email = request.getParameter(REQUEST_PARAM_USER_EMAIL);
			String password = request.getParameter(REQUEST_PARAM_USER_PASSWORD);
			String nickname = request.getParameter(REQUEST_PARAM_USER_NICKNAME);
			String phonenumber = request.getParameter(REQUEST_PARAM_USER_PHONENUMBER);

			try {
			    HttpRequestParamValidator.validateRequestParamStringNotNull(login, email, password);
			    User user = new User(0, login, email, password, nickname, phonenumber, 2);
			    userService.create(user);
			    SessionUser.addUserSession(request, user);
			    return PAGE_USER_MAIN;
			} catch (ValidateNullParamException e) {
				request.setAttribute(REQUEST_MSG, "Check inputs");
			    return PAGE_USER_SIGNUP;
			} catch (ConstraintViolationException e) {
				request.setAttribute(REQUEST_MSG, "Login");
			    return PAGE_USER_SIGNUP;
			}
		}
	}
    
    
}
