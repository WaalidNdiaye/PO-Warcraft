package warcraftProjectile;

import warcraftHitbox.ProjectileHitbox;
import warcraftMain.Position;
import warcraftMonster.*;
import warcraftMain.*;


public class Arrow extends Projectile{

	public Arrow (Position p , Monster cible) {
		super(2 , 0.002 , true, p , cible);
		this.hitbox = new ProjectileHitbox(p,1); 
	}
	
	public  void draw() {
		StdDraw.picture(p.getX(), p.getY(), "images/Arrow.png", 0.03 , 0.03);
	}
	
	//ameliore les caracteristiques du projectile
	public void upgrade (){
		level++;
		damage += 1;
	}

	public void update(){
		move();
		draw();
		
		//Verifie si le projectile a toucher sa cible 
		if(hitbox.hit(target.getHitbox())){
			target.hit(damage);
			hit = true;
		} 
	}
	
	

}
