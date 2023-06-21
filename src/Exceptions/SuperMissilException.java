package Exceptions;

public class SuperMissilException extends Exception {

	public SuperMissilException() {
		// TODO Auto-generated constructor stub
	}

	public SuperMissilException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public SuperMissilException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public SuperMissilException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public SuperMissilException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	
	public String getMessage() {
		return "Cause of Exception:\n pr2.exceptions.MissileInFlightException: Cannot fire Supermissile: player does not have any supermissile";
	}

}
