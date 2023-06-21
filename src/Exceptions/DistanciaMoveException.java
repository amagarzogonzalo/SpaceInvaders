package Exceptions;

public class DistanciaMoveException extends Exception {

	public DistanciaMoveException() {
		// TODO Auto-generated constructor stub
	}

	public DistanciaMoveException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public DistanciaMoveException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public DistanciaMoveException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public DistanciaMoveException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}
	public String getMessage() {
		return "Cause of Exception:\n pr2.exceptions.DistanciaMoveException: Cannot move UCMShip: UCMShip can move one or two cells";
	}

}
