package application;

import boardgame.Board;
import chess.ChessMatch;

public class Program {

	public static void main(String[] args) {
		//by ED
		// TODO Auto-generated method stub
		//System.out.println("Hello ");
		ChessMatch chessMatch=new ChessMatch();
		UI.printBoard(chessMatch.getPieces());
		

	}

}
