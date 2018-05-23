package by.htp.ad_project.dao.hbn;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import by.htp.ad_project.dao.UserDao;
import by.htp.ad_project.domain.User;

@Component
@Repository
@SuppressWarnings("unchecked")
public class UserDaoHibernateImpl implements UserDao {

	@Override
	public void create(User entity) {

		Session session = SessionFactoryManager.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(entity);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public User read(int id) {

		Session session = SessionFactoryManager.getSessionFactory().openSession();
		session.beginTransaction();
		session.close();
		return (User) session.load(User.class, id);
	}

	@Override
	public List<User> readAll() {

		Session session = SessionFactoryManager.getSessionFactory().openSession();
		List<User> users = session.createCriteria(User.class).list();
		session.close();
		return users;
		
	}

	@Override
	public void update(User entity) {

		Session session = SessionFactoryManager.getSessionFactory().openSession();
		session.beginTransaction();
		session.merge(entity);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void delete(User entity) {

		Session session = SessionFactoryManager.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(entity);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public User loginRead(String login, String password) {

		Session session = SessionFactoryManager.getSessionFactory().openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("Login", login)).add(Restrictions.eq("Password", password));
		List<User> users = criteria.list();

		session.close();
		if (!users.isEmpty()) {
		    return users.get(0);
		} else {
		    return null;
		}
	}

}
