package warcraftMonster;

import warcraftMain.Position;
import warcraftHitbox.MonsterHitbox;

public abstract class Monster {


	
	protected Position p;				// Position du monstre à l'instant t
	protected double speed;				// Vitesse du monstre
	protected Position nextP;			// Position du monstre à l'instant t+1
	protected boolean reached;			// A atteint le chateau du joueur
	protected int checkpoint = 0;		// Compteur de déplacement pour savoir si le monstre à atteint le chateau du joueur
	protected boolean flying ;			//Monstre volant
	protected int life;					//Point de vie du monstre 
	protected int dropCoin;				//Argent gagné lors de la mort du monstre 
	protected MonsterHitbox hitbox;		//Hitbox
	protected double size;				//Taille de la Hitbox

	
	/*
	 * GETTERS AND SETTERS
	 */
	public Position getP() {
		return p;
	}
	public void setP(Position p) {
		this.p = p;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public Position getNextP() {
		return nextP;
	}
	public void setNextP(Position nextP) {
		this.nextP = nextP;
	}
	public boolean isReached() {
		return reached;
	}
	public void setReached(boolean reached) {
		this.reached = reached;
	}
	public int getCheckpoint() {
		return checkpoint;
	}
	public void setCheckpoint(int checkpoint) {
		this.checkpoint = checkpoint;
	}
	public double getSize() {
		return size;
	}
	public void setSize(double size) {
		this.size = size;
	}
	public MonsterHitbox getHitbox() {
		return hitbox;
	}
	public void setHitbox(MonsterHitbox hitbox) {
		this.hitbox = hitbox;
	}
	public boolean isFlying() {
		return flying;
	}
	public void setFlying(boolean flying) {
		this.flying = flying;
	}
	public int getLife() {
		return life;
	}
	public void setLife(int life) {
		this.life = life;
	}
	public int getDropCoin() {
		return dropCoin;
	}
	public void setDropCoin(int dropCoin) {
		this.dropCoin = dropCoin;
	}
	
	public Monster(Position p, double size, double speed, int life, int dropCoin ) {
		this.p = p;
		this.size = size; 
		this.speed = speed;
		this.nextP = new Position(p);
		this.hitbox = new MonsterHitbox(p, size);
		this.life = life ;
		this.dropCoin = dropCoin;
	}
	
	/**
	 * Déplace le monstre en fonction de sa vitesse sur l'axe des x et des y et de sa prochaine position.
	 */
	public void move() {
		// Mesure sur quel axe le monstre se dirige.
		double dx = nextP.getX() - p.getX();
		double dy = nextP.getY() - p.getY();
		if (dy + dx != 0){
			// Mesure la distance à laquelle le monstre à pu se déplacer.
			double ratioX = dx/(Math.abs(dx) + Math.abs(dy));
			double ratioY = dy/(Math.abs(dx) + Math.abs(dy));

			p.setX(p.getX() +  ratioX * speed);
			p.setY(p.getY() +  ratioY * speed);
			hitbox.move(p);
		}
	}

	public void update() {
		move();
		draw();
		checkpoint++;
	}
	public void hit(int damage){
		life -= damage;
	}
	
	/**
	 * Fonction abstraite qui sera instanciée dans les classes filles pour afficher le monstre sur le plateau de jeu.
	 */
	public abstract void draw();

	
}
