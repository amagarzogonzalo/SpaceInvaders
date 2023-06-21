package Commands;

import Control.Game;

public class ExitCommand extends Command {
	
	private final static String name = "exit";
	private final static String details = "[e]xit"; 
	private final static String shortcut = "e";
	private final static String help = "exit: Terminates the program.";
	
	
	public ExitCommand(String name, String shortcut, String details, String help) {
		super(name, shortcut, details, help);
	}

	public static Command parse(String s) {
		String[] textos = s.trim().toLowerCase().split("\\s+");
		if(textos[0].equals(name) || textos[0].equals(shortcut))
		{
			return new ExitCommand(name, shortcut, details, help);
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
		game.exit();
		return false;
	}
	

	@Override
	public Command parse(String[] commandWords) {
		return null;
	}

}
