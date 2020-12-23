package warcraftProjectile;
import warcraftHitbox.ProjectileHitbox;

import warcraftMain.Position;


public class Arrow extends Projectile{
	
	public Arrow (Position p) {
		super(2 , 0.04 , true, p);
		this.hitbox = new ProjectileHitbox(p,1); 
	}
	
	public  void draw() {
		
	}
	
	public void upgrade (){
		level++;
		damage += 1;
	}
	

}
