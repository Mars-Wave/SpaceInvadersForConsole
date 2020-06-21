package tp.p1.GameElements;

import tp.p1.Model.Game;
import tp.p1.Interfaces.IExecuteRandomActions;

public class UFO extends EnemyShip implements IExecuteRandomActions {    //Does it implement this?

    private static final Direction dir = Direction.LEFT;
    private static boolean appereance; 
    
    public UFO(Game game) {
        super(game, Game.DIM_X, 0, 1, 25);
        appereance = false;
    }

    public String toString() {
        return "<(+)>";
    }

    public void getHit() {
        shield--;
    }


    @Override
    public boolean isAlive() {
        return shield > 0;
    }
    
    @Override
    public void computerAction() {    //Fix that this can't be static but has to be called for UFO which doesn't exist yet wow! xD
    	if (!appereance && IExecuteRandomActions.canGenerateUfo(game)) {
           // game.addObject(new UFO(game));
    		appereance = true;
        }
    }

    @Override
    public void move() {
        if (appereance)
            positionX += dir.getValue();
    }
    @Override
    public void destroy() {
		appereance = false;
		positionX = Game.DIM_X;
		positionY = 0;
<<<<<<< Updated upstream
		shield = 1;
=======
		
>>>>>>> Stashed changes
	}
    @Override
    public void onDelete() {
		// TODO Auto-generated method stub
<<<<<<< Updated upstream
		if(shield <= 0) {
			game.receivePoints(points);
			game.enableSW();
=======

    	if(shield <= 0) {
			game.receivePoints(points);
			game.enableSW();
			
			shield = 1;
			
>>>>>>> Stashed changes
		}
		
	}
}


