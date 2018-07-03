package by.htp.ad_project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.htp.ad_project.dao.UserDao;
import by.htp.ad_project.domain.User;
import by.htp.ad_project.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void create(User user) {
		userDao.create(user);
		
	}

	@Override
	public User read(int id) {
		return userDao.read(id);
	}

	@Override
	public void update(User user) {
		userDao.update(user);
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.readAll();
	}

	@Override
	public User loginRead(String login, String password) {
		return userDao.loginRead(login, password);
	}


}
