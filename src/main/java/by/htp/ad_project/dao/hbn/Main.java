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
		
		System.out.println(adDao.read(3));
		Ad ad = new Ad(0, "lolol", "lolol", "lolol", 555, 2, 2);
		adDao.create(ad);
		System.out.println("Ad added" + ad);
		ad.setTitle("123lasodasd");
		adDao.update(ad);
		System.out.println("Ad updated" + ad);		
		adDao.delete(ad);
		System.out.println("Ad deleted" + ad);
		 List<Ad> ads = adDao.readAll();
		 for (Ad ad1 : ads) {
		 System.out.println(ad1);
		 }
	}

}
