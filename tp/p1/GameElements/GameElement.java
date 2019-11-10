package tp.p1.GameElements;

//import /* imported classes */

import tp.p1.Game;
import tp.p1.IAttack;

public abstract class  GameElement implements IAttack {
    protected int positionX, positionY;
    protected int shield;
    protected Game game;
    protected boolean toBeDestroyed = false;

    public GameElement(Game game, int x, int y, int lives) {
        positionX = x;
        positionY = y;
        this.game = game;
        shield = lives;
    }

    /* method(s) to get value of coordinates */
    public boolean isAlive() {
        return shield > 0;
    }

    public int getShield() {
        return shield;
    }

    public boolean isOnPosition(int x, int y) {
        return (positionX == x && positionY == y);
    }

    public void getDamage(int damage) {
        shield = damage >= shield ? 0 : shield - damage;
    }

    public boolean isOut() {
        return !game.isOnBoard(positionX, positionY);
    }

    public abstract void computerAction();

    public abstract void onDelete();

    public abstract void move();    //This is the hardest shit to implement what it does is basically... Read notes in drive xD

    public abstract String toString();
/*default boolean performAttack(GameElement other) {return false;};	I think all of these should be in here? since GameElement implements IAttack and change default to public maybe?
default boolean receiveMissileAttack(int damage) {return false;};
default boolean receiveBombAttack(int damage) {return false;};
default boolean receiveShockWaveAttack(int damage) {return false;};*/
}