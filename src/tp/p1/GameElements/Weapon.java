package tp.p1.GameElements;

import tp.p1.Model.Game;

public abstract class Weapon extends GameElement {
	protected int damage;
	
	public Weapon(Game game, int x, int y, int dmg) {
		super(game, x, y, 1);
		damage = dmg;
	}
	
	public abstract boolean performAttack(GameElement other);
	
	  @Override
	    public void computerAction() {
	        // Default Empty
	    }

}
