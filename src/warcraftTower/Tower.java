package warcraftTower;

import warcraftMain.Position;

public abstract class Tower {

	//prix de la tour
	protected int towerCost;

	//pot�e de la tour 
	protected double range; 

	//temps de rechargement
	protected int cooldown;

	//peut attaquer les cibles volantes 
	protected boolean aerialTarget ;

	// Position de la tour 
	protected Position p;

	//niveau de la tour (niveau 1 puis niveau 2 si am�liorer)
	protected int level;

	public int getTowerCost() {
		return towerCost;
	}
	public void setTowerCost(int towerCost) {
		this.towerCost = towerCost;
	}
	public double getRange() {
		return range;
	}
	public void setRange(double range) {
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
	public void setP(Position p) {
		this.p = p;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}



	public Tower(int towerCost, double range, int cooldown, boolean aerialTarget , Position p) {
		this.towerCost = towerCost;
		this.range = range ;
		this.cooldown = cooldown ;
		this.aerialTarget = aerialTarget ;
		this.p = p;
		this.level = 1 ;
	}


	public abstract void draw();

	public abstract void upgrade();

}
