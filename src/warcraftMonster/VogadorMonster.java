package warcraftMonster;

import warcraftMain.Position;
import warcraftMain.StdDraw;

public class VogadorMonster extends Monster {

	public VogadorMonster (Position p) {
		super(p, (float)0.08, (float)0.004, 160, 15, false);
	}
	
	// Affichage du monstre 
	public void draw() {
		StdDraw.picture(p.getX(), p.getY(), "images/Monster/VogadorMonsterAnimation/" + time%10 +  ".png", size * 0.6 , size);
	}
}
