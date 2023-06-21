package Entities;

import Control.Game;
import Control.GameObject;
import Interface.IExecuteRandomActions;

public class DestroyerAlien extends AlienShip implements IExecuteRandomActions {
	private int points;
	private int numDestroyer = 0;
	private boolean isBomb;
	
	public DestroyerAlien (Game game, int x, int y, int live) {
		super(game, x, y, live);
		this.isBomb = false;
		this.points = 10;
		this.numDestroyer++;   
	}

	@Override
	public String toString() {
		return "D["+this.live +"]";
	}
	
	@Override
	public void onDelete() {
		game.receivePoints(points);
		numDestroyer--;
		super.deleteAlien();
	}
	
	@Override 
	public GameObject computerAction() {
		if(isBomb == false && IExecuteRandomActions.canGenerateRandomBomb(game) && super.isAlive()) {
			Bomb b = new Bomb(game,this.x,this.y,1);
			b.setDestroyer(this);
			isBomb = true;
			GameObject bomba = b;
			if(isBomb) return bomba; 
			return null;
		}
		else return null;
	}
	
	@Override
	public  String Stringify() {
		String s;
		if(super.isAlive()) 
		{
			s = "D;" +x +"," + y + "," +live + "," + game.getLevel().getNumCyclesToMoveOneCell() + ",";
			if(super.direccion == -1) s = s + "izq\n";
			else if(super.direccion == 1) s = s + "der\n";
			}
		else s =  "";
		return s;
		
	}
	
	public boolean performAttack(GameObject other) {return false;}
	public int getNumDestroyer() {
		return numDestroyer;
	}

	public void setNumDestroyer(int numDestroyer) {
		this.numDestroyer = numDestroyer;
	}

	public boolean isBomb() {
		return isBomb;
	}

	public void setBomb(boolean isBomb) {
		this.isBomb = isBomb;
	}

	public int getPoints() {
		return points;
	}

	@Override
	public void move() {
		
	}
}

