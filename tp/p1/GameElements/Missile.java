package tp.p1.GameElements;

import tp.p1.Game;

public class Missile extends Weapon {

    private static final Direction dir = Direction.UP;
    private static int count;

    public Missile(Game game, int x, int y) {
        super(game, x, y);
        // TODO Auto-generated constructor stub
    }

    public static int getCount() {
        return count;
    }

    public static boolean exists() {
        return itExists;
    }


    public boolean findAt(int x, int y) {
        if (exists()) {
            return getX() == x && getY() == y;
        } else {
            return false;
        }
    }

    private int getX() {
        return positionX;
    }

    private int getY() {
        return positionY;
    }


    public String toString() {
        return "�";
    }

    public static void destroy() {
        itExists = false;
        count = 0;
    }

    public void update() {
        updatePos();
        updateCollision();
    }

    private void updatePos() {
        if (positionY > 0) {
            positionY += dir.getValue();
        } else {
            destroy();
        }
    }


    public void updateCollision() {
 /*
          Attempt to attack the shit at my position
          recieveAttack from the shit at my position



        if(game.dListFoundAt(positionX, positionY)) {
            game.dListgetHit(game.dListFindShip(positionX, positionY));
            destroy();
        }
        else if(game.cListFoundAt(positionX, positionY)) {
            game.cListgetHit(game.cListFindShip(positionX, positionY));
            destroy();
        }
        else if(game.projectileAt(positionX, positionY)) {
            game.projectileDestroy(game.bListFindBomb(positionX, positionY));
            destroy();
        }
        else if(game.UFOat(positionX, positionY)) {
            game.UFOgetHit();
            destroy();
        }

 */
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
        // TODO Auto-generated method stub

    }

}


