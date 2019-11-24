package tp.p1;

import java.util.Random;

public class Main {


	

	public static void main(String[] args) {
		if	(args.length <=2 || args.length >0) {
			Random rand = new Random();
		if	(args.length == 2) {
			 rand = new Random(Integer.parseInt(args[1]));
		}
		Game game = new Game(rand, Level.parse(args[0]));
		Controller controller = new Controller(game);
		controller.run();
		}
		else {
			System.out.println("usage: main.tp.p1 args <level> [seed]");
		} 
	}
}
