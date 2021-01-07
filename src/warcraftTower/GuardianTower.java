package warcraftTower;

import warcraftMain.StdDraw;
import warcraftMain.World;
import warcraftMonster.*;
import warcraftMain.Position;

public class GuardianTower extends Tower {

	private int damage = 90 ;														// Degat de l'attaque du gardien
	private float rangeDamageZone = (float) 0.07;  									// Portée de l'attaque de zone du gardien 
	private float rangeCantShoot = (float) 0.1 ;									// Porté de la zone morte dans laquelle le gardien ne peu pas attaquer 

	/*
	 * CONSTRUCTEUR 
	 */
	public GuardianTower (Position p) {
		super( 80, (float)0.35, 50, false, p);
		System.out.println("\n--- Nouveau gardien creer!---");
	}
	
	/*
	 * Fonction d'affichage 
	 */
	public void draw() {
		
		// Affiche Gardien
		if((time - lastShot) > 20 || (time - lastShot) < 0) {
			if(time%15 < 10) StdDraw.picture(getP().getX() , getP().getY() + 0.03, "images/Tower/GuardianTowerAnimation/0" + time%15 + ".png", (1.0/24.0) * 1.6  , (1.0/15.0) * 1.6  );
			else StdDraw.picture(getP().getX() , getP().getY() + 0.03 , "images/Tower/GuardianTowerAnimation/" + time%15 + ".png", (1.0/24.0) * 1.6 , (1.0/15.0) * 1.6 );
		}


		// Affiche l'animation de l'attaque du gardien
		if(target != null){
			for(int i = 0 ; i < 21 ; i++) {
				// Afiche l'animation de tir en fonction de la position de la cible par rapport a la tour 
				if( (target.getP().getX() - p.getX()) >= 0 ){
					if((time - lastShot) == i && (i < 10) && (time > 20)) StdDraw.picture(getP().getX() + 0.01, getP().getY() + 0.03, "images/Tower/GuardianAttackRightSide/0" + i + ".png", (1.0/24.0) * 1.6, (1.0/15.0) * 1.6 );
					if((time - lastShot) == i && (i > 9)  && (time > 20)) StdDraw.picture(getP().getX() + 0.01, getP().getY() + 0.03, "images/Tower/GuardianAttackRightSide/" + i + ".png", (1.0/24.0) * 1.6 , (1.0/15.0) * 1.6 );
				}
				else{
					if((time - lastShot) == i && (i < 10) && time > 20) StdDraw.picture(getP().getX() - 0.01, getP().getY() + 0.03, "images/Tower/GuardianAttackLeftSide/0" + i + ".png", (1.0/24.0) * 1.6 , (1.0/15.0) * 1.6 );
					if((time - lastShot) == i && (i > 9)  && time > 20) StdDraw.picture(getP().getX() - 0.01, getP().getY() + 0.03, "images/Tower/GuardianAttackLeftSide/" + i + ".png", (1.0/24.0) * 1.6 , (1.0/15.0) * 1.6 );
	
				}
				
			}
		}
		
	}

	public void upgrade(){

	}

	/*
	 * Mise a jour de la tour 
	 */
	public void update(){
		time++;
		draw();
		shot();
		target = activate();
		if(canShot())  {
			lastShot = time ;
		}
	}

	// Peut tirer
	public boolean canShot(){
		if(target != null  && lastShot == -1) return true ;
		else if(target != null && time - lastShot > cooldown ) return true ;
		else return false ;
	}

