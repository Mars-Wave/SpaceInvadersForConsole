package tp.p1.GameElements;

import tp.p1.Game;

public class CarrierShip extends AlienShip{
	
	public CarrierShip(Game game, int x, int y) {
		super(game, x, y, 2, 5);
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
			else if(getX() == Game.DIM_X) {
				aux = Edge.RightEdge;
			}
		return aux;

	}

    public int getY() {
		return positionY;
	}
	
	public String toString() {
		return "-<" + shield + ">-";
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
		shield--;
		if(shield <= 0) {
			toBeDestroyed = true;
			game.receivePoints(points);	//Maybe?
		}
	}

	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move() {	//This is the hardest shit to implement what it does is basically... Read notes in drive xD
		// TODO Auto-generated method stub
		
	}
	
}


