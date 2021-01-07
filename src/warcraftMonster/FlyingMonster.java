package warcraftMonster;

import warcraftMain.Position;
import warcraftMain.StdDraw;

public class FlyingMonster extends Monster {
	
	public FlyingMonster (Position p) {
		super(p , (float)0.04 , (float)0.0035, 110, 7 , true);
	}
	
	// Affichage du monstre 
	public void draw() {
		StdDraw.picture(p.getX(), p.getY(), "images/Monster/FlyingMonsterAnimation/" + time % 9 +  ".png", size * 2, size * 2.5);
	}
}