	// Charge un tir 

	
	/**
	 * Calcul le monstre le plus proche 
	 * @return le monstre le plus proche a porté ou null si aucun monstre n'est a porté
	 */
	public Monster activate(){

		float distanceMin = (float) (range + 0.01);
		Monster closest = null;
		for(int i = 0 ; i < World.getMonsters().size() ; i++){

			float distance = monsterInRange(World.getMonsters().get(i));
			if(distanceMin > distance && distance > rangeCantShoot) {
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
	 * Tir sur le monstre en parametre 
	 */
	public void shot (){
		if(time - lastShot == 20 && target != null){
			target.hit(this.damage);
			for(Monster m : World.getMonsters()){
				if(rangeDamageZone(m)) m.hit(damage);
			}
		}
	}

	
	/**
	 * Calcul la distance entre la tour et un monstre 
	 * @return true si le projectile est a porté sinon false 
	 */
	public float monsterInRange(Monster m) {

		float distance = 1;																	// Distance entre la tour et monstre

		if (m.getP().getX() > p.getX()) {
			// Lorsque le monstre est en haut a droite de la tour
			if (m.getP().getY() > p.getY()) {
				float AB = Math.abs(m.getP().getX() - p.getX());							// AB
				float BC = Math.abs(m.getP().getY() - p.getY());							// BC
				distance = (float) Math.sqrt(Math.pow(AB, 2) + Math.pow(BC, 2));			// AC2 = AB2 + BC2

			}
			// Lorsque le monstre est en bas a droite de la tour
			else {
				float AB = Math.abs(m.getP().getX() - p.getX());
				float BC = Math.abs(p.getY() - m.getP().getY());
				distance = (float) Math.sqrt(Math.pow(AB, 2) + Math.pow(BC, 2));
			}
		} 
		else {
			// Lorsque le monstre est en haut a gauche de la tour
			if (m.getP().getY() > p.getY()) {
				float AB = Math.abs(p.getX() - m.getP().getX());
				float BC = Math.abs(m.getP().getY() - p.getY());
				distance = (float) Math.sqrt(Math.pow(AB, 2) + Math.pow(BC, 2));
			} 
			// Lorsque le monstre est en bas a gauche de la tour
			else {
				float AB = Math.abs(p.getX() - m.getP().getX());
				float BC = Math.abs(p.getY() - m.getP().getY());
				distance = (float) Math.sqrt(Math.pow(AB, 2) + Math.pow(BC, 2));
			}
		}

		return distance ;

	}

	/*
	 * Verifie sur le monstre est a portée de l'explostion
	 */
	public boolean rangeDamageZone(Monster m){

		// Distance le projectile et le monstre m 
		float distance = (float) 1.0 ; 

		if(m.getP().getX() > p.getX()){
			// Losque le monstre est en haut a droite de la tour  
			if(m.getP().getY() > p.getY()) {
				float AB = Math.abs(m.getP().getX() - p.getX());								
				float BC = Math.abs(m.getP().getY() - p.getY());

				// Distance le projectile et le monstre m  (AC2 = AB2 + BC2)
				distance = (float) Math.sqrt ( Math.pow(AB, 2) + Math.pow(BC, 2) );
			}	
			// Losque le monstre est en bas a droite de la tour 
			else {
				float AB = Math.abs(m.getP().getX() - p.getX());
				float BC = Math.abs( p.getY() - m.getP().getY());
				distance = (float)Math.sqrt ( Math.pow(AB, 2) + Math.pow(BC, 2) );
			}
		}
		else {
			// Losque le monstre est en haut a gauche de la tour 
			if(m.getP().getY() > p.getY()) {
				float AB = Math.abs(p.getX() - m.getP().getX());
				float BC = Math.abs(m.getP().getY() - p.getY());
				distance = (float) Math.sqrt ( Math.pow(AB, 2) + Math.pow(BC, 2) );
			}
			else{
				// Losque le monstre est en bas a gauche de la tour 
				float AB = Math.abs(p.getX() - m.getP().getX());
				float BC = Math.abs( p.getY() - m.getP().getY());
				distance = (float) Math.sqrt ( Math.pow(AB, 2) + Math.pow(BC, 2) );
				
			}
		}

		// Si la distance est inferieur ou egale a la portée de l'explosion alors true, sinon false 
		if(distance <= rangeDamageZone) return true ;
		else return false ;
	}
}

