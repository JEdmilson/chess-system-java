package chess.pieces;


import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Queen extends ChessPiece{
	
	public Queen(Board board, Color color) {
		super(board, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Q";
	}
	
	@Override
	public boolean[][] possibleMoves() {
		// TODO Auto-generated method stub
		boolean[][]mat =new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p=new Position(0,0);
		//above:
		p.setValues(position.getRow()-1,position.getCol());
		
		//enquanto a posi��o existir e n�o houver pe�a l�		
		while(getBoard().positionExists(p)&&!getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getCol()]=true;
			p.setRow(p.getRow()-1);
		}
		//verificar se tem uma pe�a advers�ria
		if(getBoard().positionExists(p)&&isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getCol()]=true;
		}
		/////
		//left
		p.setValues(position.getRow(),position.getCol()-1);
		
		//enquanto a posi��o existir e n�o houver pe�a l�		
		while(getBoard().positionExists(p)&&!getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getCol()]=true;
			p.setCol(p.getCol()-1);
		}
		//verificar se tem uma pe�a advers�ria
		if(getBoard().positionExists(p)&&isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getCol()]=true;
		}
		/////
		//right
		p.setValues(position.getRow(),position.getCol()+1);
			
		//enquanto a posi��o existir e n�o houver pe�a l�		
		while(getBoard().positionExists(p)&&!getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getCol()]=true;
			p.setCol(p.getCol()+1);
		}
		//verificar se tem uma pe�a advers�ria
		if(getBoard().positionExists(p)&&isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getCol()]=true;
		}
		///
		//below	:
		p.setValues(position.getRow()+1,position.getCol());
				
		//enquanto a posi��o existir e n�o houver pe�a l�		
		while(getBoard().positionExists(p)&&!getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getCol()]=true;
			p.setRow(p.getRow()+1);
		}
		//verificar se tem uma pe�a advers�ria
		if(getBoard().positionExists(p)&&isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getCol()]=true;
		}
		
		//NW:
				p.setValues(position.getRow()-1,position.getCol()-1);
				
				//enquanto a posi��o existir e n�o houver pe�a l�		
				while(getBoard().positionExists(p)&&!getBoard().thereIsAPiece(p)) {
					mat[p.getRow()][p.getCol()]=true;
					p.setValues(p.getRow()-1,p.getCol()-1);
								
				}
				//verificar se tem uma pe�a advers�ria
				if(getBoard().positionExists(p)&&isThereOpponentPiece(p)) {
					mat[p.getRow()][p.getCol()]=true;
				}
				/////
				//NE
				p.setValues(position.getRow()-1,position.getCol()+1);
				
				//enquanto a posi��o existir e n�o houver pe�a l�		
				while(getBoard().positionExists(p)&&!getBoard().thereIsAPiece(p)) {
					mat[p.getRow()][p.getCol()]=true;
					p.setValues(p.getRow()-1,p.getCol()+1);
				}
				//verificar se tem uma pe�a advers�ria
				if(getBoard().positionExists(p)&&isThereOpponentPiece(p)) {
					mat[p.getRow()][p.getCol()]=true;
				}
				/////
				//SE
				p.setValues(position.getRow()+1,position.getCol()+1);
					
				//enquanto a posi��o existir e n�o houver pe�a l�		
				while(getBoard().positionExists(p)&&!getBoard().thereIsAPiece(p)) {
					mat[p.getRow()][p.getCol()]=true;
					p.setValues(p.getRow()+1,p.getCol()+1);
				}
				//verificar se tem uma pe�a advers�ria
				if(getBoard().positionExists(p)&&isThereOpponentPiece(p)) {
					mat[p.getRow()][p.getCol()]=true;
				}
				///
				//SW	:
				p.setValues(position.getRow()+1,position.getCol()-1);
						
				//enquanto a posi��o existir e n�o houver pe�a l�		
				while(getBoard().positionExists(p)&&!getBoard().thereIsAPiece(p)) {
					mat[p.getRow()][p.getCol()]=true;
					p.setValues(p.getRow()+1,p.getCol()-1);
				}
				//verificar se tem uma pe�a advers�ria
				if(getBoard().positionExists(p)&&isThereOpponentPiece(p)) {
					mat[p.getRow()][p.getCol()]=true;
				}
		
		
		
		
		
		return mat;
	}
	
	

}
