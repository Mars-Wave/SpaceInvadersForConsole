package tp.p1.Model;

//import /* imported classes */

import tp.p1.GameElements.CarrierShip;
import tp.p1.GameElements.DestroyerShip;
import tp.p1.GameElements.UFO;

public class BoardInitializer {
    private Level level;
    private Board board;
    private Game game;

    public Board initialize(Game game, Level level) {
        this.level = level;
        this.game = game;
        board = new Board(game, level.getNumCarrierShips() + 2*level.getNumDestroyers() + 4); // (+ 4 = ufo, playership, missile, shockwave) 2*destroyers because ones are the bombs the other the ships
        initializeCarrierShips();
        initializeDestroyers();
        initializeUFO();
        return board;
    }

    private void initializeUFO() {
    	board.add(new UFO(game));
    	UFO.init();
    }

    private void initializeCarrierShips() {
        int xE = 2, xO = 2, yO = 1;
        if (level.equals(Level.EASY)) {
            for (int i = 0; i < level.getNumCarrierShips(); i++) {
                board.add(new CarrierShip(game, xE, 1));
                xE++;
            }
        } else if (level.equals(Level.HARD) || level.equals(Level.INSANE)) {
            for (int i = 0; i < level.getNumCarrierShips(); i++) {
                if (yO != 2) {
                    board.add(new CarrierShip(game, xO, yO));
                    if (xO == 5) {
                        yO++;
                        xO = 1;
                    }
                    xO++;
                } else {
                    board.add(new CarrierShip(game, xO, yO));
                    xO++;
                }
            }
        }
    }

    private void initializeDestroyers() {
        for (int i = 0; i < level.getNumDestroyers(); i++) {
            if (level.equals(Level.EASY)) {
                board.add(new DestroyerShip(game, 3+i, 2));
            } else if (level.equals(Level.HARD)) {
                board.add(new DestroyerShip(game, 3+i, 3));
            } else {
                board.add(new DestroyerShip(game, 2+i, 3));
            }
        }
    }
}