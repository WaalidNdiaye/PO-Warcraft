package warcraftMonster;

import warcraftMain.Position;

public class FlyingMonster extends Monster {
	
	public FlyingMonster (Position p) {
		super(p , 0.03 , 0.001, 3, 8);
		flying = true;
	}
	
	public void draw() {
		
	}

}
