package by.htp.ad_project.web.actions.impl;

import static by.htp.ad_project.web.util.WebConstantDeclaration.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.htp.ad_project.domain.Ad;
import by.htp.ad_project.domain.Category;
import by.htp.ad_project.domain.User;
import by.htp.ad_project.service.AdService;
import by.htp.ad_project.service.CategoryService;
import by.htp.ad_project.service.UserService;

@Controller
@RequestMapping(value = "/view_ad_action={id}")
public class ViewAdAction {

	@Autowired
	private	AdService adService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private UserService userService;

	public void setAdService(AdService adService) {
		this.adService = adService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String createAd(@PathVariable int id, Model model) {
		Ad ad = adService.read(id);
		int user_id = ad.getUsers_ID();
		int category_id = ad.getCategory_ID();
		User user = userService.read(user_id);
		Category category = categoryService.read(category_id);
		model.addAttribute(REQUEST_PARAM_AD, ad);
		model.addAttribute(REQUEST_PARAM_USER_NICKNAME, user.getNickname());
		model.addAttribute(REQUEST_PARAM_USER_PHONENUMBER, user.getPhoneNumber());
		model.addAttribute(REQUEST_PARAM_CATEGORY, category);
		return PAGE_ADS_VIEW_AD;
	}
}
