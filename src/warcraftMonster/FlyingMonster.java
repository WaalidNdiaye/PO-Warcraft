package warcraftMonster;

import warcraftMain.Position;
import warcraftMain.StdDraw;

public class FlyingMonster extends Monster {
	
	public FlyingMonster (Position p) {
		super(p , (float)0.03 , (float)0.001, 3, 8);
		this.flying = true;
	}
	
	public void draw() {
		StdDraw.picture(p.getX(), p.getY(), "images/FlyingMonster.png", size , size);
	}

}
