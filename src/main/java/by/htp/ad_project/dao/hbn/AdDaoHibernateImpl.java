package by.htp.ad_project.dao.hbn;

import java.util.List;

import org.hibernate.Session;

import by.htp.ad_project.dao.AdDao;
import by.htp.ad_project.domain.Ad;

@SuppressWarnings("unchecked")
public class AdDaoHibernateImpl implements AdDao {

	@Override
	public void create(Ad entity) {

		Session session = SessionFactoryManager.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(entity);
		session.getTransaction().commit();
		session.close();

	}

	@Override
	public Ad read(int id) {

		Session session = SessionFactoryManager.getSessionFactory().openSession();
		session.beginTransaction();
		Ad ad = (Ad) session.load(Ad.class, id);
		session.close();
		return ad;
	}

	@Override
	public List<Ad> readAll() {

		Session session = SessionFactoryManager.getSessionFactory().openSession();
		List<Ad> cars = session.createCriteria(Ad.class).list();
		session.close();

		return cars;
	}

	@Override
	public void update(Ad entity) {

		Session session = SessionFactoryManager.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(entity);
		session.getTransaction().commit();
		session.close();

	}

	@Override
	public void delete(Ad entity) {

		Session session = SessionFactoryManager.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(entity);
		session.getTransaction().commit();
		session.close();

	}

}
