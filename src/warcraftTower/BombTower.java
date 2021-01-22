package warcraftTower;

import warcraftMain.StdDraw;
import warcraftMain.World;
import warcraftMonster.*;
import java.util.ArrayList;
import warcraftMain.Position;
import warcraftProjectile.Bomb;

public class BombTower extends Tower {

	private ArrayList<Bomb> bomb = new ArrayList<Bomb>(); // Liste des projectiles (en mouvement) tiré par cette tour

	/**
	 * Getters and Setters
	 */
	public ArrayList<Bomb> getBomb() {
		return bomb;
	}
	public void setBomb(ArrayList<Bomb> bomb) {
		this.bomb = bomb;
	}

	/**
	 * Constructeur d'un gardien bombardier
	 * @param p position
	 */
	public BombTower(Position p) {
		super(55, (float) 0.15, 50, false, p);
		System.out.println("\n--- Nouvelle mortier creer!---");
	}

	/**
	 * Fonction d'affichage
	 * 	- Condition onBuild renseigne si le defenseur est sur un batiment ou non (influe sur l'affichage)
	 */
	public void draw() {
		// Hauteur a rajouter pour l'affichage du defenceur 
		float heigth ;
		
		if(onBuild)
			heigth = (float) 0.015 ;
		else
			heigth = (float) 0 ;

		// Affiche l'animation du "bombardier" (en fonction de s'il est sur un batiment ou non)
		if (time % 12 < 10)
			StdDraw.picture(getP().getX(), getP().getY() + heigth, "images/Tower/BombTowerAnimation/0" + time % 12 + ".png", (1.0 / 24.0) / 1.5, (1.0 / 15.0) / 1.5);
		else
			StdDraw.picture(getP().getX(), getP().getY() + heigth,"images/Tower/BombTowerAnimation/" + time % 12 + ".png", (1.0 / 24.0) / 1.5, (1.0 / 15.0) / 1.5);
		
		// Affichage d'une animation representent le niveau du defenceur 
		if(level == 1)
			StdDraw.picture(getP().getX() , getP().getY() + 0.04 + heigth , "images/Tower/LevelAnimation/" + time%6 + ".png", (1.0/24.0) * 0.5, (1.0/15.0) * 0.4 );
		if(level == 2) {
			StdDraw.picture(getP().getX() + 0.0045, getP().getY() + 0.04 + heigth, "images/Tower/LevelAnimation/" + time%6 + ".png", (1.0/24.0) * 0.5, (1.0/15.0) * 0.4 );
			StdDraw.picture(getP().getX() - 0.0045, getP().getY() + 0.04 + heigth, "images/Tower/LevelAnimation/" + time%6 + ".png", (1.0/24.0) * 0.5, (1.0/15.0) * 0.4 );
		}
	}

	/**
	 * Amelioration du gardien
	 */
	public void upgrade() {
		if (level < levelMax) {
			level++;
			range += 0.03;
			cooldown -= 6;
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
	public void update() {
		time++;
		draw();

		if (time % 3 == 0)
			target = activate();

		if(time - lastShot > cooldown )
			canShot = true ;
		else
			canShot = false ;

		// Si un monstre est porte et que l'on est pas en cooldown
		if (target != null && canShot && !target.isFlying())
			shot();

		// Suprime le projectile si il a ete tue entre temps
		for (int i = 0; i < bomb.size(); i++)
			if (bomb.get(i).getTarget().getLife() <= 0 && bomb.get(i).getTimeRemainig() > 24)
				bomb.remove(bomb.get(i));

		// Suprime le prjectile s'il a depasse la potee de la tour
		for (int i = 0; i < bomb.size(); i++)
			if(p.dist(bomb.get(i).getP()) > range)
				bomb.remove(bomb.get(i));

		// Suprime le projectile si il a touche un monstre et qu'il a pu afficher un explosion
		for (int i = 0; i < bomb.size(); i++) {
			if (bomb.get(i).getHit() && bomb.get(i).getTimeRemainig() > 0)
				bomb.remove(bomb.get(i));
		}

		// Met a jour les projectiles
		for (int i = 0; i < bomb.size(); i++)
			bomb.get(i).update();
	}

	/**
	 * Calcul le monstre le plus proche
	 * @return le monstre le plus proche a porte ou null si aucun monstre n'est a porté
	 */
	public Monster activate() {
		float distanceMin = (float) (range + 0.01);
		Monster closest = null;
		
		for (int i = 0; i < World.getMonsters().size(); i++) {
			float distance = p.dist(World.getMonsters().get(i).getP());
			if (distanceMin > distance) {
				distanceMin = distance;
				closest = World.getMonsters().get(i);
			}
		}
		if (distanceMin < range) {
			return closest;
		} 
		else
			return null;

	}

	/**
	 * Tir un projectile sur le monstre en parametre
	 */
	public void shot() {
		Position pProjectile = new Position(getP().getX(), (float) (getP().getY() + 0.03));
		bomb.add(new Bomb(pProjectile, target));
		lastShot = time ; 
	}

}
