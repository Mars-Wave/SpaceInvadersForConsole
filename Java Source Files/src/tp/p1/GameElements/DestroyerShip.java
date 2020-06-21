package tp.p1.GameElements;

<<<<<<< Updated upstream
import tp.p1.Interfaces.IExecuteRandomActions;
import tp.p1.Model.Game;
=======
import tp.p1.Model.Game;
import tp.p1.Interfaces.IExecuteRandomActions;
>>>>>>> Stashed changes

public class DestroyerShip extends AlienShip {

    private boolean weaponsReady = true;
<<<<<<< Updated upstream

    public DestroyerShip(Game game, int x, int y) {
        super(game, x, y, 1, 10, Direction.LEFT, Direction.LEFT);
=======
    
    public DestroyerShip(Game game, int x, int y) {
        super(game, x, y, 1, 10);
>>>>>>> Stashed changes
    }

    public String toString() {
        return "!<" + shield + ">!";
    }

    public boolean getWeaponsReady() {
        return weaponsReady;
    }

<<<<<<< Updated upstream
=======
    public Edge edge() {
        Edge aux = Edge.NotOnEdge;
        if (getX() == 0) {
            aux = Edge.LeftEdge;
        } else if (getX() == Game.DIM_X) {
            aux = Edge.RightEdge;
        }
        return aux;

    }

>>>>>>> Stashed changes
    public void updateWeaponsReady(boolean ready) {
        weaponsReady = ready;
    }

    @Override
    public void computerAction() {
        if (weaponsReady && IExecuteRandomActions.canGenerateBomb(game)) {
<<<<<<< Updated upstream
            game.addObject(new Projectile(game, positionX, positionY, this));
            weaponsReady = false;
        }

=======
			//iShoot = true;
        	game.addObject(new Projectile(game, positionX, positionY, this));
        	weaponsReady = false;
        }
>>>>>>> Stashed changes
    }
}




