package by.htp.ad_project.web.actions.impl;

import javax.servlet.http.HttpServletRequest;

import static by.htp.ad_project.web.util.WebConstantDeclaration.*;

import by.htp.ad_project.service.AdService;
import by.htp.ad_project.service.CategoryService;
import by.htp.ad_project.web.actions.BaseAction;

public class MainAction implements BaseAction{
	
	private AdService adService;
	private CategoryService categoryService;

	public void setAdService(AdService adService) {
		this.adService = adService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@Override
	public String executeAction(HttpServletRequest request) {
		request.setAttribute(REQUEST_PARAM_ADS_LIST, adService.getAllAds());
		request.setAttribute(REQUEST_PARAM_CATEGORIES_LIST, categoryService.getAllCategories());
		return PAGE_USER_MAIN;
	}

}
