package tp.p1.GameElements;

<<<<<<< Updated upstream
import tp.p1.Interfaces.IExecuteRandomActions;
import tp.p1.Model.Game;
=======
import tp.p1.Model.Game;
import tp.p1.Interfaces.IExecuteRandomActions;
>>>>>>> Stashed changes

public class CarrierShip extends AlienShip{
	
	public CarrierShip(Game game, int x, int y) {
<<<<<<< Updated upstream
		super(game, x, y, 2, 5, Direction.LEFT, Direction.LEFT);
	}   

=======
		super(game, x, y, 2, 5);
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
	
>>>>>>> Stashed changes
	public String toString() {
		return "-<" + shield + ">-";
	}

	@Override
	public void computerAction() {
<<<<<<< Updated upstream
		if (IExecuteRandomActions.evolveExplosive(game)) {
			this.itExists = false;
			ExplosiveShip e = new ExplosiveShip(game, positionX, positionY, shield, points, this.dir, this.nextDir);
			game.addObject(e);
		}
=======
		if (IExecuteRandomActions.canGenerateExplosiveShip(game)) {
	           destroy();
	          game.replace(this, new ExplosiveShip(game, positionX, positionY));
	        }
>>>>>>> Stashed changes
	}

}


