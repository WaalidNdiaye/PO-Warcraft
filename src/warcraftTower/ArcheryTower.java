package warcraftTower;

import warcraftMain.StdDraw;
import warcraftMain.World;
import java.util.ArrayList;
import warcraftMonster.*;
import warcraftProjectile.Arrow;
import warcraftMain.Position;

public class ArcheryTower extends Tower {

	private ArrayList<Arrow> arrow = new ArrayList<Arrow>();					// Liste des projectiles tiré (en mouvement) par cette tour 

	/**
	 * Getters and Setters
	 */
	public ArrayList<Arrow> getArrow() {
		return arrow;
	}
	public void setArrow(ArrayList<Arrow> arrow) {
		this.arrow = arrow;
	}

	/**
	 * Constructeur d'un gardien archer
	 * @param p position
	 */
	public ArcheryTower(Position p) {
		super(30, (float)0.2, 30, true, p);
		System.out.println("\n--- Nouvelle tour d'archer creer!---");
	}
	
	/**
	 * Fonction d'affichage
	 * 	- Condition onBuild renseigne si le defenseur est sur un batiment ou non (influe sur l'affichage)
	 */
	public void draw() {
		// Hauteur a rajouter pour l'affichage du defenceur 
		float heigth;
		
		if(onBuild)
			heigth = (float) 0.03;
		else
			heigth = (float) 0.01;

		// Affiche Archer qui attend
		if((time - lastShot) > 18 || (time - lastShot) < 0){
			if(time % 25 < 10)
				StdDraw.picture(getP().getX() + 0.004, getP().getY() + heigth, "images/Tower/ArcheryTower/Level" + level + "/ArcherWait/0" + time % 25+ ".png", (1.0/24.0) * 1.5 , (1.0/15.0)  * 1.5 );
			else
				StdDraw.picture(getP().getX() + 0.004, getP().getY() + heigth, "images/Tower/ArcheryTower/Level" + level + "/ArcherWait/" + time % 25+ ".png", (1.0/24.0) * 1.5 , (1.0/15.0) * 1.5 );
		}
		
		// Affiche une animation d'archer qui tir 
		if(target != null){
			for(int i = 0 ; i < 23 ; i++) {
				
				// Afiche l'animation de tir en fonction de la position de la cible par rapport a la tour (a gauche ou a droite)
				if( (target.getP().getX() - p.getX()) >= 0 ){
					if((time - lastShot) == i && (i < 10))
						StdDraw.picture(getP().getX() + 0.004, getP().getY() + heigth, "images/Tower/ArcheryTower/Level" + level + "/ArcherShotRightSide/0" + i + ".png", (1.0/24.0) * 1.5, (1.0/15.0) * 1.5);
					if((time - lastShot) == i && (i > 9) )
						StdDraw.picture(getP().getX() + 0.004, getP().getY() + heigth, "images/Tower/ArcheryTower/Level" + level + "/ArcherShotRightSide/" + i + ".png", (1.0/24.0) * 1.5, (1.0/15.0) );
				}
				
				else{
					if((time - lastShot) == i && (i < 10))
						StdDraw.picture(getP().getX() + 0.004, getP().getY() + heigth, "images/Tower/ArcheryTower/Level" + level + "/ArcherShotLeftSide/0" + i + ".png", (1.0/24.0) * 1.5, (1.0/15.0) * 1.5 );
					if((time - lastShot) == i && (i > 9) )
						StdDraw.picture(getP().getX() + 0.004, getP().getY() + heigth, "images/Tower/ArcheryTower/Level" + level + "/ArcherShotLeftSide/" + i + ".png", (1.0/24.0) * 1.5, (1.0/15.0) * 1.5);
				}
			}
		}

		// Affichage d'une animation representent le niveau du defenceur 
		if(level == 1)
			StdDraw.picture(getP().getX() + 0.002, getP().getY() + 0.025 + heigth, "images/Tower/LevelAnimation/" + time%6 + ".png", (1.0/24.0) * 0.5, (1.0/15.0) * 0.5 );
		if(level == 2) {
			StdDraw.picture(getP().getX() - 0.0035, getP().getY() + 0.025 + heigth, "images/Tower/LevelAnimation/" + time%6 + ".png", (1.0/24.0) * 0.5, (1.0/15.0) * 0.5 );
			StdDraw.picture(getP().getX() + 0.0075, getP().getY() + 0.025 + heigth, "images/Tower/LevelAnimation/" + time%6 + ".png", (1.0/24.0) * 0.5, (1.0/15.0) * 0.5 );
		}
	}
	
	/**
	 * Amelioration du gardien
	 */
	public void upgrade() {
		if(level < levelMax){
			level++;
			range += 0.05;
			cooldown -= 5;
			upgradeCost = upgradeCost * 2;
		}else
			System.out.println("Cet tour est deja au niveau max !");
	}

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

		if(time - lastShot > cooldown )
			canShot = true;
		else
			canShot = false;

		// Si le tir est charger alors shoot 
		shot(); 
		draw();

		if( time % 3 == 0)
			target = activate();
		
		// Si un monstre est porte et que le cooldown est recharge
		if( target != null && canShot)
			loadingShoot(target);

		// Suprime le projectile si il a ete tue entre temps
		for (int i = 0; i < arrow.size(); i++)
			if (arrow.get(i).getTarget().getLife() <= 0)
				arrow.remove(arrow.get(i));

		// Suprime le prjectile s'il a depasse la potee de la tour
		for (int i = 0; i < arrow.size(); i++)
			if(p.dist(arrow.get(i).getP()) > range)
				arrow.remove(arrow.get(i));

		// Suprime le projectile si il a touche un monstre 
		for(int i = 0 ; i < arrow.size() ; i++)
			if(arrow.get(i).getHit())
				arrow.remove(arrow.get(i));

		// Met a jour les projectiles
		for(int i = 0 ; i < arrow.size() ; i++)
			arrow.get(i).update();
	}

	
	/**
	 * Calcul le monstre le plus proche 
	 * @return le monstre le plus proche a porte ou null si aucun monstre n'est a porté
	 */
	public Monster activate(){
		float distanceMin = (float) (range + 0.025);
		Monster closest = null;
		
		for(int i = 0 ; i < World.getMonsters().size() ; i++){
			float distance = p.dist(World.getMonsters().get(i).getP());
			if(distanceMin > distance) {
				distanceMin = distance; 
				closest = World.getMonsters().get(i);
			}
		} 
		if(distanceMin < range)
			return closest;
		else
			return null;
		
	}

	/*
	 * Charge un tir et tir 
	 */
	public void loadingShoot(Monster monster){
		target = monster ;
		lastShot = time ; 
	}

	/**
	 * Tir un projectile lorsque le projectil est charger 
	 */
	public void shot (){
		if(target != null && (time - lastShot) == 19 && lastShot != -1){
			Position pProjectile = new Position(getP().getX(), (float) (getP().getY() + 0.04));
			arrow.add(new Arrow(pProjectile, target));
		}
	}

}

