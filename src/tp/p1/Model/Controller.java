package tp.p1.Model;
import tp.p1.Commands.Command;
import tp.p1.Commands.CommandGenerator;

import java.util.Scanner;

class Controller {
	private Scanner in;
	private Game game;

	public Controller(Game game) {
		in = new Scanner(System.in);
		this.game = game;
	}
	
	public void run() {
		while (!game.isFinished()){
			System.out.println("Turn Action > ");
			String[] words = in.nextLine().toLowerCase().trim().split (" ");
			Command command = CommandGenerator.parse(words);
			if (command != null) {
				if (command.execute(game)) {
					System.out.println(game.infoToString());
				}
				else {
					System.out.println("It cannot be done.");
				}
			}
			else if (words[0].equals("")) {
				game.update();					//Implement new update!
				System.out.println(game.infoToString());
			}
			else {
				System.out.format("Unknown command\r\n");
				
			}
		}
			if(game.playerWins()){
				System.out.println("Game Over!\r\nYou Win!");
			}
			else if(game.aliensWin()){
				System.out.println("Game Over!\r\nYou Lose!");
			}
	}
}

