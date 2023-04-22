package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece {
	
	private Color color;

	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
	
	protected boolean isThereOpponentPiece(Position position) {
		ChessPiece p=(ChessPiece) getBoard().piece(position);
		//retorna verdadeiro sem tem uma peça e se a cor é diferentee
		return p !=null && p.getColor()!=color;
		
	}
	
	
	

}
