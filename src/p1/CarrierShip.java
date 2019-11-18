package tp.p1;

class CarrierShip {
	private int resistance;
	private static int points;
	private int positionX, positionY;
	private Game game;
	private boolean toBeDestroyed = false;
	
	public CarrierShip(int x, int y, Game game) {
		resistance = 2;
		points = 5;
		positionX = x;
		positionY = y;
		this.game = game;
	}
	
	public boolean get2BeDestroyed() {
    	return toBeDestroyed;
    }
	
    public static int getPoint() {
			return points;
		}
	
    public int getX() {
		return positionX;
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

    public int getY() {
		return positionY;
	}
	
	public String toString() {
		return "-<" + resistance + ">-";
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
		resistance--;
		if(resistance <= 0) {
			toBeDestroyed = true;
			game.winCpoints();
		}
	}
	
}


