package tp.p1.Commands;

import tp.p1.Model.Game;

public class NoneCommand extends NoParamsCommand {
	protected final static String nName = "None";
	protected final static String nShortName = "N";
	private final static String nCommandText = nName;
	private final static String nHelpText = "Skips one cycle";
	
	
	public NoneCommand() {
		super(nName, nShortName, nCommandText, nHelpText);
	}

	@Override
	public boolean execute(Game game) {
		game.update();	//This is from old Game2... The new update doesn't have any parameters... Implement the new update
		return true;
	}

}
