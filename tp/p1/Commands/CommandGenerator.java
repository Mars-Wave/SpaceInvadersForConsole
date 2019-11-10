package tp.p1.Commands;

public class CommandGenerator {
	private static Command[] availableCommands = {
			new ListCommand(),
			new HelpCommand(),
			new ResetCommand(),
			new ExitCommand(),
			new NoneCommand(),
			new ShootCommand(),
			new MoveCommand(),
			new ShockwaveCommand()
			};

	public static Command parse(String[] commandWords) {
		Command comm = null;
		for(int i = 0; i < availableCommands.length && comm == null; i++) {
			comm = (availableCommands[i].parse(commandWords));
		}
		return comm;
	}
	
	public static String commandHelp() {
		String str = "";
		for(int i = 0; i < availableCommands.length; i++) {
			str += (availableCommands[i].helpText());
		}		
		return str;
	}
	
}
