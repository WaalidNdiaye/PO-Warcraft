package warcraftProjectile;

import warcraftMain.Position;
import warcraftHitbox.ProjectileHitbox;


public class Bomb extends Projectile{

	public Bomb (Position p) {
		super(8, 0.02, false, p);
		this.hitbox = new ProjectileHitbox(p,2);
	}
	
	public void draw() {
		
	}
	
	public void upgrade (){
		level++;
		damage += 1;
	}
}
