package Exceptions;

public class ShockwaveException extends Exception {

	public ShockwaveException() {
		// TODO Auto-generated constructor stub
	}

	public ShockwaveException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ShockwaveException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public ShockwaveException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ShockwaveException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return "Cause of Exception:\n pr2.exceptions.NoShockwaveException: Cannot release shockwave: no shockwave available";
	}
}
