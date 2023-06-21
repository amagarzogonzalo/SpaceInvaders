package Entities;

import Control.Game;
import Control.GameObject;

public abstract class Weapon extends GameObject {
	protected int damage;
	public Weapon(Game game, int x, int y, int live) {
		super(game, x, y, live);
		this.setDamage(1);
	}
	
	public abstract void move();
	public abstract String toString();

	public int getDamage() {return damage;}
	public void setDamage(int damage) {this.damage = damage;}
	public abstract GameObject computerAction();
	public abstract void onDelete();
	public abstract String Stringify();
	public abstract boolean moveA();
	
	public boolean receiveShockWaveAttack(int damage) { return false;}
	
}
