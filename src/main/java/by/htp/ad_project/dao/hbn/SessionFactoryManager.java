package by.htp.ad_project.dao.hbn;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import by.htp.ad_project.domain.Ad;
import by.htp.ad_project.domain.Category;
import by.htp.ad_project.domain.Role;
import by.htp.ad_project.domain.User;

public class SessionFactoryManager {

	private static SessionFactory sessionFactory;

	private static SessionFactory buildSessionFactory() {

		Configuration configuration = new Configuration();
//		configuration.configure("config/hibernate.cfg.xml");
		configuration.addAnnotatedClass(Ad.class);
		configuration.addAnnotatedClass(Category.class);
		configuration.addAnnotatedClass(Role.class);
		configuration.addAnnotatedClass(User.class);
		
		configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		configuration.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
		configuration.setProperty("hibernate.connection.url",
			"jdbc:mysql://localhost:3306/krasutski?serverTimezone=UTC");
		configuration.setProperty("hibernate.connection.username", "root");
		configuration.setProperty("hibernate.show_sql", "true");
		configuration.setProperty("hibernate.enable_lazy_load_no_trans", "true");
		configuration.setProperty("current_session_context_class", "thread");
		configuration.setProperty("hibernate.jdbc.serverTimezone", "UTC");

		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();

		return configuration.buildSessionFactory(serviceRegistry);
	}

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			sessionFactory = buildSessionFactory();
		}
		return sessionFactory;
	}

}
