package tp.p1;

class CarrierList {

	private int count;
	private CarrierShip[] cShip;
	
	public CarrierList(Level lvl) {
		count = lvl.carrierNum();
		cShip = new CarrierShip[count];
	}

	
	public int getX(int pos) {
			return cShip[pos].getX() ;
		}

	public int getY(int pos) {
			return cShip[pos].getY();
		}
	
	public void deleteship(int where) {
		CarrierShip aux;  
		if(where != -1 && where != count-1) {
			for(int i = where; i < getCount()-1; i++) {
				aux = cShip[i+1];
				cShip[i+1] = cShip[i];
				cShip[i] = aux;
			}
		}
		count--;
	}
	public Edge onEdge(){
		Edge changeDirAux = Edge.NotOnEdge;
		for (int i = 0; i < getCount() && changeDirAux == Edge.NotOnEdge; i++) {
			changeDirAux = cShip[i].edge();
		}
		return changeDirAux;
	}

	public boolean findAt(int x, int y) {
		return this.findShip(x, y) != -1;
	}
	
	public void getHit(int pos) {
		cShip[pos].getHit();
	}
	
	public int findShip(int x, int y) {
		int aux = -1;
		boolean found = false;
		for(int i = 0; i < getCount() && !found; i++) {
			if(cShip[i].getX() == x && cShip[i].getY() == y) {
				 aux = i;
				 found = true;
			}
		}
		return aux;
	}
	
	public void addship(int where, CarrierShip ship) {
		cShip[where] = ship;
	}

	public String cShipToString(int pos) {
		return cShip[pos].toString();
		}
	
	public int getCount() {
		return count;
	}
	

	public void updatePos(Direction dir) {
		for(int i = 0; i < count; i++) {
			cShip[i].updatePos(dir);
        }
	}
	
	public void update() {
		int n = count;
		for(int i = n; i > 0; i--) {
			if(cShip[i-1].get2BeDestroyed()) {
				deleteship(i-1);
			}
		}
	}
	
}
