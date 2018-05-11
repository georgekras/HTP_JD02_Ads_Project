package by.htp.ad_project.service;

import java.util.List;

import by.htp.ad_project.domain.User;

public interface UserService {
	
	void create(User user);
	
	User read(int id);
	
	User loginRead(String login, String password);
	
	void update(User user);
	
	void delete(User user);
	
	List<User> getAllUsers();

}
