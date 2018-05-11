package by.htp.ad_project.web.actions;

import static by.htp.ad_project.web.util.WebConstantDeclaration.*;

import java.util.HashMap;
import java.util.Map;

import by.htp.ad_project.web.actions.impl.MainAction;


public final class ActionManager {

	private static Map<String, BaseAction> actions;
	
	static {
		actions = new HashMap<>();
		actions.put(ACTION_NAME_MAIN, new MainAction());
	}
	
	private ActionManager(){	
	}
	
	public static BaseAction getAction(String action){
		return actions.get(action);
	}
}
