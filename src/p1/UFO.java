package tp.p1;

class UFO {
	private int resistance;
	private static int points;
	private Game game;
	private int positionX, positionY;
	private static boolean itExists = false;
	private static final Direction dir = Direction.LEFT;

	public UFO(Game game) {
		resistance = 1;
		points = 25;
		positionX = 9;
		positionY = 0;
		this.game = game;
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
    	resistance --;
    	if(resistance <= 0) {
			game.UFOdestroy();
		}
    }
    
    public boolean updatePos() {
  	boolean canBeDone = positionX + dir.getValue() >= 0;
    	if(canBeDone) {
				positionX += dir.getValue();
	   	}
    	return canBeDone;
	}

	public static void destroy() {
		itExists = false;
	}
}


