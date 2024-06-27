package boardgame;

public abstract class Piece{
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
	
	public abstract boolean[][] possibleMoves();
	/* Hook metod: é um metodo que faz um gancho com uma subclasse; 
	 * Esse metodo é responsavel por verificar as posições que a peça pode se locomover*/
	public boolean possibleMove(Position position){
		return possibleMoves()[position.getRow()][position.getColumn()];
	}
	
	//Metodo que verifica se tem alguma jogada possivel com a peça dentro do tabuleiro
	public boolean isThereAnyPossibleMove() {
		boolean[][] mat = possibleMoves();
		for (int i = 0; i<mat.length; i++) {
			for(int j = 0; j<mat.length; j++) {
				if(mat[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
	
	
}
