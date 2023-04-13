package boardgame;

public class Board {
	private int row;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int row, int columns) {
		//super();
		this.row = row;
		this.columns = columns;
		pieces=new Piece[row][columns];
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}
	public Piece piece (int row, int col) {
		return pieces[row][col];
	}
	//sobrecarga de m�todo:
	public Piece piece (Position position) {
		return pieces[position.getRow()][position.getCol()];
	}
	
	public void placePiece(Piece piece, Position position) {
		//pieces[position.getRow()][position.getCol()];
		pieces[position.getRow()][position.getCol()]=piece;
		piece.position=position;
		
	}
	
	
	
	

}
