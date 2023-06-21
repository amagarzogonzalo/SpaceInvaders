package Commands;

import java.util.Scanner;

import Control.Game;
import Exceptions.CommandExecuteException;
import Exceptions.DistanciaMoveException;

public class MoveCommand extends Command {
	
	private final static String name = "move";
	private final static String details = "[m]ove"; 
	private final static String shortcut = "m";
	private final static String help = "move(enter)<left|right>(enter)<1|2>(enter): Moves UCM-Ship to the indicated direction.";
	private Scanner l = null;
	private Scanner d = null;
	
	public MoveCommand(String name, String shortcut, String details, String help) {
		super(name, shortcut, details, help);
		this.l = new Scanner(System.in);
		this.d = new Scanner(System.in);
	}


	public static Command parse(String s) {
		String[] textos = s.trim().toLowerCase().split("\\s+");
		if(textos[0].equals(name) || textos[0].equals(shortcut))
		{
			return new MoveCommand(name, details, shortcut, help);
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
		String lado = " ";
		int dist = 0;
		lado = this.l.nextLine().toLowerCase();
		try {
			dist = this.d.nextInt();
			if(dist >= 1 & dist <= 2);
			else throw new DistanciaMoveException();
			}
		catch(DistanciaMoveException ex) {
			System.out.println(ex.getMessage());
			
		}
		if(game.move(lado, dist));
	
		game.update();
		return true;
	}
	

	@Override
	public Command parse(String[] commandWords) {
		return null;	
	}

}
