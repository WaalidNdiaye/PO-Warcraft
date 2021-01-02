package warcraftProjectile;
import warcraftMain.Position;
import warcraftMonster.*;
import warcraftMain.StdDraw;
import warcraftMain.World;


public class Bomb extends Projectile{
	
	private float explosiveRange = (float) 0.01;  								// Portee de l'explosion

	public Bomb (Position p, Monster target) {
		super(8, (float)0.003, false, p, target, (float)0.03);
	}
	
	public void draw() {
		StdDraw.picture(p.getX(), p.getY(), "images/Bomb.png", size , size);
	}

	//ameliore les caracteristiques du projectile
	public void upgrade (){
		level++;
		damage += 1;
	}

	public void update(){
		move();
		hitbox.move(p);
		draw();
		
		// Verifie si le projectile a toucher sa cible 
		if(hitbox.hit(target.getHitbox())){
			target.hit(damage);

			// Parcours tout la liste de monstre pour trouver ceux a portée et leur infliger des degats 
			for (int i = 0 ; i < World.getMonsters().size() ; i++){
				if(explosiveRange(World.getMonsters().get(i))) World.getMonsters().get(i).hit(damage);
				// Affiche une explosion a l'emplacement des monstres touché par l'explosion 
				StdDraw.picture(World.getMonsters().get(i).getP().getX(),World.getMonsters().get(i).getP().getY(), "images/Explosion.png", size + 0.02 , size + 0.02);
			}

			hit = true;
			StdDraw.picture(target.getP().getX(),target.getP().getY(), "images/Explosion.png", size + 0.02 , size + 0.02);
		} 
	}

	//Verifie sur le monstre est a portée de l'explostion
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
