package tp.p1;

import tp.p1.GameElements.Direction;

public interface IPlayerController {
	// Player actions
	public boolean move (int numCells, Direction dir);
	public boolean shootMissile();
	public boolean shockWave();
	// Callbacks
	public void receivePoints(int points);
	public void enableShockWave();
	public void enableMissile();
	}
