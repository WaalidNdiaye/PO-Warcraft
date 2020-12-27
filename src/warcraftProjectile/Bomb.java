package warcraftProjectile;

import warcraftMain.Position;
import warcraftHitbox.ProjectileHitbox;
import warcraftMonster.*;


public class Bomb extends Projectile{

	public Bomb (Position p, Monster target) {
		super(8, 0.02, false, p , target);
		this.hitbox = new ProjectileHitbox(p,2);
	}
	
	public void draw() {
		
	}
	
	public void upgrade (){
		level++;
		damage += 1;
	}
}
