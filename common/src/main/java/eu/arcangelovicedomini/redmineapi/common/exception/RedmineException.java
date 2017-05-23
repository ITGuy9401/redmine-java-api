package eu.arcangelovicedomini.redmineapi.common.exception;

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
