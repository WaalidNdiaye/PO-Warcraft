package warcraftProtector;

import warcraftMain.StdDraw;
import warcraftMain.World;
import warcraftMonster.*;
import warcraftMain.Position;

public class GuardianProtector extends Protector {

	private int damage =  85;														// Degat de l'attaque du gardien
	private float rangeDamageZone = (float) 0.04;  									// Portée de l'attaque de zone du gardien 
	private float rangeCantShoot = (float) 0.1 ;									// Porté de la zone morte dans laquelle le gardien ne peu pas attaquer 
	private Position pZoneAttack ;

	/**
	 * Constructeur d'un gardien
	 * @param p position
	 */
	public GuardianProtector (Position p) {
		super( 100, (float)0.3, 70, false, p);
		System.out.println("\n--- Nouveau gardien creer!---");
	}
	
	/**
	 * Fonction d'affichage
	 * 	- compare au deux autres gardien le "gardien" ne peut pas etre place sur les toit
	 */
	public void draw() {
		
		// Affiche Gardien
		if((time - lastShot) > 20 || (time - lastShot) < 0) {
			if(time%31 < 10)
				StdDraw.picture(getP().getX() , getP().getY() + 0.01, "images/Tower/GuardianTower/GuardianWait/0" + time%31 + ".png", (1.0/24.0) * 1.7  , (1.0/15.0) * 1.7  );
			else
				StdDraw.picture(getP().getX() , getP().getY() + 0.01 , "images/Tower/GuardianTower/GuardianWait/" + time%31 + ".png", (1.0/24.0) * 1.7 , (1.0/15.0) * 1.7 );
		}

		// Affiche l'animation de l'attaque du gardien
		if(target != null){
			for(int i = 0 ; i < 21 ; i++) {
				
				// Afiche l'animation de tir en fonction de la position de la cible par rapport a la tour 
				if( (target.getP().getX() - p.getX()) >= 0 ){
					if((time - lastShot) == i && (i < 10) && (time > 20))
						StdDraw.picture(getP().getX() + 0.01, getP().getY() + 0.02, "images/Tower/GuardianTower/GuardianAttackRightSide/0" + i + ".png", (1.0/24.0) * 1.7, (1.0/15.0) * 1.7 );
					if((time - lastShot) == i && (i > 9)  && (time > 20))
						StdDraw.picture(getP().getX() + 0.01, getP().getY() + 0.02, "images/Tower/GuardianTower/GuardianAttackRightSide/" + i + ".png", (1.0/24.0) * 1.7 , (1.0/15.0) * 1.7 );
				}
				
				else{
					if((time - lastShot) == i && (i < 10) && time > 20)
						StdDraw.picture(getP().getX() - 0.01, getP().getY() + 0.02, "images/Tower/GuardianTower/GuardianAttackLeftSide/0" + i + ".png", (1.0/24.0) * 1.7 , (1.0/15.0) * 1.7 );
					if((time - lastShot) == i && (i > 9)  && time > 20)
						StdDraw.picture(getP().getX() - 0.01, getP().getY() + 0.02, "images/Tower/GuardianTower/GuardianAttackLeftSide/" + i + ".png", (1.0/24.0) * 1.7 , (1.0/15.0) * 1.7 );
				}
			}
		}
	}

	/**
	 * Fonction d'affichage de l'attaque a distance du gardien 
	 */
	public void drawAttack() {
		if(time - lastShot > 21  && time - lastShot < 64 && lastShot != -1  && pZoneAttack != null){
			if((time - lastShot - 20) % 44  < 10  )
				StdDraw.picture(pZoneAttack.getX() + 0.01, pZoneAttack.getY() , "images/Tower/GuardianTower/GuardianAttackAnimation/0" + (time - lastShot  - 20) % 44 + ".png", (1.0/24.0) * 2 , (1.0/15.0) * 2 );
			else
				StdDraw.picture(pZoneAttack.getX() + 0.01, pZoneAttack.getY(), "images/Tower/GuardianTower/GuardianAttackAnimation/" + (time - lastShot  - 20)% 44 + ".png", (1.0/24.0) * 2, (1.0/15.0) * 2);
		} 
	}

	/**
	 * Le gardien ne peut pas etre am�liore
	 */
	public void upgrade(){}

	/**
	 * Mise a jour du gardien
	 * 
	 * Si un monstre est a portee du gardien alors target != null 
	 * NOTE :
	 * Nous avons rajouter une condition pour limiter les calcules de notre programme (sans impacter significativement le jeu)
	 * au lieux de s'executer a chaque update ces instructions s'executent toutes les 3 updates
	 */
	public void update(){
		time++;

		// Definit la postion de l'ataque lorsque (time - lastShot == 21)
		shot();

		// Inflige les degats de zones 
		damageZone();

		// Affiche la tour et les degats a distance qu'inflige le gardien  
		draw();
		drawAttack();

		if(time%3 == 0) target = activate();

		// Ajoute un repere chronologique qui permet de declencher les methodes lie a l'attaque du gardien
		if(canShot())
			lastShot = time;
	}

	/*
	 * Peut tirer
	 */
	public boolean canShot() {
		if( target != null  && lastShot == -1)
			return true ;
		else if(target != null && time - lastShot > cooldown )
			return true ;
		else
			return false ;
	}

	/**
	 * Calcul le monstre le plus proche 
	 * @return le monstre le plus proche a porté ou null si aucun monstre n'est a porté
	 */
	public Monster activate(){
		float distanceMin = (float) (range + 0.01);
		Monster closest = null;
		
		for(int i = 0 ; i < World.getMonsters().size() ; i++){
			float distance = p.dist(World.getMonsters().get(i).getP());
			if(distanceMin > distance && distance > rangeCantShoot) {
				distanceMin = distance; 
				closest = World.getMonsters().get(i);
			}
		} 
		if(distanceMin < range) {
			return closest;
		}
		else
			return null;
		
	}

	/**
	 * Tir sur le monstre en parametre 
	 */
	public void shot (){
		if(time - lastShot == 21 && target != null && lastShot != -1){
			pZoneAttack = new Position((float)(target.getP().getX() + 0.01) , target.getP().getY());
		}
	}

	/**
	 * Inflige des degat de zone
	 */
	public void damageZone (){
		if(time - lastShot > 20 && time - lastShot < 64 && lastShot != -1){

			// Inflige des degats de zones (attaque en 3 phase : a chaque sortie d'un pic du sol cela inflige des degats)
			if(time - lastShot == 22){
				for(Monster m : World.getMonsters()){
					// Parcours la liste de monstre et inflige des degats au monstre a portée 
					if(pZoneAttack != null && pZoneAttack.dist(m.getP()) <= rangeDamageZone  && !m.isFlying())
						m.hit(damage);
				}
			}
			
			if(time - lastShot == 30){
				for(Monster m : World.getMonsters()){
					if(pZoneAttack != null && pZoneAttack.dist(m.getP()) <= rangeDamageZone && !m.isFlying())
						m.hit(damage);
				}
			}

			// Lors de la dernière phase le pic etant le plus haut inflige plus de dégat et il peut toucher les monstres volants
			if(time - lastShot == 40){
				for(Monster m : World.getMonsters()){
					if(pZoneAttack != null &&pZoneAttack.dist(m.getP()) <= rangeDamageZone )
						m.hit(damage + 20 );
				}
			}
		}
	}

}

