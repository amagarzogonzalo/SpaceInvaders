package Commands;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import Control.Game;
import java.util.Scanner;
import Control.Stringifier;

public class SaveCommand extends Command {
	private Stringifier Stringifier;
	private Scanner in = null;
	
	private final static String name = "save";
	private final static String details = "sa[v]e"; 
	private final static String shortcut = "v";
	private final static String help = "save <nombre>:saves game information";
	
	
	public SaveCommand(String name, String shortcut, String details, String help) {
		super(name, shortcut, details, help);
		this.Stringifier = null;
		this.in = new Scanner(System.in);

	}
	
	public static String getHelp() {
		return help;
	}
	
	public static String getDetails() {
		return details;
	}
	
	@Override
	public boolean execute(Game game) {
		String nombre  = this.in.nextLine();
		String archivo = nombre +".dat";
		try {
			Stringifier seria = new Stringifier (game,9,8);
			FileWriter archivo1 = new FileWriter(archivo);
			BufferedWriter prp = new BufferedWriter(archivo1);
			prp.write(seria.toString(game));
			prp.close();
			System.out.println("Game successfully saved in file "+ archivo +". Use the load command to reload it.");
		}catch(IOException e) {
		e.printStackTrace();
		}
		return false;
	}
	
	
	public static Command parse(String s) {
		String[] textos = s.trim().toLowerCase().split("\\s+");
		if(textos[0].equals(name) || textos[0].equals(shortcut))
		{
		return new SaveCommand(name, details, shortcut, help);
		}
		else { return null;}
	
	}
	
	@Override
	public Command parse(String[] commandWords) {	return null;}

}




