package by.htp.ad_project.web.actions;

import org.springframework.web.context.WebApplicationContext;

public final class ActionManagerContext {

	private ActionManagerContext() {

	}

	public static BaseAction getAction(String action, WebApplicationContext webApplicationContext) {
		return (BaseAction) webApplicationContext.getBean(action);
	}

}
