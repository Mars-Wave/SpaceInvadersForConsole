package tp.p1;

class UCMspaceship {
	private int resistance;
	private boolean shockwave;
	private int positionX, positionY;
	private Direction dir;
	private Game game;

	public UCMspaceship(Game game) {
		resistance = 3;
		shockwave = false;
		positionX = 4;
		positionY = 7;
		dir = Direction.LEFT;
		this.game = game;
	}
	
	public boolean findAt(int x, int y) {
		return (this.getX() == x && this.getY() == y);
	}
	
	


    public void changeDir(int changeDir) {
			if(changeDir == 0 ) {
				dir = Direction.RIGHT;
			}
			else if(changeDir == 1 ) {
				dir = Direction.LEFT;
			}
	}

	public boolean canIgo(int blocks){
		if (dir == Direction.LEFT) {
			return  positionX - blocks >= 0;
		}
		else {
			return positionX + blocks <= game.maxX;
		}
	}

	public void updatePos(int blocks) {
		positionX += blocks * dir.getValue();
	}

	public void getHit() {
		resistance--;
	}
	
	public int getX() {
		return positionX;
	}
 
    public int getY() {
		return positionY;
	}
    
    public int getResistance() {
		return resistance;
	}
	
    public boolean getSW() {
		return shockwave;
	}
    
    public void setSW(boolean i) {
		shockwave = i;
	}
    
    public String swString() {
		String str = "Ready!";
		if(!shockwave) {
			str = "NO";
		}
		return str;
	}
    
	public String toString() {
		String str = "/-^-\\";
		if(resistance <= 0) {
			str = "_+.+_";
		}
		return str;
	}
}