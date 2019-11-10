package tp.p1.GameElements;

import tp.p1.Game;

public abstract class Weapon extends GameElement {
	protected static boolean itExists = false;
	public Weapon(Game game, int x, int y) {
		super(game, x, y, 1);
	}

}
