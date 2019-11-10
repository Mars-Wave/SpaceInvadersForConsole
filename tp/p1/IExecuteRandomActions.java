package tp.p1;

//Who the fuck implements this?

public interface IExecuteRandomActions {
    static boolean canGenerateUfo(Game game) {
        return game.getRandom().nextInt(10) < 10 * game.getLevel().getUfoFrequency();
    }

    static boolean canGenerateBomb(Game game) {
        return game.getRandom().nextInt(10) < 10 * game.getLevel().getShootFrequency();
    }
}
