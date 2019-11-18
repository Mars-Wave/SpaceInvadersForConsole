package tp.p1.Model;

import tp.p1.GameElements.*;
import tp.p1.Interfaces.IPlayerController;

import java.util.Random;

public class Game implements IPlayerController {
    public final static int DIM_X = 9;
    public final static int DIM_Y = 8;
    private int currentCycle;
    private GamePrinter printer;
    private Random rand;
    private Level level;
    public Board board;
    private UCMspaceship player;
    private boolean doExit;
    private BoardInitializer initializer;

    public Game(Level gameLevel, Random random) {
        rand = random;
        level = gameLevel;
        initializer = new BoardInitializer();
        initGame();
        printer = new GamePrinter(this, DIM_Y, DIM_X);
    }

    public void initGame() {
        currentCycle = 0;
        board = initializer.initialize(this, level);
        player = new UCMspaceship(this, DIM_X / 2, DIM_Y - 1);
        board.add(player);
    }

    public Random getRandom() {
        return rand;
    }

    public Level getLevel() {
        return level;
    }

    public void reset() {
        initGame();
    }

    public void addObject(GameElement object) {    //Maybe we are supposed to call this in boardInitializer instead of directly board.add?
        board.add(object);
    }

    public String positionToString(int x, int y) {//Maybe we are supposed to call this in gamePrinter instead of directly board.tostring?
        return board.toString(x, y);
    }

    public boolean isFinished() {
        return playerWins() || aliensWin() || doExit;
    }

    public boolean aliensWin() {
        return !player.isAlive() || AlienShip.haveLanded();
    }

    public boolean playerWins() {    //I changed this to public cuz why would it be private?
        return AlienShip.allDead();
    }

    public void update() {
        board.computerAction(rand, level);
        board.update();
        currentCycle++;
    }

    public boolean isOnBoard(int x, int y) {
    	return (x >= 0 && x < DIM_X + 1 && 0 <= y && y < DIM_Y);    //Check if this tells us if an object is on the board or outside the edges(rang)
    }

    public void exit() {
        doExit = true;
    }

    public String infoToString() {
        return "Score: " + player.getScore() + '\n' + "Shield Strength: " + player.getResistance() + '\n' + "Shockwave: " + player.swString() + '\n' + "Cycle Number: : " + currentCycle + '\n' + "Remaining Alien Ships: " + AlienShip.enemyShipsCounter() + '\n' + printer.toString();
    }

    public String getWinnerMessage() {
        if (playerWins()) return "Player wins!";
        else if (aliensWin()) return "Aliens win!";
        else if (doExit) return "Player exits the game";
        else return "Something went wrong!";
    }

    @Override
    public boolean move(int numCells, Direction dir) {
        player.changeDir(dir);
        boolean aux = player.canIgo(numCells);
        if (aux) {
        	player.iWillMove();
        	for(int i = 0; i < numCells;i++) {
        		
        		player.move();
        	}
        	player.iMoved();
            this.update();    //Implement the new update without parameters
        }
        return aux;
    }

    //TODO implement the methods of the IPlayerController interface

    @Override
    public boolean shootMissile() {
        boolean aux = player.canShoot();
        if(aux) {
            Missile m = new Missile(this, player.getX(), player.getY());
            player.shoot(m);
            board.add(m);
        }
        return aux;
    }

    public void releaseShockWave() {
        player.releaseSW(new ShockWave(this, player.getX(), player.getY()));
        
    }

    @Override
    public boolean shockWave() {
        return player.swHave();
    }

    @Override
    public void receivePoints(int points) {
        // TODO Auto-generated method stub
    	player.recievePoints(points);
    }

    @Override
    public void enableShockWave() {
        // TODO Auto-generated method stub

    }

    @Override
    public void enableMissile() {
        if(!player.missileExists()){
            UCMspaceship.iCanShoot();
        }
        // TODO Auto-generated method stub
    }
}