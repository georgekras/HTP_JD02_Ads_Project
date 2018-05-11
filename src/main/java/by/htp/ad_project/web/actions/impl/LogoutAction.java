package by.htp.ad_project.web.actions.impl;

import static by.htp.ad_project.web.util.WebConstantDeclaration.*;

import javax.servlet.http.HttpServletRequest;

import by.htp.ad_project.web.actions.BaseAction;

public class LogoutAction implements BaseAction{

	@Override
	public String executeAction(HttpServletRequest request) {
		request.getSession().invalidate();
		return PAGE_USER_MAIN;
	}

}
