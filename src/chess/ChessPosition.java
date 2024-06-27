package chess;

import boardgame.Position;

public class ChessPosition {
	private char column;
	private int row;
	
	public ChessPosition(char column, int row) {
		if (column < 'a' || column > 'h' || row < 1 || row > 8) {
			throw new ChessException("Error instantiating ChessPosition. Valid values are from a1 to h8.");
		}
		this.column = column;
		this.row = row;
	}

	public char getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}
	/* A logica passada por parametro indica a posição da linha e da coluna atraves da subtração 
	 * da linha subtraida por 8 (tamanho maximo de linha) e o unicode de 'a' subtraido pelo valor 
	 * da coluna. Dessa forma, encontramos dentro da matriz a de posição desejada. */
	protected Position toPosition() {
		return new Position(8 - row, column - 'a');
	}
	
	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition((char)('a' - position.getColumn()), 8 - position.getRow());
	}
	
	@Override 
	public String toString() {
		return "" + column + row;
	}
	
}
