package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece{
	private ChessMatch chessMatch;

	public Pawn(Board board, Color color, ChessMatch chessMacth) {
		super(board, color);
		this.chessMatch=chessMacth;
	}
	@Override
	public String toString() {
		return "P";
	}

	@Override
	public boolean[][] possibleMoves() {
		
		boolean[][]mat =new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p=new Position(0,0);
		
		if(getColor()==Color.WHITE) {
			
			p.setValues(position.getRow()-1, position.getCol());
			if(getBoard().positionExists(p)&& !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getCol()]=true;
			}
			
			p.setValues(position.getRow()-2, position.getCol());
			Position p2=new Position(position.getRow()-1, position.getCol());
			if(getBoard().positionExists(p)&& !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2)&& !getBoard().thereIsAPiece(p2)&&getMoveCount()==0) {
				mat[p.getRow()][p.getCol()]=true;
			}
			
			p.setValues(position.getRow()-1, position.getCol()-1);
			if(getBoard().positionExists(p)&& isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getCol()]=true;
			}
			
			p.setValues(position.getRow()-1, position.getCol()+1);
			if(getBoard().positionExists(p)&& isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getCol()]=true;
			}
			
			//special move enpassant WHITE:
			if(position.getRow()==3) {
				Position left =new Position(position.getRow(),position.getCol()-1);
				if(getBoard().positionExists(left) && isThereOpponentPiece(left) &&getBoard().piece(left)==chessMatch.getEnPassantVunerable()) {
					mat[left.getRow()-1][left.getCol()]=true;
					
				}
				Position right =new Position(position.getRow(),position.getCol()+1);
				if(getBoard().positionExists(right)&& isThereOpponentPiece(right) && getBoard().piece(right)==chessMatch.getEnPassantVunerable()) {
					mat[right.getRow()-1][right.getCol()]=true;
					
				}
				
			}
			
			
			
			
		}else {
			
			p.setValues(position.getRow()+1, position.getCol());
			if(getBoard().positionExists(p)&& !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getCol()]=true;
			}
			
			p.setValues(position.getRow()+2, position.getCol());
			Position p2=new Position(position.getRow()+1, position.getCol());
			if(getBoard().positionExists(p)&& !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2)&& !getBoard().thereIsAPiece(p2)&&getMoveCount()==0) {
				mat[p.getRow()][p.getCol()]=true;
			}
			
			p.setValues(position.getRow()+1, position.getCol()-1);
			if(getBoard().positionExists(p)&& isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getCol()]=true;
			}
			
			p.setValues(position.getRow()+1, position.getCol()+1);
			if(getBoard().positionExists(p)&& isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getCol()]=true;
			}
			
			//special move enpassant BLACK:
			if(position.getRow()==4) {
				Position left =new Position(position.getRow(),position.getCol()-1);
				if(getBoard().positionExists(left)&& isThereOpponentPiece(left) &&getBoard().piece(left)==chessMatch.getEnPassantVunerable()) {
					mat[left.getRow()+1][left.getCol()]=true;
					
				}
				Position right =new Position(position.getRow(),position.getCol()+1);
				if(getBoard().positionExists(right)&& isThereOpponentPiece(right) && getBoard().piece(right)==chessMatch.getEnPassantVunerable()) {
					mat[right.getRow()+1][right.getCol()]=true;
					
				}
				
			}
			
		}
		
		return mat;
	}

}
