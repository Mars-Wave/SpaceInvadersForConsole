package tp.p1.Board;

//import /* imported classes */

import tp.p1.Model.Game;
import tp.p1.GameElements.CarrierShip;
import tp.p1.GameElements.DestroyerShip;
import tp.p1.GameElements.UFO;
import tp.p1.Model.Level;

public class BoardInitializer {
    private Level level;
    private Board board;
    private Game game;

    public Board initialize(Game game, Level level) {
        this.level = level;
        this.game = game;
        board = new Board(game, level.getNumCarrierShips()*2 + 2*level.getNumDestroyers() + 4); // (+ 4 = ufo, playership, missile, shockwave), 2*carriers theoretical temporary space for explosiveships, 2*destroyers because ones are the bombs the other the ships
        initializeCarrierShips();
        initializeDestroyers();
        initializeUFO();
        return board;
    }

    private void initializeUFO() {
    	UFO u = new UFO(game);
    	board.add(u);
    	u.destroy();
    }

    private void initializeCarrierShips() {
        int xE = 2;
        int xO = 2, yO = 1;
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
        int xE = 3;
        int xO = 2;
        for (int i = 0; i < level.getNumDestroyers(); i++) {
            if (level.equals(Level.EASY)) {
                board.add(new DestroyerShip(game, xE, 2));
                xE++;
            } else if (level.equals(Level.HARD)) {
                board.add(new DestroyerShip(game, xE, 3));
                xE++;
            } else {
                board.add(new DestroyerShip(game, xO, 3));
                xO++;
            }
        }
    }
}