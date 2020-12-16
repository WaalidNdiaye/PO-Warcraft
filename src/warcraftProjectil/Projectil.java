package warcraftProjectil;

import warcraftMain.Position;

public abstract class Projectil {

	//Position du projectile à l'instant t
	Position p;

	//Position du projectile à l'instant t+1
	Position nextP;

	//degat du projectile  
	int damage ;

	//vitesse du projectile 
	double speed ;

	//peut attaquer les cibles volantes 
	boolean aerialTarget ;
	
	//niveau des projectiles (le premier niveau est le niveau 1)
	int level ;

	public Projectil(int damage, double speed, boolean aerialTarget, Position p) {
		this.damage = damage;
		this.speed = speed;
		this.aerialTarget = aerialTarget ;
		this.p = p;
		this.nextP = new Position(p);
		level = 1;
	}

	public abstract void draw() ;
	
	public abstract void upgrade() ;

}
