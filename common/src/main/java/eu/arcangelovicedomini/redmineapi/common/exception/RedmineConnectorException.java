package eu.arcangelovicedomini.redmineapi.common.exception;

public class RedmineConnectorException extends RedmineException {
	
	public RedmineConnectorException(Throwable cause, String... redmineErrorMessages) {
		super(cause, redmineErrorMessages);
	}

	public RedmineConnectorException(String... redmineErrorMessage) {
		super(redmineErrorMessage);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
