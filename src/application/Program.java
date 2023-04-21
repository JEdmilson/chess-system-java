package application;

import java.util.Scanner;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		//by ED
		// TODO Auto-generated method stub
		//System.out.println("Hello ");
		Scanner sc=new Scanner(System.in);
		ChessMatch chessMatch=new ChessMatch();
		
		while(true) {
			UI.printBoard(chessMatch.getPieces());
			System.out.println();
			System.out.print("Source: ");
			ChessPosition source=UI.ChessPosition(sc);
			
			System.out.println();
			System.out.print("Target: ");
			ChessPosition target=UI.ChessPosition(sc);
			
			ChessPiece capturedPiece=chessMatch.perfomChessMove(source,target);
			
			
			
			
			
			
			
		}
		
		

	}

}
