/*package tp.p1;

class DestroyerList {

	private static int count;
	private DestroyerShip[] dShip;
	
	public DestroyerList(Level lvl) {
		count = lvl.getNumDestroyers();
		dShip = new DestroyerShip[count];
		
	}

	public String dShipToString(int pos) {
		return dShip[pos].toString();
	}
	
	public void addship(int where, DestroyerShip ship) {
		dShip[where] = ship;
	}
	
	 public int getX(int pos) {
			return dShip[pos].getX() ;
		}
	    
	    public int getY(int pos) {
			return dShip[pos].getY();
		}
	
	public void deleteship(int where) {
		DestroyerShip aux;  
		if(where != -1 && where != count-1) {
		for(int i = where; i < getCount()-1; i++) {
			aux = dShip[i+1];
			dShip[i+1] = dShip[i];
			dShip[i] = aux;
		}
		}
		count--;
		
	}

	public Edge onEdge(){
		Edge changeDirAux = Edge.NotOnEdge;
		for (int i = 0; i < getCount() && changeDirAux == Edge.NotOnEdge; i++) {
			changeDirAux = dShip[i].edge();
		}
		return changeDirAux;
	}
	public boolean foundAt(int x, int y) {
		return this.findShip(x, y) != -1;
	}
	
	public int findShip(int x, int y) {
		int aux = -1;
		boolean found = false;
		for(int i = 0; i < getCount() && !found; i++) {
			if(dShip[i].getX() == x && dShip[i].getY() == y) {
				 aux = i;
				 found = true;
			}
		}
		return aux;
	}
	
	public void getHit(int pos) {
		dShip[pos].getHit();
	}
	
	public int getCount() {
		return count;
	}
	

	 public boolean getWeaponsReady(int i) {
			return dShip[i].getWeaponsReady();
		}
	

		
		public void updatePos(Direction dir) {
			for(int i = 0; i < count;i++) {
				dShip[i].updatePos(dir);
			}
			} 
	 
		public Projectile shoot(int pos, int x, int y) {	
			return dShip[pos].shoot(x, y);
	}


		
	public void update() {
		int n = count;
		for(int i = n; i > 0; i--) {	
			if(dShip[i-1].get2BeDestroyed()) {
				deleteship(i-1);
			}
		}
	}
	
	
	
}*/
