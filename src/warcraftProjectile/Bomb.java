package warcraftProjectile;

import warcraftMain.Position;
import warcraftMonster.*;
import warcraftMain.StdDraw;


public class Bomb extends Projectile{

	public Bomb (Position p, Monster target) {
		super(8, (float)0.003, false, p, target, (float)0.03);
	}
	
	public void draw() {
		StdDraw.picture(p.getX(), p.getY(), "images/Bomb.png", size , size);
	}

	//ameliore les caracteristiques du projectile
	public void upgrade (){
		level++;
		damage += 1;
	}

	public void update(){
		move();
		hitbox.move(p);
		draw();
		
		//Verifie si le projectile a toucher sa cible 
		if(hitbox.hit(target.getHitbox())){
			target.hit(damage);
			hit = true;
			StdDraw.picture(target.getP().getX(),target.getP().getY(), "images/Explosion.png", size + 0.02 , size + 0.02);
		} 
	}
}
