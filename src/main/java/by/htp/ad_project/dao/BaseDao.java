package by.htp.ad_project.dao;

import java.util.List;

import by.htp.ad_project.domain.Entity;

public interface BaseDao<T extends Entity> {

	void create(T entity);

	T read(int id);

	List<T> readAll();

	void update(T entity);

	void delete(T entity);
}
