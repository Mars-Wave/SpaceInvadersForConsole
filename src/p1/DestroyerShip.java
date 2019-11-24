package tp.p1;

class DestroyerShip {
	private int resistance;
	private static int points;
	private int positionX, positionY;
	private Game game;
	private boolean toBeDestroyed = false;
	private boolean weaponsReady = true;
	
	public DestroyerShip(int x, int y, Game game) {
		resistance = 1;
		points = 10;
		positionX = x;
		positionY = y;
		this.game = game;
	}
	
	public String toString() {
		return "!<" + resistance + ">!";
	}
	
	public boolean getWeaponsReady() {
		return weaponsReady;
	}
	
	 public int getX() {
			return positionX;
		}
	    
	public int getY() {
	return positionY;
	}

	public static int getPoint() {
	return points;
	}



	public Projectile shoot(int x, int y) {
		Projectile shot = new Projectile(game , x, y);
		updateWeaponsReady(false);
		shot.setDship(this);
		return shot;
	}

	public Edge edge() {
		Edge aux = Edge.NotOnEdge;
		if (getX() == 0) {
			aux = Edge.LeftEdge;
		}
		else if(getX() == game.maxX) {
			aux = Edge.RightEdge;
		}
		return aux;

	}

	public boolean get2BeDestroyed() {
	return toBeDestroyed;
	}

	public void updateWeaponsReady(boolean ready) {
		weaponsReady = ready;
	}
	    
	public void updatePos(Direction dir) {
			if(dir == Direction.DOWN) {
				positionY += dir.getValue();

			}
			else {
				positionX += dir.getValue();
			}
	}
	
	public void getHit() {
		resistance -= 1;
		if(resistance <= 0) {
			toBeDestroyed = true;
			game.winDpoints();
		}
	}

}




