package Exceptions;

public class BuyException extends Exception {

	public BuyException() {
		// TODO Auto-generated constructor stub
	}

	public BuyException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public BuyException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public BuyException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public BuyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return "Cause of Exception:\n pr2.exceptions.BuyException: Cannot buy: not enough points";
	}
}
