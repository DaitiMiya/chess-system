package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

	public Pawn(Board board, Color color) {
		super(board, color);
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position p = new Position(0, 0);

		if (getColor() == Color.WHITE) {
			//anda 1 casa
			p.setValues(position.getRow() - 1, position.getColumn());
			if (getBoard().positionExists(p) && !getBoard().therIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			//possibilidade de mover 2 casas no primeiro movimento
			p.setValues(position.getRow() - 2, position.getColumn());
			Position p2 = new Position(position.getRow() - 1, position.getColumn());
			if (getBoard().positionExists(p) && !getBoard().therIsAPiece(p) && getBoard().positionExists(p2)
					&& !getBoard().therIsAPiece(p2) && getMoveCount() == 0) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			//remover peca oponente diagonal esquerda
			p.setValues(position.getRow() - 1, position.getColumn()-1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			//remover peca oponente diagonal direita
			p.setValues(position.getRow() - 1, position.getColumn()+1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
		}
		else {
			//anda 1 casa
			p.setValues(position.getRow() + 1, position.getColumn());
			if (getBoard().positionExists(p) && !getBoard().therIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			//possibilidade de mover 2 casas no primeiro movimento
			p.setValues(position.getRow() + 2, position.getColumn());
			Position p2 = new Position(position.getRow() + 1, position.getColumn());
			if (getBoard().positionExists(p) && !getBoard().therIsAPiece(p) && getBoard().positionExists(p2)
					&& !getBoard().therIsAPiece(p2) && getMoveCount() == 0) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			//remover peca oponente diagonal esquerda
			p.setValues(position.getRow() + 1, position.getColumn()-1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			//remover peca oponente diagonal direita
			p.setValues(position.getRow() + 1, position.getColumn()+1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
		}
		return mat;
	}
	
	@Override
	public String toString() {
		return "P";
	}
}
