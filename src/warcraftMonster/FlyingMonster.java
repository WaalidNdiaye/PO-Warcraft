package warcraftMonster;

import warcraftMain.Position;

public class FlyingMonster extends Monster {
	
	public FlyingMonster (Position p) {
		super(p , 1 , 0.02);
		flying = true;
	}
	
	public void draw() {
		
	}

}
