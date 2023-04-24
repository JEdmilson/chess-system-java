package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece{

	public King(Board board, Color color) {
		super(board, color);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "K";
	}
	
	private boolean canMove(Position position) {
		ChessPiece p=(ChessPiece) getBoard().piece(position);
		return (p==null || p.getColor()!=getColor());
		//o rei só pode mover se estiver vazio ou se tiver uma peça de cor difrente?
		
	}

	@Override
	public boolean[][] possibleMoves() {
		// TODO Auto-generated method stub
		boolean[][]mat =new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p=new Position(0, 0);
		
		//above
		p.setValues(position.getRow()-1,position.getCol());
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getCol()]=true;			
		}
		
		//below
		p.setValues(position.getRow()+1,position.getCol());
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getCol()]=true;			
		}
		
		//right
		p.setValues(position.getRow(),position.getCol()+1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getCol()]=true;			
		}
		
		//left
		p.setValues(position.getRow(),position.getCol()-1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getCol()]=true;			
		}
		
		//nw
		p.setValues(position.getRow()-1,position.getCol()-1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getCol()]=true;			
		}
		
		//ne
		p.setValues(position.getRow()-1,position.getCol()+1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getCol()]=true;			
		}
		//sw
		p.setValues(position.getRow()+1,position.getCol()-1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getCol()]=true;			
		}
		//se
		p.setValues(position.getRow()+1,position.getCol()+1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getCol()]=true;			
		}
		
		
		
		
		return mat;
	}
	

}
