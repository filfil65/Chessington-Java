package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends AbstractPiece {
    public Pawn(PlayerColour colour) {
        super(Piece.PieceType.PAWN, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
    	ArrayList<Move> allowed_moves = new ArrayList<Move>();
    	allowed_moves.add(get_move_one(from));
    	allowed_moves.add(get_move_two(from));
        return allowed_moves;
    }
    
    private Move get_move_one(Coordinates from){
    	Move pawn_move;
    	Coordinates to;
    	if(colour.equals(PlayerColour.WHITE)) {
    		to = new Coordinates(from.getRow()-1, from.getCol());
    	}
    	else {
    		to = new Coordinates(from.getRow()+1, from.getCol());
    	}
    	pawn_move = new Move(from, to);
    	return pawn_move;
    }
    
    private Move get_move_two(Coordinates from){
    	Move pawn_move;
    	Coordinates to;
    	if(colour.equals(PlayerColour.WHITE) && from.getRow()==6) {
    		to = new Coordinates(from.getRow()-2, from.getCol());
    	}
    	else if(colour.equals(PlayerColour.BLACK) && from.getRow()==1) {
    		to = new Coordinates(from.getRow()+2, from.getCol());
    	}
    	else {
    		return null;
    	}
    	pawn_move = new Move(from, to);
    	return pawn_move;
    }
    
//    private boolean get_move_permission(Coordinates from, Board board){
//    	Move pawn_move;
//    	Coordinates to;
//    	 
//    	
//    	if(colour.equals(PlayerColour.WHITE) && from.getRow()==6) {
//    		to = new Coordinates(from.getRow()-2, from.getCol());
//    	}
//
//    	else {
//    		return false;
//    	}
//    	return true;
//    }
    
    
}
