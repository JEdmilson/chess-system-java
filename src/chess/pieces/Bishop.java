package chess.pieces;


import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece{
	
	public Bishop(Board board, Color color) {
		super(board, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "B";
	}
	
	@Override
	public boolean[][] possibleMoves() {
		// TODO Auto-generated method stub
		boolean[][]mat =new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p=new Position(0,0);
		//NW:
		p.setValues(position.getRow()-1,position.getCol()-1);
		
		//enquanto a posição existir e não houver peça lá		
		while(getBoard().positionExists(p)&&!getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getCol()]=true;
			p.setValues(p.getRow()-1,p.getCol()-1);
						
		}
		//verificar se tem uma peça adversária
		if(getBoard().positionExists(p)&&isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getCol()]=true;
		}
		/////
		//NE
		p.setValues(position.getRow()-1,position.getCol()+1);
		
		//enquanto a posição existir e não houver peça lá		
		while(getBoard().positionExists(p)&&!getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getCol()]=true;
			p.setValues(p.getRow()-1,p.getCol()+1);
		}
		//verificar se tem uma peça adversária
		if(getBoard().positionExists(p)&&isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getCol()]=true;
		}
		/////
		//SE
		p.setValues(position.getRow()+1,position.getCol()+1);
			
		//enquanto a posição existir e não houver peça lá		
		while(getBoard().positionExists(p)&&!getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getCol()]=true;
			p.setValues(p.getRow()+1,p.getCol()+1);
		}
		//verificar se tem uma peça adversária
		if(getBoard().positionExists(p)&&isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getCol()]=true;
		}
		///
		//SW	:
		p.setValues(position.getRow()+1,position.getCol()-1);
				
		//enquanto a posição existir e não houver peça lá		
		while(getBoard().positionExists(p)&&!getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getCol()]=true;
			p.setValues(p.getRow()+1,p.getCol()-1);
		}
		//verificar se tem uma peça adversária
		if(getBoard().positionExists(p)&&isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getCol()]=true;
		}
		
		
		
		
		
		return mat;
	}
	
	

}
