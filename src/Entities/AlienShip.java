package Entities;
import Control.*;

public abstract class AlienShip extends EnemyShip {
	protected static int numAlienShip = 0;
	private static boolean AliensHaveLanded = false;
	protected static int direccion = -1;
	private static boolean tocaBajar = false;
	private static int navesBajadas = 0;
	private static int counter;
	
	private static int Ships;
	
	public AlienShip(Game game, int x, int y, int live) {
		super(game, x, y, live);
		AlienShip.numAlienShip = AlienShip.numAlienShip + 1;
		AlienShip.Ships++;
		this.counter = game.getLevel().getVelocidad();
		
	}
	public static int getNumShips() {
		return numAlienShip;
	}
	
	public boolean isAlienDead() {
		if (!super.isAlive()){
			AlienShip.numAlienShip--;
			return true;
		}
		else return false;
	}
	
	public boolean isAllDead () {
		if(AlienShip.numAlienShip <= 0) return true;
		else return false;
	}
	
	
	// comandos de move
	@Override
	public boolean moveA() {
		boolean fin = false;
		if (tocaBajar) {
			this.y++;
			if(this.AliensGanan()) {
				this.y--;
				AliensHaveLanded = true;
				fin = true;
			}
			if(!fin) {
				navesBajadas++;
				if (navesBajadas == Ships) {
					navesBajadas = 0;
					tocaBajar = false;
				}
			}
		}
		else {
			if(!fin) this.x+=direccion;
		}
	return fin;	
	}
	
	public void cambiaDireccion() {
		if (direccion==1 && this.x==8) {
			direccion=-1;
			tocaBajar = true;
		}
		if (direccion==-1 && this.x==0) {
			direccion = 1;
			tocaBajar = true;
		}		
	}
	
	public boolean AliensGanan() {
		if (this.y == 7) {
			return true;
		}
		else return false;
	}
			
		public void moveNaves() {
			if (this.tocaBajar) {
				this.y=y+1;
				navesBajadas++;	
				}	
				if (navesBajadas == numAlienShip) {
					navesBajadas = 0;
					tocaBajar = false;		
				}
			else {
				this.x+=direccion;
			}
		}
		
		//fin comandos de move
		
	
	
	public abstract GameObject computerAction();
	public abstract String toString();
	public abstract void onDelete();
	public abstract String Stringify();

	
	public int getNumAlienShip() {
		return numAlienShip;
	}
	
	public void deleteAlien() {
		AlienShip.numAlienShip--;
		if(AlienShip.numAlienShip < 0) AlienShip.numAlienShip = 0;
	}
	public static boolean isAliensHaveLanded() {
		return AliensHaveLanded;
	}
	
	 
	
}
