package warcraftTower;

import warcraftMain.StdDraw;
import warcraftMain.World;
import java.util.ArrayList;
import warcraftMonster.*;
import warcraftProjectile.Arrow;
import warcraftMain.Position;

public class ArcheryTower extends Tower {

	private ArrayList<Arrow> arrow = new ArrayList<Arrow>();

	public ArrayList<Arrow> getArrow() {
		return arrow;
	}
	public void setArrow(ArrayList<Arrow> arrow) {
		this.arrow = arrow;
	}

	public ArcheryTower(Position p) {
		super(25, (float)0.2, 30, true, p);
		System.out.println("\n--- Nouvelle tour d'archer creer!---");
	}
	
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
	
	//Amelioration de la tour
	public void upgrade() {
		if(level < levelMax){
			level++;
			range += 0.01;
			cooldown -= 3;
			upgradeCost = upgradeCost * 2;
		}
		else System.out.println("Cet tour est deja au niveau max !");
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

	public void update(){
		time++;
		// Si le tir est charcher alors shoot (time = 18)
		shoot(); 
		draw();
		// Si un monstre est a portée de la tour alors m != null
		Monster m = activate();
		if( m != null){ 
			if(time % cooldown == 0 ) loadingShoot(m);
		}
		// Met a jour les projectiles
		for(int i = 0 ; i < arrow.size() ; i++ ) if(arrow.get(i).getHit()) arrow.remove(arrow.get(i));
		for(int i = 0 ; i < arrow.size() ; i++ ) arrow.get(i).update();
	}

	// Charge un tir et tire lorsque (time - lastShoot) == 18 
	public void loadingShoot(Monster monster){
		target = monster ;
		lastShot = time ; 
	}
	public void shoot (){
		if((time - lastShot) == 11 && lastShot != -1){
			Position pProjectile = new Position(getP().getX(), (float) (getP().getY() + 0.03));
			arrow.add(new Arrow(pProjectile, target));
		}

	}

}

