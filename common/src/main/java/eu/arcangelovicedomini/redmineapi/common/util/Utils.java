package eu.arcangelovicedomini.redmineapi.common.util;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import eu.arcangelovicedomini.redmineapi.common.exception.RedmineConnectorException;
import eu.arcangelovicedomini.redmineapi.common.exception.RedmineException;

public class Utils {

	public static RedmineException resolveRedmineException(Throwable th) {
		if (th instanceof RedmineException) {
			return (RedmineException) th;
		}
		return new RedmineConnectorException(th, th.getMessage());
	}

	public static void checkNullArgument(String name, Object argument) throws RedmineException {
		if (argument == null) {
			throw resolveRedmineException(new IllegalArgumentException(name + " argument cannot be null"));
		}
	}

	public static void checkEmptyString(String name, String argument) throws RedmineException {
		if (argument == null || StringUtils.isBlank(argument)) {
			throw resolveRedmineException(new IllegalArgumentException(name + " argument cannot be null"));
		}
	}
	
	public static void checkEmptyArray(String name, Object[] argument) throws RedmineException {
		if (argument == null || ArrayUtils.isEmpty(argument)) {
			throw resolveRedmineException(new IllegalArgumentException(name + " argument cannot be null"));
		}
	}
	
	public static String toJson(Object dto) {
		try {
			return new ObjectMapper().writeValueAsString(dto);
		} catch (JsonProcessingException e) {
			throw new RuntimeException("Error parsing JSON data", e);
		}
	}
}
