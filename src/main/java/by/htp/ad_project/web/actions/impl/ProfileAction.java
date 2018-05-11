package by.htp.ad_project.web.actions.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.htp.ad_project.web.util.WebConstantDeclaration.*;

import by.htp.ad_project.domain.User;
import by.htp.ad_project.service.UserService;
import by.htp.ad_project.web.actions.BaseAction;
import by.htp.ad_project.web.util.FormUtil;
import by.htp.ad_project.web.util.HttpRequestParamValidator;
import by.htp.ad_project.web.util.SessionUser;
import by.htp.ad_project.web.util.ValidateNullParamException;

public class ProfileAction implements BaseAction{

	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public String executeAction(HttpServletRequest request) {
		
		String password = request.getParameter(REQUEST_PARAM_USER_PASSWORD);
		String phonenumber = request.getParameter(REQUEST_PARAM_USER_PHONENUMBER);

        HttpSession session = request.getSession();
        Object o = session.getAttribute(REQUEST_PARAM_USER);
        User user;
        if (o != null) {
            user = (User) o;
        } else
            return PAGE_USER_LOGIN;
        
		if (!FormUtil.isPost(request)) {
			try {
				user.setPhoneNumber(phonenumber);
				user.setPassword(password);
				HttpRequestParamValidator.validateRequestParamStringNotNull(password, phonenumber);
				userService.update(user);
			} catch (ValidateNullParamException e) {
				request.setAttribute(REQUEST_MSG, "Check inputs");
			}
		}
		return PAGE_USER_PROFILE;
	}

}
