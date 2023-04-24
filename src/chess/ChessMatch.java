package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
	private int turn;
	private Color currentPlayer;
	private Board board;

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
		nextTurn();		
		return (ChessPiece) capturedPiece;
		
	}

	private Piece makeMove(Position source, Position target) {
		// TODO Auto-generated method stub
		Piece p=board.removePiece(source);
		Piece capturedPiece=board.removePiece(target);
		board.placePiece(p,target);
		return capturedPiece;
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

	private void placeNewPiece(char col, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(col, row).toPosition());

	}

	private void initialSetup() {
		// board.placePiece(new Rook(board,Color.WHITE), new Position(2,0));
		// board.placePiece(new King(board,Color.BLACK), new Position(1,1));
		// board.placePiece(new King(board,Color.WHITE), new Position(7,7));
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

	}

}
