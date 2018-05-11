package by.htp.ad_project.web.util;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

public class FormUtil {
    static String getString(HttpServletRequest req, String field, String regxp) throws ParseException {
        String value = req.getParameter(field);
        if (value.trim().matches(regxp))
            return value;
        else
            throw new ParseException("Input error",1);
    }

    static int getInt(HttpServletRequest req, String field) throws ParseException {
        String value=req.getParameter(field);
        return Integer.parseInt(value);
    }

    public static boolean isPost(HttpServletRequest reg){
        return reg.getMethod().toUpperCase().equals("POST");
    }
}
