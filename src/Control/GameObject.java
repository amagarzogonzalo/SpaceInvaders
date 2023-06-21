package Control;
import Interface.*;

public abstract class GameObject implements IAttack {
	protected int x;
	protected int y;
	protected Game game;
	protected int live;
	
	public GameObject(Game game,int x, int y, int live) {
		this.x = x;
		this.y = y;		
		this.game = game;
		this.live = live;		
	}

	public boolean isOnPosition(int x, int y) {
		if(this.x == x && this.y == y) return true;
		else return false;
		}
	
	public boolean isOut() {
		if(this.game.isOnBoard(this.x, this.y)) return false;
		else return true;
	}
	
	
	public boolean isAlive() {
		if(this.live > 0) return true;
		else return false;
	}
	
	public void getDamage (int damage) {
		this.live = this.live - damage;
	}
	
	public int getLive() {return this.live;}
	
	public int getX() {return x;}
	public int getY() {return y;}	

	public abstract String toString();
	public abstract void move();
	public abstract void onDelete();
	public abstract GameObject computerAction();
	public abstract String Stringify();
	public abstract void cambiaDireccion();
	public abstract boolean moveA();
}
	
	
	
