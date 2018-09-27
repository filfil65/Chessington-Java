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
    	
    	if(get_move_permission(from, board)) {
        	allowed_moves.add(get_move_one(from, board));
        	
        	if(get_move_two(from) != null) {
            	allowed_moves.add(get_move_two(from));
        	}
        	
        	ArrayList<Move> attackMoves = get_attack_move(from, board);
        	for(Move each : attackMoves) {
        		if(each!=null) {
        			allowed_moves.add(each);
        		}
        	}
    	}
        return allowed_moves;
    }
    
    private Move get_move_one(Coordinates from, Board board){
    	Move pawn_move = new Move(from, from);
    	Coordinates to;
    	if(colour.equals(PlayerColour.WHITE)) {
    		to = new Coordinates(from.getRow()-1, from.getCol());
    		if(board.get(to)==null) {// If not blocked by another piece
    			pawn_move = new Move(from, to);
    		}
    	}
    	else  {
    		to = new Coordinates(from.getRow()+1, from.getCol());
    		if(board.get(to)==null) {// If not blocked by another piece
    			pawn_move = new Move(from, to);
    		}
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
    
    private boolean get_move_permission(Coordinates from, Board board){
    	Coordinates to;
    	//White Piece
    	if(colour.equals(PlayerColour.WHITE)) {
        	to = new Coordinates(from.getRow()-1, from.getCol());
        	if(from.getRow()>0) { //If not at the board edge
	        	if(board.get(to)==null ) { // If not blocked by another piece
	        		return true;
	        	}
	        	else {
	        		return false;
	        	}
        	}
        	else {
        		return false;
        	}
    	}
    	//Black Piece
    	if(colour.equals(PlayerColour.BLACK)) {
    		to = new Coordinates(from.getRow()+1, from.getCol());
    		if(from.getRow()<7){ //If not at the board edge
	        	if(board.get(to)==null) {// If not blocked by another piece
	        		return true;
	        	}
	        	else {
	        		return false;
	        	}
    		}
    		else {
    			return false;
    		}
    	}
    	else {
    		return false;
    	}
    }
    
    private ArrayList<Move> get_attack_move(Coordinates from, Board board){
    	Coordinates left;
    	Coordinates right;
    	ArrayList<Move> outMoves = new ArrayList<Move>();
    	
    	if(colour.equals(PlayerColour.WHITE)) {
    		left = new Coordinates(from.getRow()-1, from.getCol()-1);
    		right = new Coordinates(from.getRow()-1, from.getCol()+1);
    		// Attacking left
    		if(left.getCol()>-1) { //IF NOT AT THE EDGE
    			if(board.get(left)!=null) {
    				if(board.get(left).getColour() == PlayerColour.BLACK) { //IF PIECE NOT THE SAME COLOUR
    					outMoves.add(new Move(from, left)); //THEN ATTACK DIAGONALLY TO LEFT
    				}
    			}
    		}
    		// Attacking right
    		if(right.getCol()<8) {//IF NOT AT THE EDGE
    			if(board.get(right)!= null) {
    				if(board.get(right).getColour()== PlayerColour.BLACK) {
    					outMoves.add(new Move(from, right));//THEN ATTACK DIAGONALLY TO RIGHT
    				}
    			}
    		}
    	}
    	else if(colour.equals(PlayerColour.BLACK)) {
    		left = new Coordinates(from.getRow()+1, from.getCol()-1);
    		right = new Coordinates(from.getRow()+1, from.getCol()+1);
    		// Attacking left
    		if(left.getCol()>-1) { //IF NOT AT THE EDGE
    			if(board.get(left)!=null) {
    				if(board.get(left).getColour() == PlayerColour.WHITE) { //IF PIECE NOT THE SAME COLOUR
    					outMoves.add(new Move(from, left)); //THEN ATTACK DIAGONALLY TO LEFT
    				}
    			}
    		}
    		// Attacking right
    		if(right.getCol()<8) {//IF NOT AT THE EDGE
    			if(board.get(right)!= null) {
    				if(board.get(right).getColour()== PlayerColour.WHITE) {
    					outMoves.add(new Move(from, right));//THEN ATTACK DIAGONALLY TO RIGHT
    				}
    			}
    		}
    	}
		else {
			return outMoves;
		}
    return outMoves;
    }
    
    
}
