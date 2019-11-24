package tp.p1.GameElements;

import tp.p1.Model.Game;

public abstract class EnemyShip extends Ship{

	protected int points;
	
	public EnemyShip(Game game, int x, int y, int lives, int point) {
		super(game, x, y, lives);
		points = point;
	}
	
	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		if(shield <= 0) game.receivePoints(points);
		
	}

	public boolean receiveMissileAttack(int damage) {
		shield -= damage;
		return true;
	}
	
	public boolean receiveShockWaveAttack(int damage) {
		shield -= damage;
		return true;
	}
	
}
