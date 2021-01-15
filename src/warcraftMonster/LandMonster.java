package warcraftMonster;

import warcraftMain.Position;
import warcraftMain.StdDraw;
import warcraftMain.World;

public class LandMonster extends Monster {

	public LandMonster (Position p) {
		super(p , (float)0.055 , (float)0.002, 125, 2, false);
		if(World.getCurrentW() >= 5)
			life = 205;
	}
	
	// Affichage du monstre 
	public void draw() {
		if(time % 25 < 10) StdDraw.picture(p.getX(), p.getY(), "images/Monster/LandMonsterAnimation/0" + time%25 +  ".png", size * 0.6 , size);
		if(time % 25 >= 10) StdDraw.picture(p.getX(), p.getY(), "images/Monster/LandMonsterAnimation/" + time%25 +  ".png", size * 0.6 , size);
	}
}
