package tp.p1.Commands;

import tp.p1.Game;

public class ExitCommand extends NoParamsCommand {
	private final static String eName = "Exit";
	private final static String eShortName = "E";
	private final static String eCommandText = eName;//"Game over!\r\n" + "Player Exit\r\n";
	private final static String eHelpText = "terminates the program.";//"exit: terminates the program.\r\n";
	

	public ExitCommand() {
		super(eName, eShortName, eCommandText, eHelpText);
	}

	@Override
	public boolean execute(Game game) {
		boolean output = false;
		game.exit();
		return output;
	}
}
