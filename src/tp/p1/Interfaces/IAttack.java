package tp.p1.Interfaces;

import tp.p1.GameElements.GameElement;

public interface IAttack {
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
}
