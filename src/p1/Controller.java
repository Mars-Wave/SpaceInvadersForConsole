package tp.p1;
import java.util.Scanner;

class Controller {
	private Scanner in;
	private Game game;

	public Controller(Game game) {
		in = new Scanner(System.in);
		this.game = game;
	}

	public void run() {
		String str;
		boolean controller; //The correct input will trigger controller to be true and thus game gets updated
		int blocks;
		GamePrinter printer = new GamePrinter(game, game.gameGetMaxX(), game.gameGetMaxY());
		outPut(printer);
		do {
			blocks = 0;
			controller = false;
			System.out.println("Turn Action > ");
			str = in.nextLine();
			String[] words = str.split(" "); //regex
			if (words.length == 0 || str.equals("")) {
				controller = true;
			}
			else if (words.length == 1) {
				if (str.equalsIgnoreCase(("Shockwave")) || str.equalsIgnoreCase(("W"))) {
					if (game.UCMgetSW()) {
						game.shockwave();
						controller = true;

					} else {
						System.out.println("Your special ability is not ready yet");
					}
				} else if (str.equalsIgnoreCase(("Shoot")) || str.equalsIgnoreCase(("S"))) {
					if (game.UCMshoot()) {
						controller = true;
					} else {
						System.out.println("You can´t shoot more than one missile");
					}

				} else if (str.equalsIgnoreCase(("List")) || str.equalsIgnoreCase(("L"))) {
					System.out.println("Command > list\r\n" +
							"-<x>-: Points: 5 - Damage: 0 - Resistance: 2\r\n" +
							"!<x>!: Points: 10 - Damage: 1 - Resistance: 1\r\n" +
							"<(+)>: Points: 25 - Damage: 0 - Resistance: 1\r\n" +
							"/-^-\\: Damage: 1 - Resistance: 3\r\n" +
							"");
				} else if (str.equalsIgnoreCase(("Reset")) || str.equalsIgnoreCase(("R"))) {
					game.reset();
					outPut(printer);
				} else if (str.equalsIgnoreCase(("None")) || str.equalsIgnoreCase(("N"))) { //Maybe useless but it's more user friendly :)
					controller = true;
				} else if (str.equalsIgnoreCase(("Help")) || str.equalsIgnoreCase(("H"))) {
					System.out.println("move <left|right><1|2>: causes the UCM-Ship to move as indicated.\r\n" +
							"shoot: causes the UCM-Ship to launch a missile.\r\n" +
							"shockwave: causes the UCM-Ship to release a shock wave.(W)\r\n" +
							"list: displays the list of ship types in the game.\r\n" +
							"reset: starts a new game.\r\n" +
							"help: prints this help message.\r\n" +
							"exit: terminates the program.\r\n" +
							"[none]: skips one cycle.");
				} else if (str.equalsIgnoreCase(("Exit")) || str.equalsIgnoreCase(("E"))) {
					System.out.println("Game over!\r\n" + "Player Exit\r\n");
				} else {
					System.out.println("Unknown Command! (Type Help or H if you need it!)");
				}
			}
			else if (words.length == 3){
				if (words[0].equalsIgnoreCase(("Move")) || words[0].equalsIgnoreCase(("M"))) {
					if	(Character.isDigit(words[2].charAt(0))) {
						if (words[1].equalsIgnoreCase("Right") || words[1].equalsIgnoreCase(("R")) || words[1].equalsIgnoreCase("Left") || words[1].equalsIgnoreCase(("L"))) {
							if (words[1].equalsIgnoreCase("Right") || words[1].equalsIgnoreCase(("R"))) {
								game.UCMchangeDir(0);
							}
							else{
								game.UCMchangeDir(1);
							}
							blocks = Integer.parseInt(words[2]);
							if (blocks < 3 && blocks > 0 && game.canUCMgo(blocks)) {
								controller = true;
							}
							else{
								System.out.println("Ship cannot go that far!");
							}
						}
						else {
							System.out.println("Invalid direction");
						}

					}
					else {
						System.out.println("Expected positive integers 1 or 2 as 3rd argument");
					}
				}
			}
			else {
				System.out.println("Unknown Command! (Type Help or H if you need it!)");
			}

			if (controller){
				game.update(blocks);
				outPut(printer);
			}

		}while(!game.getState() && !(str.equalsIgnoreCase(("Exit")) || str.equalsIgnoreCase(("E"))));

		if(game.getState()) { //if player purposefully exits the game will not have ended
			if(game.getVictory()){
				System.out.println("Game Over!\nYou Win!");
			}
			else {
				System.out.println("Game Over!\nYou Lose!");
			}
		}
	}
	
	
	private void outPut(GamePrinter printer) {	// I added a method here!
		System.out.println("Score: " + game.getScore());
		System.out.println("Shield Strength: " + game.UCMgetResistance());
		System.out.println("Shockwave: " + game.UCMswString());
		System.out.println("Cycle Number: : " + game.getCycle());
		System.out.println("Remaining Alien Ships: " + game.getTotalShips());
		System.out.println(printer);
	}

}

