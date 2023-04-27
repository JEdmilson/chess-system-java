package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		//by ED
		//Possiveis erros encontrados: 
		//1) ao jogar uma situacao invalida n�o deve mudar o jogador
		
		
		//System.out.println("Hello ");
		Scanner sc=new Scanner(System.in);
		ChessMatch chessMatch=new ChessMatch();
		List<ChessPiece> captured =new ArrayList<>();
		
		while(true) {
			try {
				UI.clearScreen();
				UI.printMatch(chessMatch, captured);
				System.out.println();
				System.out.print("Source: ");
				ChessPosition source=UI.ChessPosition(sc);
				
				//imprimir possiveis moviemntos da peca de origem:
				boolean [][] possibleMoves=chessMatch.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces(),possibleMoves );
				//para executar o met�do acima deve-se criar uma sobrecarga do metodo, 
				//recebendo os possiveis movimentos e colorindo-os
				
				
				System.out.println();
				System.out.print("Target: ");
				ChessPosition target=UI.ChessPosition(sc);
				
				ChessPiece capturedPiece=chessMatch.perfomChessMove(source,target);
				
				if(capturedPiece!=null) {
					captured.add(capturedPiece);
				}
			
			}
			catch (ChessException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			
				
		}
			
			
			
			
			
	}
		
		

	

}
