package tp.p1.GameElements;

import tp.p1.Interfaces.IExecuteRandomActions;
import tp.p1.Model.Game;

public class UFO extends EnemyShip implements IExecuteRandomActions {    //Does it implement this?

    private static final Direction dir = Direction.LEFT;
    private static boolean itExists;

    public UFO(Game game) {
        super(game, Game.DIM_X, 0, 1, 25);
        itExists = true;
    }

    public static void init() {
        itExists = false;
    }

    public static boolean exists() {
        return itExists;
    }

    public String toString() {
        return "<(+)>";
    }

    public void getHit() {
        shield--;
    }


    @Override
    public void computerAction() {    //Fix that this can't be static but has to be called for UFO which doesn't exist yet wow! xD
        if (!UFO.exists() && IExecuteRandomActions.canGenerateUfo(game)) {
            game.addObject(new UFO(game));
        }
    }

    @Override
    public void move() {
        if (itExists) {
            positionX += dir.getValue();
        }
    }
}


