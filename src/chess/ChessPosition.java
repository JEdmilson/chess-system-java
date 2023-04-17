package chess;

import boardgame.BoardException;
import boardgame.Position;

public class ChessPosition {
	private char col;
	private int row;
	
	//matrix_row=8-chess_row
	//a=0,b=1...
	//matrix_col=chess_col-'a'
	
	public ChessPosition(char col, int row) {
		//super();
		if(col<'a'||col>'h'||row<1||row>8) {
			throw new BoardException("Erro de posiscção col entre A e H(inclusive) e fileira entre 1 e 8(incluisve).");
		}
		this.col = col;
		this.row = row;			
	}
	
	protected Position toPosition() {
		return new Position(8-row,col - 'a');		
	}
	
	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition((char)('a'+position.getCol()), 8-position.getRow());
	} 

	public char getCol() {
		return col;
	}

	public int getRow() {
		return row;
	}
	
	@Override
	public String toString() {
		return ""+col+row;			
	}

	
	
	

}
