package tp.p1.GameElements;

import tp.p1.Model.Game;

public abstract class AlienShip extends EnemyShip {

<<<<<<< Updated upstream
    protected static int enemyShipsCounter = 0;
    protected static boolean haveLanded = false;
    protected static Direction dir;
    protected static Direction nextDir;

    public AlienShip(Game game, int x, int y, int lives, int points, Direction dir, Direction nextDir) {
        super(game, x, y, lives, points);
        this.dir = dir;
        this.nextDir = nextDir;
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

        if (game.getcurrentCycle() % game.getCycle2Move() == 0) {
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

    @Override
    public void onDelete() {
        // TODO Auto-generated method stub
        if (shield <= 0) {
            game.receivePoints(points);
        }
        enemyShipsCounter--;  //Explosive ship constructor will use the super with another ++ so when carriership is removed to evolve it does not affect the counter

    }


=======
	protected static int enemyShipsCounter = 0;
	protected static boolean haveLanded = false;
	protected static Direction dir = Direction.LEFT;
	protected static Direction nextDir = Direction.LEFT;

	public AlienShip(Game game, int x, int y, int lives, int points) {
		super(game, x, y, lives, points);
		//dir = Direction.LEFT;
		//nextDir = Direction.LEFT;
		enemyShipsCounter++;
	}

	public static void initializeDir() {
		dir = Direction.LEFT;
		nextDir = Direction.LEFT;
	}
	
	public void move() { // This is the hardest shit to implement what it does is basically... Read notes
							// in drive xD
		// TODO Auto-generated method stub
		if(game.getcurrentCycle() % game.getCycle2Move() == 0){
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

	public static void changeDir() {
		dir = nextDir;
	}
	public void checkLanded(){
		haveLanded = positionY == Game.DIM_Y - 1;
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		if(shield <= 0) game.receivePoints(points);
		
		enemyShipsCounter--;
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
	
	public boolean receiveShockWaveAttack(int damage) {
		shield -= damage;
		return true;
	}
	
	
>>>>>>> Stashed changes
}
