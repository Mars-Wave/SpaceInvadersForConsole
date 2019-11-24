package tp.p1;

class BombList {

	private static int count = 0;
	private int size;
	private Projectile[] bList;
	
	public BombList(Level lvl) {
		size = lvl.destroyerNum();
		bList = new Projectile[lvl.destroyerNum()];
	}
	
	public boolean Bombexists(int pos) {
		return bList[pos].exists();
	}
	
	public void addBomb(int where, Projectile bomb) {
		if(where < size ) {
			bList[where] = bomb;
			count++;
		}
	}
	
	public void deleteBomb(int where) {
		Projectile aux;  
		if(where != -1 && where != (count-1)) {
		for(int i = where; i < getCount()-1; i++) {
			aux = bList[i+1];
			bList[i+1] = bList[i];
			bList[i] = aux;
		}
		}
		count--;
	}
	
	public void destroy(int pos) {
    	bList[pos].destroy();
    }
	
	public boolean findAt(int x, int y) {
		return this.findBomb(x, y) != -1;
	}
	
	public int findBomb(int x, int y) {
		int aux = -1;
		boolean found = false;
		if(BombList.getCount() > 0){
		for(int i = 0; i < count && !found; i++) {
			if(bList[i].getX() == x && bList[i].getY() == y) {
				 aux = i;
				 found = true;
			}
		}
	}
		return aux;
	}

	public String bombToString(int pos) {
		return bList[pos].toString();
	}

	public static int getCount() {

		return count;
	}
	
	 public void setDship(int pos, DestroyerShip dShip) {
	    	bList[pos].setDship(dShip);
	    }
	
	public static void resetCount() {
		count = 0;
	}
	
	public void update() {
		int n = count;
		for(int i = 0; i < count; i++) {
			bList[i].update(i);
		}
		for(int i = n; i > 0; i--) {
			if(bList[i-1].get2BeDestroyed()) {
				deleteBomb(i-1);
			}
		}
	}
	
}
