package tp.p1.GameElements;

import tp.p1.Game;

public class DestroyerShip extends AlienShip{
	
	private boolean weaponsReady = true;
	
	public DestroyerShip(Game game, int x, int y) {
		super(game, x, y, 1, 10);
		
	}
	
	public String toString() {
		return "!<" + shield + ">!";
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
		shot.setDship(this); //should be in constructor of the projectile I guess is what he said?!
		return shot;
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
		shield -= 1;
		if(shield <= 0) {
			toBeDestroyed = true;
			game.receivePoints(points);
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




