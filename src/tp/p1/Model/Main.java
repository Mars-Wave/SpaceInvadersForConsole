package tp.p1.Model;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        if (args.length <= 2 || args.length > 0) {
            Random rand = new Random();
            if (args.length == 2) {
                rand = new Random(Integer.parseInt(args[1]));
            }
            Game game = new Game(Level.parse(args[0]), rand);
            Controller controller = new Controller(game);
            System.out.println(game.infoToString());
            controller.run();
        } else {
            System.out.println("usage: main.tp.p1 args <level> [seed]");
        }
    }
}
