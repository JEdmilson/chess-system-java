package boardgame;

public class Piece {
	protected Position position;
	private Board board;
	
	public Piece(Board board) {
	//	super();
		this.board = board;
		position=null;
		//por padr�o o valor � null foi instaciado �so para enfatizar!
	}

	protected Board getBoard() {
		//protected porque s� a camada de tabuleiro que deve acessar ou as subclasses da pe�as
		return board;
	}
	
	

}
