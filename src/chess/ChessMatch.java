package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
	private Board board;
	
	public ChessMatch() {
		board=new Board(8, 8);
		initialSetup();
	}
	
	public ChessPiece[][] getPieces(){
		ChessPiece [][] mat=new ChessPiece[board.getRow()][board.getColumns()];
		for (int i=0; i<board.getRow();i++) {
			for(int j=0;j<board.getColumns();j++) {
				mat[i][j]=(ChessPiece) board.piece(i,j);
				
			}
		}
		return mat;
	}
	private void placeNewPiece(char col,int row,ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(col,row).toPosition());
		
	} 
	
	private void initialSetup() {
		//board.placePiece(new Rook(board,Color.WHITE), new Position(2,0));
		//board.placePiece(new King(board,Color.BLACK), new Position(1,1));
		//board.placePiece(new King(board,Color.WHITE), new Position(7,7));
		placeNewPiece('b',6, new Rook(board,Color.WHITE));
		placeNewPiece('e',8, new King(board,Color.BLACK));
		placeNewPiece('e',1, new King(board,Color.WHITE));
		
	}
	

}
