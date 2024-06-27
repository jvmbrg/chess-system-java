package boardgame;

public class Piece{
	protected Position position;
	private Board board;
	
	/* O atributo position não é informado no construtor por que quando a peça for criada sua posição será nula, 
	 * o que implica que a peça ainda não foi colocada no tabuleiro. */
	public Piece(Board board) {
		this.board = board;
		position = null;
	}
	
	/* Transformando o metodo acessor para protected protejemos o sistema e limitamos o acesso apenas para a cama
	 * da de tabuleiro(no mesmo pacote "boardgame") e para as classes que tem ligação com ele. (subclasses de "Piece")*/
	protected Board getBoard() {
		return board;
	}
	
	
}
