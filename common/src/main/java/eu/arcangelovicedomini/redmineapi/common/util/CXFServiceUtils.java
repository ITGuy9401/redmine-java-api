package eu.arcangelovicedomini.redmineapi.common.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.cxf.jaxrs.client.JAXRSClientFactoryBean;

public class CXFServiceUtils {

	public static <E> E getOutboundService(String url, String username, String password, String apikey,
			Class<E> clazz) {
		JAXRSClientFactoryBean factory = new JAXRSClientFactoryBean();

		factory.setAddress(url);

		Map<String, String> headers = new HashMap<>();

		if (StringUtils.isNotBlank(apikey)) {
			headers.put("X-Redmine-API-Key", apikey);
		} else if (StringUtils.isNotBlank(username)) {
			factory.setUsername(username);
			factory.setPassword(password);
		}
		
		// FIXME error handling
		
		return factory.create(clazz);
		
	}
}
