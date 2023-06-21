package Entities;

import Control.Game;
import Control.GameObject;

public abstract class EnemyShip extends Ship {

	protected int numShips = 0;
	
	public EnemyShip(Game game, int x, int y, int live) {
		super(game, x, y, live);
		this.numShips++;
	}
	
	public abstract String toString();
	public abstract void move();
	public abstract void onDelete();
	public abstract GameObject computerAction();
	public abstract String Stringify();

	
	public boolean receiveMissileAttack(int damage) {
		this.getDamage(damage);
		return true;
	}
	public boolean receiveShockWaveAttack(int damage) {
		this.live = this.live - 1;
		return true;
		}
	
	public boolean receiveBombAttack(int damage) {return false;}


}
