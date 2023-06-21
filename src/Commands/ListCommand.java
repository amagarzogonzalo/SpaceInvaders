package Commands;

import Control.Game;

public class ListCommand extends Command{

	private final static String name = "list";
	private final static String details = "[l]ist"; 
	private final static String shortcut = "l";
	private final static String help = "list: Prints the list of available ships.";

	public ListCommand(String name, String shortcut, String details, String help) {
		super(name, shortcut, details, help);
	} 
 
	public static Command parse(String s) {
		String[] textos = s.trim().toLowerCase().split("\\s+");
		if(textos[0].equals(name) || textos[0].equals(shortcut))
		{
			return new ListCommand(name, details, shortcut, help);
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
		//Muestra la lista de comandos, cogiendo las funciones de CommandGenerator.listaDetailsComandos
		for (GetStringFunction f: CommandGenerator.listaDetailsComandos) {
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

