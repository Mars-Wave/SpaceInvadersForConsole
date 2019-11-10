package tp.p1.GameElements;

import tp.p1.Game;

public abstract class EnemyShip extends Ship{

	protected static int points;
	
	
	public EnemyShip(Game game, int x, int y, int lives, int points) {
		super(game, x, y, lives);
		this.points = points;
	}

}
