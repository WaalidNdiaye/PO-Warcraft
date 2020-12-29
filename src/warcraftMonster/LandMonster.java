package warcraftMonster;

import warcraftMain.Position;
import warcraftMain.StdDraw;

public class LandMonster extends Monster {

	public LandMonster (Position p) {
		super(p , (float)0.04 , (float)0.002 , 5 , 5);
	}
	
	public void draw() {
		StdDraw.picture(p.getX(), p.getY(), "images/LandMonster.png", size , size);
	}
}
