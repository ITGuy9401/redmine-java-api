package eu.arcangelovicedomini.redmineapi.common.util;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import eu.arcangelovicedomini.redmineapi.common.exception.RedmineException;
import eu.arcangelovicedomini.redmineapi.common.exception.RedmineTechnicalException;

public class Utils {

	public static RedmineException resolveRedmineException(Throwable th) {
		if (th instanceof RedmineException) {
			return (RedmineException) th;
		}
		return new RedmineTechnicalException(th, th.getMessage());
	}

	public static void checkNullArgument(String name, Object argument) {
		if (argument == null) {
			throw new IllegalArgumentException(name + " argument cannot be null");
		}
	}

	public static void checkEmptyString(String name, String argument) {
		if (argument == null || StringUtils.isBlank(argument)) {
			throw new IllegalArgumentException(name + " argument cannot be null");
		}
	}
	
	public static void checkEmptyArray(String name, Object[] argument) {
		if (argument == null || ArrayUtils.isEmpty(argument)) {
			throw new IllegalArgumentException(name + " argument cannot be null");
		}
	}
}
