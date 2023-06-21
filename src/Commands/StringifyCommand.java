package Commands;

import Control.Game;

import java.util.Scanner;

import Control.*;

public class StringifyCommand extends Command {
	private Game game;
	private Scanner in;
	
	private final static String name = "stringify";
	private final static String details = "stringi[f]y"; 
	private final static String shortcut = "f";
	private final static String help = "stringify: Prints the game.";
	  
	public StringifyCommand() {
		super(name, shortcut, details, help);
		this.in = new Scanner(System.in);
		}
	
	
	public static Command parse(String s) {
		String[] textos = s.trim().toLowerCase().split("\\s+");
		if(textos[0].equals(name) || textos[0].equals(shortcut))
		{
			return new StringifyCommand();
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
		this.game = game;
		Command command = null;
		Stringifier print = new Stringifier (this.game,9,8);
		System.out.println(this.game.infoToString() + print.toString(game));
		while(!this.game.isFinished()) {
			System.out.println("Command>");
			String[] words = in.nextLine().toLowerCase().trim().split ("\\s+");
			command = CommandGenerator.parse(words[0]);
			if (command != null) {
				if (command.execute(game)) {
					System.out.println(this.game.infoToString() + print.toString(game));
					}
				}
			else System.out.println("unknownCommandMsg");
		}
		return false;
	}


	@Override
	public Command parse(String[] commandWords) {
		return null;
	}
}
