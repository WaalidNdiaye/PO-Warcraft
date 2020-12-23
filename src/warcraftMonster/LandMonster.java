package warcraftMonster;

import warcraftMain.Position;
import warcraftMain.StdDraw;

public class LandMonster extends Monster {

	public LandMonster (Position p) {
		super(p , 1.25 , 0.01);
	}
	
	public void draw() {
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.filledCircle(p.getX(), p.getY(), 0.01);
	}
}
