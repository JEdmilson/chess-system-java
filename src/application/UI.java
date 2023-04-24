package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;

public class UI {

	// https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
	
	public static void clearScreen() { 
		//https://stackoverflow.com/questions/2979383/how-to-clear-the-console

		    System.out.print("\033[H\033[2J");  
		    System.out.flush();  
		} 

	
	public static ChessPosition ChessPosition  (Scanner sc) {
		try {
			String s =sc.nextLine();
			char col=s.charAt(0);
			int row =Integer.parseInt(s.substring(1));
			return new ChessPosition(col, row);
		}
		catch(RuntimeException e) {
			throw new InputMismatchException("Erro de leitura da entrada. Entradas valida a1 to h8");
			
			
		}
		
		
	}
	
	public static void printMatch(ChessMatch chessMatch) {
		printBoard(chessMatch.getPieces());
		System.out.println();
		System.out.println("Jodada n: "+chessMatch.getTurn());
		System.out.println("Esperando jogador: "+chessMatch.getCurrentPlayer());
		
	}
	
	

	public static void printBoard(ChessPiece[][] pieces) {
		for (int i = 0; i < pieces.length; i++) {
			System.out.print((8 - i) + " ");
			for (int j = 0; j < pieces.length; j++) {
				printPiece(pieces[i][j],false);
			}
			System.out.println();
		}
		System.out.println("  A B C D E F G H");

	}
	//sobrecarga do metodo acima imprimindo os possiveis movimentos:
	
	public static void printBoard(ChessPiece[][] pieces,boolean [][] possibleMoves) {
		for (int i = 0; i < pieces.length; i++) {
			System.out.print((8 - i) + " ");
			for (int j = 0; j < pieces.length; j++) {
				printPiece(pieces[i][j],possibleMoves[i][j]);
			}
			System.out.println();
		}
		System.out.println("  A B C D E F G H");

	}

	// m�tOdo auxiliar para impriir uma unica pe�a:
	private static void printPiece(ChessPiece piece, boolean background) {
		
		//variavel backgroud para mudar o fundo da tela se verdadeiro
		if(background) {
			System.out.print(ANSI_BLUE_BACKGROUND);
			//cor azul de fundo
		}
		
		if (piece == null) {
			System.out.print("-"+ ANSI_RESET);
		} else {
			if (piece.getColor() == Color.WHITE) {
                System.out.print(ANSI_WHITE + piece + ANSI_RESET);
            }
            else {
                System.out.print(ANSI_YELLOW + piece + ANSI_RESET);
            }
		}
		System.out.print(" ");
	}

}
