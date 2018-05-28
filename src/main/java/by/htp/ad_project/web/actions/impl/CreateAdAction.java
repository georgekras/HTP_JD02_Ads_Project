package by.htp.ad_project.web.actions.impl;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import static by.htp.ad_project.web.util.WebConstantDeclaration.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import by.htp.ad_project.domain.Ad;
import by.htp.ad_project.domain.Category;
import by.htp.ad_project.domain.User;
import by.htp.ad_project.service.AdService;
import by.htp.ad_project.service.CategoryService;
import by.htp.ad_project.web.util.FormUtil;
import by.htp.ad_project.web.util.HttpRequestParamValidator;
import by.htp.ad_project.web.util.ValidateNullParamException;

@Controller
@RequestMapping(value = "/create_ad_action")
public class CreateAdAction {

	@Autowired
	private	AdService adService;
	
	@Autowired
	private CategoryService categoryService;

	public void setAdService(AdService adService) {
		this.adService = adService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String createAd(HttpServletRequest request) {
		List<Category> categories = categoryService.getAllCategories();
		request.setAttribute(REQUEST_PARAM_CATEGORIES_LIST, categories);
		return PAGE_ADS_CREATE_AD;
	}

	@RequestMapping(method = RequestMethod.POST)
	private String adCreate(@RequestParam Map<String, String> params, @RequestParam Map<String, Integer> intParams,
			HttpSession session, HttpServletRequest request, Model model) throws ParseException {
        session = request.getSession();
        Object o = session.getAttribute("user");
        User user;
        if (o != null) {
            user = (User) o;
        } else
        	return REDIRECT_TO + "/main_action";
		String title = params.get(REQUEST_PARAM_AD_TITLE);
		String smalldesc = params.get(REQUEST_PARAM_AD_SMALLDESC);
		String description = params.get(REQUEST_PARAM_AD_DESCRIPTION);
		int price = FormUtil.getInt(request, REQUEST_PARAM_AD_PRICE);
		int categoryid = FormUtil.getInt(request, REQUEST_PARAM_AD_CATEGORY_ID);
		try {
			HttpRequestParamValidator.validateRequestParamStringNotNull(title, smalldesc, description);
			Ad ad = new Ad(0, title, smalldesc, description, price, user.getID(), categoryid);
			adService.create(ad);
			return REDIRECT_TO + "/main_action";
		} catch (ValidateNullParamException e) {
			model.addAttribute(REQUEST_MSG, "Check inputs");
			return PAGE_USER_MAIN;
		}
	}
}
