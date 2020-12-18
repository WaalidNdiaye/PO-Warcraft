package warcraftTower;

import warcraftMain.Position;

public abstract class Tower {

	//prix de la tour
	protected int towerCost;

	//potée de la tour 
	protected double range; 

	//temps de rechargement
	protected int cooldown;

	//peut attaquer les cibles volantes 
	boolean aerialTarget ;

	// Position de la tour 
	Position p;
	
	//niveau de la tour (niveau 1 puis niveau 2 si améliorer)
	int level;

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
