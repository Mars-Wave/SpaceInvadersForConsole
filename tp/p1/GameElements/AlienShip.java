package tp.p1.GameElements;

import tp.p1.Game;

public abstract class AlienShip extends EnemyShip{
	
	protected static int enemyShipsCounter = 0;
	protected static boolean haveLanded = false;
	
	public AlienShip(Game game, int x, int y, int lives, int points) {
		super(game, x, y, lives, points);
		enemyShipsCounter++;
		
	}

	public static boolean allDead() {
		return (enemyShipsCounter == 0);
	}
	
	public static int enemyShipsCounter() {
		return enemyShipsCounter;
	}

	public boolean haveReachedBottom() {	//I made this and want to call it on each enemyShip every time we update to check if any of em reached the end!
		boolean haveReachedBottom = false;
		if(positionY == Game.DIM_Y) {
			haveReachedBottom = true;
		}
		return haveReachedBottom;
	}
	
	public static boolean haveLanded() {	//Should this be static?
		return haveLanded;
	}
}
