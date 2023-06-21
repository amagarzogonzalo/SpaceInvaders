package Entities;

import Control.Game;
import Control.GameObject;

public abstract class Ship extends GameObject {
	
	public Ship(Game game, int x, int y, int live) {
		super(game, x, y, live);

		}
	
	public abstract String toString();
	public abstract void move();
	public abstract GameObject computerAction();
	public abstract void onDelete();
	public abstract String Stringify();
	public abstract boolean moveA();
	
	public boolean performAttack(GameObject other) {return false;}
}
