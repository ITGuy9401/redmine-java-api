package eu.arcangelovicedomini.redmineapi.common.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.cxf.jaxrs.client.JAXRSClientFactoryBean;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationIntrospector;

import eu.arcangelovicedomini.redmineapi.common.jaxrs.RedmineErrorInterceptor;

public class CXFServiceUtils {

	@SuppressWarnings({ "unchecked", "rawtypes" })
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
		
		List interceptors = new ArrayList<>();
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SZ"));
		mapper.setAnnotationIntrospector(new JaxbAnnotationIntrospector(TypeFactory.defaultInstance()));
		
		interceptors.add(new JacksonJsonProvider(mapper));
		interceptors.add(new RedmineErrorInterceptor());
		
		factory.setOutInterceptors(interceptors);
		
		return factory.create(clazz);
		
	}
}
