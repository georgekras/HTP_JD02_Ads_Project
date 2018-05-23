package by.htp.ad_project.web.actions.impl;

import java.util.List;

import static by.htp.ad_project.web.util.WebConstantDeclaration.*;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import by.htp.ad_project.domain.Ad;
import by.htp.ad_project.service.AdService;

@Controller
@RequestMapping(value = "/")
public class SpringMVCMainAction {

	@Autowired
	private AdService adService;

	public void setAdService(AdService adService) {
		this.adService = adService;
	}

	@RequestMapping(value = "/main_action", method = RequestMethod.GET)
	public String mainAction(ModelMap model) {
		List<Ad> ads = adService.getAllAds();
		model.addAttribute(REQUEST_PARAM_ADS_LIST, ads);
		return "main";
	}
}
