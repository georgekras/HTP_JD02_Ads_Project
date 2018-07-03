package by.htp.ad_project.web.controllers.impl;

import static by.htp.ad_project.web.util.WebConstantDeclaration.*;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.htp.ad_project.domain.User;
import by.htp.ad_project.service.UserService;
import by.htp.ad_project.web.util.FormUtil;

@Controller
@RequestMapping(value = "/edit_users_action")
public class EditUsersController {

	private static final String MSG_USER_UPDATED = " was updated.";
	private static final String MSG_USER_DELETED = " was deleted.";

	@Autowired
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String viewUsers(Model model) {
		List<User> users = userService.getAllUsers();
		model.addAttribute(REQUEST_PARAM_USER_LIST, users);
		return PAGE_ADMIN_EDIT_USERS;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String editUsers(HttpServletRequest request, HttpSession session, Model model) throws ParseException {
		int id = FormUtil.getInt(request, REQUEST_PARAM_USER_ID);
		String login = FormUtil.getString(request, REQUEST_PARAM_USER_LOGIN);
		String email = FormUtil.getString(request, REQUEST_PARAM_USER_EMAIL);
		String password = FormUtil.getString(request, REQUEST_PARAM_USER_PASSWORD);
		String nickname = FormUtil.getString(request, REQUEST_PARAM_USER_NICKNAME);
		String phoneNumber = FormUtil.getString(request, REQUEST_PARAM_USER_PHONENUMBER);
		int role_id = FormUtil.getInt(request, REQUEST_PARAM_USER_ROLES_ID);
		List<User> users = userService.getAllUsers();
		model.addAttribute(REQUEST_PARAM_USER_LIST, users);
		User user = new User(id, login, email, password, nickname, phoneNumber, role_id);
		if (request.getParameter("Update") != null) {
			userService.update(user);
			request.setAttribute(REQUEST_MSG_SUCCESS, "User " + user.getLogin() + MSG_USER_UPDATED);
			return PAGE_ADMIN_EDIT_USERS;
		} else if (request.getParameter("Delete") != null) {
			userService.delete(user);
			request.setAttribute(REQUEST_MSG, "User " + user.getLogin() + MSG_USER_DELETED);
			return PAGE_ADMIN_EDIT_USERS;
		}
		return null;
	}

}
