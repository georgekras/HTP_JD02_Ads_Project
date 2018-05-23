package by.htp.ad_project.dao.hbn;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import by.htp.ad_project.dao.CategoryDao;
import by.htp.ad_project.domain.Category;

@Component
@Repository
@SuppressWarnings("unchecked")
public class CategoryDaoHibernateImpl implements CategoryDao {

	@Override
	public void create(Category entity) {

		Session session = SessionFactoryManager.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(entity);
		session.getTransaction().commit();

	}

	@Override
	public Category read(int id) {

		Session session = SessionFactoryManager.getSessionFactory().openSession();
		session.beginTransaction();

		return (Category) session.load(Category.class, id);
	}

	@Override
	public List<Category> readAll() {

		Session session = SessionFactoryManager.getSessionFactory().openSession();
		List<Category> brands = session.createCriteria(Category.class).list();

		return brands;
	}

	@Override
	public void update(Category entity) {

		Session session = SessionFactoryManager.getSessionFactory().openSession();
		session.beginTransaction();
		session.merge(entity);
		session.getTransaction().commit();

	}

	@Override
	public void delete(Category entity) {

		Session session = SessionFactoryManager.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(entity);
		session.getTransaction().commit();

	}

}
