package tp.p1.Lists;



import tp.p1.Model.Level;
import tp.p1.GameElements.Projectile;

public class BombList {

	private static int count = 0;
	private int size;
	private Projectile[] bList;
	
	public BombList(Level lvl) {
		size = lvl.getNumDestroyers();
		bList = new Projectile[lvl.getNumDestroyers()];
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
	
	
	
	public static void resetCount() {
		count = 0;
	}
}
