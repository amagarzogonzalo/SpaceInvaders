 package Entities;

import Control.Game;
import Control.GameObject;

public class UCMMissile extends Weapon {
	public UCMMissile(Game game, int x, int y, int live) {
		super(game, x, y, live);
	}
	
	public boolean performAttack(GameObject other) {
		if(other.isOnPosition(this.x, this.y)) return true;
		else return false;	
	}
	
	public boolean receiveBombAttack(int damage) {return true;}
	public boolean receiveMissileAttack(int damage) {return false;}

		
	@Override 
	public void onDelete() {
		this.x = - 1;
		this.y = - 1;
		this.live = 0;
		this.game.enableMissile();
	}
	
	@Override
	public void move() {
		if(super.isAlive()) {
			this.y = this.y - 1;
			if(super.isOut()) onDelete();
		}
	}
	
	
	
	@Override
	public String toString() {
		return "oo";
	}
	
	@Override
	public  String Stringify() {
		String s = "";
		if(super.isAlive()) {
			if(!game.isS())s = "M;" +x +"," + y +"\n";
			else if (game.isS()) s = "X;" +x +"," + y +"\n";
		}
		else s = "";

		return s;
		
	}
	
	@Override public void cambiaDireccion() {}
	
	@Override public boolean moveA() {return false;}
	@Override public GameObject computerAction() {return null;}

	
}
