package by.htp.ad_project.web.controllers.impl;

import java.util.List;

import static by.htp.ad_project.web.util.WebConstantDeclaration.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import by.htp.ad_project.domain.Ad;
import by.htp.ad_project.domain.Category;
import by.htp.ad_project.service.AdService;
import by.htp.ad_project.service.CategoryService;

@RestController
@RequestMapping(value = "/")
public class MainController {

	@Autowired
	private AdService adService;

	@Autowired
	private CategoryService categoryService;

	public void setAdService(AdService adService) {
		this.adService = adService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@RequestMapping(value = "/main_action", method = RequestMethod.GET)
	public ModelAndView mainAction(ModelMap model) {
		List<Ad> ads = adService.getAllAds();
		List<Category> categories = categoryService.getAllCategories();
		model.addAttribute(REQUEST_PARAM_CATEGORIES_LIST, categories);
		model.addAttribute(REQUEST_PARAM_ADS_LIST, ads);
		return new ModelAndView(PAGE_USER_MAIN);
	}
}
