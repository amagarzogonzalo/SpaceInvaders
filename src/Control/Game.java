package Control;
import java.lang.String;
import java.util.Random;
import java.util.Scanner;
import Entities.*;
import Exceptions.ShootException;
import Exceptions.SuperMissilException;
import Interface.IPlayerController;

public class Game implements IPlayerController{
	public final static int DIM_X = 9;
	public final static int DIM_Y = 8;
	
	GameObjectBoard board;
	private UCMShip player;
	private int currentCycle;
	private Random rand;
	private Level level;
	private boolean doExit;
	private BoardInitializer initializer;
	private boolean S;
	
	public Game (Level level, Random rand){
		this.rand = rand;
		this.level = level;
		initializer = new BoardInitializer();
		initGame();
		S = false;
	}
	
	public void initGame () {
		currentCycle = 0;
		board = initializer.initialize (this, this.level);
		this.player = new UCMShip(this,DIM_X/2,DIM_Y-1,3);
		this.board.add(this.player);
		}
	
	public boolean isS() {
		return S;
	}

	public void setS(boolean s) {
		S = s;
	}

	public Random getRandom() {
		return rand;
	}
	
	public boolean isOnBoard(int x, int y) {
		if(x >= 0 && x <= 8 && y <= 7 && y >= 0) return true;
		else return false;
	}

	public Level getLevel() {
		return level;
	}
	
	public int getCurrentCycle() {
		return currentCycle;
	}

	public void reset() {
		this.initGame();
	}
	
	public void addObject(GameObject object) {
		this.board.add(object);
	}
	
	public String toStringObjectAt(int x, int y) {
		return this.board.toString(x,y);
	}
	
	public boolean isFinished() {
		return doExit || playerWin() || aliensWin(); 
	}
	
	public boolean aliensWin() {
		if(player.getLive() == 100 || AlienShip.isAliensHaveLanded()) return true; 
		
		else return false;
	}
	
	private boolean playerWin () {
		return AlienShip.getNumShips() == 0;
	}
	
	public void update() {
		board.computerAction(this);
		board.update(this);
		currentCycle += 1;
	}
	
	public void exit() {
		doExit = true;
	}


	public String infoToString() {
		String info = "Life: " ;
		if(this.player.getLive() == 100) info = info + 0;
		else info = info + this.player.getLive();
		info = info + "\nNumber of cycles: " + currentCycle
				+ "\nPoints: " + this.player.getPoints() + "\nRemaining aliens: " + AlienShip.getNumShips();;
		if (this.player.isShockWave()) info = info + "\nShockWave : YES";
		else info = info + "\nShockWave : NO";
		info = info + "\nNumber of SuperMissils: " + this.player.getsMis();
		return info;
	}
	
	public String getWinnerMessage () {
		if (playerWin()) return "Player win!";
		else if (aliensWin()) return "Aliens win!";
		else if (doExit) return "Player exits the game";
		else return "This should not happen";
	}
	
	//Metodos del interfaz IPlayerController
	@Override
	public boolean move(String lado, int distancia) {
		if(this.player.moveP(lado, distancia)) return true;
		else return false;
	}

	@Override
	public boolean shootMissile(boolean s) {
		boolean ok = false;
		try{
			if(!this.player.isMisilShoot()) {
				if(s) {
					try {
						if(player.getsMis() > 0 && this.wasteSM()) {
							this.player.setMisilShoot(true);
							UCMMissile misil = new UCMMissile(this,this.player.getX(), this.player.getY(),1);
							this.addObject(misil);
							this.S = true;
							ok =  true;
							}
						 else {
							 ok = false;
							 throw new SuperMissilException();
						 }
					}
					catch(SuperMissilException ex) {
						System.out.println(ex.getMessage());
					}
				}
				else if (!s) {
					this.player.setMisilShoot(true);
					UCMMissile misil = new UCMMissile(this,this.player.getX(), this.player.getY(),1);
					this.addObject(misil);
					ok = true;
				}
				
			}			
			else throw new ShootException();
		}
		catch(ShootException e) {
			System.out.println(e.getMessage());
			}
		return ok;
	}

	@Override
	public boolean shockWave() {
		if(this.player.isShockWave()) {
			board.shockWave(this);
			return true;
		}
		else return false;
	}

	@Override
	public void receivePoints(int points) {
		this.player.setPoints(this.player.getPoints() + points);
		
	}
	
	@Override
	public void ableShockWave (boolean able) {
		this.player.setShockWave(able);
	}

	@Override
	public void enableMissile() {
		this.player.setMisilShoot(false);
	
	}
	
	@Override 
	public boolean sMis() { // buy
		if(player.getPoints() >= 20) {
			player.setPoints(player.getPoints()- 20);
			player.setsMis(player.getsMis()+1);
			return true;
		}
		else return false;
	}
	
	@Override 
	public boolean wasteSM() {
		if(this.player.getsMis() > 0) {
			this.player.setsMis(this.player.getsMis()-1);
			return true;
		}
		else {
			return false;
		}
	}

}