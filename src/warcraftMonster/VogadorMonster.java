package warcraftMonster;

import warcraftMain.Position;
import warcraftMain.StdDraw;

public class VogadorMonster extends Monster {

	public VogadorMonster (Position p) {
		super(p , (float)0.08 , (float)0.0035 , 150 , 10);
	}
	
	// Affichage du monstre 
	public void draw() {
		StdDraw.picture(p.getX(), p.getY(), "images/Monster/VogadorMonsterAnimation/" + time%10 +  ".png", size * 0.6 , size);
	}
}
