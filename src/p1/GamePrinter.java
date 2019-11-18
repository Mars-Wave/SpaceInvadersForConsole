package tp.p1;

import tp.pr1.util.MyStringUtils;

class GamePrinter {
	private int numRows;
	private int numCols;
	private Game game;
	private String[][] board;
	private final String space = " ";
	
	
	
	public GamePrinter (Game game, int rows, int cols) {
		this.numRows = rows;
		this.numCols = cols;		
		this.game = game;
	}
	
	private void encodeGame(Game game) {
		board = new String[numRows][numCols];
		for(int i = 0; i < numRows; i++) {
			for(int j = 0; j < numCols; j++) {
				if (game.UCMat(j, i)){
					board[i][j] = game.UCMtoString();
				}
				else if(game.cListFoundAt(j, i)){
					board[i][j] = ( game.cListToString(game.cListFindShip(j, i)));
					
				}
				else if(game.dListFoundAt(j, i)){
					board[i][j] = ( game.dListToString(game.dListFindShip(j, i)));
				}
				else if (game.UFOat(j, i)){
					board[i][j] = game.UFOtoString();
				}
				else if (game.missileAt(j, i)){
					board[i][j] = game.MissiletoString();
				}
				else if (game.projectileAt(j, i)){
					board[i][j] = game.bListToString(game.bListFindBomb(j, i));
				}
				
				else {
					board[i][j] = " ";
				}
			}
		}
	}
	
	public String toString() {
		encodeGame(game);
		int cellSize = 7;
		int marginSize = 2;
		String vDelimiter = "|";
		String hDelimiter = "-";
		String intersect = space;
		String vIntersect = space;
		String hIntersect = "-";
		String corner = space;
		
		String cellDelimiter = MyStringUtils.repeat(hDelimiter, cellSize);
		
		String rowDelimiter = vIntersect + MyStringUtils.repeat(cellDelimiter + intersect, numCols-1) + cellDelimiter + vIntersect;
		String hEdge =  corner + MyStringUtils.repeat(cellDelimiter + hIntersect, numCols-1) + cellDelimiter + corner;
		
		String margin = MyStringUtils.repeat(space, marginSize);
		String lineEdge = String.format("%n%s%s%n", margin, hEdge);
		String lineDelimiter = String.format("%n%s%s%n", margin, rowDelimiter);
		
		StringBuilder str = new StringBuilder();
		
		str.append(lineEdge);
		for(int i=0; i<numRows; i++) {
				str.append(margin).append(vDelimiter);
				for (int j=0; j<numCols; j++)
					str.append( MyStringUtils.centre(board[i][j], cellSize)).append(vDelimiter);
				if (i != numRows - 1) str.append(lineDelimiter);
				else str.append(lineEdge);	
		}
		
		return str.toString();
	}
}