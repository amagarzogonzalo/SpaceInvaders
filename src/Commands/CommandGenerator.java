package Commands;

public class CommandGenerator {
	private static ParseCommandFunction[] listaParseaComandos = {
			(String s) -> {return ListCommand.parse(s);},	//una función por cada comando
			(String s) -> {return HelpCommand.parse(s);},
			(String s) -> {return ResetCommand.parse(s);},    
			(String s) -> {return ExitCommand.parse(s);},	
			(String s) -> {return UpdateCommand.parse(s);},
			(String s) -> {return MoveCommand.parse(s);},
			(String s) -> {return ShockwaveCommand.parse(s);},
			(String s) -> {return StringifyCommand.parse(s);},
			(String s) -> {return BuySMissilCommand.parse(s);},
			(String s) -> {return SaveCommand.parse(s);},
			(String s) -> {return ShootCommand.parse(s);}
	};
	
	public static GetStringFunction[] listaHelpComandos = {
			() -> {return ListCommand.getHelp();},	//una función por cada comando
			() -> {return HelpCommand.getHelp();},
			() -> {return ResetCommand.getHelp();},	
			() -> {return ExitCommand.getHelp();},
			() -> {return UpdateCommand.getHelp();},
			() -> {return MoveCommand.getHelp();},	
			() -> {return ShockwaveCommand.getHelp();},
			() -> {return StringifyCommand.getHelp();},
			() -> {return BuySMissilCommand.getHelp();},
			() -> {return SaveCommand.getHelp();},
			() -> {return ShootCommand.getHelp();}
	};
	
	public static GetStringFunction[] listaDetailsComandos = {
			() -> {return ListCommand.getDetails();},	//una función por cada comando
			() -> {return HelpCommand.getDetails();},
			() -> {return ResetCommand.getDetails();},   
			() -> {return ExitCommand.getDetails();},	
			() -> {return UpdateCommand.getDetails();},
			() -> {return MoveCommand.getDetails();},
			() -> {return ShockwaveCommand.getDetails();},
			() -> {return StringifyCommand.getDetails();},
			() -> {return BuySMissilCommand.getDetails();},
			() -> {return SaveCommand.getDetails();},
			() -> {return ShootCommand.getDetails();}
	};
	
	public static Command parse(String instrucciones) {
		Command comando = null;
		for(ParseCommandFunction f: listaParseaComandos) {
			comando = f.accion(instrucciones);
			if (comando != null ) break;
		}
		return comando;
	}
}
