package chess;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.Bishop;
import chess.pieces.King;
import chess.pieces.Knight;
import chess.pieces.Pawn;
import chess.pieces.Rook;

public class ChessMatch {
	private int turn;
	private Color currentPlayer;
	private Board board;
	private boolean check;//por defaul eh inicializado com false
	private boolean checkMate;
	
	private List<Piece> piecesOnTheBoard=new ArrayList<>();
	private List<Piece> capturedPieces=new ArrayList<>();
		//inicialmente a lista era do tipo ChessPiece mudou para Piece para nao ter que fazer downacast, ficou mais generico
	//a inicializacao das listas acima poderia ser feito no construtor porem o prof acha melhor aqui fora mesmo
	

	public ChessMatch() {
		board = new Board(8, 8);
		turn=1;
		currentPlayer=Color.WHITE;
		initialSetup();
	}
	
	public int getTurn() {
		return turn;
	}
	
	public Color getCurrentPlayer() {
		return currentPlayer;
		
	}
	
	public boolean getCheck() {
		return check;
	}
	
	public boolean getCheckMate() {
		return checkMate;
	}

	public ChessPiece[][] getPieces() {
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getColumns(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i, j);

			}
		}
		return mat;
	}
	
	public boolean [][] possibleMoves(ChessPosition sourcePosition){
		Position position=sourcePosition.toPosition();
		validateSourcePosition(position);
		return board.piece(position).possibleMoves();
	}
	
	public ChessPiece perfomChessMove(ChessPosition sourcePosition,ChessPosition targetPosition) {
		Position source=sourcePosition.toPosition();
		Position target=targetPosition.toPosition();
		validateSourcePosition(source);
		validateTargetPosition(source,target);
		Piece capturedPiece=makeMove(source,target);

		//verificar se a jogada atula nao deixou o proprio rei em check
		if(testCheck(currentPlayer)) {
			undoMove(source, target, capturedPiece);
			throw new ChessException("Voce nao pode se colocar em check");
		}
		
		//verificar se estah em check
		check=(testCheck(opponent(currentPlayer)))? true:false;
		
		//verificar se estah em checkmate
		if(testCheckMate(opponent(currentPlayer))) {
			checkMate=true;
		}else {
			nextTurn();	
		}
		
			
		return (ChessPiece) capturedPiece;
		
	}

	private Piece makeMove(Position source, Position target) {
		// TODO Auto-generated method stub
		ChessPiece p=(ChessPiece)board.removePiece(source);
		p.increaseMoveCount();
		Piece capturedPiece=board.removePiece(target);
		board.placePiece(p,target);
		
		if(capturedPiece!=null) {
			piecesOnTheBoard.remove(capturedPiece);
			capturedPieces.add(capturedPiece);
			
		}
		
		return capturedPiece;
	}
	
	private void undoMove(Position source,Position target, Piece capturedPiece) {
		ChessPiece p=(ChessPiece)board.removePiece(target);
		p.decreaseMoveCount();
		board.placePiece(p,source);
		if(capturedPiece!=null) {
			board.placePiece(capturedPiece, target);
			capturedPieces.remove(capturedPiece);
			piecesOnTheBoard.add(capturedPiece);
			
		}
	}

	private void validateSourcePosition(Position position) {
		
		if(!board.thereIsAPiece(position)) {
			throw new ChessException("Não há peça na posição de origem.");			
		}
		//validar a cor da peca do jogador atual:
		if(currentPlayer!=((ChessPiece)board.piece(position)).getColor()) {
			//no if acima foi feio o downcast para poder acessar a cor da peac que so existe em chesspiece
			//se a cor for diferente é uma peca do adversario
			throw new ChessException("A peca escolhida nao eh sua.");			
		}
		
		if(!board.piece(position).isThereAnyPossibleMove()) {
			throw new ChessException("Não existe movimentos possiveis para a peça escolhida.");		
			
		}
		
	}
	
	private void validateTargetPosition(Position source,Position target) {
		if(!board.piece(source).possibleMove(target)) {
			throw new ChessException("A peca escolhida nao pode se mover para a posicao de destino.");	
			
		}
	}
	
	private void nextTurn() {
		turn++;
		currentPlayer=(currentPlayer==Color.WHITE)? Color.BLACK:Color.WHITE;
		// operador ternario   condição? valor se for verdareiro : valor se for falso
	}
	
	private Color opponent(Color color) {
		return (color==Color.WHITE)? Color.BLACK:Color.WHITE;
	}
	
	private ChessPiece king(Color color) {
		List<Piece> list=piecesOnTheBoard.stream().filter(x->((ChessPiece)x).getColor()==color).collect(Collectors.toList());
		for(Piece p:list) {
			if(p instanceof King) {
				return (ChessPiece)p;
			}
		}
		throw new IllegalStateException("Não existe o rei da "+color+"no tabuleiro.");
		
	}
	
	private boolean testCheck(Color color) {
		Position kingPosition =king(color).getChessPosition().toPosition();
		//a seguir temo a filtragem da lista de pecas do opponete de color
		List<Piece> opponentPieces=piecesOnTheBoard.stream().filter(x->((ChessPiece)x).getColor()==opponent(color)).collect(Collectors.toList());
		//varrer todas as possiveis jogadas de todas as pecas do opnente para verificar se estah em check
		for(Piece p:opponentPieces) {
			boolean[][] mat=p.possibleMoves();
			//se o elemento da matriz onde o rei se encontra for verdaeiro significa que o rei está em check!
			if(mat[kingPosition.getRow()][kingPosition.getCol()]) {
				return true;				
			}
			
		}
		//se esgotar o for e não houver return significa que o rei noa esta em check
		return false;		
	}
	
	private boolean testCheckMate(Color color) {
		if(!testCheck(color)) {
			return false;
		}
		List<Piece> list=piecesOnTheBoard.stream().filter(x->((ChessPiece)x).getColor()==color).collect(Collectors.toList());
		for(Piece p:list) {
			boolean[][] mat=p.possibleMoves();
			for(int i=0;i<board.getRows();i++) {
				for(int j=0;j<board.getColumns();j++) {
					if(mat[i][j]) {
						//vou verificar se alguma peca que pode mover retira o rei de check
						Position source=((ChessPiece)p).getChessPosition().toPosition();
						Position target=new Position(i, j);
						Piece capturedPiece=makeMove(source,target);
						boolean testCheck=testCheck(color);
						undoMove(source, target, capturedPiece);
						if(!testCheck) {
							return false;							
						}					
						
					}
				}
				
			}
						
		}
		return true;
		
	}

	private void placeNewPiece(char col, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(col, row).toPosition());
		piecesOnTheBoard.add(piece);

	}

	private void initialSetup() {
		// board.placePiece(new Rook(board,Color.WHITE), new Position(2,0));
		// board.placePiece(new King(board,Color.BLACK), new Position(1,1));
		// board.placePiece(new King(board,Color.WHITE), new Position(7,7));
		/*
		placeNewPiece('c', 1, new Rook(board, Color.WHITE));
		placeNewPiece('c', 2, new Rook(board, Color.WHITE));
		placeNewPiece('d', 2, new Rook(board, Color.WHITE));
		placeNewPiece('e', 2, new Rook(board, Color.WHITE));
		placeNewPiece('e', 1, new Rook(board, Color.WHITE));
		placeNewPiece('d', 1, new King(board, Color.WHITE));

		placeNewPiece('c', 7, new Rook(board, Color.BLACK));
		placeNewPiece('c', 8, new Rook(board, Color.BLACK));
		placeNewPiece('d', 7, new Rook(board, Color.BLACK));
		placeNewPiece('e', 7, new Rook(board, Color.BLACK));
		placeNewPiece('e', 8, new Rook(board, Color.BLACK));
		placeNewPiece('d', 8, new King(board, Color.BLACK));
		*/
		placeNewPiece('a', 1, new Rook(board, Color.WHITE));
		placeNewPiece('b', 1, new Knight(board, Color.WHITE));
		placeNewPiece('c', 1, new Bishop(board, Color.WHITE));
		placeNewPiece('e', 1, new King(board, Color.WHITE));
		placeNewPiece('f', 1, new Bishop(board, Color.WHITE));
		placeNewPiece('g', 1, new Knight(board, Color.WHITE));
		placeNewPiece('h', 1, new Rook(board, Color.WHITE));
		placeNewPiece('a', 2, new Pawn(board, Color.WHITE));
		placeNewPiece('b', 2, new Pawn(board, Color.WHITE));
		placeNewPiece('c', 2, new Pawn(board, Color.WHITE));
		placeNewPiece('d', 2, new Pawn(board, Color.WHITE));
		placeNewPiece('e', 2, new Pawn(board, Color.WHITE));
		placeNewPiece('f', 2, new Pawn(board, Color.WHITE));
		placeNewPiece('g', 2, new Pawn(board, Color.WHITE));
		placeNewPiece('h', 2, new Pawn(board, Color.WHITE));

		placeNewPiece('a', 8, new Rook(board, Color.BLACK));
		placeNewPiece('b', 8, new Knight(board, Color.BLACK));
		placeNewPiece('c', 8, new Bishop(board, Color.BLACK));
		placeNewPiece('e', 8, new King(board, Color.BLACK));
		placeNewPiece('f', 8, new Bishop(board, Color.BLACK));
		placeNewPiece('g', 8, new Knight(board, Color.BLACK));
		placeNewPiece('h', 8, new Rook(board, Color.BLACK));
		placeNewPiece('a', 7, new Pawn(board, Color.BLACK));
		placeNewPiece('b', 7, new Pawn(board, Color.BLACK));
		placeNewPiece('c', 7, new Pawn(board, Color.BLACK));
		placeNewPiece('d', 7, new Pawn(board, Color.BLACK));
		placeNewPiece('e', 7, new Pawn(board, Color.BLACK));
		placeNewPiece('f', 7, new Pawn(board, Color.BLACK));
		placeNewPiece('g', 7, new Pawn(board, Color.BLACK));
		placeNewPiece('h', 7, new Pawn(board, Color.BLACK));

	}

}
