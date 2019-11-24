package tp.p1.Commands;

import tp.p1.Model.Game;

public class ShootCommand extends NoParamsCommand {

	protected final static String sName = "shoot";
	protected final static String sShortName = "S";
	private final static String sCommandText = sName; // Implement this
	private final static String sHelpText = "causes the UCM-Ship to launch a missile."; //"shoot: causes the UCM-Ship to launch a missile.\\r\\n\"";
	

	public ShootCommand() {
		super(sName, sShortName, sCommandText, sHelpText);
	}

	@Override
	public boolean execute(Game game) {

		boolean canBeExecuted = true;
		if (game.shootMissile()) {
			game.update();	//Fix this by implementing the new update which has no parameters
		} else {
			canBeExecuted = false;
		}
		return canBeExecuted;
	}

}
