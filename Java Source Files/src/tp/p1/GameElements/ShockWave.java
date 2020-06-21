package tp.p1.GameElements;

import tp.p1.Model.Game;

<<<<<<< Updated upstream
public class ShockWave extends Weapon {
	
=======
public class ShockWave extends Weapon {	
>>>>>>> Stashed changes
	
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
<<<<<<< Updated upstream
		
=======
		game.disableSW();
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
				other.receiveShockWaveAttack(damage);
				this.itExists = false;
=======
			other.receiveShockWaveAttack(damage);
			itExists = false;
>>>>>>> Stashed changes
		return itExists;
	}

}
