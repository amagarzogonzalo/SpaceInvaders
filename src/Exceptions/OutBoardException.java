package Exceptions;

public class OutBoardException extends Exception {

	public OutBoardException() {
		// TODO Auto-generated constructor stub
	}

	public OutBoardException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public OutBoardException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public OutBoardException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public OutBoardException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return "Cause of Exception:\n pr2.exceptions.OffWorldException: Cannot perform move: ship too near border";
	}
}
