package tp.p1;

import tp.p1.GameElements.GameElement;
import tp.p1.GameElements.UFO;

import java.awt.datatransfer.FlavorEvent;
import java.util.Random;


public class Board {
    private GameElement[] elements;
    private Game game;    //Am I allowed to have game here?
    private int currentElements;

    public Board(Game game, int numships) {
        this.game = game;
        currentElements = 0;
        elements = new GameElement[numships]; //Conflicted about this shit, the array needs to be initialised so add(GameElement gameElement) can add shit so I give it the amount of total ships the game is gonna have
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
            elements[i].move();            //This is the hardest shit to implement what it does is basically... Read notes in drive xD
        }
        for (int i = 0; i < currentElements; i++) {
            elements[i].onDelete();            //Check if any of the elements are dead or out of borders
        }
// TODO implement
    }

    private void checkAttacks(GameElement gameElement) {
// TODO implement
    }

    public void computerAction(Random randseed, Level level) {
        // HOW AM I SUPPOSED TO IMPLEMENT IT IF I CANNOT KNOW WHICH UFO I HAVE TO ASK IF IT EXISTS????????????????¿???????
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

    private void remove(GameElement gameElement) {
// TODO implement
    }

    private void removeDead() {
// TODO implement
    }
}