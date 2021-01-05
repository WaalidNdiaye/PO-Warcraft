package warcraftProjectile;

import warcraftMain.Position;
import warcraftMonster.*;

import warcraftMain.*;


public class Arrow extends Projectile{

	private double angleRotation ;

	/*
	 * CONSTRUCTEUR 
	 */
	public Arrow (Position p , Monster cible) {
		super(35, (float)0.006, true, p, cible, (float)0.03);
		this.angleRotation = angleCalculation();
	}

	/*
	 * Fonction d'affichage 
	 */
	public  void draw() {
		StdDraw.picture(p.getX(), p.getY(), "images/Tower/ArrowAnimation/" + time % 7 + ".png", size , size , this.angleRotation);
	}
	
	/*
	 * Ameliore les caracteristiques du projectile
	 */
	public void upgrade (){
		level++;
		damage += 1;
	}

	/*
	 * Mise a jour de la tour 
	 */
	public void update(){
		time++;
		move();
		hitbox.move(p);
		// Met a jour la rotation de l'image lorsque time % 10 == 0
		if(time%10 == 0) this.angleRotation = angleCalculation();
		draw();
		
		//Verifie si le projectile a toucher sa cible 
		if(hitbox.hit(target.getHitbox())){
			target.hit(damage);
			hit = true;
		} 
	}

	/*
	 * Calcul et renvoie l'angle de rotation de l'image de fleche en fonction de la position de cible
	 */
	public double angleCalculation(){
		if(p.getY() >= target.getP().getY()){
			if(p.getX() >= target.getP().getX()){ 
				// Cible positionner en bas a gauche de la fleche 
				
				/* Explication : 
				 * A(Xa , Ya) position du monstre 
				 * B(Xb , Yb) postion de la tour 
				 * C(Xc , Yc) tell que AC // l'axe des ordonnées et BC soit sur l'axe des abscisses
				 */
				float X = p.getX() - target.getP().getX();    		// CB
				float Y = p.getY() - target.getP().getY();			// AC
				double angle = Math.toDegrees(Math.atan(Y/X)) ;		// tan (Angle)  = AC / CB  donc Angle = acrtan(AC / CB)
				return angle ;
			}
			else {
				// Cible positionner en bas a droite de la fleche 
				float Y = p.getY() - target.getP().getY();
				float X =  target.getP().getX() - p.getX() ;
				double angle = Math.toDegrees(Math.atan(Y/X)) ;
				return (180 - angle ) ;
			}
		}
		else {
			if(p.getX() >= target.getP().getX()){
				// Cible positionner en haut a gauche de la fleche 
				float X = p.getX() - target.getP().getX();
				float Y =  target.getP().getY() - p.getY();
				double angle = Math.toDegrees(Math.atan(Y/X)) ;
				return  - angle ;
			}
			else{
				// Cible positionner en haut a droite de la fleche 
				float X =  target.getP().getX() - p.getX();
				float Y =  target.getP().getY() - p.getY();
				double angle = Math.toDegrees(Math.atan(Y/X)) ;
				return -( 180 - angle) ;
			}
		}
	}
	
	

}
