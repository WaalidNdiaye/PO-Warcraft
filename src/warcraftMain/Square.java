package warcraftMain;

import java.util.List;
import java.util.LinkedList;

import warcraftMonster.Monster;

public class Square {
	
	/**
	 * Initialise le plateau de jeu
	 * Le travail de cette fonction est plus precisement de creer la liste des cases du plateau de jeu.
	 * Cela nous permet dans le programme de simplement appeler le numero de la case dans la liste
	 * afin de trouver la position normalisee de la case voulu
	 * @return la liste des cases du plateau de jeu
	 */
	public static List<Position> setBoard() {
		List<Position> square = new LinkedList<Position>();
		
		for(int i=1; i<=World.getNbSquareX(); i++) {
			for(int j=1; j<=World.getNbSquareY(); j++)
				square.add(new Position(normalizedX((float) (i * World.getSquareWidth() - World.getSquareWidth() / 2.0)), normalizedY((float) (j * World.getSquareHeight() - World.getSquareHeight() / 2.0))));
		}
		
		return square;
	}
	
	/**
	 * @param x une position sur l'axe x
	 * @return la position sur l'axe x normalise au centre du carre a la quelle la position appartien
	 */
	public static float normalizedX(float x) {
		return (float) (x - (x % World.getSquareWidth()) + World.getSquareWidth() / 2.0);
	}
	
	/**
	 * @param y une position sur l'axe y
	 * @return la position sur l'axe y normalise au centre du carre a la quelle la position appartien
	 */
	public static float normalizedY(float y) {
		return (float) (y - (y % World.getSquareHeight() ) + World.getSquareHeight() / 2.0);
	}
	
	/**
	 * @param x une position sur l'axe x
	 * @param x2 une position sur l'axe x
	 * @param y une position sur l'axe y
	 * @param y2 une position sur l'axe y
	 * @return une boolean indiquant si les position (x, y) et (x2, y2) sont les même
	 */
	public static boolean compareNormalized(float x, float x2, float y, float y2){
		if(normalizedX(x) == normalizedX(x2) && normalizedY(y) == normalizedY(y2))
			return true;
		return false;
	}
	
	/**
	 * @param m un monstre
	 * @return un boolean indiquant si la position d'un monstre est egal a sa nextP en se basant sur les position normalises
	 */
	public static boolean pEqualNextP(Monster m) {
	    Position normalizedP = new Position(normalizedX(m.getP().getX()), normalizedY(m.getP().getY()));
	    Position normalizedNextP = new Position(normalizedX(m.getNextP().getX()), normalizedY(m.getP().getY()));
	    
	    if(normalizedP.getX() == normalizedNextP.getX() && normalizedP.getY() == normalizedNextP.getY())
	    	return true;
	    
	    return false;
	}
	
}
