package by.htp.ad_project.service;

import java.util.List;

import by.htp.ad_project.domain.Category;

public interface CategoryService {

	void create(Category category);
	
	Category read(int id);
	
	void update(Category category);
	
	void delete(Category category);
	
	List<Category> getAllCategories();

}
