package eu.arcangelovicedomini.redmineapi.issues.internal.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import eu.arcangelovicedomini.redmineapi.common.exception.RedmineException;
import eu.arcangelovicedomini.redmineapi.issues.external.service.dto.GetIssuesResponse;

@Path("")
public interface OutboundIssuesService {

	@GET
	@Path("issues.json")
	public GetIssuesResponse getIssues(
			@QueryParam("offset") Integer offset,
			@QueryParam("limit") Integer limit,
			@QueryParam("sort") String sort,
			@QueryParam("issue_id") Long issueId,
			@QueryParam("project_id") Long projectId,
			@QueryParam("subproject_id") Long subprojectId,
			@QueryParam("tracker_id") Long trackerId) throws RedmineException;
}
