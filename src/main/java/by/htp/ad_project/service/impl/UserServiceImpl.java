package by.htp.ad_project.service.impl;

import java.util.List;

import by.htp.ad_project.dao.UserDao;
import by.htp.ad_project.domain.User;
import by.htp.ad_project.service.UserService;

public class UserServiceImpl implements UserService {

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


}
