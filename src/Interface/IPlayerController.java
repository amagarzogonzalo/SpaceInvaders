package Interface;

public interface IPlayerController {
	// Player actions
	public boolean move (String lado, int numCells);
	public boolean shootMissile(boolean s);
	public boolean shockWave();
	// Callback
	public void receivePoints(int points);
	public void ableShockWave(boolean able);
	public void enableMissile();
	
	// SuperMissil
	public boolean sMis();
	public boolean wasteSM();
	}
