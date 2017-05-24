package eu.arcangelovicedomini.redmineapi.issues.external.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import eu.arcangelovicedomini.redmineapi.common.exception.RedmineException;
import eu.arcangelovicedomini.redmineapi.issues.external.service.dto.GetIssuesResponse;

public interface IssuesService {

	/**
	 * Returns a paginated list of issues. By default, it returns open issues
	 * only.
	 * 
	 * @param redmineUrl
	 *            the base url of redmine website
	 * @param username
	 *            username of current user (required if not apikey provided)
	 * @param password
	 *            password of current user (required if not apikey provided)
	 * @param apikey
	 *            apikey given by redmine (required if not username/password
	 *            combination provided)
	 * @param offset
	 *            skip this number of issues in response (optional)
	 * @param limit
	 *            number of issues per page (optional)
	 * @param sort
	 *            column to sort with. Append :desc to invert the order
	 * @param issueId
	 *            get issue with the given id or multiple issues by id using
	 *            <code>','</code> to separate id
	 * @param projectId
	 *            get issues from the project with the given id (a numeric
	 *            value, not a project identifier)
	 * @param subprojectId
	 *            get issues from the subproject with the given id. You can use
	 *            <code>project_id=XXX&subproject_id=!*</code> to get only the
	 *            issues of a given project and none of its subprojects
	 * @param trackerId
	 *            get issues from the tracker with the given id
	 * @param statusId
	 *            get issues with the given status id only. Possible values:
	 *            open, closed, * to get open and closed issues, status id
	 * @param assignedToId
	 *            get issues which are assigned to the given user id. me can be
	 *            used instead an ID to fetch all issues from the logged in user
	 *            (via API key or HTTP auth)
	 * @param parentId
	 *            get issues whose parent issue is given id
	 * @return
	 * @throws RedmineException
	 */
	public GetIssuesResponse getIssues(String redmineUrl, String username, String password, String apikey,
			Integer offset, Integer limit, String sort, String issueId, String projectId, String subprojectId,
			String trackerId, String statusId, String assignedToId, String parentId) throws RedmineException;
}
