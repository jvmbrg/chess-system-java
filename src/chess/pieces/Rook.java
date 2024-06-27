package chess.pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece{

	public Rook(Board board, Color color) {
		super(board, color);
	}
	
	//Nome que vai aparecer no tabuleiro para identificara  peça
	@Override
	public String toString() {
		return "R";
	}
	
}
