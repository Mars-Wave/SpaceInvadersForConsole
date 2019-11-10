package tp.p1.GameElements;

import tp.p1.Game;
import tp.p1.IExecuteRandomActions;

public class UFO extends EnemyShip implements IExecuteRandomActions {

	private static boolean itExists;
	private static final Direction dir = Direction.LEFT;

	public UFO(Game game) {
		super(game, Game.DIM_X + 1, 0, 1, 25);
		itExists = true;
	}

	public static boolean exists() {
		return itExists;
	}
	
	public boolean findAt(int x, int y) {
		return (this.getX() == x && this.getY() == y);
	}
	
	public static int getPoints() {
		return points;
	}
	
	private int getX() {
		return positionX;
	}
 
    private int getY() {
		return positionY;
	}

    public String toString() {
		return "<(+)>";
	}
    
    public void getHit() {
    	shield --;
    }
    
   /* public boolean update() {
  	boolean canBeDone = positionX + dir.getValue() >= 0;
    	if(canBeDone) {
				positionX += dir.getValue();
	   	}
    	return canBeDone;
	}*/


	@Override
	public void computerAction() {
		//Empty default
	}

	@Override
	public void onDelete() {
		if(shield <= 0 || isOut()) {
			itExists = false;	
		}
	}

	@Override
	public void move() {
				positionX += dir.getValue();
	}
}


