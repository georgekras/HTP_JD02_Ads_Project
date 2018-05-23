package by.htp.ad_project.dao.hbn;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import by.htp.ad_project.dao.AdDao;
import by.htp.ad_project.dao.CategoryDao;
import by.htp.ad_project.dao.UserDao;
import by.htp.ad_project.domain.Ad;
import by.htp.ad_project.domain.User;

public class Main {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/webapp-config.xml");
		AdDao adDao = (AdDao) applicationContext.getBean("adDao");
		UserDao userDao = (UserDao) applicationContext.getBean("userDao");
		
		System.out.println(userDao.loginRead("admin", "admin"));
		User user = new User(0, "user1","user1@ad.aa", "qwerty","userqwerty", "+375447778899",2);
		System.out.println(user);
//		
//		Ad ad = new Ad(0,"asdasd","asdasd","asdasd",222, 2,2);
//		System.out.println(ad);
//		ad.setDescription("qwerty");
//		adDao.update(ad);
//		System.out.println(ad);
//		
		user.setNickname("blabloblu");
		userDao.update(user);
		System.out.println(user);

	}

}
