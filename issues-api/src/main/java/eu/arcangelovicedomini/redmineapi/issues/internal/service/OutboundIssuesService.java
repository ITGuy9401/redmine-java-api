package eu.arcangelovicedomini.redmineapi.issues.internal.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import eu.arcangelovicedomini.redmineapi.common.exception.RedmineException;
import eu.arcangelovicedomini.redmineapi.issues.external.service.dto.GetIssuesResponse;

@Path("")
public interface OutboundIssuesService {

	/**
	 * 
	 * @param offset
	 * @param limit
	 * @param sort
	 * @param issueId
	 * @param projectId
	 * @param subprojectId
	 * @param trackerId
	 * @param statusId
	 * @param assignedToId
	 * @param parentId
	 * @return
	 * @throws RedmineException
	 */
	@GET
	@Path("issues.json")
	public GetIssuesResponse getIssues(
			@QueryParam("offset") Integer offset,
			@QueryParam("limit") Integer limit,
			@QueryParam("sort") String sort,
			@QueryParam("issue_id") String issueId,
			@QueryParam("project_id") String projectId,
			@QueryParam("subproject_id") String subprojectId,
			@QueryParam("tracker_id") String trackerId,
			@QueryParam("status_id") String statusId,
			@QueryParam("assigned_to_id") String assignedToId,
			@QueryParam("parent_id") String parentId) throws RedmineException;
}
