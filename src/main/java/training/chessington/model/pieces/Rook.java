package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Rook extends AbstractPiece {
    public Rook(PlayerColour colour) {
        super(PieceType.ROOK, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
    	ArrayList<Move> allowed_moves = new ArrayList<Move>();
    	allowed_moves.addAll(LeftMoves(from, board));
    	allowed_moves.addAll(RightMoves(from, board));
    	allowed_moves.addAll(UpMoves(from, board));
    	allowed_moves.addAll(DownMoves(from, board));
        return allowed_moves;
    }

    private List<Move> LeftMoves (Coordinates from, Board board) {
    	ArrayList<Move> LeftMoves = new ArrayList<Move>();
    	Coordinates to;
    	PlayerColour enemy = Enemy(colour);
    	
    	for(int i = 1; i<=from.getCol() ; i++) {
    		to = new Coordinates(from.getRow(), from.getCol()-i);
    		
    		if(board.get(to)==null) {
    			LeftMoves.add(new Move(from, to));
    		}
    		else if(board.get(to).getColour()==enemy) {
    			LeftMoves.add(new Move(from, to));
    		}
    		else if(board.get(to).getColour()==colour) {
    		}
    	}
    	return LeftMoves;
    }
       
    private List<Move> RightMoves (Coordinates from, Board board) {
    	ArrayList<Move> RightMoves = new ArrayList<Move>();
    	Coordinates to;
    	PlayerColour enemy = Enemy(colour);
    	
    	for(int i = 1; i<=(7-from.getCol()) ; i++) {
    		to = new Coordinates(from.getRow(), from.getCol()+i);
    		
    		if(board.get(to)==null) {
    			RightMoves.add(new Move(from, to));
    		}
    		else if(board.get(to).getColour()==enemy) {
    			RightMoves.add(new Move(from, to));
    		}
    		else if(board.get(to).getColour()==colour) {
    		}
    	}
    	return RightMoves;

    }    
    
    private List<Move> UpMoves (Coordinates from, Board board) {
    	ArrayList<Move> UpMoves = new ArrayList<Move>();
    	Coordinates to;
    	PlayerColour enemy = Enemy(colour);
    	
    	for(int i = 1; i<=(7-from.getCol()) ; i++) {
    		to = new Coordinates(from.getRow()+i, from.getCol());
    		
    		if(board.get(to)==null) {
    			UpMoves.add(new Move(from, to));
    		}
    		else if(board.get(to).getColour()==enemy) {
    			UpMoves.add(new Move(from, to));
    		}
    		else if(board.get(to).getColour()==colour) {
    		}
    	}
    	return UpMoves;

    }  
    
    private List<Move> DownMoves (Coordinates from, Board board) {
    	ArrayList<Move> DownMoves = new ArrayList<Move>();
    	Coordinates to;
    	PlayerColour enemy = Enemy(colour);
    	
    	for(int i = 1; i<=from.getCol() ; i++) {
    		to = new Coordinates(from.getRow()-i, from.getCol());
    		
    		if(board.get(to)==null) {
    			DownMoves.add(new Move(from, to));
    		}
    		else if(board.get(to).getColour()==enemy) {
    			DownMoves.add(new Move(from, to));
    		}
    		else if(board.get(to).getColour()==colour) {
    		}
    	}
    	return DownMoves;

    }
    
    
    private PlayerColour Enemy(PlayerColour Piece) {
    	PlayerColour enemy;
    	if(colour.equals(PlayerColour.BLACK)) {
    		enemy = PlayerColour.WHITE;
    	}
    	else {
    		enemy = PlayerColour.BLACK;
    	}
    	return enemy;
    }
    
}
