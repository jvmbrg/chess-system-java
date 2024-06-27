package chess;

import boardgame.Board;
import boardgame.Piece;
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
	
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		validateSourcePosition(source);
		Piece capturedPiece = makeMove(source, target);
		return (ChessPiece)capturedPiece;
	}
	
	private Piece makeMove(Position source, Position target) {
		Piece p = board.removePiece(source);
		Piece capturedPiece = board.removePiece(target);
		board.placePiece(p, target);
		return capturedPiece;
	}
	
	
	//Metodo que verifica se a peça desejada corresponde a posição de tabuleiro informada.
	private void validateSourcePosition(Position position) {
		if(!board.thereIsAPiece(position)) {
			throw new ChessException("There is no piece on source position");
		}
		
	}
	
	
	//Metodo para instanciar uma peça usando as coordenadas do xadrez, em vez de usar coordenadas da matriz
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	
	private void initialSetup() {
		placeNewPiece('c', 1, new Rook(board, Color.WHITE));
		placeNewPiece('c', 2, new Rook(board, Color.WHITE));
		placeNewPiece('d', 2, new Rook(board, Color.WHITE));
		placeNewPiece('e', 2, new Rook(board, Color.WHITE));
		placeNewPiece('e', 1, new Rook(board, Color.WHITE));
		placeNewPiece('d', 1, new King(board, Color.WHITE));

		placeNewPiece('c', 7, new Rook(board, Color.BLACK));
		placeNewPiece('c', 8, new Rook(board, Color.BLACK));
		placeNewPiece('d', 7, new Rook(board, Color.BLACK));
		placeNewPiece('e', 7, new Rook(board, Color.BLACK));
		placeNewPiece('e', 8, new Rook(board, Color.BLACK));
		placeNewPiece('d', 8, new King(board, Color.BLACK));
	}
}
