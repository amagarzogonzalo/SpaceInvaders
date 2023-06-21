package Control;
import java.util.Random;

public class Main {

	public static void main (String []args) {
		System.out.println("\t\t\t ------BIENVENIDO A SPACE INVADERS------");
		long seed = Long.parseLong(args[1]);
		Random ran = new Random(seed);
		Level level = null;
		if(args[0].contentEquals("EASY")) level = Level.EASY; 
		else if(args[0].contentEquals("HARD")) level = Level.HARD;
		else if(args[0].contentEquals("INSANE")) level = Level.INSANE;
		else System.out.println("Usage: Main <EASY|HARD|INSANE> [seed]: level must be one of: EASY, HARD, INSANE");
		Game game = new Game(level,ran);
		Controller controlador = new Controller(game);	
		controlador.run(game, ran);
		} 
}
