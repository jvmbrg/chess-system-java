package boardgame;

public class Board {
	
	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns]; 
		/* A matriz de peças é criada com base na quantidade de linhas e colunas informadas na instâcia da classe
		 * Não foi criado os gets e sets da matriz "pieces" pois vamos criar um metodo que retorna a posição
		 * especifica da peça dentro da classe "Board" */
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}
	//Retorna a "piece" pela matriz
	public Piece piece(int row, int column) {
		return pieces[row][column];
	}
	//Retorna a "piece" pela posição 
	public Piece piece(Position position) {
		return pieces[position.getRow()][position.getColumn()];
	}
	//Responsavel por colocar a peça em determinado local do tabuleiro
	public void placePiece(Piece piece, Position position) {
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	
}
