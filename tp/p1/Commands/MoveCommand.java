package tp.p1.Commands;

import tp.p1.GameElements.Direction;
import tp.p1.Game;

public class MoveCommand extends Command {
    private final static String mName = "Move";
    private final static String mShortName = "M";
    private static Direction dir;
    private static int numCells;
    private final static String mCommandText = mName;
    private final static String mHelpText = "terminates the program.";

    public MoveCommand() {
        super(mName, mShortName, mCommandText, mHelpText);
    }

    @Override
    public boolean execute(Game game) {
        return game.move(numCells, dir);
    }


    @Override
    public Command parse(String[] commandWords) {
        Command com = null;
        if (commandWords.length > 2) { //risk management
            if (matchCommandName(commandWords[0])) {
            	numCells = Integer.parseInt(commandWords[2]);
                if (numCells < 3 && numCells > 0) {
                    if (commandWords[1].equalsIgnoreCase("L") || commandWords[1].equalsIgnoreCase("Left")) {
                        dir = Direction.LEFT;
                    }
                    else if (commandWords[1].equalsIgnoreCase("R") || commandWords[1].equalsIgnoreCase("Right")) {
                        dir = Direction.RIGHT;
                    }
                    com = this;
                }
            }
        }
        return com;
    }
}