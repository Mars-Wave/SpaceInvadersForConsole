package tp.p1.Commands;

import tp.p1.Game;

public class HelpCommand extends NoParamsCommand {

	protected final static String hName = "Help";
	protected final static String hShortName = "H";
	private final static String hCommandText = hName; // ""
	private final static String hHelpText = "prints this help message."; //"help: prints this help message.\\r\\n\"";
	

	public HelpCommand() {
		super(hName, hShortName, hCommandText, hHelpText);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		System.out.println(CommandGenerator.commandHelp());
		return false;
	}
}
