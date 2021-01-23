package warcraftProjectile;
import warcraftMain.Position;
import warcraftMonster.*;
import warcraftMain.StdDraw;
import warcraftMain.World;


public class Bomb extends Projectile{
	
	private float explosiveRange = (float) 0.07;  								// Portee de l'explosion
	private int hitTime = -1;													// Heure de la colisition avec un monstre (si pas de colition alors -1)
	private Position explosivePosition ;										// Position de l'explosion
	
	/**
	 * Constructeur
	 * @param p position
	 * @param target cible visé par la bombe
	 */
	public Bomb (Position p, Monster target) {
		//La vitesse des fleches egale: vitesse de base des LandMonsters*2
		super(65, (float)0.005, false, p, target, (float)0.008);
	}
	
	/*
	 * Fonction d'affichage du projectile
	 */
	public void draw() {
		StdDraw.picture(p.getX(), p.getY(), "images/Tower/Bomb.png", size , size);
	}

	/**
	 * Affiche une explosion 
	 */
	public void drawExplosion(){
		if (hitTime != -1  && (time - hitTime) < 24){
			if(time - hitTime < 10)
				StdDraw.picture(explosivePosition.getX() + 0.005 ,explosivePosition.getY()+ 0.005 , "images/Tower/BombExplosionAnimation/0" + (time - hitTime) + ".png", explosiveRange , explosiveRange );
			else
				StdDraw.picture(explosivePosition.getX() + 0.005 ,  explosivePosition.getY() + 0.005 , "images/Tower/BombExplosionAnimation/" + (time - hitTime) + ".png", explosiveRange, explosiveRange );
		}
	}

	/**
	 * Renvoi le temps restant avant de pouvoir detruire le projectile
	 */
	public int getTimeRemainig() {
		return time - hitTime - 24;
	}

	/**
	 * Ameliore les caracteristiques du projectile
	 */
	public void upgrade (){
		level++;
		damage += 1;
	}

	/**
	 * Mise a jour du projectile
	 */
	public void update(){
		time++;

		if(!hit){
			move();
			draw();

			// Verifie si le projectile a toucher sa cible 
			if(hitbox.hit(target.getHitbox())){
				explosivePosition = new Position(target.getP());

				// Parcours tout la liste de monstre pour trouver ceux a portÃ©e et leur infliger des degats 
				for (int i = 0 ; i < World.getMonsters().size() ; i++){
					if(explosivePosition.dist(World.getMonsters().get(i).getP()) <= explosiveRange){
						World.getMonsters().get(i).hit(damage);
					}
				}
				hit = true;
				hitTime = time ;
				drawExplosion();
			} 
		}
		else
			drawExplosion();
	}

}
