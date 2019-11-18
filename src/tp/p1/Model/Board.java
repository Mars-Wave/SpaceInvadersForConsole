package tp.p1.Model;

import tp.p1.GameElements.AlienShip;
import tp.p1.GameElements.GameElement;

import java.util.Random;

//import java.awt.datatransfer.FlavorEvent;


public class Board {
    private GameElement[] elements;
    // private Game game;    //Am I allowed to have game here?
    private int currentElements;

    public Board(Game game, int numelements) {
        // this.game = game;
        currentElements = 0;
        elements = new GameElement[numelements]; //Conflicted about this shit, the array needs to be initialised so add(GameElement gameElement) can add shit so I give it the amount of total ships the game is gonna have
    }

    private int getcurrentElements() {
        return currentElements;
    }

    public void add(GameElement gameElement) {
        elements[currentElements] = gameElement;
        currentElements++;
    }

    public void update() {
        for (int i = 0; i < currentElements; i++) {
            elements[i].move();
            checkAttacks(elements[i]);
        }
        AlienShip.changeDir();
      /*  for (int i = 0; i < currentElements; i++) {
            checkAttacks(elements[i]);
        }*/

        removeDead();
// TODO implement
    }

    private void checkAttacks(GameElement gameElement) {
        for (int j = 0; j < currentElements; j++) {
            if (gameElement != elements[j] && gameElement.isAlive()) {
                gameElement.performAttack(elements[j]);
            }
        }
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
        elements[where].destroy();
        elements[where].onDelete();
        GameElement aux;
        for (int i = where; i < currentElements - 1; i++) {
            aux = elements[i + 1];
            elements[i + 1] = elements[i];
            elements[i] = aux;
        }
        currentElements--;
// TODO implement
    }

    private void removeDead() {
        int n = currentElements;
        for (int i = n; i > 0; i--) {

            if (!elements[i - 1].isAlive() || elements[i - 1].isOut()) {
                remove(elements[i - 1], i - 1);
            }
        }
// TODO implement
    }
}