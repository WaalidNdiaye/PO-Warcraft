package warcraftProjectile;
import warcraftMain.Position;
import warcraftMonster.*;
import warcraftMain.StdDraw;
import warcraftMain.World;


public class Bomb extends Projectile{
	
	private float explosiveRange = (float) 0.07;  								// Portee de l'explosion
	private int hitTime = -1;													// Heure de la colisition avec un monstre (si pas de colition alors -1)
	private Position explosivePosition ;										// Position de l'explosion
	
	/*
	 * CONSTRUCTEUR 
	 */
	public Bomb (Position p, Monster target) {
		super(60, (float)0.0035, false, p, target, (float)0.008);
	}
	
	/*
	 * Fonction d'affichage 
	 */
	public void draw() {
		StdDraw.picture(p.getX(), p.getY(), "images/Bomb.png", size , size);
	}

	/*
	 * Affiche une explosion a l'emplacement des monstres touché par l'explosion
	 */
	public void drawExplosion(){
		if (hitTime != -1  && (time - hitTime) < 24){
			if(time - hitTime < 10) StdDraw.picture(explosivePosition.getX() + 0.005 ,explosivePosition.getY()+ 0.005 , "images/Tower/BombExplosionAnimation/0" + (time - hitTime) + ".png", explosiveRange , explosiveRange );
			else StdDraw.picture(explosivePosition.getX() + 0.005 ,  explosivePosition.getY() + 0.005 , "images/Tower/BombExplosionAnimation/" + (time - hitTime) + ".png", explosiveRange, explosiveRange );
		}
	}

	/*
	 * Renvoi le temps restant avant de pouvoir detruire le projectile
	 */
	public int getTimeRemainig() {
		return time - hitTime - 24;
	}

	/*
	 * Ameliore les caracteristiques du projectile
	 */
	public void upgrade (){
		level++;
		damage += 1;
	}

	/*
	 * Mise a jour de la tour 
	 */
	public void update(){
		time++;

		if(!hit){
			move();
			hitbox.move(p);
			draw();

			// Verifie si le projectile a toucher sa cible 
			if(hitbox.hit(target.getHitbox())){
				target.hit(damage);

				// Parcours tout la liste de monstre pour trouver ceux a portée et leur infliger des degats 
				for (int i = 0 ; i < World.getMonsters().size() ; i++){
					if(explosiveRange(World.getMonsters().get(i))){
						World.getMonsters().get(i).hit(damage);
					}
				}
				hit = true;
				hitTime = time ;
				explosivePosition = new Position(target.getP());
			} 
		}
		else drawExplosion();
		
	}

	/*
	 * Verifie sur le monstre est a portée de l'explostion
	 */
	public boolean explosiveRange(Monster m){
		float AB = m.getP().getX() - getP().getX();
		float BC = m.getP().getY() - getP().getY();
		// Mesure la distance entre la cible et le monstre m (AC2 = AB2 + BC2)
		float distance = (float) (Math.sqrt ( Math.pow(AB, 2) + Math.pow(BC, 2)));

		// Si la distance est inferieur ou egale a la portée de l'explosion alors true, sinon false 
		if(distance <= explosiveRange) return true ;
		else return false ;
	}


}
