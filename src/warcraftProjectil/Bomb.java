package warcraftProjectil;

import warcraftMain.Position;

public class Bomb extends Projectil {

	public Bomb (Position p) {
		super(8, 0.02, false, p);
	}
	
	public void draw() {
		
	}
	
	public void upgrade (){
		level++;
		damage += 1;
	}
}
