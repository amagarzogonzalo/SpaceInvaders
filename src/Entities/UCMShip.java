package Entities;

import Control.Game;
import Control.GameObject;
import Exceptions.OutBoardException;

public class UCMShip extends Ship {
	private boolean misilShoot;
	private boolean shockWave;
	private int points;
	private int sMis;
	
	public UCMShip(Game game, int x, int y, int live) {
		super(game, x, y, live);
		this.misilShoot = false;
		this.shockWave = false;
		this.points = 0;
		this.sMis = 0;
	}
	
	public String toStringDead() {
		return "!xx!?";
	}
	
	public boolean moveP(String lado, int distancia) {
		boolean ok = false;
		try {
		
			if (lado.equals("left") || lado.equals("l")) {
				if (distancia == 1) {
					this.x = this.x - 1;
					ok = true;
				}
				else if (distancia == 2) {
					this.x = this.x - 2;
					ok = true;
				}
				
				
				if(this.x>8) {
					x = x - distancia;
					throw new OutBoardException ("Failed to move");
				}
				else if(this.x < 0) {
					x = x + distancia;
					throw new OutBoardException ("Failed to move");
				}
				
			}
			else if (lado.equals("right") || lado.equals("r")) {
				if(distancia == 1) {
					this.x = this.x + 1;
					ok = true;
				}
				else if (distancia == 2) {
					this.x = this.x + 2;
					ok = true;
				}
				
				if(this.x>8) {
					x = x - distancia;
					throw new OutBoardException ("Failed to move");
				}
				else if(this.x < 0) {
					x = x + distancia;
					throw new OutBoardException ("Failed to move");
				}
			}
		}
		catch(OutBoardException e) {
			System.out.println(e.getMessage());
		}
		return ok;
	}
	
	public boolean receiveBombAttack(int damage) {
		this.getDamage(damage);
		return true;
		}
	
	public boolean receiveMissileAttack(int damage) {return false;}
	public boolean receiveShockWaveAttack(int damage) { return false;}
	public boolean performAttack(GameObject other) {return false;}
	
	@Override
	public String toString() {
		if(live != 100) return "^__^";
		else return toStringDead();
	}
	
	@Override
	public  String Stringify() {
		String s;
		if(live >= 1 && live <= 3) {
				s = "P;" +x +"," + y + "," +live + "," + sMis + ",";
				if(misilShoot) s= s + "true\n";
				else s= s + "false\n";
				}
		else s ="";
		return s;
		
	}
	
	@Override public boolean moveA() {return false;}
	@Override public void move() {}
	@Override public void onDelete() {this.live = 100;}
	@Override public GameObject computerAction() {return null;}
	@Override public void cambiaDireccion() {}
	
	
	public boolean isMisilShoot() {
		return misilShoot;
	}

	public void setMisilShoot(boolean misilShoot) {
		this.misilShoot = misilShoot;
	}

	public boolean isShockWave() {
		return shockWave;
	}

	public void setShockWave(boolean shockWave) {
		this.shockWave = shockWave;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int puntos) {
		this.points = puntos;
	}

	public int getsMis() {
		return sMis;
	}

	public void setsMis(int sMis) {
		this.sMis = sMis;
	}

	
}

