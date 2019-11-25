//package tp.p1.JustForReference;

/*
public class GameJustForReference {
    private int cycle;
    private static int score;
    private Level lvl;
    private Random randseed;
    private Board board;
    private boolean gameOver;
    private boolean victory = false;
    public final int maxX = 8;
    private final int maxY = 9;

    public GameJustForReference(Random rand, Level lvl) {
        cycle = 0;
        score = 0;
        gameOver = false;
        randseed = rand;
        board = new Board(lvl, this);
        this.lvl = lvl;
        initCarrierList();
        initDestroyerList();
        initBombList();
    }


    public int gameGetMaxX() {
        return maxX;
    }

    public int gameGetMaxY() {
        return maxY;
    }

    private void checkGameFinish() {
        if (UCMgetResistance() <= 0 || checkReached()) {
            endGame();
        } else if (getTotalShips() <= 0) {
            winGame();
        }
    }

    public void endGame() {
        gameOver = true;
        victory = false;
    }

    private void winGame() {
        gameOver = true;
        victory = true;
    }

    private void changeDir() {
        board.changeDir();
    }

    private Direction getBoardDir() {
        return board.getDir();
    }

    private int lvlSpeed() {
        return lvl.speed();
    }

    public boolean UFOat(int x, int y) {
        return board.UFOat(x, y);
    }

    public void UFOdestroy() {
        if (board.UFOdestroy()) {
            setSW(true);
            score += board.UFOgetPoints();
        }
    }

    private void UFOremove() {
        board.UFOdestroy();
    }

    public int UFOgetPoints() {
        return board.UFOgetPoints();
    }

    private void UFOcreate() {    //Now we create UFO in game and then pass it to board instead of making it in board! According to the professor!
        board.UFOcreate(new UFO(this));
    }

    private boolean UFOupdatePos() {
        return board.UFOupdatePos();
    }

    public void UFOgetHit() {
        board.UFOgetHit();
    }

    public boolean UFOfindAt(int x, int y) {
        return board.UFOfindAt(x, y);
    }

    public String UFOtoString() {
        return board.UFOtoString();
    }

    public void shockwave() {
        int c = board.cListgetCount();
        int d = board.dListgetCount();
        for (int i = c; i > 0; i--) {
            cListgetHit(i - 1);
        }
        for (int i = d; i > 0; i--) {
            dListgetHit(i - 1);
        }
        UFOdestroy();
    }

    private int UCMgetX() {
        return board.UCMgetX();
    }

    private int UCMgetY() {
        return board.UCMgetY();
    }

    public boolean UCMshoot() {    //Now we create Missile in game and then pass it to board instead of making it in board! According to the professor!
        boolean canBeDone = !Missile.exists();
        if (canBeDone) {
            board.UCMshoot(new Missile(this, UCMgetX(), UCMgetY()));
        }
        return canBeDone;
    }

    private void setSW(boolean i) {
        board.UCMsetSW(i);
    }

    public void UCMgetHit() {
        board.UCMgetHit();
    }

    public boolean missileAt(int x, int y) {
        return board.MissilefindAt(x, y);
    }

    public boolean projectileAt(int x, int y) {
        return board.bListFindAt(x, y);
    }

    public int bListFindBomb(int x, int y) {
        return board.bListFindBomb(x, y);
    }

    private void destroyerShoot() {
        for (int i = 0; i < board.dListgetCount(); i++) {
            if (dListGetWeaponsReady(i) && randseed.nextInt(100) < lvl.firePower() * 100) {
                Projectile shot = board.shoot(i, board.dListGetX(i), board.dListGetY(i));
                addBomb(shot);
            }
        }
    }

    private boolean dListGetWeaponsReady(int pos) {
        return board.dListGetWeaponsReady(pos);
    }

    private void addBomb(Projectile bomb) {
        board.bListAddBomb(bomb);
    }

    public void bListDeleteBomb(int where, Projectile bomb) {
        board.bListDeleteBomb(where);
    }

    private void bListUpdate() {
        board.bListUpdate();
    }

    private void initBombList() {    //Now we create BombList in game and then pass it to board instead of making it in board! According to the professor!

        BombList bList = new BombList(lvl);
        board.initBombList(bList);
    }

    public String bListToString(int pos) {
        return board.bListToString(pos);
    }

    public int bListGetCount() {
        return board.bListGetCount();
    }


    public void projectileDestroy(int pos) {
        board.projectileDestroy(pos);
    }

    public boolean getState() {
        return gameOver;
    }

    public boolean getVictory() {
        return victory;
    }

    public int getScore() {
        return score;
    }

    public int getTotalShips() {
        return board.totalShips();
    }

    public int getCycle() {
        return cycle;
    }

    public void reset() {
        cycle = 0;
        score = 0;
        gameOver = false;
        board = new Board(lvl, this);
        initCarrierList();
        initDestroyerList();
        initBombList();
        if (UFO.exists()) {
            UFO.destroy();
        }
        if (BombList.getCount() != 0) {
            bombsResetCount();
        }
        if (Missile.exists()) {
            Missile.destroy();
        }
    }

    public String UCMtoString() {
        return board.UCMtoString();
    }

    public boolean UCMat(int x, int y) {
        return board.UCMfindAt(x, y);
    }

    public void UCMchangeDir(Direction changeDir) {
        board.UCMchangeDir(changeDir);
    }

    public boolean UCMgetSW() {
        return board.UCMgetSW();
    }

    public String UCMswString() {
        return board.UCMswString();
    }

    public int UCMgetResistance() {
        return board.UCMgetResistance();
    }

    private void UCMupdatePos(int blocks) {
        board.UCMupdatePos(blocks);
    }

    private void initCarrierList() {
        int xE = 2;
        int xO = 2, yO = 1;

        if (lvl.equals(Level.Easy)) {
            for (int i = 0; i < lvl.carrierNum(); i++) {
                board.cListaddship(i, new CarrierShip(xE, 1, this));
                xE++;
            }
        } else if (lvl.equals(Level.Hard) || lvl.equals(Level.Insane)) {
            for (int i = 0; i < lvl.carrierNum(); i++) {
                if (yO != 2) {
                    board.cListaddship(i, new CarrierShip(xO, yO, this));
                    if (xO == 5) {
                        yO++;
                        xO = 1;
                    }
                    xO++;
                } else {
                    board.cListaddship(i, new CarrierShip(xO, yO, this));
                    xO++;
                }
            }
        }
    }

    public boolean canUCMgo(int blocks) {
        return board.canUCMgo(blocks);
    }

    public int cListFindShip(int x, int y) {
        return board.cListFindShip(x, y);
    }

    public void winCpoints() {
        score += board.cListGetdPoints();
    }

    public void cListgetHit(int pos) {
        board.cListgetHit(pos);
    }

    public String cListToString(int pos) {
        return board.cListToString(pos);
    }

    public boolean cListFoundAt(int x, int y) {
        return board.cListFoundAt(x, y);
    }

    private void cListUpdate(int cycle) {
        board.cListUpdate();
    }

    private void cListUpdatePos(Direction dir) {
        board.cListUpdatePos(dir);
    }

    private void initDestroyerList() {
        int xE = 3;
        int xO = 2;
        for (int i = 0; i < lvl.destroyerNum(); i++) {
            if (lvl.equals(Level.Easy)) {
                board.dListaddship(i, new DestroyerShip(xE, 2, this));
                xE++;
            } else if (lvl.equals(Level.Hard)) {
                board.dListaddship(i, new DestroyerShip(xE, 3, this));
                xE++;
            } else {
                board.dListaddship(i, new DestroyerShip(xO, 3, this));
                xO++;
            }
        }
    }

    public int dListFindShip(int x, int y) {
        return board.dListFindShip(x, y);
    }

    public void winDpoints() {
        score += board.dListGetdPoints();
    }

    private void bombsResetCount() {
        board.bombsResetCount();
    }

    public String dListToString(int pos) {
        return board.dListToString(pos);
    }

    public void dListgetHit(int pos) {
        board.dListgetHit(pos);
    }

    public boolean dListFoundAt(int x, int y) {
        return board.dListFoundAt(x, y);
    }

    private void dListUpdate(int cycle) {
        board.dListUpdate();
    }

    private void dListUpdatePos(Direction dir) {
        board.dListUpdatePos(dir);
    }

    public boolean MissilefindAt(int x, int y) {
        return board.MissilefindAt(x, y);
    }

    public void missileDestroy() {
        board.missileDestroy();
    }

    public String MissiletoString() {
        return board.MissiletoString();
    }

    private void missileUpdate() {
        board.missileUpdate();
    }

    private void missileUpdateCollision() {
        board.missileUpdateCollision();
    }

    private boolean checkReached() {
        boolean reached = false;
        for (int i = 0; i < board.dListgetCount() && !reached; i++) {
            if (board.dListGetY(i) == 7) {
                reached = true;
            }
        }
        for (int i = 0; i < board.cListgetCount() && !reached; i++) {
            if (board.cListGetY(i) == 7) {
                reached = true;
            }
        }
        return reached;
    }

    private boolean cyclereached() {
        return cycle % lvlSpeed() == 0;
    }

    public void update(int blocks) {//
        if (blocks != 0) {
            UCMupdatePos(blocks);
        }
        if (!UFO.exists() && randseed.nextInt(100) < lvl.UFOprob() * 100) {
            UFOcreate();
        }
        missileUpdate();
        if (!UFOupdatePos()) {                //if UFO reached the edge remove it
            UFOremove();
        }//
        if (cyclereached()) {
            cListUpdatePos(getBoardDir());
            dListUpdatePos(getBoardDir());
        }
        destroyerShoot();            //if Destroyer can shoot according to restrictions then make a bomb and pass it to BombList
        bListUpdate();
        if (cyclereached()) {
            changeDir();
        }
        missileUpdateCollision();
        cListUpdate(blocks);
        dListUpdate(blocks);
        checkGameFinish();
        cycle++;
    }//

    public String toString() {    // Are we using this for Assignment 2 or not this way?
        GamePrinter printer = new GamePrinter(this, gameGetMaxX(), gameGetMaxY());
        return "Score: " + getScore() + '\n' + "Shield Strength: " + UCMgetResistance() + '\n' + "Shockwave: " + UCMswString() + '\n' + "Cycle Number: : " + getCycle() + '\n' + "Remaining Alien Ships: " + getTotalShips() + '\n' + printer.toString();
		System.out.println("Score: " + getScore());
		System.out.println("Shield Strength: " + UCMgetResistance());
		System.out.println("Shockwave: " + UCMswString());
		System.out.println("Cycle Number: : " + getCycle());
		System.out.println("Remaining Alien Ships: " + getTotalShips());
		System.out.println(printer);
    }

}
*/