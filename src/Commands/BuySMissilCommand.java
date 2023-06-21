package Commands;

import Control.Game;
import Exceptions.BuyException;

public class BuySMissilCommand extends Command {
	
	private final static String name = "buy";
	private final static String details = "[b]uy"; 
	private final static String shortcut = "b";
	private final static String help = "buy: Buy a supermissil.";
	  
	public BuySMissilCommand() {
		super(name, shortcut, details, help);
	}
	
	public static Command parse(String s) {
		String[] textos = s.trim().toLowerCase().split("\\s+");
		if(textos[0].equals(name) || textos[0].equals(shortcut) || textos[0].equals(""))
		{
			return new BuySMissilCommand();
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
		try {
			if(game.sMis());
			else throw new BuyException ("Can t buy");
			game.update();
			}
		catch (BuyException e){
		System.out.println(e.getMessage());	
		}
		return true;
	}

	@Override
	public Command parse(String[] commandWords) {
		return null;
	}
}