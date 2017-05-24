package eu.arcangelovicedomini.redmineapi.common.exception;

/**
 * This is the base Exception for every error coming from the Redmine Java API
 * Library. This exception have 3 extensions:
 * <ul>
 * <li>{@link RedmineBusinessException} is for the 4XX errors, interpreted as
 * "Business Logic Errors", given by Redmine Application</li>
 * <li>{@link RedmineTechnicalException} is for every other error by the Redmine
 * Application (Usually 5XX, note that this Library doesn't support the 3XX
 * family NOR 1XX family, and they'll be treated as 5XX)</li>
 * <li>{@link RedmineConnectorException} is for every exception coming from
 * Library itself (missing required field or catched runtime exceptions)</li>
 * 
 * @author Arcangelo Vicedomini
 *
 */
public class RedmineException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String[] redmineErrorMessages;

	public String[] getRedmineErrorMessage() {
		return redmineErrorMessages;
	}

	public void setRedmineErrorMessages(String... redmineErrorMessages) {
		this.redmineErrorMessages = redmineErrorMessages;
	}

	public RedmineException(Throwable cause, String... redmineErrorMessages) {
		this.initCause(cause);
		this.redmineErrorMessages = redmineErrorMessages;
	}

	public RedmineException(String... redmineErrorMessages) {
		this.redmineErrorMessages = redmineErrorMessages;
	}

	@Override
	public String getMessage() {
		return "";
	}

}
