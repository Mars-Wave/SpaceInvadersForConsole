package tp.p1;

public class Projectile {

	private int positionX, positionY;
	private static Direction dir = Direction.DOWN;
	private boolean itExists;
	private boolean toBeDestroyed = false;
	private Game game;
	private DestroyerShip dShip;
	
	public Projectile(Game game, int x, int y) {
		positionX = x;
		positionY = y;
		itExists = true;
		this.game = game;
	}


	public boolean exists() {
		return itExists;
	}

	public Direction getDir() {
		return dir;
	}
	
	public String toString() {
		return "!";
	}
	
	public int getX() {
		return positionX;
	}
 
    public int getY() {
		return positionY;
	}
    
    public boolean get2BeDestroyed() {
		return toBeDestroyed;
	}
	
    public void setDship(DestroyerShip dShip) {
    	this.dShip = dShip;
    }
    
    public void destroy() {
    	itExists = false;
    	toBeDestroyed = true;
    	dShip.updateWeaponsReady(true);
    }
    
    public void update(int pos) {
    	boolean posi, coli;
		posi = updatePos();
		coli = updateCollision();
		if(!posi || !coli) {
			itExists = false;
			toBeDestroyed = true;
			destroy();
		}
		}
	
    private boolean updatePos() {
    	boolean canBeDone = true;
	if(positionY < 7 && !toBeDestroyed) {
	positionY += dir.getValue();
	}
	else {
		canBeDone = false;
	}
	return canBeDone;
	} 

	private boolean updateCollision() {
		boolean canBeDone = true;
	if(game.UCMat(positionX, positionY)) {
		game.UCMgetHit();
		canBeDone = false;
	}
	if(game.missileAt(positionX, positionY)) {		// This is already taken care of by the way our update works (Missile will remove the proj which means this case is never achieved)!
		canBeDone = false;
		game.missileDestroy();
	}
	return canBeDone;
	}
	
}



