package tp.p1.Interfaces;

import tp.p1.Model.Game;

public interface IExecuteRandomActions {
    static boolean canGenerateUfo(Game game) {
        return game.getRandom().nextInt(10) < 10 * game.getLevel().getUfoFrequency();
    }

    static boolean canGenerateBomb(Game game) {
        return game.getRandom().nextInt(10) < 10 * game.getLevel().getShootFrequency();
    }
}
