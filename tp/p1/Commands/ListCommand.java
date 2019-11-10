package tp.p1.Commands;

import tp.p1.Game;

public class ListCommand extends NoParamsCommand {

	protected final static String lName = "List";
	protected final static String lShortName = "L";
	private final static String lCommandText = lName;
	private final static String lHelpText = "displays the list of ship types in the game.";
	

	public ListCommand() {
		super(lName, lShortName, lCommandText, lHelpText);
	}

	@Override
	public boolean execute(Game game) {
		System.out.println("Command > list\r\n" + 
				"-<x>-: Points: 5 - Damage: 0 - Resistance: 2\r\n" + 
				"!<x>!: Points: 10 - Damage: 1 - Resistance: 1\r\n" + 
				"<(+)>: Points: 25 - Damage: 0 - Resistance: 1\r\n" + 
				"/-^-\\: Damage: 1 - Resistance: 3\r\n");
		return false;
	}

}
