package eu.arcangelovicedomini.redmineapi.common.exception;

public class RedmineBusinessException extends RedmineException {

	public RedmineBusinessException(Throwable cause, String... redmineErrorMessages) {
		super(cause, redmineErrorMessages);
	}
	
	public RedmineBusinessException(String... redmineErrorMessage) {
		super(redmineErrorMessage);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
