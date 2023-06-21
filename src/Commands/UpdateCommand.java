package Commands;

import Control.Game;

public class UpdateCommand extends Command {
	
	private final static String name = "node";
	private final static String details = "[n]one"; 
	private final static String shortcut = "n";
	private final static String help = "[none]: Skips one cycle.";
	  
	public UpdateCommand() {
		super(name, shortcut, details, help);
	}
	
	public static Command parse(String s) {
		String[] textos = s.trim().toLowerCase().split("\\s+");
		if(textos[0].equals(name) || textos[0].equals(shortcut) || textos[0].equals(""))
		{
			return new UpdateCommand();
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
		game.update();
		return true;
	}

	@Override
	public Command parse(String[] commandWords) {
		return null;
	}
}
