package Control;
import Entities.*;

public class BoardInitializer {
	private Level level ;
	private GameObjectBoard board;
	private Game game;
	private RegularAlien regular;
	private DestroyerAlien destroyer;
	private Ovni ovni;

	
	public GameObjectBoard initialize(Game game, Level level) {
		this.level = level;
		this.game = game;
		board = new GameObjectBoard(game);
		initializeOvni () ;
		initializeRegularAliens () ;
		initializeDestroyerAliens () ;
		return board;
	}
	
	private void initializeOvni () {
		this.ovni = new Ovni(this.game,9,0,0);
		board.add(this.ovni);
	}
	
	private void initializeRegularAliens () {
		int fila = 1, col = 3;
		for (int i = 0; i < this.level.getNumRegularAliens(); i++) {
		    if(i <= 3) {
		    	this.regular = new RegularAlien(game, col+i,fila,2);
		    	board.add(regular);
				}
		    else if(i >= 4) {
		    	this.regular = new RegularAlien(game, i-1,fila+1,2);
				board.add(regular);		    
				}
		}
	}
	
	private void initializeDestroyerAliens () {
		int fila = 3, col = 4;
		for (int i = 0; i < this.level.getNumDestroyerAliens(); i++) {
		    if(this.level.getNumDestroyerAliens() == 2 && this.level.getNumRegularAliens() == 4) fila = 2; 
		    if(this.level.getNumDestroyerAliens() == 2 && this.level.getNumRegularAliens() == 8) fila = 3; 
		    if(this.level.getNumDestroyerAliens() == 4 && this.level.getNumRegularAliens() == 8) col = 3; 
		    this.destroyer = new DestroyerAlien(game,col+i, fila, 1);
		    board.add(destroyer);
			}
	}
	
}