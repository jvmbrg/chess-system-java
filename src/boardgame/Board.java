package boardgame;

public class Board {
	
	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns){
		if(rows < 1 || columns < 1) {
			throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns]; 
		/* A matriz de peças é criada com base na quantidade de linhas e colunas informadas na instâcia da classe
		 * Não foi criado os gets e sets da matriz "pieces" pois vamos criar um metodo que retorna a posição
		 * especifica da peça dentro da classe "Board" */
	}
	
	/* Utilizando programação defensiva, foram tirados os métodos setRow e setColumns para evitar que seja possivel 
	 * alterar as dimensões de uma tabuleiro depois que ele for criado. */
	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	//Retorna a "piece" pela matriz
	public Piece piece(int row, int column) {
		if (!positionExists(row, column)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[row][column];
	}
	//Retorna a "piece" pela posição 
	public Piece piece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	//Responsavel por colocar a peça em determinado local do tabuleiro
	public void placePiece(Piece piece, Position position) {
		if (thereIsAPiece(position)) {
			throw new BoardException("There is already a piece on position " + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	//Metodo para remover uma peça
	public Piece removePiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		if(piece(position) == null) {
			return null;
		}
		Piece aux = piece(position);
		aux.position = null;
		pieces[position.getRow()][position.getColumn()] = null;
		return aux;
	}
	
	
	
	/* Metodo auxiliar que verifica se a posição fornecida existe dentro do tabuleiro 
	 * atraves de uma linha e de uma coluna informados por parametro */
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >=0 && column < columns;
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	//Responsavel por verificar se tem uma peça na posição informada
	public boolean thereIsAPiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return piece(position) != null;
	}
	
	
}
