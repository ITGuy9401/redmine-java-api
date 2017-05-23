package eu.arcangelovicedomini.redmineapi.common.exception;

public class RedmineTechnicalException extends RedmineException {

	public RedmineTechnicalException(Throwable cause, String... redmineErrorMessages) {
		super(cause, redmineErrorMessages);
	}
	
	public RedmineTechnicalException(String... redmineErrorMessage) {
		super(redmineErrorMessage);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
