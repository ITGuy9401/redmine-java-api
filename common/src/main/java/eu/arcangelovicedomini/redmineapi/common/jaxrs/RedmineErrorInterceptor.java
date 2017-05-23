package eu.arcangelovicedomini.redmineapi.common.jaxrs;

import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.ResponseExceptionMapper;

import eu.arcangelovicedomini.redmineapi.common.exception.RedmineBusinessException;
import eu.arcangelovicedomini.redmineapi.common.exception.RedmineException;
import eu.arcangelovicedomini.redmineapi.common.exception.RedmineTechnicalException;
import eu.arcangelovicedomini.redmineapi.common.internal.api.RedmineErrorDTO;

public class RedmineErrorInterceptor implements ResponseExceptionMapper<RedmineException> {

	@Override
	public RedmineException fromResponse(Response res) {
		if (!Response.Status.Family.SUCCESSFUL.equals(res.getStatusInfo().getFamily())) {
			if (Response.Status.Family.CLIENT_ERROR.equals(res.getStatusInfo().getFamily())) {
				RedmineErrorDTO error = res.readEntity(RedmineErrorDTO.class);
				return new RedmineBusinessException(error.errors);
			} else if (Response.Status.Family.SERVER_ERROR.equals(res.getStatusInfo().getFamily())) {
				return new RedmineTechnicalException("Error retrieving data from Redmine: " + res.getStatus() + " " + res.getStatusInfo().getReasonPhrase());
			} else {
				// 3XX and 1XX are not handled
				return new RedmineTechnicalException("Unexpected response status: " + res.getStatus());
			}
		}
		return null;
	}

}
