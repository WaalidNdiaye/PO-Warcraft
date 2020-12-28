package warcraftTower;

import java.util.ArrayList;

import warcraftMain.Position;
import warcraftMonster.Monster;

public abstract class Tower {

	protected int towerCost;					// Prix de la tour
	protected float range; 					// Portee de la tour 
	protected int cooldown;						// Temps de rechargement
	protected boolean aerialTarget ;			// Attaquer les cibles volantes 
	private Position p ;						// Position de la tour 
	protected int level;						// Niveau de la tour (niveau 1 puis niveau 2...)

	/*
	 * GETTERS AND SETTERS
	 */
	public int getTowerCost() {
		return towerCost;
	}
	public void setTowerCost(int towerCost) {
		this.towerCost = towerCost;
	}
	public float getRange() {
		return range;
	}
	public void setRange(float range) {
		this.range = range;
	}
	public int getCooldown() {
		return cooldown;
	}
	public void setCooldown(int cooldown) {
		this.cooldown = cooldown;
	}
	public boolean isAerialTarget() {
		return aerialTarget;
	}
	public void setAerialTarget(boolean aerialTarget) {
		this.aerialTarget = aerialTarget;
	}
	public Position getP() {
		return p;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}

	public Tower(int towerCost, float range, int cooldown, boolean aerialTarget , Position p) {
		this.towerCost = towerCost;
		this.range = range ;
		this.cooldown = cooldown ;
		this.aerialTarget = aerialTarget ;
		this.p = p;
		this.level = 1 ;
	}
	

	public abstract void draw();

	public abstract void upgrade();

	public abstract void update(ArrayList <Monster> monsters);

}
