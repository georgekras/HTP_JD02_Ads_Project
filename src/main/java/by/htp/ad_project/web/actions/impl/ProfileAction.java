package by.htp.ad_project.web.actions.impl;

import static by.htp.ad_project.web.util.WebConstantDeclaration.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.htp.ad_project.domain.User;
import by.htp.ad_project.service.UserService;
import by.htp.ad_project.web.util.FormUtil;

@Controller
@RequestMapping(value = "/profile_action")
public class ProfileAction {

	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String viewProfile() {
		return PAGE_USER_PROFILE;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String profile(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Object o = session.getAttribute("user");
        User user;
        if (o != null) {
            user = (User) o;
        } else
        	return REDIRECT_TO + "/main_action";
		if (FormUtil.isPost(request)) {
            String password = FormUtil.getString(request, REQUEST_PARAM_USER_PASSWORD);
            String phoneNumber = FormUtil.getString(request, REQUEST_PARAM_USER_PHONENUMBER);
            user.setPassword(password);
            user.setPhoneNumber(phoneNumber);
            userService.update(user);
        }
		return null;
	}

}
