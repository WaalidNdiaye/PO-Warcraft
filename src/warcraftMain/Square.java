package warcraftMain;

import java.util.List;
import java.util.LinkedList;

import warcraftMonster.Monster;

public class Square {
	
	public static List<Position> setBoard() {
		List<Position> square = new LinkedList<Position>();
		
		for(int i=1; i<=World.getNbSquareX(); i++) {
			for(int j=1; j<=World.getNbSquareY(); j++)
				square.add(new Position(normalizedX((float) (i * World.getSquareWidth() - World.getSquareWidth() / 2.0)), normalizedY((float) (j * World.getSquareHeight() - World.getSquareHeight() / 2.0))));
		}
		
		return square;
	}
	
	public static float normalizedX(float x) {
		return (float) (x - (x % World.getSquareWidth()) + World.getSquareWidth() / 2.0);
	}
	
	public static float normalizedY(float y) {
		return (float) (y - (y % World.getSquareHeight() ) + World.getSquareHeight() / 2.0);
	}
	
	public static boolean compareNormalized(float x, float x2, float y, float y2){
		if(normalizedX(x) == normalizedX(x2) && normalizedY(y) == normalizedY(y2))
			return true;
		return false;
	}
	
	public static boolean pEqualNextP(Monster m) {
	    Position normalizedP = new Position(normalizedX(m.getP().getX()), normalizedY(m.getP().getY()));
	    Position normalizedNextP = new Position(normalizedX(m.getNextP().getX()), normalizedY(m.getP().getY()));
	    
	    if(normalizedP.getX() == normalizedNextP.getX() && normalizedP.getY() == normalizedNextP.getY())
	    	return true;
	    
	    return false;
	}
	
}
