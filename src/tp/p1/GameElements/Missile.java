package tp.p1.GameElements;

import tp.p1.Model.Game;

public class Missile extends Weapon {

    private static final Direction dir = Direction.UP;
 
    private static int count;

    public Missile(Game game, int x, int y) {
        super(game, x, y, 1);
        itExists = true;
        // TODO Auto-generated constructor stub
    }

    public static int getCount() {
        return count;
    }

    public boolean exists() {
        return itExists;
    }

    public String toString() {
        return "�";
    }

    @Override
    public void move() {
			positionY += dir.getValue();
    }

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
	}
	
	public boolean performAttack(GameElement other) {
		boolean aux = other.getX() == positionX && other.getY() == positionY;
		if(aux) {
			if (other.receiveMissileAttack(damage))
			itExists = false;
		}
		return aux;
	}
	
	public void destroy() {
		itExists = false;
		game.enableMissile();
	}
	
	public boolean receiveBombAttack(int damage) {
		shield -= damage;
		return true;
	}
}


