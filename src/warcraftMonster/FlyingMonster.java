package warcraftMonster;

import warcraftMain.Position;

public class FlyingMonster extends Monster {
	
	public FlyingMonster (Position p) {
		super(p);
		speed = 0.02;
		size = 1;
		hitbox = new MonsterHitbox(p, size); 
	}
	
	public void draw() {
		
	}

}
