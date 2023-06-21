package Commands;

import Control.Game;
import Control.Level;

public class ResetCommand extends Command {
	
	private final static String name = "reset";
	private final static String details = "[r]eset"; 
	private final static String shortcut = "r";
	private final static String help = "reset: Starts a new game.";

	public ResetCommand(String name, String shortcut, String details, String helps) {
		super(name, shortcut, details, help);
	}

	public static Command parse(String s) {
		String[] textos = s.trim().toLowerCase().split("\\s+");
		if(textos[0].equals(name) || textos[0].equals(shortcut))
		{
			return new ResetCommand(name, shortcut, details, help);
		}
		else { return null;}
	}
	
	public static String getHelp() {
		return help;
	}
	
	public static String getDetails() {
		return details;
	}
	
	
	public boolean execute(Game game) {
		game.reset();
		return true;
	}
	

	@Override
	public Command parse(String[] commandWords) {
		return null;
	}

}
