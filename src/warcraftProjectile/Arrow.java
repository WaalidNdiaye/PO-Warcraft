package warcraftProjectile;

import warcraftMain.Position;
import warcraftMonster.*;
import warcraftMain.*;


public class Arrow extends Projectile{

	public Arrow (Position p , Monster cible) {
		super(2 , 0.01 , true, p , cible , 0.03);
	}
	
	public  void draw() {
		StdDraw.picture(p.getX(), p.getY(), "images/Arrow.png", size , size);
	}
	
	//ameliore les caracteristiques du projectile
	public void upgrade (){
		level++;
		damage += 1;
	}

	public void update(){
		System.out.println("Position du projectile a instant t - 1 : " + getP().getX() + " / " + getP().getY());
		move();
		hitbox.move(p);
		System.out.println("Position du projectile a instant t : " + getP().getX() + " / " + getP().getY());
		draw();
		
		//Verifie si le projectile a toucher sa cible 
		if(hitbox.hit(target.getHitbox())){
			System.out.println("Cible touché");
			target.hit(damage);
			hit = true;
		} 
	}
	
	

}
