package tp.p1.GameElements;

import tp.p1.Interfaces.IExecuteRandomActions;
import tp.p1.Model.Game;

public class DestroyerShip extends AlienShip {

    private boolean weaponsReady = true;

    public DestroyerShip(Game game, int x, int y) {
        super(game, x, y, 1, 10, Direction.LEFT, Direction.LEFT);
    }

    public String toString() {
        return "!<" + shield + ">!";
    }

    public boolean getWeaponsReady() {
        return weaponsReady;
    }

    public void updateWeaponsReady(boolean ready) {
        weaponsReady = ready;
    }

    @Override
    public void computerAction() {
        if (weaponsReady && IExecuteRandomActions.canGenerateBomb(game)) {
            game.addObject(new Projectile(game, positionX, positionY, this));
            weaponsReady = false;
        }

    }
}




