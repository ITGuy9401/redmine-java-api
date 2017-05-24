package eu.arcangelovicedomini.redmineapi.issues.external.service;

import org.apache.commons.lang.StringUtils;

import eu.arcangelovicedomini.redmineapi.common.exception.RedmineException;
import eu.arcangelovicedomini.redmineapi.common.util.CXFServiceUtils;
import eu.arcangelovicedomini.redmineapi.common.util.Utils;
import eu.arcangelovicedomini.redmineapi.issues.external.service.dto.GetIssuesResponse;
import eu.arcangelovicedomini.redmineapi.issues.internal.service.OutboundIssuesService;

public class IssuesServiceImpl implements IssuesService {

	@Override
	public GetIssuesResponse getIssues(String redmineUrl, String username, String password, String apikey,
			Integer offset, Integer limit, String sort, String issueId, String projectId, String subprojectId,
			String trackerId, String statusId, String assignedToId, String parentId) throws RedmineException {

		Utils.checkEmptyString("redmineUrl", redmineUrl);
		if (StringUtils.isBlank(apikey) && StringUtils.isBlank(username) && StringUtils.isBlank(password)) {
			Utils.checkEmptyString("apikey", apikey);
		} else {
			Utils.checkEmptyString("username", username);
			Utils.checkEmptyString("password", password);
		}

		OutboundIssuesService outboundService = CXFServiceUtils.<OutboundIssuesService>getOutboundService(OutboundIssuesService.class);
		return outboundService.getIssues(offset, limit, sort, issueId, projectId, subprojectId, trackerId, statusId,
				assignedToId, parentId);
	}

}
