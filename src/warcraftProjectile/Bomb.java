package warcraftProjectile;

import warcraftMain.Position;


public class Bomb extends Projectile{

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
