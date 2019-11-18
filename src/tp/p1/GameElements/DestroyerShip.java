package tp.p1.GameElements;

import tp.p1.Model.Game;
import tp.p1.Interfaces.IExecuteRandomActions;

public class DestroyerShip extends AlienShip {

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

    public Edge edge() {
        Edge aux = Edge.NotOnEdge;
        if (getX() == 0) {
            aux = Edge.LeftEdge;
        } else if (getX() == Game.DIM_X) {
            aux = Edge.RightEdge;
        }
        return aux;

    }

    public void updateWeaponsReady(boolean ready) {
        weaponsReady = ready;
    }

    @Override
    public void computerAction() {
        if (weaponsReady && IExecuteRandomActions.canGenerateBomb(game)) {
			//iShoot = true;
        	game.addObject(new Projectile(game, positionX, positionY, this));
        	weaponsReady = false;
        }
    }
}




