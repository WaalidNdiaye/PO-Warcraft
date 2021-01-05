package warcraftTower;

import warcraftMain.StdDraw;
import warcraftMain.World;
import java.util.ArrayList;
import warcraftMonster.*;
import warcraftProjectile.Arrow;
import warcraftMain.Position;

public class ArcheryTower extends Tower {

	private ArrayList<Arrow> arrow = new ArrayList<Arrow>();					// Liste des projectiles tiré (en mouvement) par cette tour 

	/*
	 * GETTERS AND SETTERS
	 */
	public ArrayList<Arrow> getArrow() {
		return arrow;
	}
	public void setArrow(ArrayList<Arrow> arrow) {
		this.arrow = arrow;
	}

	/*
	 * CONSTRUCTEUR 
	 */
	public ArcheryTower(Position p) {
		super(25, (float)0.2, 30, true, p);
		System.out.println("\n--- Nouvelle tour d'archer creer!---");
	}
	
	/*
	 * Fonction d'affichage 
	 */
	public void draw() {
		if(level == 1 ) 	StdDraw.picture(getP().getX(), getP().getY(), "images/Tower/Archery Tower Level 1.png", (1.0/24.0) , (1.0/15.0) );
		else if(level == 2) 	StdDraw.picture(getP().getX(), getP().getY(), "images/Tower/Archery Tower Level 2.png", (1.0/24.0) , (1.0/15.0) );
		
		// Affiche Archer 
		if((time - lastShot) > 18 || (time - lastShot) < 0) StdDraw.picture(getP().getX(), getP().getY() + 0.03, "images/Tower/ArcheryTowerAnimationL/00.png", (1.0/24.0) , (1.0/15.0) );
		// Affiche une animation d'archer qui tir 
		if(target != null){
			for(int i = 0 ; i < 19 ; i++) {
				// Afiche l'animation de tir en fonction de la position de la cible par rapport a la tour 
				if( (target.getP().getX() - p.getX()) >= 0 ){
					if((time - lastShot) == i && (i < 10) && (time > 18)) StdDraw.picture(getP().getX(), getP().getY() + 0.03, "images/Tower/ArcheryTowerAnimationR/0" + i + ".png", (1.0/24.0) , (1.0/15.0) );
					if((time - lastShot) == i && (i > 9)  && (time > 18)) StdDraw.picture(getP().getX(), getP().getY() + 0.03, "images/Tower/ArcheryTowerAnimationR/" + i + ".png", (1.0/24.0) , (1.0/15.0) );
				}
				else{
					if((time - lastShot) == i && (i < 10) && time > 18) StdDraw.picture(getP().getX(), getP().getY() + 0.03, "images/Tower/ArcheryTowerAnimationL/0" + i + ".png", (1.0/24.0) , (1.0/15.0) );
					if((time - lastShot) == i && (i > 9)  && time > 18) StdDraw.picture(getP().getX(), getP().getY() + 0.03, "images/Tower/ArcheryTowerAnimationL/" + i + ".png", (1.0/24.0) , (1.0/15.0) );
	
				}
				
			}
		}
		
	}
	
	/*
	 * Amelioration de la tour
	 */
	public void upgrade() {
		if(level < levelMax){
			level++;
			range += 0.01;
			cooldown -= 3;
			upgradeCost = upgradeCost * 2;
		}
		else System.out.println("Cet tour est deja au niveau max !");
	}

