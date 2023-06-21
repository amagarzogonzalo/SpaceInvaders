package Control;
import java.util.Random;
import java.util.Scanner;

import Commands.Command;
import Commands.CommandGenerator;
import Control.*;
import Control.GamePrinter;
import Exceptions.CommandExecuteException;
import Exceptions.CommandParseException;

public class Controller {
	private Game game;
	private Scanner in = null;
	private FormattedPrinter print;
	private Command command;

	public Controller(Game game) {
		this.game = game;
		this.command = null;
		this.in = new Scanner(System.in);
		this.print = new FormattedPrinter(game,8,9);
	}

	public void run(Game game, Random args) {
		System.out.println(this.game.infoToString() + this.print.toString(game));
		while(!this.game.isFinished()) {
			System.out.println("Command>");
			String[] words = in.nextLine().toLowerCase().trim().split ("\\s+");
			try {
			command = CommandGenerator.parse(words[0]);
			if (command == null) throw new CommandParseException();
			else {
				if (command.execute(game)) {
					this.print.encodeGame(this.game);
					System.out.println(this.game.infoToString() + this.print.toString(game));
					}
				}
			}
			catch(CommandParseException ex){
				System.out.println(ex.getMessage()+ " %n %n");

			}
		}
		System.out.println(this.game.getWinnerMessage());
	}
}