package Commands;

import Control.Game;

public class HelpCommand extends Command {

	private final static String name = "help";
	private final static String details = "[h]elp"; 
	private final static String shortcut = "h";
	private final static String help = "help: Prints this help message.";
	  
	public HelpCommand() {
		super(name, shortcut, details, help);
		}
	
	
	public static Command parse(String s) {
		String[] textos = s.trim().toLowerCase().split("\\s+");
		if(textos[0].equals(name) || textos[0].equals(shortcut))
		{
			return new HelpCommand();
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
		//Muestra la lista de comandos, cogiendo las funciones de CommandGenerator.listaHelpComandos
		for (GetStringFunction f: CommandGenerator.listaHelpComandos) {
			System.out.println(f.runFunction()); //imprime cada detail por pantalla
		}
		
		//No hace game.update(), puesto que no corre ciclo
		
		//devuelve false porque NO hay que pintar el tablero nuevamente
		return false;
	}


	@Override
	public Command parse(String[] commandWords) {
		return null;
	}
}
