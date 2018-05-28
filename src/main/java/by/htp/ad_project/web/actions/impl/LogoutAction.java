package by.htp.ad_project.web.actions.impl;

import static by.htp.ad_project.web.util.WebConstantDeclaration.*;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/logout_action")
public class LogoutAction {

	@RequestMapping(method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return REDIRECT_TO + "/main_action";
	}

}
