package tp.p1.GameElements;

import tp.p1.Game;

public class UCMspaceship extends Ship {

    //private boolean sWave;
    private Direction dir;
    private Missile missile;
    private ShockWave shockWave;
    private int score = 0;

    public UCMspaceship(Game game, int x, int y) {
        super(game, x, y, 3);
        shockWave = new ShockWave(game, this.positionX, this.positionY);
    }

    public int getScore() {
        return score;
    }

    public boolean findAt(int x, int y) {
        return (this.getX() == x && this.getY() == y);
    }

    public void shoot(Missile missile) {
        this.missile = missile;
    }


    public void changeDir(Direction changeDir) {
        dir = changeDir;
    }

    public boolean canIgo(int blocks) {
        if (dir == Direction.LEFT) {
            return positionX - blocks >= 0;
        } else {
            return positionX + blocks <= Game.DIM_X;
        }
    }

    public void updatePos(int blocks) {
        positionX += blocks * dir.getValue();
    }

    public void getHit() {
        shield--;
    }

    public int getX() {
        return positionX;
    }

    public int getY() {
        return positionY;
    }

    public int getResistance() {
        return shield;
    }

    public boolean getSW() {
        return shockWave.isAlive();
    }

    public void setSW(boolean i) {    //Probably needs to go away xD
        shockWave.itExists = i;
    }

    public String swString() {
        String str = "Ready!";
        if (!shockWave.itExists) {
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

    public void releaseSW(ShockWave shockWave) {    //Maybe?
        // TODO Auto-generated method stub
        this.shockWave = shockWave;
    }

    @Override
    public void computerAction() {
        // TODO Auto-generated method stub

    }

    @Override
    public void onDelete() {
        // TODO Auto-generated method stub

    }

    @Override
    public void move() {
        // TODO Auto-generated method stub

    }
}