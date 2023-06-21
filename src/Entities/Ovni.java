package Entities;
import Control.Game;
import Control.GameObject;
import Interface.IExecuteRandomActions;

public class Ovni extends EnemyShip implements IExecuteRandomActions {
	private int points;	
	public Ovni (Game game, int x, int y, int live) { 
		super(game, x, y, live);
		this.game = game;
		this.points = 25;
	}
	
	@Override
	public String toString() {
		return "O["+this.live+"]";
	}
	
	@Override
	public void move() {
		if (super.isAlive()) this.x -= 1; 
		else this.live = 2;
	}
	
	@Override
	public void onDelete() {
		game.receivePoints(points);
		this.live = 1;
		this.x = - 1;
		game.ableShockWave(true);
		}
	
	@Override
	public  String Stringify() {
		String s;
		if(super.isAlive()) s = "O;" +x +"," + y + "," +live + "\n";
		else s = "";
		return s;
		
	}
	
	public boolean performAttack(GameObject other) {return false;}
	@Override public void cambiaDireccion() {}
	@Override public boolean moveA() {return false;}

	@Override 
	public GameObject computerAction() {
		if(super.isOut()) live = 0;
		if(IExecuteRandomActions.canGenerateRandomOvni(this.game) && !super.isAlive()) {
			this.live = 1;
			this.x = 9;
			this.y = 0;
		}
		return null;
	}
	

	
}
