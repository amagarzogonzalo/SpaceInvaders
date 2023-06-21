package Control;

public  abstract class GamePrinter {
	private Game game;
	int numRows = 8; 
	int numCols = 9;
	
	public GamePrinter (Game game, int rows, int cols) {
		this.game = game;
		encodeGame(this.game);
	}
	
	public abstract void encodeGame(Game game);
	
	public abstract String toString(Game game);
}