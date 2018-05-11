package by.htp.ad_project.web.util;

public final class HttpRequestParamValidator {

	private HttpRequestParamValidator() {

	}

	public static void validateRequestParamStringNotNull(String... str) {
		for (String s : str) {
			if (s == null) {
				throw new ValidateNullParamException("Empty parametr recieved");
			}
		}
	}

	public static void validateRequestParamObjectNotNull(Object... objects) {
		for (Object o : objects) {
			if (o == null) {
				throw new ValidateNullParamException("Empty parametr recieved");
			}

		}
	}

}
