package boardgame;

public class Piece {
	protected Position position;
	private Board board;
	
	public Piece(Board board) {
	//	super();
		this.board = board;
		position=null;
		//por padrão o valor é null foi instaciado ´so para enfatizar!
	}

	protected Board getBoard() {
		//protected porque só a camada de tabuleiro que deve acessar ou as subclasses da peças
		return board;
	}
	
	

}
