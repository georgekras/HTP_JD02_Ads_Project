package by.htp.ad_project.web.controllers.impl;

import java.util.List;

import static by.htp.ad_project.web.util.WebConstantDeclaration.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import by.htp.ad_project.domain.Ad;
import by.htp.ad_project.domain.Category;
import by.htp.ad_project.service.AdService;
import by.htp.ad_project.service.CategoryService;

@RestController
@RequestMapping(value = "/")
public class MainController {

	private static final int maxAdsOnPage = 9;
	
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
	public ModelAndView mainAction(@RequestParam(required = false) Integer page) {
		ModelAndView modelAndView = new ModelAndView(PAGE_USER_MAIN);

		List<Ad> ads = adService.getAllAds();
		List<Category> categories = categoryService.getAllCategories();
        PagedListHolder<Ad> pagedListHolder = new PagedListHolder<>(ads);
        pagedListHolder.setPageSize(maxAdsOnPage);
        modelAndView.addObject(REQUEST_PARAM_CATEGORIES_LIST, categories);
        modelAndView.addObject("maxPages", pagedListHolder.getPageCount());

        if(page==null || page < 1 || page > pagedListHolder.getPageCount())page=1;

        modelAndView.addObject("page", page);
        if(page == null || page < 1 || page > pagedListHolder.getPageCount()){
            pagedListHolder.setPage(0);
            modelAndView.addObject(REQUEST_PARAM_ADS_LIST, pagedListHolder.getPageList());
        }
        else if(page <= pagedListHolder.getPageCount()) {
            pagedListHolder.setPage(page-1);
            modelAndView.addObject(REQUEST_PARAM_ADS_LIST, pagedListHolder.getPageList());
        }
		return modelAndView;
	}
}
