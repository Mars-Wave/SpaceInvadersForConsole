/*package tp.p1;

class Board2 {
	private CarrierList cList;
	private DestroyerList dList;
	private BombList bList;
	private UCMspaceship UCM;
	private UFO ufo;
	private Missile missile;
	private static Direction dir = Direction.LEFT;
	private static Edge edge;

	public Board2(Level lvl, Game game) {
		cList = new CarrierList(lvl);
		dList = new DestroyerList(lvl);
		UCM = new UCMspaceship(game);
		dir = Direction.LEFT;

	}


	private Edge onEdge(){
		Edge changeDirAux = Edge.NotOnEdge;
		if(cList.getCount() != 0) {
			changeDirAux = cList.onEdge();
		}
		if (dList.getCount() != 0 && changeDirAux == Edge.NotOnEdge){
			changeDirAux = dList.onEdge();
		}
		return changeDirAux;
	}


	public  void changeDir() {
		Edge changeDirAux = onEdge(); //NotOnEdge means they must keep their direction, else they must change it;
		if(changeDirAux == Edge.LeftEdge && dir == Direction.DOWN) {
			dir = Direction.RIGHT;
		}
		else if(changeDirAux == Edge.RightEdge && dir == Direction.DOWN) {
			dir = Direction.LEFT;
		}
		else if(changeDirAux == Edge.LeftEdge || changeDirAux == Edge.RightEdge) {
			dir = Direction.DOWN;
		}
	}
	
	public Direction getDir() {
		return dir;
	}
	
	public void UFOcreate(UFO ufo) {
		this.ufo = ufo;
	}

	  public void UFOgetHit() {
	    	ufo.getHit();
	    }

	public boolean UFOexists() {
		return UFO.exists();
	}
	
	public int UFOgetPoints() {
		return UFO.getPoints();
	}
	
	public void UCMshoot(Missile missile) {
			this.missile = missile;
	}
	
	public boolean bListFindAt(int x, int y) {
		boolean canBeDone = false;
		if(Bombexists(bListGetCount()-1)) {
			canBeDone = bList.findAt(x, y);
		}
		return canBeDone;
	}	
	
	public void bombsResetCount() {
		BombList.resetCount();	
	}
	
	public String bListToString(int pos) {
		 return bList.bombToString(pos);
		}
	
	public int bListFindBomb(int x, int y) {
		return bList.findBomb(x, y);
	}
	
	public void bListDeleteBomb(int where) {
		
		bList.deleteBomb(where);
	}
	
	
	public void initBombList(BombList bList) {
		this.bList = bList;
	}
	
	private boolean Bombexists(int pos) {
		boolean canBeDone = false;
		if(bListGetCount() > 0 ) {
			canBeDone = bList.Bombexists(pos);
		}
		return canBeDone;
	}

	public void bListAddBomb(Projectile bomb) {
		bList.addBomb(bListGetCount(), bomb);	
	}
	
	public void bListUpdate() {
		if(bListGetCount() > 0) {
			bList.update();
		}
	}
	
	public int bListGetCount() {
		return BombList.getCount();
	}

	
	public void projectileDestroy(int pos) {
		bList.destroy(pos);

	}
	 
	public int totalShips() {

		return cList.getCount() + dList.getCount();
	}

	public boolean UCMat(int x, int y) {

		return UCM.findAt(x, y);
	}
	
	public int UCMgetX() {
		return UCM.getX();
	}
 
    public int UCMgetY() {
		return UCM.getY();
	}
	
	public boolean canUCMgo(int blocks) {
		return UCM.canIgo(blocks);
	}
	public void UCMupdatePos(int blocks){
		UCM.updatePos(blocks);
	}
	
	public boolean UCMfindAt(int x, int y) {
		return UCM.findAt(x, y);
	}
	
	public String UCMtoString() {
		return UCM.toString();
	}
	
	public void UCMsetSW(boolean i) {
		UCM.setSW(i);
	}
	
	 public boolean UCMgetSW() {
			return UCM.getSW();
		}
	
	 public String UCMswString() {
			return UCM.swString();
		}
	 
	 public int UCMgetResistance() {
			return UCM.getResistance();
		}
	
	public void UCMchangeDir(Direction changeDir) {
		UCM.changeDir(changeDir);
	}
	
	public void UCMgetHit() {
		UCM.getHit();
	}
	

 
	 public void missileDestroy() {
			Missile.destroy(); 
		}
	 
	 public void missileUpdate() {
		 if(Missile.exists()) {
			missile.update();
		 }
	 }
	 
	 public void missileUpdateCollision() {
		 if(Missile.exists()) {
			missile.updateCollision();
		 }
	}

		public boolean MissilefindAt(int x, int y) {
			if (Missile.getCount() > 0) {
				return missile.findAt(x, y);
			}
			else {
				return false;
			}
		}
	 
	 public String MissiletoString() {
			return missile.toString();
		}
	 
	 public void cListaddship(int where, CarrierShip ship) {
			cList.addship(where, ship);
		}
	 
		public int cListFindShip(int x, int y) {
			return cList.findShip(x, y);
		}

		public void cListDeleteship(int where) {
			cList.deleteship(where);
		}

		public int cListgetCount() {
			return cList.getCount();
		}

		public int cListGetdPoints() {

			return CarrierShip.getPoint();
		}
		
	public int cListGetX(int pos) {
	return cList.getX(pos) ;
	}

	public int cListGetY(int pos) {
	return cList.getY(pos);
	}

	public boolean cListFoundAt(int x, int y) {
	return cList.findAt(x, y);
	}

	public void cListUpdate() {
	cList.update();
	}

	public void cListUpdatePos( Direction dir) {
		cList.updatePos(dir);
	}

	public String cListToString(int pos) {
	return cList.cShipToString(pos);
	}


	public boolean cListAt(int x, int y) {
	return cList.findAt(x, y);
	}


	public void cListgetHit(int pos) {
	cList.getHit(pos);
	}
	
	 public void dListaddship(int where, DestroyerShip ship) {
			dList.addship(where, ship);
		}
		
	 public int dListFindShip(int x, int y) {
			return dList.findShip(x, y);
		}
	 
	 public void dListDeleteship(int where) {
			dList.deleteship(where);
		}
	 
		public Projectile shoot(int pos, int x, int y) {	
			return dList.shoot(pos, x, y);
	}

	 public int dListgetCount() {
			return dList.getCount();
		}

	public int dListGetdPoints() {

			return DestroyerShip.getPoint();
		}

	 public boolean dListFoundAt(int x, int y) {
			return dList.foundAt(x, y);
		}

	 public int dListGetX(int pos) {

			return dList.getX(pos) ;
		}
	    
	    public int dListGetY(int pos) {
			return dList.getY(pos);
		}
	    
		public boolean dListAt(int x, int y) {
			return dList.foundAt(x, y);
		}


	 
	 public void dListUpdate() {
			dList.update();
		}
	 

		
		public void dListUpdatePos(Direction dir) {
			dList.updatePos(dir);
			}
	 
	 public boolean dListGetWeaponsReady(int pos) {
			return dList.getWeaponsReady(pos);
		}
		
	 
	 public String dListToString(int pos) {
		 return dList.dShipToString(pos);
		}
	 
	 public void dListgetHit(int pos) {
		 dList.getHit(pos);
		}
	
	 public boolean UFOat(int x, int y) {
		 boolean found = false;
		 if(UFO.exists()) {
			found = ufo.findAt(x, y);
		 }
		 return found;
		}

		public boolean UFOupdatePos() {

			if(UFO.exists()) {
				return ufo.updatePos();
			}
			else {
				return false;
			}

		}
		
		public boolean UFOfindAt(int x, int y) {
			return ufo.findAt(x, y);
		}
		
		public String UFOtoString() {
			return ufo.toString();
		}

		public boolean UFOdestroy() {
			boolean aux = UFO.exists();
			if(UFO.exists()) {
				UFO.destroy();
			}
			return aux;
		}
	 
}*/
	
				
