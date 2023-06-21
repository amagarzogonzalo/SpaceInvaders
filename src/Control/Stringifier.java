package Control;

public class Stringifier extends GamePrinter {

	public Stringifier(Game game, int i, int j) {
		super(game, i, j);
	}

	@Override public void encodeGame(Game game) {}

	@Override
	public String toString(Game game) {
		String fichero = "\n\n— Space Invaders v2.0 —\nG;" + game.getCurrentCycle() + "\nL;"+ game.getLevel() + "\n";
		fichero = fichero + game.board.Stringify(game);
	    return fichero;
	}

}
