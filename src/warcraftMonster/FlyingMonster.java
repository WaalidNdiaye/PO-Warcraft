package warcraftMonster;

import warcraftMain.Position;
import warcraftMain.StdDraw;
import warcraftMain.World;

public class FlyingMonster extends Monster {
	
	public FlyingMonster (Position p) {
		super(p , (float)0.04 , (float)0.0035, 110, 5, true);
		if(World.getCurrentW() >= 5)
			life = 195;
	}
	
	// Affichage du monstre 
	public void draw() {
		StdDraw.picture(p.getX(), p.getY(), "images/Monster/FlyingMonsterAnimation/" + time % 9 +  ".png", size * 2, size * 2.5);
	}
}
