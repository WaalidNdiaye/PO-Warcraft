package warcraftProjectile;

import warcraftHitbox.ProjectileHitbox;
import warcraftMain.Position;
import warcraftMonster.*;


public class Arrow extends Projectile{

	public Arrow (Position p , Monster cible) {
		super(2 , 0.04 , true, p , cible);
		this.hitbox = new ProjectileHitbox(p,1); 
	}
	
	public  void draw() {
		
	}
	
	public void upgrade (){
		level++;
		damage += 1;
	}
	

}
