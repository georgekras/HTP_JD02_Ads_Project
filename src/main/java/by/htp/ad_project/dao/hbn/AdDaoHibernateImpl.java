package by.htp.ad_project.dao.hbn;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import by.htp.ad_project.dao.AdDao;
import by.htp.ad_project.domain.Ad;

@Component
@Repository
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
		Ad ad = (Ad) session.get(Ad.class, id);
		session.close();
		return ad;
	}

	@Override
	public List<Ad> readAll() {

		Session session = SessionFactoryManager.getSessionFactory().openSession();
		List<Ad> ads = session.createCriteria(Ad.class).list();
		session.close();

		return ads;
	}
	
	@Override
	public List<Ad> readUserAds(int user_ID) {

		Session session = SessionFactoryManager.getSessionFactory().openSession();
//		Query query = session.createQuery(hql);
//		query.setParameter("user_ID", user_ID);
//		List<Ad> ads = query.list();
		List<Ad> ads = session.createCriteria(Ad.class).add(Restrictions.eq("users_ID", user_ID)).list();
		session.close();

		return ads;
	}

	@Override
	public void update(Ad entity) {

		Session session = SessionFactoryManager.getSessionFactory().openSession();
		session.beginTransaction();
		session.merge(entity);
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
