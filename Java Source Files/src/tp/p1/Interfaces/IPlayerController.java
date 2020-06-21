package tp.p1.Interfaces;

import tp.p1.GameElements.Direction;

public interface IPlayerController {
	// Player actions
	public boolean move (int numCells, Direction dir);
<<<<<<< Updated upstream
	public boolean shootMissile();
=======
	public boolean shootMissile(int type);
>>>>>>> Stashed changes
	public boolean shockWave();
	// Callbacks
	public void receivePoints(int points);
	public void enableShockWave();
	public void enableMissile();
	}
