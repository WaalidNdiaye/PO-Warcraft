package warcraftMonster;

import warcraftMain.Position;
import warcraftHitbox.MonsterHitbox;
import warcraftMain.StdDraw;

public abstract class Monster {

	protected Position p;				// Position du monstre à l'instant t
	protected float speed;				// Vitesse du monstre
	protected Position nextP;			// Position du monstre à l'instant t+1
	protected boolean reached;			// A atteint le chateau du joueur
	protected int checkpoint = 0;		// Compteur de déplacement pour savoir si le monstre à atteint le chateau du joueur
	protected boolean flying ;			// Monstre volant
	protected int life;					// Point de vie du monstre 
	protected int lifeMax;				// Point de vie max du monstre 
	protected float lifeRatio = 1;		// Ratio entre life et lifeMax
	protected int dropCoin;				// Argent gagné lors de la mort du monstre 
	protected MonsterHitbox hitbox;		// Hitbox
	protected float size;				// Taille de la Hitbox
	protected int time = 100;			// Permert d'afficher cycliquement les monstres 

	
	/*
	 * Getters and Setters
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
	
	/**
	 * Constructeur d'un monstre
	 * @param p position
	 * @param size taille de la hitbox
	 * @param speed vitesse
	 * @param life points de vie
	 * @param dropCoin coin drop a sa mort
	 * @param flying si le monstre vol ou non
	 */
	public Monster(Position p, float size, float speed, int life, int dropCoin, boolean flying) {
		this.p = p;
		this.size = size; 
		this.speed = speed;
		this.nextP = new Position(p);
		this.hitbox = new MonsterHitbox(p, size);
		this.life = life ;
		this.lifeMax = life ;
		this.dropCoin = dropCoin;
		this.flying = flying ;
	}
	
	/**
	 * Deplace le monstre en fonction de sa vitesse sur l'axe des x et des y et de sa prochaine position.
	 */
	public void move() {
		// Mesure sur quel axe le monstre se dirige.
		float dx = nextP.getX() - p.getX();
		float dy = nextP.getY() - p.getY();
		
		if (dy + dx != 0){
			// Mesure la distance a�laquelle le monstre à pu se déplacer.
			float ratioX = dx/(Math.abs(dx) + Math.abs(dy));
			float ratioY = dy/(Math.abs(dx) + Math.abs(dy));

			p.setX(p.getX() +  ratioX * speed);
			p.setY(p.getY() +  ratioY * speed);
			hitbox.move(p);
		}
	}

	/**
	 * Met a jour le monstre 
	 */
	public void update() {
		time++;
		move();
		draw();
		drawLife();
		checkpoint++;
	}

	/**
	 * regarde si le monstre a ete touche
	 * @param damage degats pris par le monstre
	 */
	public void hit(int damage){
		life -= damage;
		lifeRatio = (float) life/lifeMax;
	}
	
	/**
	 * Fonction abstraite qui sera instanciée dans les classes filles pour afficher le monstre sur le plateau de jeu.
	 */
	public abstract void draw();

	/**
	 * Fonction afficher la vie du monstre
	 */
	public void drawLife(){
		// Seuils (15 seuils en tout)
		float born = (float) 1/15 ;
		
		// Permet d'afficher les bonnes images en fonction de lifeRatio
		if(lifeRatio < born)  StdDraw.picture(p.getX(), p.getY() + 0.035, "images/Monster/DrawLifeAnimation/00.png", 0.02 , 0.02);
		for(int i = 2 ; i < 15 ; i++){
			float bornInf = (float)((i - 1)*born );
			float bornSupp = (float)(i*born);
			if(i < 10) {
				if(lifeRatio > bornInf && lifeRatio <= bornSupp)
					StdDraw.picture(p.getX(), p.getY() + 0.035, "images/Monster/DrawLifeAnimation/0" + i + ".png", 0.02 , 0.02);
			}
			else {
				if(lifeRatio > bornInf && lifeRatio <= bornSupp)
					StdDraw.picture(p.getX(), p.getY() + 0.035, "images/Monster/DrawLifeAnimation/" + i + ".png", 0.02 , 0.02);
			}
		}
		if(lifeRatio > 14*born)
			StdDraw.picture(p.getX(), p.getY() + 0.035, "images/Monster/DrawLifeAnimation/15.png", 0.02 , 0.02);
		
	}


	
}
