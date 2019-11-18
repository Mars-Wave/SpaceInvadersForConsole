package tp.p1.GameElements;

import tp.p1.Model.Game;

public class Projectile extends Weapon {

	private static Direction dir = Direction.DOWN;
	private DestroyerShip dShip = null;
	
	public Projectile(Game game, int x, int y, DestroyerShip dShip) {
		super(game, x, y, 1);
		this.dShip = dShip;
		itExists = true;
	}

	public Direction getDir() {
		return dir;
	}
	
	public String toString() {
		return "!";
	}

	
    /*public void setDship(DestroyerShip dShip) {
    	this.dShip = dShip;
    }*/
    
    public void destroy() {
    	itExists = false;
    	dShip.updateWeaponsReady(true);
    }

	@Override
	public void move() {
		// TODO Auto-generated method stub
		positionY += dir.getValue();
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean performAttack(GameElement other) {
		boolean aux = other.getX() == positionX && other.getY() == positionY;
		if(aux && itExists) {
			other.receiveBombAttack(damage);
			itExists = false;
		}
		return aux;
	}
	
	public boolean receiveMissileAttack(int damage) {
		shield -= damage;
		if(shield <= 0) itExists = false;
		return true;
	}
	
}



