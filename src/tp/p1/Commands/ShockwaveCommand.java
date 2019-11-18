package tp.p1.Commands;

import tp.p1.Model.Game;

public class ShockwaveCommand extends NoParamsCommand {

	protected final static String sName = "Shockwave";
	protected final static String sShortName = "W";
	private final static String sCommandText = sName;
	private final static String sHelpText = "causes the UCM-Ship to release a shock wave.(W)";
	

	public ShockwaveCommand() {
		super(sName, sShortName, sCommandText, sHelpText);
	}

	@Override
	public boolean execute(Game game) {
		boolean canBeExecuted = true;
		if (game.shockWave()) {
			game.releaseShockWave();	//This should now create a new object of type shockWave which inherits from weapon and add it to the elements[] array of board and then make it attack every single other element in the array other than UCM of course and then we should delete the shockWave :)
			game.update();	//Implement the new update that has no parameters now

		} else {
			canBeExecuted = false;
		}
		return canBeExecuted;
	}

}
