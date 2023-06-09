package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Knight extends ChessPiece{

	public Knight(Board board, Color color) {
		super(board, color);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "N";
	}
	
	private boolean canMove(Position position) {
		ChessPiece p=(ChessPiece) getBoard().piece(position);
		return (p==null || p.getColor()!=getColor());
		//o rei s� pode mover se estiver vazio ou se tiver uma pe�a de cor difrente?
		
	}

	@Override
	public boolean[][] possibleMoves() {
		// TODO Auto-generated method stub
		boolean[][]mat =new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p=new Position(0, 0);
		
		
		p.setValues(position.getRow()-1,position.getCol()-2);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getCol()]=true;			
		}
		
		
		p.setValues(position.getRow()-2,position.getCol()-1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getCol()]=true;			
		}
		
		
		p.setValues(position.getRow()-2,position.getCol()+1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getCol()]=true;			
		}
		
		
		p.setValues(position.getRow()-1,position.getCol()+2);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getCol()]=true;			
		}
		
		
		p.setValues(position.getRow()+1,position.getCol()+2);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getCol()]=true;			
		}
		
		
		p.setValues(position.getRow()+1,position.getCol()-2);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getCol()]=true;			
		}
		
		p.setValues(position.getRow()+2,position.getCol()-1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getCol()]=true;			
		}
		
		p.setValues(position.getRow()+2,position.getCol()+1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getCol()]=true;			
		}
		
		
		
		
		return mat;
	}
	

}
