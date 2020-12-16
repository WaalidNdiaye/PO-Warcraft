package warcraftTower;

import warcraftMain.Position;

public class ArcheryTower extends Tower {

	public ArcheryTower(Position p) {
		super(50, 0.3, 15, true, p);
	}
	
	public void draw() {
		
	}
	
	public void upgrade() {
		level++;
		range += 0.005;
		cooldown =- 2;
	}
}

