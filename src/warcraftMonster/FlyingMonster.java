package warcraftMonster;

import warcraftMain.Position;
import warcraftMain.StdDraw;
import warcraftMain.World;

public class FlyingMonster extends Monster {
	
	public FlyingMonster (Position p) {
		super(p , (float)0.04 , (float)0.004275, 110, 5, true);
		//Pour les vagues 3 et 5 la vie des FlyingMonsters est egale a 110+(110/2)
		//Pour les vagues 3 et 5 la vitesse des FlyingMonsters est egale a 0.004275+(0.004275/5)
		if(World.getCurrentW() == 3 || World.getCurrentW() == 5) {
			life = 165;
			speed = (float)0.005130;
		}
		//Pour les vagues 6 et 7 la vie des FlyingMonsters est egale a 165+(165/2)
		//Pour les vagues 3 et 5 la vitesse des FlyingMonsters est egale a 0.005130+(0.005130/5)
		if(World.getCurrentW() == 6 || World.getCurrentW() == 7) {
			life = 247;
			speed = (float)0.006156;
		}
	}
	
	// Affichage du monstre 
	public void draw() {
		StdDraw.picture(p.getX(), p.getY(), "images/Monster/FlyingMonsterAnimation/" + time % 9 +  ".png", size * 2, size * 2.5);
	}
}
