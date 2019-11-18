package tp.p1.GameElements;

//import /* imported classes */

import tp.p1.Model.Game;
import tp.p1.Interfaces.IAttack;

public abstract class  GameElement implements IAttack {
    protected int positionX, positionY;
    protected int shield;
    protected Game game;
    protected boolean itExists = false;

    public GameElement(Game game, int x, int y, int lives) {
        positionX = x;
        positionY = y;
        this.game = game;
        shield = lives;
        itExists = true;
    }

    /* method(s) to get value of coordinates */
    
    public int getX() {
		return positionX;
	}
 
    public int getY() {
		return positionY;
	}
   
     
    public boolean isAlive() {
        return itExists;
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
    
    public void destroy() {
        /*positionX = Game.DIM_X -1;
        positionX = 0;
        //Maybe useful !! */
		itExists = false;
	}

    public abstract void computerAction();

    public abstract void onDelete();

    public abstract void move();    //This is the hardest shit to implement what it does is basically... Read notes in drive xD

    public abstract String toString();
    
    
	
}