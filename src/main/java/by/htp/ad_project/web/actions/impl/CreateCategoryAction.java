package by.htp.ad_project.web.actions.impl;

import java.text.ParseException;
import java.util.Map;

import static by.htp.ad_project.web.util.WebConstantDeclaration.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import by.htp.ad_project.domain.Category;
import by.htp.ad_project.service.CategoryService;
import by.htp.ad_project.web.util.HttpRequestParamValidator;
import by.htp.ad_project.web.util.ValidateNullParamException;

@Controller
@RequestMapping(value = "/create_category_action")
public class CreateCategoryAction {

	@Autowired
	private CategoryService categoryService;

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String createCategory() {
		return PAGE_ADMIN_CREATE_CATEGORY;
	}

	@RequestMapping(method = RequestMethod.POST)
	private String categoryCreate(@RequestParam Map<String, String> params,
			HttpServletRequest request, Model model) throws ParseException {
		String name = params.get(REQUEST_PARAM_CATEGORY_NAME);
		try {
			HttpRequestParamValidator.validateRequestParamStringNotNull(name);
			Category category = new Category(0, name);
			categoryService.create(category);
			return REDIRECT_TO + "/main_action";
		} catch (ValidateNullParamException e) {
			model.addAttribute(REQUEST_MSG, "Check inputs");
			return PAGE_ADMIN_CREATE_CATEGORY;
		}
	}
}
