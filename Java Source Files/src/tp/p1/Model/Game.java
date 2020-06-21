package tp.p1.Model;

<<<<<<< Updated upstream
import tp.p1.Board.*;
=======
import tp.p1.Board.Board;
import tp.p1.Board.BoardInitializer;
import tp.p1.Board.GamePrinter;
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
    Board board;
=======
    public  Board board;
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
=======
    public void checkAttacks(GameElement element){
        board.checkAttacks(element);
    }
    
>>>>>>> Stashed changes
    public Level getLevel() {
        return level;
    }
    
    public int getcurrentCycle() {
        return currentCycle;
    }
    public int getCycle2Move() {
        return level.getNumCyclesToMoveOneCell();
    }
    
<<<<<<< Updated upstream

=======
    public int getcurrentElements() {
        return board.getcurrentElements();
    }
    
    public void explosiveAttack() {
    	//board.
    }
    
>>>>>>> Stashed changes
    public void reset() {
        initGame();
    }

    public void addObject(GameElement object) {    //Maybe we are supposed to call this in boardInitializer instead of directly board.add?
        board.add(object);
    }

<<<<<<< Updated upstream
    public void checkAttacks(GameElement element){
        board.checkAttacks(element);
    }

=======
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
    public boolean shootMissile() {
        boolean aux = player.canShoot();
        if(aux) {
            Missile m = new Missile(this, player.getX(), player.getY());
            player.shoot(m);
            board.add(m);
        }
        return aux;
=======
    public boolean shootMissile(int type) {
    		boolean canBeDone = false;
        if(player.canShoot()) {
        	Missile m = null;
        	if(type == 1) {
        		  m = new Missile(this, player.getX(), player.getY(), 1);	//Fix the one
        		 
        	}
        	else if(type == 2 && player.smHave()) {
        		  m = new SuperMissile(this, player.getX(), player.getY());	//Fix the one
        		  
        	}
        	if(m != null) {
        		player.shoot(m);
                board.add(m);
                canBeDone = true;
        	}
            
        }
        return canBeDone;
>>>>>>> Stashed changes
    }

    public void releaseShockWave() {
    	if(player.swHave()) {
<<<<<<< Updated upstream

    		 player.releaseSW(new ShockWave(this, player.getX(), player.getY()));

=======
    		 player.releaseSW(new ShockWave(this, player.getX(), player.getY()));
>>>>>>> Stashed changes
    	}
        
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

	public void enableSW() {
<<<<<<< Updated upstream
		// TODO Auto-generated method stub
		player.enableSW();
	}
=======
		player.enableSW();
	}

	public void disableSW() {
		player.disableSW();
	}

	public void replace(GameElement oldElement, GameElement newElement) {
       board.replace(oldElement, newElement);
    }
	
	public boolean canBuy(String gElement) {
		boolean canBuyIt = false;
		if(gElement == "SuperMissile") {
			if(player.getScore() >= SuperMissile.checkPrice()) {
				player.enableSM();
				player.recievePoints(-SuperMissile.checkPrice());
				canBuyIt = true;
			}
		}
		return canBuyIt;
	}

	public void disableSM() {
		player.disableSM();
	}
>>>>>>> Stashed changes
}