package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece{
	
	private ChessMatch chessMatch; 

	public King(Board board, Color color,ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch=chessMatch;
		
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
	
	private boolean testRookCastling(Position position) {
		ChessPiece p=(ChessPiece)getBoard().piece(position);
		return p!=null && p instanceof Rook && p.getColor()==getColor() && p.getMoveCount()==0; 
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
		
		//Special Move Castling
		if(getMoveCount()==0 && !chessMatch.getCheck()) {
			//roque pequeno king side
			Position posT1=new Position(position.getRow(), position.getCol()+3);
			if(testRookCastling(posT1)) {
				Position p1=new Position(position.getRow(), position.getCol()+1); 
				Position p2=new Position(position.getRow(), position.getCol()+2);
				if(getBoard().piece(p1)==null && getBoard().piece(p2)==null) {
					//falta verificar se as posicoes que passariam o rei estariam em check!
					mat[position.getRow()][position.getCol()+2]=true;			
					
				}
			}
			//roque grande queen side
			Position posT2=new Position(position.getRow(), position.getCol()-4);
			if(testRookCastling(posT2)) {
				Position p1=new Position(position.getRow(), position.getCol()-1); 
				Position p2=new Position(position.getRow(), position.getCol()-2);
				Position p3=new Position(position.getRow(), position.getCol()-3);
				if(getBoard().piece(p1)==null && getBoard().piece(p2)==null && getBoard().piece(p3)==null) {
					//falta verificar se as posicoes que passariam o rei estariam em check!
					mat[position.getRow()][position.getCol()-2]=true;								
				}
			}
			
			
			
		}
		
		
		
		
		
		return mat;
	}
	

}
