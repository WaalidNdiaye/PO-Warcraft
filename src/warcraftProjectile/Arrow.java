package warcraftProjectile;

import warcraftMain.Position;
import warcraftMonster.*;

import warcraftMain.*;


public class Arrow extends Projectile{

	private double angleRotation ;

	/**
	 * Constructeur
	 * @param p position
	 * @param cible monstre que le projectile cible
	 */
	public Arrow (Position p , Monster cible) {
		//La vitesse des fleches egale: vitesse de base des FlyingMonsters*2
		super(40, (float)0.008550, true, p, cible, (float)0.03);
		this.angleRotation = angleCalculation();
	}

	/**
	 * Affichage du projectile
	 */
	public  void draw() {
		StdDraw.picture(p.getX(), p.getY(), "images/Tower/ArcheryTower/ArrowAnimation/" + time % 7 + ".png", size  , size * 0.6 , this.angleRotation);
	}
	
	/**
	 * Upgrade du projectile
	 */
	public void upgrade (){
		level++;
		damage += 1;
	}

	/**
	 * Update du projectile
	 * Met a jour la rotation de l'image en fonction de la postion de la cible 
	 * NOTE :
	 * Nous avons rajouter une condition pour limiter les calcules de notre programme (sans impacter significativement le jeu)
	 * au lieux de s'executer a chaque update ces instructions s'executent toutes les 10 updates
	 */
	public void update(){
		time++;
		move();

		if(time%10 == 0)
			this.angleRotation = angleCalculation();

		draw();
		
		if(hitbox.hit(target.getHitbox())){
			target.hit(damage);
			hit = true;
		} 
	}

	/**
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
