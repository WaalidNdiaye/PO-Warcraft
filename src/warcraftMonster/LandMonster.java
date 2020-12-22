package warcraftMonster;

import warcraftMain.Position;

public class LandMonster extends Monster {

	public LandMonster (Position p) {
		super(p);
		speed = 0.01;
		size = 1.25;
		hitbox = new MonsterHitbox(p, size);
	}
	
	public void draw() {
		
	}
}
