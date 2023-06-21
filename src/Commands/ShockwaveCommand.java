package Commands;

import Control.Game;
import Exceptions.ShockwaveException;

public class ShockwaveCommand extends Command {
	
	private final static String name = "shockwave";
	private final static String details = "shock[w]ave"; 
	private final static String shortcut = "w";
	private final static String help = "shockWave: UCM-Ship releases a shock wave.";

	public ShockwaveCommand() {
		super(name, shortcut, details, help);
	}

	public static Command parse(String s) {
		String[] textos = s.trim().toLowerCase().split("\\s+");
		if(textos[0].equals(name) || textos[0].equals(shortcut))
		{
			return new ShockwaveCommand();
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
		try{
			if(game.shockWave());
			else throw new ShockwaveException("Failed to shoot");
			game.update();
		}
		catch (ShockwaveException e) {
			System.out.println(e.getMessage());
		}
		return true;
	}
	

	@Override
	public Command parse(String[] commandWords) {
		return null;
	}
}
