package Exceptions;

public class ShootException extends Exception {

	public ShootException() {
		// TODO Auto-generated constructor stub
	}

	public ShootException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ShootException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public ShootException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ShootException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	
	public String getMessage() {
		return "Cause of Exception:\n pr2.exceptions.MissileInFlightException: Cannot fire missile: missile already exists on board";
	}
}
