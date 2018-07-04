//package by.htp.ad_project.config;
//
//import java.util.Properties;
//
//import javax.sql.DataSource;
//
//import org.apache.commons.dbcp2.BasicDataSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.orm.hibernate5.HibernateTransactionManager;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import by.htp.ad_project.domain.Ad;
//import by.htp.ad_project.domain.Category;
//import by.htp.ad_project.domain.Role;
//import by.htp.ad_project.domain.User;
//
//@Configuration
//@PropertySource("classpath:db_config.properties")
//@EnableTransactionManagement
//@ComponentScan(basePackages = {"by.htp.ad_project"})
//public class HibernateConfig {
//
//	@Autowired
//	   private Environment env;
//
//	   @Bean
//	   public DataSource getDataSource() {
//	      BasicDataSource dataSource = new BasicDataSource();
//	      dataSource.setDriverClassName(env.getProperty("db.driver"));
//	      dataSource.setUrl(env.getProperty("db.url"));
//	      dataSource.setUsername(env.getProperty("db.username"));
//	      dataSource.setPassword(env.getProperty("db.password"));
//	      return dataSource;
//	   }
//
//	   @Bean
//	   public LocalSessionFactoryBean getSessionFactory() {
//	      LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
//	      factoryBean.setDataSource(getDataSource());
//	      
//	      Properties props=new Properties();
//	      props.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
//	      props.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
//
//	      factoryBean.setHibernateProperties(props);
//	      factoryBean.setAnnotatedClasses(User.class);
//	      factoryBean.setAnnotatedClasses(Role.class);
//	      factoryBean.setAnnotatedClasses(Ad.class);
//	      factoryBean.setAnnotatedClasses(Category.class);
//	      return factoryBean;
//	   }
//
//	   @Bean
//	   public HibernateTransactionManager getTransactionManager() {
//	      HibernateTransactionManager transactionManager = new HibernateTransactionManager();
//	      transactionManager.setSessionFactory(getSessionFactory().getObject());
//	      return transactionManager;
//	   }
//	
//}
