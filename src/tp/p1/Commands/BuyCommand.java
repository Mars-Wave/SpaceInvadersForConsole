package tp.p1.Commands;

import tp.p1.Model.Game;

public class BuyCommand extends Command{
	protected final static String bName = "Buy";
	protected final static String bShortName = "B";
	private final static String bCommandText = bName; // Implement this
	private final static String bHelpText = "Allows you to buy from the shop. Ex B 1 (Where 1 stands for the first item in the shop)"; //"shoot: causes the UCM-Ship to launch a missile.\\r\\n\"";
	private int item;	//1 normal missile, 2 super missile
	private String gElement;
	

	public BuyCommand() {
		super(bName, bShortName, bCommandText, bHelpText);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		boolean canBeExecuted = true;
		if(item == 1) {
			gElement = "SuperMissile";
		}
		if (game.canBuy(gElement)) {
			game.update();	//Fix this by implementing the new update which has no parameters
		} else {
			canBeExecuted = false;
		}
		return canBeExecuted;
	}

	@Override
	public Command parse(String[] commandWords) {
		Command com = null;
        if (commandWords.length > 1) { //risk management
            if (matchCommandName(commandWords[0])) {
            	item = Integer.parseInt(commandWords[1]);
                        com = this;
            }
        }
        return com;
	}

}
