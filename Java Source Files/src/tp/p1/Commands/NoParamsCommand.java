package tp.p1.Commands;

public abstract class NoParamsCommand extends Command {

	public NoParamsCommand(String name, String shortName, String commandText, String helpText) {
		super(name, shortName, commandText, helpText);
	}
	
	public Command parse(String[] commandWords) {
		Command com = null;
			//System.out.println(availableCommands[i].helpText());
			if(matchCommandName(commandWords[0])) {
				com = this;
			}
		return com;
	}
}
