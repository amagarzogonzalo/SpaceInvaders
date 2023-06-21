package Control;
import java.util.Random;
import Control.*;
import Entities.*;
import Interface.*;

public class GameObjectBoard  {
	private GameObject[] objects;
	private int currentObjects;
	private int counter;
	
	public GameObjectBoard (Game game) {
		this.objects = new GameObject [30];
		this.currentObjects = 0;
		this.counter = game.getLevel().getVelocidad();
	}
	
	
	public int getCurrentObjects() {
		return currentObjects;
	}

	public void add (GameObject object) {
		if(object != null) {
			this.objects[this.currentObjects] = object;
			this.currentObjects++;
			}
	}
	
	private GameObject getObjectInPosition (int x, int y) {
		GameObject obj = null;
		for(int i = 0; i < this.currentObjects; i++) 
			if(this.objects[i].isOnPosition(x,y)) obj = this.objects[i];
		return obj;
	}
	
	private void remove(GameObject object) {
		object = null;		
	}
	
	public void update(Game game) {
		// MoveAlien
		this.counter = this.counter -1;
		boolean aWin = false;
		if(this.counter == 0) {
			for(int i = 0; i <  this.currentObjects;i++) {
				objects[i].cambiaDireccion();
				}
			for(int i = 0; i <  this.currentObjects && !aWin;i++) {
				if(objects[i].moveA()) {
					aWin = true;
					game.exit();
				}
				this.counter = game.getLevel().getVelocidad();
				}
			}
		
		// Move objects and checkAtacks
		for(int i = 0; i <  this.currentObjects;i++) {	
			objects[i].move();
			}
		for(int i = 0; i <  this.currentObjects;i++) {	
			checkAttacks(this.objects[i], game);
			}

		this.removeDead(game);		
		
	}
	
	private void checkAttacks(GameObject object, Game game) {	
		for(int j = this.currentObjects-1; j >= 0; j--) {
		// Missile y Alien / Ovni
		if(this.objects[j].isOnPosition(object.getX(), object.getY()) && object.performAttack(this.objects[j]) &&  object != this.objects[j] &&
				!this.objects[j].performAttack(object) && this.objects[j].receiveMissileAttack(0) && !object.receiveMissileAttack(0)
				&& !object.receiveShockWaveAttack(0)) {
			if (game.isS()) {
				game.setS(false);
				this.objects[j].getDamage(2); 
			}
			else this.objects[j].getDamage(1); 		
			object.onDelete();// Destroy Missile
			game.enableMissile();
			if(!this.objects[j].isAlive()) {
				if(this.objects[j].performAttack(object)) {
					this.regularEx(this.objects[j].getX()-1, this.objects[j].getY()+1);
					this.regularEx(this.objects[j].getX()-1, this.objects[j].getY());
					this.regularEx(this.objects[j].getX()-1, this.objects[j].getY()-1);
					this.regularEx(this.objects[j].getX(), this.objects[j].getY()+1);
					this.regularEx(this.objects[j].getX(), this.objects[j].getY()-1);
					this.regularEx(this.objects[j].getX()+1, this.objects[j].getY()+1);
					this.regularEx(this.objects[j].getX()+1, this.objects[j].getY());
					this.regularEx(this.objects[j].getX()+1, this.objects[j].getY()-1);
					}
				this.objects[j].onDelete();

				}
			}
		
		// Bomb y player
		else if(object.performAttack(this.objects[j]) && this.objects[j].receiveBombAttack(1) && object != this.objects[j]
				&& object.isOnPosition(this.objects[j].getX(), this.objects[j].getY()) && !object.receiveBombAttack(0)) { 
			object.getDamage(1);
			object.onDelete(); // Destroy Bomb
			if(!this.objects[j].isAlive()) {
				this.objects[j].onDelete();
				game.isFinished();
				}
		}
		// Object Missile y objects[j] Bomb
		else if(object.performAttack(this.objects[j]) && this.objects[j] != object && objects[j].receiveMissileAttack(0) 
				&& object.receiveBombAttack(0) && !object.receiveMissileAttack(0) && !objects[j].receiveBombAttack(0) &&
				this.objects[j].isOnPosition(object.getX(), object.getY())) {	
			object.getDamage(1);
		 	this.objects[j].getDamage(1);
			this.objects[j].onDelete();
			object.onDelete(); // Destroy Missile y Bomb
			}
		}
	}
	
	void computerAction(Game game) {
		for(int i = 0; i< this.currentObjects; i++) 
			this.add(this.objects[i].computerAction());
	}


	private void removeDead(Game game) {
		for(int i = 0; i < this.currentObjects; i++) {
			if(!this.objects[i].isAlive()){
				this.remove(this.objects[i]);	
				for(int j = i; j< this.currentObjects; j++) {
					this.objects[j] = this.objects[j+1];
				}
				this.currentObjects--;
			}
		}

	}
	
	public String toString (int x, int y) {
		String graphic = " ";
		int i = 0;
		boolean c = false;
		while(i < this.currentObjects && !c) {
			if(this.objects[i].isOnPosition(x, y) && this.objects[i].isAlive()) {
				graphic = this.objects[i].toString();
				c = true;
			}
			i++;
		}
		
		return graphic;
	}
	
	public void shockWave(Game game) {
		game.ableShockWave(false);
		for(int i = 0; i < this.currentObjects; i++) {
			if(this.objects[i].receiveShockWaveAttack(1)) {
				if(!this.objects[i].isAlive()) {
					this.objects[i].onDelete();
					if(this.objects[i].performAttack(this.objects[i])) ;

				}
			}
		}
		
	}
	
	public void regularEx(int x, int y) {
		GameObject objE = getObjectInPosition (x,y); 
		if(objE != null) {
			objE.getDamage(1);
			if(!objE.isAlive()) objE.onDelete();	
		}
	}
	
	
	public String Stringify(Game game) {
		String s = "";
		for(int i = 0; i < this.currentObjects; i ++)
			s = s +this.objects[i].Stringify();
		return s;
	}
	
	
}