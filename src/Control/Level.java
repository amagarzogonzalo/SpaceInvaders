package Control;

public enum Level {
	EASY(4, 2, 0.1, 3, 0.5, 1, 3),
	HARD(8, 2, 0.3, 2, 0.2, 2, 2),
	INSANE(8, 4, 0.5, 1, 0.1, 2, 1);
	private int numRegularAliens;
	private int numDestroyerAliens;
	private int numCyclesToMoveOneCell;
	private double ovniFrequency;
	private double shootFrequency;
	private int numRowsOfRegularAliens;
	private int velocidad;
	//private int turnExplodeFrequency = 0,05; // actualmente no depende del nivel
	
	private Level(
		int numRegularAliens,
		int numDestroyerAliens,
		double shootFrequency,
		int numCyclesToMoveOneCell,
		double ovniFrequency,
		int numRowsOfRegularAliens,
		int velocidad)
	
		{
		this.numRegularAliens = numRegularAliens;
		this.numDestroyerAliens = numDestroyerAliens;
		this.shootFrequency = shootFrequency;
		this.numCyclesToMoveOneCell = numCyclesToMoveOneCell;
		this.ovniFrequency = ovniFrequency;
		this.numRowsOfRegularAliens = numRowsOfRegularAliens;
		this.velocidad = velocidad;
		}
	
	public int getNumRegularAliens() {
		return numRegularAliens;
	}
	
	public int getNumDestroyerAliens() {
		return numDestroyerAliens;
	}
	
	public double getShootFrequency() {
		return shootFrequency;
	}
	
	public int getNumCyclesToMoveOneCell() {
		return numCyclesToMoveOneCell;
	}
	
	public double getOvniFrequency() {
		return ovniFrequency;
	}
	
	public int getNumRowsOfRegularAliens() {
		return numRowsOfRegularAliens;
	}
	
	public int getNumRegularAliensPerRow() {
		return numRegularAliens / numRowsOfRegularAliens;
	}
	
	public int getNumDestroyerAliensPerRow() {
		return getNumDestroyerAliens();
	}
	
	public static Level parse(String cadenaEntrada) {
		for (Level level : Level.values() )
		if (level . name().equalsIgnoreCase(cadenaEntrada))
		return level;
		return EASY;
	}

	public int getVelocidad() {
		return velocidad;
	}
	
	
	
	/*public double getTurnExplodeFrequency(){
		return turnExplodeFrequency;
	}*/
}


/*package Control;

public class Level {
	private enum Dificultad{
		EASY, HARD, INSANE, VACIO
	};
	
	private Dificultad dificultad;
	private int velocidad, maxregulares, maxdestructores, posXr, posYr,posXd,posYd;
	private float frecuencia, probovni;
	
	public Level (String args []) {
	switch (args [0]) {
	    case "VACIO":
		this.dificultad = Dificultad.VACIO;
		break;
		case "EASY":
			this.dificultad = Dificultad.EASY;
			this.velocidad = 3;
			this.frecuencia= 0.1F;
			this.maxregulares=4;
			this.maxdestructores=2;
			this.probovni=0.5F;
			this.posXr = 3;
			this.posYr = 1;
			this.posXd = 4;
			this.posYd = 2;
			break;
		case "HARD":
			this.dificultad = Dificultad.HARD;
			this.velocidad = 2;
			this.frecuencia=0.3F;
			this.maxregulares=8;
			this.maxdestructores=2;
			this.probovni=0.2F;
			this.posXr = 3;
			this.posYr = 1;
			this.posXd = 4;
			this.posYd = 3;
			break;
		case "INSANE":
			this.dificultad = Dificultad.INSANE;
			this.velocidad = 1;
			this.frecuencia=0.5F;
			this.maxregulares=8;
			this.maxdestructores=4;
			this.probovni=0.1F;
			this.posXr = 3;
			this.posYr = 1;
			this.posXd = 3;
			this.posYd = 3;
			break;
			}
		}

	public Dificultad getDificultad() {
		return dificultad;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public int getMaxregulares() {
		return maxregulares;
	}

	public int getMaxdestructores() {
		return maxdestructores;
	}

	public int getPosXr() {
		return posXr;
	}

	public int getPosYr() {
		return posYr;
	}

	public int getPosXd() {
		return posXd;
	}

	public int getPosYd() {
		return posYd;
	}

	public float getFrecuencia() {
		return frecuencia;
	}

	public float getProbovni() {
		return probovni;
	}
	
}
*/
