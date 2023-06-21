package Entities;

import Control.Game;
import Control.GameObject;
import Interface.IExecuteRandomActions;

public class RegularAlien extends AlienShip implements IExecuteRandomActions {
	private int points;
	private int numRegulars = 0;
	private boolean ex;
	
	public RegularAlien(Game game, int x, int y, int live) {
		super(game, x, y, live);
		this.points = 5;
		this.numRegulars++;
		this.ex = false;
	}

	@Override
	public String toString() {
		if(!ex) return "R["+this.live +"]";
		else return "E["+live+"]";
	}

	@Override 
	public void onDelete() {		
		game.receivePoints(points);
		numRegulars--;
		super.deleteAlien();
	}
	
	public boolean performAttack(GameObject other) {
		if(!this.isAlive() && ex) {
			ex = false;
			return true;	
		}
		else return false;
		}
	
	@Override
	public GameObject computerAction() {
		if(!ex && IExecuteRandomActions.canGenerateRandomEplosive(game)) {
			ex = true;
			}	
		return null;
		}
	
	@Override
	public  String Stringify() {
		String s;
		if(super.isAlive()) {
			s = "R;" +x +"," + y + "," +live + "," + game.getLevel().getNumCyclesToMoveOneCell() + ",";
			if(super.direccion == -1) s = s + "izq\n";
			else if(super.direccion == 1) s = s + "der\n";
		}
		else s = "";
		return s;
		
	}
	
	public int getNumRegulars() {
		return numRegulars;
	} 

	public void setNumRegulars(int numRegulars) {
		this.numRegulars = numRegulars;
	}

	public int getPoints() {
		return points;
	}

	@Override
	public void move() {
		
	}

}
