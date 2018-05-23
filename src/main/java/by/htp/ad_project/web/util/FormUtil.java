package by.htp.ad_project.web.util;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

public class FormUtil {
    public static String getString(HttpServletRequest req, String field) {
        String value = req.getParameter(field);
		return value;
    }

    static int getInt(HttpServletRequest req, String field) throws ParseException {
        String value=req.getParameter(field);
        return Integer.parseInt(value);
    }

    public static boolean isPost(HttpServletRequest reg){
        return reg.getMethod().toUpperCase().equals("POST");
    }
}
