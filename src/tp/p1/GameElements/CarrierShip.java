package tp.p1.GameElements;

import tp.p1.Interfaces.IExecuteRandomActions;
import tp.p1.Model.Game;

public class CarrierShip extends AlienShip{
	
	public CarrierShip(Game game, int x, int y) {
		super(game, x, y, 2, 5, Direction.LEFT, Direction.LEFT);
	}   

	public String toString() {
		return "-<" + shield + ">-";
	}

	@Override
	public void computerAction() {
		if (IExecuteRandomActions.evolveExplosive(game)) {
			this.itExists = false;
			ExplosiveShip e = new ExplosiveShip(game, positionX, positionY, shield, points, this.dir, this.nextDir);
			game.addObject(e);
		}
	}

}


