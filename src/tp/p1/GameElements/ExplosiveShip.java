package tp.p1.GameElements;

import tp.p1.Model.Game;

public class ExplosiveShip extends AlienShip {
    boolean Exploding;

    public ExplosiveShip(Game game, int x, int y, int lives, int points, Direction dir, Direction nextDir) {
        super(game, x, y, lives, points, dir, nextDir);
        Exploding = false;
    }

    @Override
    public void onDelete() {
        // TODO Auto-generated method stub
        if (shield <= 0) {
            game.receivePoints(points);
            Exploding = true;
            game.checkAttacks(this);
        }
        enemyShipsCounter--;
    }

    public boolean performAttack(GameElement other) {
        if (Exploding) {
            for (int i = this.positionX - 1; i <= this.positionX + 1; i++) {
                for (int j = this.positionY - 1; j <= this.positionY + 1; j++) {
                    boolean aux = other.getX() == i && other.getY() == j;
                    if (aux) {
                        other.receiveMissileAttack(1);
                    }
                }
            }
            itExists = false; //he literally explodes
        }

        return true;
    }

    @Override
    public void computerAction() {
        //Default Empty
    }

    public String toString() {
        return "*<" + shield + ">*";
    }
}