package Entities;

import Control.Game;
import Control.GameObject;

public class Bomb extends Weapon {
	private DestroyerAlien destroyer;
	public Bomb(Game game, int x, int y, int live) {
		super(game, x, y, live);
	}
	
	
	public boolean performAttack(GameObject other) {
		if(other.isOnPosition(this.x, this.y)) return true;
		else return false;	
		}
	
	public boolean receiveBombAttack(int damage) {return false;}
	public boolean receiveMissileAttack(int damage) {return true;}
	
	@Override
	public void move() {
		if(super.isAlive()) {
			this.y += 1;
			if(super.isOut()) onDelete();			
		}
	}   
	
	@Override public void cambiaDireccion() {}
	
	
	@Override 
	public void onDelete() {
		this.x = -10;
		this.y = -10;
		this.live = 0;
		this.destroyer.setBomb(false);
	}
	
	@Override
	public String toString() {
		return ".";
	}
	
	@Override public GameObject computerAction() {return null;}
	@Override public boolean moveA() {return false;}

	@Override
	public  String Stringify() {
		String s;
		if(super.isAlive()) s = "B;" +x +"," + y +"\n";
		else s = "";

		return s;
		
	}
	

	public void setDestroyer(DestroyerAlien destroyer) {
		this.destroyer = destroyer;
	}

}