	/*
	 * Mise a jour de la tour 
	 */
	public void update(){
		time++;

		if(time - lastShot > cooldown ) canShot = true ;
		else canShot = false ;

		// Si le tir est charger alors shoot (time = 18)
		shot(); 
		draw();

		// Si un monstre est a portée de la tour alors target != null (ce if() sert a reduire les calcules pour des questions de performances)
		if( time % 3 == 0){
			target = activate();
		}
		// Si un monstre est porté et que l'on est pas en cooldown 
		if( target != null && canShot)	loadingShoot(target);

		// Suprime le projectile si il a été tué entre temps
		for (int i = 0; i < arrow.size(); i++) if (arrow.get(i).getTarget().getLife() <= 0) arrow.remove(arrow.get(i));

		// Suprime le prjectile s'il a dépassé la potée de la tour
		for (int i = 0; i < arrow.size(); i++) if(!inRange(arrow.get(i))) arrow.remove(arrow.get(i));

		// Suprime le projectile si il a touché un monstre 
		for(int i = 0 ; i < arrow.size() ; i++ ) if(arrow.get(i).getHit()) arrow.remove(arrow.get(i));

		// Met a jour les projectiles
		for(int i = 0 ; i < arrow.size() ; i++ ) arrow.get(i).update();
	}

	
	/**
	 * Calcul le monstre le plus proche 
	 * @return le monstre le plus proche a porté ou null si aucun monstre n'est a porté
	 */
	public Monster activate(){

		float distanceMin = (float) (range + 0.01);
		Monster closest = null;
		for(int i = 0 ; i < World.getMonsters().size() ; i++){

			float AB = World.getMonsters().get(i).getP().getX() - getP().getX();
			float BC = World.getMonsters().get(i).getP().getY()  - getP().getY();
			// Mesure la distance entre la tour et le monstre (AC2 = AB2 + BC2)
			float distance = (float) (Math.sqrt ( Math.pow(AB, 2) + Math.pow(BC, 2)));
			if(distanceMin > distance) {
				distanceMin = distance; 
				closest = World.getMonsters().get(i);
			}
		} 
		if(distanceMin < range) {
			return closest;
		}
		else return null;
		
	}

	/*
	 * Charge un tir et tire lorsque (time - lastShoot) == 18 
	 */
	public void loadingShoot(Monster monster){
		target = monster ;
		lastShot = time ; 
	}

	/*
	 * Tir un projectile lorsque le projectil est charger 
	 */
	public void shot (){
		if(target != null && (time - lastShot) == 11 && lastShot != -1){
			Position pProjectile = new Position(getP().getX(), (float) (getP().getY() + 0.03));
			arrow.add(new Arrow(pProjectile, target));
		}

	}


	/**
	 * Calcul si le projectile est a porté 
	 * @return true si le projectile est a porté sinon false 
	 */
	public boolean inRange(Arrow arroxCurrent) {

		float distance = 0;																	// Distance entre la tour et le projetile

		if (arroxCurrent.getP().getX() > p.getX()) {
			// Lorsque le projectile est en haut a droite de la tour
			if (arroxCurrent.getP().getY() > p.getY()) {
				float AB = Math.abs(arroxCurrent.getP().getX() - p.getX());							// AB
				float BC = Math.abs(arroxCurrent.getP().getY() - p.getY());							// BC
				distance = (float) Math.sqrt(Math.pow(AB, 2) + Math.pow(BC, 2));			// AC2 = AB2 + BC2

			}
			// Lorsque le projectile est en bas a droite de la tour
			else {
				float AB = Math.abs(arroxCurrent.getP().getX() - p.getX());
				float BC = Math.abs(p.getY() - arroxCurrent.getP().getY());
				distance = (float) Math.sqrt(Math.pow(AB, 2) + Math.pow(BC, 2));
			}
		} 
		else {
			// Lorsque le projectile est en haut a gauche de la tour
			if (arroxCurrent.getP().getY() > p.getY()) {
				float AB = Math.abs(p.getX() - arroxCurrent.getP().getX());
				float BC = Math.abs(arroxCurrent.getP().getY() - p.getY());
				distance = (float) Math.sqrt(Math.pow(AB, 2) + Math.pow(BC, 2));
			} 
			// Lorsque le projectile est en bas a gauche de la tour
			else {
				float AB = Math.abs(p.getX() - arroxCurrent.getP().getX());
				float BC = Math.abs(p.getY() - arroxCurrent.getP().getY());
				distance = (float) Math.sqrt(Math.pow(AB, 2) + Math.pow(BC, 2));
			}
		}

		if(distance >= range) return false ;
		else return true;

	}
}

