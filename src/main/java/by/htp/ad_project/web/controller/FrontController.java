package by.htp.ad_project.web.controller;

import static by.htp.ad_project.web.util.WebConstantDeclaration.REQUEST_PARAM_ACTION;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import by.htp.ad_project.web.actions.ActionManagerContext;
import by.htp.ad_project.web.actions.BaseAction;

public class FrontController extends HttpServlet{
	
	public FrontController() {
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext servletContext = request.getServletContext();
		WebApplicationContext webApplicationContext = WebApplicationContextUtils
				.getWebApplicationContext(servletContext);
		String action = request.getParameter(REQUEST_PARAM_ACTION);
		BaseAction baseAction = ActionManagerContext.getAction(action, webApplicationContext);
		if (action != null) {
			String page = baseAction.executeAction(request);
			request.getRequestDispatcher(page).forward(request, response);
		} else {
			response.getWriter().println("Incorrect Action!");
		}
	}
}
