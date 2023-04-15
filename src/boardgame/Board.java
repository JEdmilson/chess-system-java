package boardgame;

public class Board {
	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		//super();
		//porgramacao defensiva:
		if(rows<1 || columns<1) {
			throw new BoardException("Erro ao criar tabuleiro:row and col tem que ser >=1");
		}
		
		this.rows = rows;
		this.columns = columns;
		pieces=new Piece[rows][columns];
	}

	public int getRow() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public Piece piece (int row, int col) {
		if(!positionExists(row, col)) {
			throw new BoardException("Posi��o n�o est� no tabuleiro."); 
		}
		return pieces[row][col];
	}
	//sobrecarga de m�todo:
	public Piece piece (Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Posi��o n�o est� no tabuleiro."); 
		}
		return pieces[position.getRow()][position.getCol()];
	}
	
	public void placePiece(Piece piece, Position position) {
		if(thereIsAPiece(position)) {
			throw new BoardException("J� tem uma pe�a ness posi��o "+position); 
		}
		//pieces[position.getRow()][position.getCol()];
		pieces[position.getRow()][position.getCol()]=piece;
		piece.position=position;
		
	}
	
	public boolean positionExists (int row, int col) {
		return row>=0 && row<rows && col>=0 && col <columns;		
	}
	
	public boolean positionExists (Position position) {
		return positionExists(position.getRow(),position.getCol());
	}
	
	
	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Posi��o n�o est� no tabuleiro."); 
		}
		return piece(position)!=null;
		//piece(position)- retorna a pe�a que est� na posi��o, ser� nulo se n�o houver pe�a. 
	}
	
	
	
	
	
	

}
