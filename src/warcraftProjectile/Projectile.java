package warcraftProjectile;

import warcraftHitbox.ProjectileHitbox;
import warcraftMain.Position;
import warcraftMonster.*;


public abstract class Projectile {

	//Position du projectile à l'instant t
	protected Position p;

	//Position du projectile à l'instant t+1
	protected Position nextP;

	//degat du projectile  
	protected int damage ;

	//vitesse du projectile 
	protected double speed ;

	//peut attaquer les cibles volantes 
	protected boolean aerialTarget ;

	//niveau des projectiles (le premier niveau est le niveau 1)
	protected int level ;

	//hitbox
	protected ProjectileHitbox hitbox ;

	//Cible du projectile 
	protected Monster target ;
	
	public Position getP() {
		return p;
	}
	public void setP(Position p) {
		this.p = p;
	}
	public Position getNextP() {
		return nextP;
	}
	public void setNextP(Position nextP) {
		this.nextP = nextP;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public boolean isAerialTarget() {
		return aerialTarget;
	}
	public void setAerialTarget(boolean aerialTarget) {
		this.aerialTarget = aerialTarget;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public ProjectileHitbox getHitbox() {
		return hitbox;
	}
	public void setHitbox(ProjectileHitbox hitbox) {
		this.hitbox = hitbox;
	}
	public Monster getTarget() {
		return target;
	}
	public void setTarget(Monster cible) {
		this.target = cible;
	}

	public Projectile(int damage, double speed, boolean aerialTarget, Position p, Monster target) {
		this.damage = damage;
		this.speed = speed;
		this.aerialTarget = aerialTarget ;
		this.p = p;
		this.nextP = new Position(p);
		this.target = target;

		level = 1;
	}

	public void move(){
		
	}

	public abstract void draw() ;

	public abstract void upgrade() ;


}
