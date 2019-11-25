package tp.p1.Interfaces;

import tp.p1.GameElements.GameElement;

public interface IAttack {
<<<<<<< Updated upstream
    default boolean performAttack(GameElement other) {
        return false;
    }

    default boolean receiveMissileAttack(int damage) {
        return false;
    }

    default boolean receiveBombAttack(int damage) {
        return false;
    }

    default boolean receiveShockWaveAttack(int damage) {
        return false;
    }
=======
default boolean performAttack(GameElement other) {return false;};	//Not GameObject right? I changed it to GameElement
default boolean receiveMissileAttack(int damage) {return false;};
default boolean receiveBombAttack(int damage) {return false;};
default boolean receiveShockWaveAttack(int damage) {return false;};
>>>>>>> Stashed changes
}
