package tp.p1.GameElements;

import tp.p1.Model.Game;

public class SuperMissile extends Missile{
	private static int price = 20;
	
	public SuperMissile(Game game, int x, int y) {
		super(game, x, y, 2);
		// TODO Auto-generated constructor stub
	}
	
	public static int checkPrice(){
		return price;
	}

	public void destroy() {
		itExists = false;
		game.enableMissile();
		game.disableSM();
	}
	
	public String toString() {
        return "/S\\";
    }
}
