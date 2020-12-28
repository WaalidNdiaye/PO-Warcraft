package warcraftMonster;

import warcraftMain.Position;
import warcraftMain.StdDraw;

public class BaseMonster extends Monster {

	public BaseMonster(Position p) {
		super(p , 0.2 , 0.2 , 3 ,5);
		flying = false ;
	}
	
	/**
	 * Affiche un monstre qui change de couleur au cours du temps
	 * Le monstre est représenté par un cercle de couleur bleue ou grise
	 */
	public void draw() {
		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.filledCircle(p.getX(), p.getY(), 0.01);
	}
}
