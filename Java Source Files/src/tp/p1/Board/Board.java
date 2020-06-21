package tp.p1.Board;

<<<<<<< Updated upstream
import tp.p1.GameElements.AlienShip;
import tp.p1.GameElements.GameElement;
import tp.p1.Model.Game;
import tp.p1.Model.Level;

import java.util.Random;

//import java.awt.datatransfer.FlavorEvent;
=======
import tp.p1.GameElements.GameElement;
import tp.p1.GameElements.AlienShip;
import tp.p1.Model.Game;
import tp.p1.Model.Level;
//import java.awt.datatransfer.FlavorEvent;
import java.util.Random;
>>>>>>> Stashed changes


public class Board {
    private GameElement[] elements;
    // private Game game;    //Am I allowed to have game here?
    private int currentElements;

    public Board(Game game, int numelements) {
        // this.game = game;
        currentElements = 0;
        elements = new GameElement[numelements]; //Conflicted about this shit, the array needs to be initialised so add(GameElement gameElement) can add shit so I give it the amount of total ships the game is gonna have
    }

<<<<<<< Updated upstream
    private int getcurrentElements() {
=======
    public int getcurrentElements() {
>>>>>>> Stashed changes
        return currentElements;
    }

    public void add(GameElement gameElement) {
        elements[currentElements] = gameElement;
        currentElements++;
    }
<<<<<<< Updated upstream

    public void update() {
        for (int i = 0; i < currentElements; i++) {
            checkAttacks(elements[i]);
            elements[i].move();
            checkAttacks(elements[i]);
        }
        AlienShip.changeDir();
=======
    
    public void replace(GameElement oldElement, GameElement newElement) {
        elements[getIndex(oldElement.getX(), oldElement.getY())] = newElement;
    }

    public void update() {
        for (int i = 0; i < currentElements; i++) {
        	checkAttacks(elements[i]);
            elements[i].move();   
            checkAttacks(elements[i]);
        }
        AlienShip.changeDir();   
>>>>>>> Stashed changes
        removeDead();
// TODO implement
    }

    public void checkAttacks(GameElement gameElement) {
<<<<<<< Updated upstream
        if (gameElement.exists()) {
            for (int j = 0; j < currentElements; j++) {
                if (gameElement != elements[j]) {
                    gameElement.performAttack(elements[j]);

                }
            }
        }
=======
    	if(gameElement.exists()){
    		for(int j = 0; j < currentElements; j++) {
    			if(gameElement != elements[j]) {
    				gameElement.performAttack(elements[j]);
    			}
    		
    	}
    	}
>>>>>>> Stashed changes
// TODO implement
    }

    public void computerAction(Random randseed, Level level) {
        for (int i = 0; i < currentElements; i++) {
            elements[i].computerAction();
        }
// TODO implement
    }

    public String toString(int x, int y) {
        if (getObjectAt(x, y) == (null)) {
            return "";
        } else {
            return getObjectAt(x, y).toString();
        }
    }

    private GameElement getObjectAt(int x, int y) {
        GameElement element = null;
        boolean found = false;
        for (int i = 0; i < currentElements && !found; i++) {
            if (elements[i].isOnPosition(x, y)) {
                element = elements[i];
                found = true;
            }
        }
        return element;
    }

    private int getIndex(int x, int y) {
        boolean found = false;
        int index = -1;
        for (int i = 0; i < elements.length && !found; i++) {
            if (elements[i].isOnPosition(x, y)) {
                index = i;
                found = true;
            }
        }
        return index;
    }

    private void remove(GameElement gameElement, int where) {
<<<<<<< Updated upstream
        elements[where].onDelete();
        elements[where].destroy();
        GameElement aux;
        if (!elements[where].exists()) {
            for (int i = where; i < currentElements - 1; i++) {
                aux = elements[i + 1];
                elements[i + 1] = elements[i];
                elements[i] = aux;
            }
            currentElements--;
=======
    	elements[where].destroy();
    	elements[where].onDelete(); 
    	 GameElement aux;
        if(!elements[where].exists()) {
        	 
	        for (int i = where; i < currentElements - 1; i++) {
	            aux = elements[i + 1];
	            elements[i + 1] = elements[i];
	            elements[i] = aux;
	        }
	        currentElements--;
>>>>>>> Stashed changes
        }
// TODO implement
    }

    private void removeDead() {
        int n = currentElements;
        for (int i = n; i > 0; i--) {
<<<<<<< Updated upstream
            if (!elements[i - 1].isAlive() || elements[i - 1].isOut() || !elements[i - 1].exists()) {
                remove(elements[i - 1], i - 1);
=======
        	if (!elements[i - 1].isAlive() || elements[i-1].isOut()|| !elements[i-1].exists()) {
                remove(elements[i - 1], i-1);  
>>>>>>> Stashed changes
            }
        }
// TODO implement
    }
}