package boardgame;

public abstract class Piece {
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
	
	public abstract boolean[][] possibleMoves();
	
	public boolean possibleMove(Position position) {
		return possibleMoves()[position.getRow()][position.getCol()];
		//tal metodo soh faz sentido quando houve umclasse concreta que implemente de fato o possibleMoves
		//rookie metodo -gancho
		//template method
	}
	
	public boolean isThereAnyPossibleMove() {
		boolean[][] mat=possibleMoves();
		for(int i=0;i<mat.length;i++) {
			for(int j=0;j<mat.length;j++) {
				if(mat[i][j]) {
					return true;
				}
			}
			
		} 
		return false;
	}
	
	
	
	

}
