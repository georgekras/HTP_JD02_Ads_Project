package by.htp.ad_project.web.controllers.impl;

import java.util.List;

import static by.htp.ad_project.web.util.WebConstantDeclaration.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.htp.ad_project.domain.Ad;
import by.htp.ad_project.domain.Category;
import by.htp.ad_project.domain.User;
import by.htp.ad_project.service.AdService;
import by.htp.ad_project.service.CategoryService;

@Controller
@RequestMapping(value = "/my_ads_action")
public class UserAdsController {

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

	@RequestMapping(method = RequestMethod.GET)
	public String userAd(HttpServletRequest request, HttpSession session, Model model) {
		session = request.getSession();
		Object o = session.getAttribute("user");
		User user = (User) o;
		if (user == null) {
			return REDIRECT_TO + "/main_action";
		} else {
			List<Ad> ads = adService.getUserAds(user.getID());
			List<Category> categories = categoryService.getAllCategories();
			model.addAttribute(REQUEST_PARAM_CATEGORIES_LIST, categories);
			model.addAttribute(REQUEST_PARAM_ADS_LIST, ads);
			return PAGE_ADS_USER_ADS;
		}
	}
}
