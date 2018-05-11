package by.htp.ad_project.web.util;

import static by.htp.ad_project.web.util.WebConstantDeclaration.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.htp.ad_project.domain.User;

public class SessionUser {

    private SessionUser() {
    }

    public static void addUserSession(HttpServletRequest request, User user) {

	HttpSession session = request.getSession();
	session.setAttribute(REQUEST_PARAM_USER, user);

    }

    public static User getUserSession(HttpServletRequest request) {
	HttpSession session = request.getSession();
	return (User) session.getAttribute(REQUEST_PARAM_USER);
    }

}