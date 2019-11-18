package tp.p1.GameElements;

import tp.p1.Model.Game;

public class ShockWave extends Weapon {
	
	private static boolean itExists;
	
	public ShockWave(Game game, int x, int y) {
		super(game, x, y, 1);
	}

	 public static boolean exists() {
	        return itExists;
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
	public void move() {
		// Default Empty
	}

	@Override
	public String toString() {
		return null;
	}

	@Override
	public boolean performAttack(GameElement other) {
		if(itExists) {
			other.receiveShockWaveAttack(damage);
			itExists = false;
		}
		return itExists;
	}

}
