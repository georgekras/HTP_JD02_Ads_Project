package by.htp.ad_project.dao.hbn;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import by.htp.ad_project.dao.CategoryDao;
import by.htp.ad_project.domain.Category;

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
		Category category = (Category) session.get(Category.class, id);
		session.close();
		
		return category;
	}

	@Override
	public List<Category> readAll() {

		Session session = SessionFactoryManager.getSessionFactory().openSession();
		List<Category> categories = session.createCriteria(Category.class).list();

		return categories;
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
