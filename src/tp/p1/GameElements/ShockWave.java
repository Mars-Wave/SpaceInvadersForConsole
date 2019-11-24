package tp.p1.GameElements;

import tp.p1.Model.Game;

public class ShockWave extends Weapon {
	
	
	public ShockWave(Game game, int x, int y) {
		super(game, x, y, 1);
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
				other.receiveShockWaveAttack(damage);
				this.itExists = false;
		return itExists;
	}

}
