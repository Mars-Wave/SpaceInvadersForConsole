package tp.p1.GameElements;

import tp.p1.Model.Game;

public class CarrierShip extends AlienShip{
	
	public CarrierShip(Game game, int x, int y) {
		super(game, x, y, 2, 5);
	}   

	public Edge edge() {
		Edge aux = Edge.NotOnEdge;
		if (getX() == 0) {
				aux = Edge.LeftEdge;
			}
			else if(getX() == Game.DIM_X) {
				aux = Edge.RightEdge;
			}
		return aux;

	}
	
	public String toString() {
		return "-<" + shield + ">-";
	}

	@Override
	public void computerAction() {
		// Default Empty
	}

}


