package tp.p1.Commands;

import tp.p1.Model.Game;

public class ShopCommand extends NoParamsCommand {

	protected final static String sName = "Shop";
	protected final static String sShortName = "S";
	private final static String sCommandText = sName; // ""
	private final static String sHelpText = "displays the items available in the shop."; //"help: prints this help message.\\r\\n\"";
	

	public ShopCommand() {
		super(sName, sShortName, sCommandText, sHelpText);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		System.out.println("These are the available items in the shop: (Remember to use Buy/B followed by the number assigned to each item)\n"
				+ "1. Super Missile (20)");
		return false;
	}
}
