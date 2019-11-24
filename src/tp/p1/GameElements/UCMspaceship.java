package tp.p1.GameElements;

import tp.p1.Model.Game;

public class UCMspaceship extends Ship {

    //private boolean sWave;
    private Direction dir;
    private Missile missile = null;
    private boolean shockWave;
    private int score = 0;
    private boolean iMove;
    private static boolean ableToShoot;

    public UCMspaceship(Game game, int x, int y) {
        super(game, x, y, 3);
        iMove = false;
        shockWave = false;
        ableToShoot = true;
    }

    public boolean missileExists() {
        return missile.exists();
    }

    public boolean canShoot() {
        return ableToShoot;
    }
    
    public void recievePoints(int points) {
         score += points;
    }
    
    public int getScore() {
        return score;
    }

    public boolean findAt(int x, int y) {
        return (this.getX() == x && this.getY() == y);
    }

    public void shoot(Missile missile) {
            this.missile = missile;
            ableToShoot = false;
    }

    public static void iCanShoot(){
        ableToShoot = true;
    }
    
    public void iWillMove() {
    	 iMove = true;
    }
    
    public void iMoved() {
   	 iMove = false;
   }
    public void changeDir(Direction changeDir) {
        dir = changeDir;
    }
    
    public boolean canIgo(int blocks) {
        if (dir == Direction.LEFT) {
            return positionX - blocks >= 0;
        } else {
            return positionX + blocks <= Game.DIM_X-1;
        }
    }

    public int getResistance() {
        return shield;
    }
    
    public boolean swHave()
    {
    	return shockWave;
    }
    
    public void enableSW()
    {
    	shockWave = true;
    }
    
    public String swString() {
        String str = "Ready!";
        if (!shockWave) {
            str = "Not ready.";
        }
        return str;
    }

    public String toString() {
        String str = "/-^-\\";
        if (shield <= 0) {
            str = "_+.+_";
        }
        return str;
    }
    
    
    @Override
    public void destroy() {
  		
  	}
    public void releaseSW(ShockWave sWave) {    //Maybe?
        // TODO Auto-generated method stub
    	game.addObject(sWave);
    	shockWave = false;
    }

    @Override
    public void computerAction() {
        // TODO Auto-generated method stub

    }

    @Override
    public void move() {
        // TODO Auto-generated method stub
    	if(iMove) {
            positionX += dir.getValue();
        }
    	if (missile != null && !missileExists()){
    	    iCanShoot();
        }
    }

	@Override
	public void onDelete() {
		// Default Empty
		
	}
	
	
	public boolean receiveBombAttack(int damage) {
		shield -= damage;
		if(shield <= 0) itExists = false;
		return true;
	}
}