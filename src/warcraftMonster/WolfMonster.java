package warcraftMonster;

import warcraftMain.Position;
import warcraftMain.StdDraw;
import warcraftMain.World;

public class WolfMonster extends Monster {

	public WolfMonster (Position p) {
		super(p, (float)0.08, (float)0.004, 160, 10, false);
		if(World.getCurrentW() >= 5)
			life = 180;
	}
	
	// Affichage du monstre 
	public void draw() {
		StdDraw.picture(p.getX(), p.getY(), "images/Monster/WolfMonsterAnimation/" + time%10 +  ".png", size * 0.6 , size);
	}
}
