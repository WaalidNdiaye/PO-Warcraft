package warcraftMonster;

import warcraftMain.Position;
import warcraftHitbox.MonsterHitbox;

public abstract class Monster {


	
	protected Position p;				// Position du monstre à l'instant t
	protected float speed;				// Vitesse du monstre
	protected Position nextP;			// Position du monstre à l'instant t+1
	protected boolean reached;			// A atteint le chateau du joueur
	protected int checkpoint = 0;		// Compteur de déplacement pour savoir si le monstre à atteint le chateau du joueur
	protected boolean flying ;			// Monstre volant
	protected int life;					// Point de vie du monstre 
	protected int dropCoin;				// Argent gagné lors de la mort du monstre 
	protected MonsterHitbox hitbox;		// Hitbox
	protected float size;				// Taille de la Hitbox
	protected int time = 0;				// Permert d'afficher cycliquement les monstres 

	
	/*
	 * GETTERS AND SETTERS
	 */
	public Position getP() {
		return p;
	}
	public void setP(Position p) {
		this.p = p;
	}
	public float getSpeed() {
		return speed;
	}
	public void setSpeed(float speed) {
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
	public float getSize() {
		return size;
	}
	public void setSize(float size) {
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
	
	public Monster(Position p, float size, float speed, int life, int dropCoin ) {
		this.p = p;
		this.size = size; 
		this.speed = speed;
		this.nextP = new Position(p);
		this.hitbox = new MonsterHitbox(p, (float)(size/1.5));
		this.life = life ;
		this.dropCoin = dropCoin;
	}
	
	/**
	 * Déplace le monstre en fonction de sa vitesse sur l'axe des x et des y et de sa prochaine position.
	 */
	public void move() {
		// Mesure sur quel axe le monstre se dirige.
		float dx = nextP.getX() - p.getX();
		float dy = nextP.getY() - p.getY();
		if (dy + dx != 0){
			// Mesure la distance à laquelle le monstre à pu se déplacer.
			float ratioX = dx/(Math.abs(dx) + Math.abs(dy));
			float ratioY = dy/(Math.abs(dx) + Math.abs(dy));

			p.setX(p.getX() +  ratioX * speed);
			p.setY(p.getY() +  ratioY * speed);
			hitbox.move(p);
		}
	}

	public void update() {
		time++;
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
