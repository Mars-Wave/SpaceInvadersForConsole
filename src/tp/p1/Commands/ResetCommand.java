package tp.p1.Commands;

import tp.p1.Model.Game;

public class ResetCommand extends NoParamsCommand {

	protected final static String rName = "Reset";
	protected final static String rShortName = "R";
	private final static String rCommandText = rName;
	private final static String rHelpText = "starts a new game."; //"reset: starts a new game.\\r\\n"
	

	public ResetCommand() {
		super(rName, rShortName, rCommandText, rHelpText);
	}

	@Override
	public boolean execute(Game game) {
		boolean canBeExecuted = true;
		game.reset();
		return canBeExecuted;
	}

}
