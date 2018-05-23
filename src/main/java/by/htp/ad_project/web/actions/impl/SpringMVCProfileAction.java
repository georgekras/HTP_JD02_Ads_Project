package by.htp.ad_project.web.actions.impl;

import static by.htp.ad_project.web.util.WebConstantDeclaration.*;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import by.htp.ad_project.domain.User;
import by.htp.ad_project.service.UserService;
import by.htp.ad_project.web.util.FormUtil;

@Controller
@RequestMapping(value = "/profile_action")
public class SpringMVCProfileAction {

	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String viewProfile() {
		return "profile";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String profile(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return REDIRECT_TO + "/main_action";
		}
		else if (FormUtil.isPost(request)) {
            String password = FormUtil.getString(request, REQUEST_PARAM_USER_PASSWORD);
            String phoneNumber = FormUtil.getString(request, REQUEST_PARAM_USER_PHONENUMBER);
            user.setPassword(password);
            user.setPhoneNumber(phoneNumber);
            userService.update(user);
        }
		return null;
	}

}
