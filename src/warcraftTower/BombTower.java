package warcraftTower;

import warcraftMain.StdDraw;
import warcraftMain.World;
import warcraftMonster.*;
import java.util.ArrayList;
import warcraftMain.Position;
import warcraftProjectile.Bomb;

public class BombTower extends Tower {

	private ArrayList<Bomb> bomb = new ArrayList<Bomb>(); // Liste des projectiles (en mouvement) tiré par cette tour

	/*
	 * GETTERS AND SETTERS
	 */
	public ArrayList<Bomb> getBomb() {
		return bomb;
	}
	public void setBomb(ArrayList<Bomb> bomb) {
		this.bomb = bomb;
	}

	/*
	 * CONSTRUCTEUR
	 */
	public BombTower(Position p) {
		super(55, (float) 0.15, 45, false, p);
		System.out.println("\n--- Nouvelle mortier creer!---");
	}

	/*
	 * Fonction d'affichage
	 */
	public void draw() {
		if (level == 1)
			StdDraw.picture(getP().getX(), getP().getY(), "images/Tower/Bomb Tower Level 1.png", (1.0 / 24.0),
					(1.0 / 15.0));
		else if (level == 2)
			StdDraw.picture(getP().getX(), getP().getY(), "images/Tower/Bomb Tower Level 2.png", (1.0 / 24.0),
					(1.0 / 15.0));

		// Affiche l'animation au dessus de la tour
		if (time % 12 < 10)
			StdDraw.picture(getP().getX(), getP().getY() + 0.03,
					"images/Tower/BombTowerAnimation/0" + time % 12 + ".png", (1.0 / 24.0) / 1.5, (1.0 / 15.0) / 1.5);
		else
			StdDraw.picture(getP().getX(), getP().getY() + 0.03,
					"images/Tower/BombTowerAnimation/" + time % 12 + ".png", (1.0 / 24.0) / 1.5, (1.0 / 15.0) / 1.5);
	}

	/*
	 * Amelioration de la tour
	 */
	public void upgrade() {
		if (level < levelMax) {
			level++;
			range += 0.02;
			cooldown -= 2;
			upgradeCost = upgradeCost * 2;
		} else
			System.out.println("Cet tour est deja au niveau max !");
	}

	/*
	 * Mise a jour de la tour
	 */
	public void update() {
		time++;
		draw();

		// Si un monstre est a portée de la tour alors target != null (ce if() sert a reduire les calcules pour des questions de performance)
		if (time % 3 == 0)
			target = activate();

		if(time - lastShot > cooldown ) canShot = true ;
		else canShot = false ;

		// Si un monstre est porté et que l'on est pas en cooldown
		if (target != null && canShot && !target.isFlying())
			shot(target);

		// Suprime le projectile si il a été tué entre temps
		for (int i = 0; i < bomb.size(); i++)
			if (bomb.get(i).getTarget().getLife() <= 0 && bomb.get(i).getTimeRemainig() > 24)
				bomb.remove(bomb.get(i));

		// Suprime le prjectile s'il a dépassé la potée de la tour
		for (int i = 0; i < bomb.size(); i++) if(p.dist(bomb.get(i).getP()) > range) bomb.remove(bomb.get(i));

		// Suprime le projectile si il a touché un monstre et qu'il a pu afficher un explosion
		for (int i = 0; i < bomb.size(); i++) {
			if (bomb.get(i).getHit() && bomb.get(i).getTimeRemainig() > 0)
				bomb.remove(bomb.get(i));
		}

		// Met a jour les projectiles
		for (int i = 0; i < bomb.size(); i++) bomb.get(i).update();
	}

	/**
	 * Calcul le monstre le plus proche
	 * @return le monstre le plus proche a porté ou null si aucun monstre n'est a porté
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
		else return null;

	}

	/*
	 * Tir un projectile sur le monstre en parametre
	 */
	public void shot(Monster monster) {
		Position pProjectile = new Position(getP().getX(), (float) (getP().getY() + 0.03));
		bomb.add(new Bomb(pProjectile, monster));
		lastShot = time ; 
	}

}
