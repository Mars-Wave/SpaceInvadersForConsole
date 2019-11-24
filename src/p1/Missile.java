package tp.p1;

class Missile {

	private int positionX, positionY;
	private Game game;
	private static final Direction dir = Direction.UP;
	private static int count;
	private static boolean itExists = false;
	
	public Missile(Game game, int x, int y) {
		positionX = x;
		positionY = y;
		this.game = game;
		itExists = true;
		count++;
	}
	
	public static int getCount() {
		return count;
	}
	
	public static boolean exists() {
		return itExists;
	}


	public boolean findAt(int x, int y) {
		if (exists()) {
			return getX() == x && getY() == y;
		}
		else{
			return false;
		}
	}
	
	private int getX() {
		return positionX;
	}
 
    private int getY() {
		return positionY;
	}
	
	
	public String toString() {
		return "ˆ";
	}
	
	public static void destroy() {
		itExists = false;
		count = 0;
	}
	
	public void update() {
		updatePos();
		updateCollision();
	}
	
private void updatePos() {
	if(positionY > 0) {
	positionY += dir.getValue();
	}
	else {
		destroy();
	}
	}


public void updateCollision() {
	if(game.dListFoundAt(positionX, positionY)) {
		game.dListgetHit(game.dListFindShip(positionX, positionY));
		destroy();
	}
	else if(game.cListFoundAt(positionX, positionY)) {
		game.cListgetHit(game.cListFindShip(positionX, positionY));
		destroy();
	}
	else if(game.projectileAt(positionX, positionY)) {
		game.projectileDestroy(game.bListFindBomb(positionX, positionY));
		destroy();
	}
	else if(game.UFOat(positionX, positionY)) {
		game.UFOgetHit();
		destroy();
	}
	
	
	}
	
}


