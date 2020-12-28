package warcraftMonster;

import warcraftMain.Position;

public class FlyingMonster extends Monster {
	
	public FlyingMonster (Position p) {
		super(p , 1 , 0.001, 3, 8);
		flying = true;
	}
	
	public void draw() {
		
	}

}
