package warcraftTower;
import warcraftMain.StdDraw;

import warcraftMain.Position;

public class ArcheryTower extends Tower {

	public ArcheryTower(Position p) {
		super(50, 0.3, 15, true, p);
	}
	
	public void draw() {

		StdDraw.picture(p.getX() , p.getY(), "images/ArcheryTower.jpg", (1.0/24.0) , (1.0/15.0) );
	}
	
	public void upgrade() {
		level++;
		range += 0.005;
		cooldown =- 2;
	}
}

