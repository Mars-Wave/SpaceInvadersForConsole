package tp.p1.Commands;

import tp.p1.Model.Game;

<<<<<<< Updated upstream
public class ShootCommand extends NoParamsCommand {

	protected final static String sName = "shoot";
	protected final static String sShortName = "S";
	private final static String sCommandText = sName; // Implement this
	private final static String sHelpText = "causes the UCM-Ship to launch a missile."; //"shoot: causes the UCM-Ship to launch a missile.\\r\\n\"";
	
=======
public class ShootCommand extends Command {

	protected final static String sName = "Shoot";
	protected final static String sShortName = "S";
	private final static String sCommandText = sName; // Implement this
	private final static String sHelpText = "causes the UCM-Ship to launch a missile."; //"shoot: causes the UCM-Ship to launch a missile.\\r\\n\"";
	private int type;	//1 normal missile, 2 super missile
>>>>>>> Stashed changes

	public ShootCommand() {
		super(sName, sShortName, sCommandText, sHelpText);
	}

	@Override
	public boolean execute(Game game) {
<<<<<<< Updated upstream

		boolean canBeExecuted = true;
		if (game.shootMissile()) {
=======
		boolean canBeExecuted = true;
		if (game.shootMissile(type)) {
>>>>>>> Stashed changes
			game.update();	//Fix this by implementing the new update which has no parameters
		} else {
			canBeExecuted = false;
		}
		return canBeExecuted;
	}

<<<<<<< Updated upstream
=======
	@Override
	public Command parse(String[] commandWords) {
		Command com = null;
        if (commandWords.length > 1) { //risk management
            if (matchCommandName(commandWords[0])) {
            	type = Integer.parseInt(commandWords[1]);
               
                    if (type == 1) {
                        
                        com = this;
                    }
                    else if (type == 2) {
                        
                        com = this;
                    }
                
            }
        }
        return com;
	}

>>>>>>> Stashed changes
}
