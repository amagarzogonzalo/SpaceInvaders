package Commands;

import java.util.Scanner;

import Control.Game;
import Exceptions.ShootException;

public class ShootCommand extends Command {
	private Scanner in = null;
	
	private final static String name = "shoot";
	private final static String details = "[s]hoot"; 
	private final static String shortcut = "s";
	private final static String help = "shoot: UCM-Ship launches a missile.";

	public ShootCommand(String name, String shortcut, String details, String help) {
		super(name, shortcut, details, help);
		this.in = new Scanner(System.in);
	} 
 
	public static Command parse(String s) {
		String[] textos = s.trim().toLowerCase().split("\\s+");
		if(textos[0].equals(name) || textos[0].equals(shortcut))
		{
			return new ShootCommand(name, details, shortcut, help);
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
		boolean s = false;
		System.out.println("Do you want to use supermissil (s|n)?");
	
		String eleccion = this.in.nextLine().toLowerCase();
		if(eleccion.equals("s")) s = true;		
		if(game.shootMissile(s));

		game.update();
	

		return true;
	}

	@Override
	public Command parse(String[] commandWords) {
		return null;
	}

}
	