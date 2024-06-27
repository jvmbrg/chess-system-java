package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
	
	private Board board;
	/* Partindo do fundamento de delegar tarefas as classes, a classe responsavel por saber o tamanho
	 * de um tabuleiro de xadrez é classe "ChessMatch", já que ela é a classe coração do da partida e 
	 * resposavel por conter todas as informações pertinentes a partida.*/
	public ChessMatch() {
		board = new Board(8,8);
		initialSetup();
	}
	
	/* Método responsavel por retornar a matriz do tabuleiro de xadrez corresponde a partida definida
	 * pela classe "ChessMatch"
	 * 
	 * Pra esse desenvolvimento de camadas, estamos trabalhando com 2 tipos de peças. As peças
	 * "ChessPiece" que estão localizadas na camada "Chess" e as peças "Piece" que 
	 * estão localizadas na camada de "Board. O programa vai estar liberado apenas para idenficar as 
	 * peças especificadas em "Chess". Dessa forma, condicionamos o programa e ver apenas a camada de 
	 * xadrez(chess) e não de tabuleiro(board)*/
	public ChessPiece[][] getPieces(){
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		for(int i = 0; i<board.getRows(); i++) {
			for(int j = 0; j<board.getColumns(); j++) {
				//Aqui foi feito um downcasting para o programa idenficar o boardpiece como um chesspiece
				mat[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		return mat;
	}
	
	private void initialSetup() {
		board.placePiece(new Rook(board, Color.WHITE), new Position(2,1));
		board.placePiece(new King(board, Color.BLACK), new Position(0,4));
		board.placePiece(new King(board, Color.WHITE), new Position(7,4));
	}
}
