package tp.p1.GameElements;

import tp.p1.Model.Game;

public abstract class AlienShip extends EnemyShip {

    protected static int enemyShipsCounter = 0;
    protected static boolean haveLanded = false;
    protected static Direction dir;
    protected static Direction nextDir;

    public AlienShip(Game game, int x, int y, int lives, int points) {
        super(game, x, y, lives, points);
        dir = Direction.LEFT;
        nextDir = Direction.LEFT;
        enemyShipsCounter++;
    }

    public static void changeDir() {
        dir = nextDir;
    }

    public static boolean allDead() {
        return (enemyShipsCounter == 0);
    }

    public static int enemyShipsCounter() {
        return enemyShipsCounter;
    }

    public static boolean haveLanded() { // Should this be static?
        return haveLanded;
    }

    public void move() {
        // TODO Auto-generated method stub
        if (itExists) {
            if (dir == Direction.DOWN) {
                positionY += dir.getValue();
            } else {
                positionX += dir.getValue();
            }

            if (dir == Direction.DOWN) {
                if (positionX == 0) {
                    nextDir = Direction.RIGHT;
                } else if (positionX == Game.DIM_X - 1) {
                    nextDir = Direction.LEFT;
                }
            } else if (positionX == 0 || positionX == Game.DIM_X - 1) {

                nextDir = Direction.DOWN;
            }
            haveLanded = positionY == Game.DIM_Y - 1;
        }
    }

    public void checkLanded() {
        haveLanded = positionY == Game.DIM_Y - 1;
    }

    public boolean receiveMissileAttack(int damage) {
        shield -= damage;
        if (shield <= 0) itExists = false;
        return true;
    }
}
