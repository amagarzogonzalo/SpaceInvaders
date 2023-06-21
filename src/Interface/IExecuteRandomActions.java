package Interface;
import Control.*;
import Entities.*;

public interface IExecuteRandomActions {
	
	static boolean canGenerateRandomOvni(Game game){
		return game.getRandom().nextDouble() < game.getLevel().getOvniFrequency();
	}
	static boolean canGenerateRandomBomb(Game game){
		return game.getRandom().nextDouble() < game.getLevel().getShootFrequency();
		
	}
	static boolean canGenerateRandomEplosive(Game game){
		return game.getRandom().nextDouble() < 0.05;
	}
}
