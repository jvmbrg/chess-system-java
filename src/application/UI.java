package application;

import chess.ChessPiece;

public class UI {
	//Aqui é onde as area do tabuleiro é impressa
	public static void printBoard(ChessPiece[][] pieces) {
		for (int i = 0; i<pieces.length; i++ ) {
			System.out.print((8 - i) + " ");
			for(int j=0; j<pieces.length; j++) {
				printPiece(pieces[i][j]);
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
	}
	
	//Aqui é onde a peça do tabuleiro é impressa
	private static void printPiece(ChessPiece piece) {
		if(piece == null) {
			System.out.print("-");
		}
		else {
			System.out.print(piece);
		}
		System.out.print(" ");
	}
}
