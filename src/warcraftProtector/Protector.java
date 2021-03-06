package warcraftProtector;


import warcraftMain.Position;
import warcraftMain.World;
import warcraftMonster.Monster;

public abstract class Protector {

	protected int towerCost;					// Prix de la tour
	protected int upgradeCost;					// Prix pour ameliorer la tour  
	protected float range; 						// Portee de la tour 
	protected int cooldown;						// Temps de rechargement
	protected boolean aerialTarget ;			// Attaquer les cibles volantes 
	protected Position p ;						// Position de la tour 
	protected int level;						// Niveau de la tour (niveau 1 puis niveau 2...)
	protected int levelMax = 2;					// Niveau max des tours 
	protected int time = 100;					// Repere chronologique 
	protected int lastShot = -1;				// Dernier tir (chronologiquement)
	protected boolean canShot ; 				// Peut tirer (cooldown depassé)
	protected Monster target = null ;			// Cible de la tour 
	protected boolean onBuild ;					// Si le defenseur est sur une construction 

	/**
	 * Getters and Setters
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
	public int getUpgradeCost() {
		return upgradeCost;
	}
	public void setUpgradeCost(int upgradeCost) {
		this.upgradeCost = upgradeCost;
	}

	/**
	 * Constructeur
	 * @param towerCost prix
	 * @param range range d'attaque
	 * @param cooldown cooldown entre chaque attaque
	 * @param aerialTarget zone d'attaque
	 * @param p position
	 */
	public Protector(int towerCost, float range, int cooldown, boolean aerialTarget , Position p ) {
		this.towerCost = towerCost;
		this.range = range ;
		this.cooldown = cooldown ;
		this.aerialTarget = aerialTarget ;
		this.p = p;
		this.level = 1 ;
		this.upgradeCost = towerCost * 2;
		onBuild = World.getBuilding().isBuilding(p);
		System.out.println("---- (" + p.getX() + "," + p.getY() + ")");
		System.out.println("le defenceur est sur une tour : " + onBuild );
	}
	
	public abstract void draw();

	public abstract void upgrade();

	public abstract void update();

}
