package application;

import chess.ChessPiece;

public class UI {
	
	public static void printBoard(ChessPiece[][] pieces) {
		for(int i=0;i<pieces.length;i++) {
			System.out.print(( 8 - i )+" ");
			for(int j=0;j<pieces.length;j++) {
				printPiece(pieces[i][j]);				
			}
			System.out.println();
		}
		System.out.println("  A B C D E F G H");
		
		
		
	}
	
	//m�tOdo auxiliar para impriir uma unica pe�a:
	private static void printPiece(ChessPiece piece) {
		if (piece==null) {
			System.out.print("-");
		}else {
			System.out.print(piece);//ainda nao foi immplementado o to String do piece
		}
		System.out.print(" ");
	}

}
