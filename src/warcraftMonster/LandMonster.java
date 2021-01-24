package warcraftMonster;

import warcraftMain.Position;
import warcraftMain.StdDraw;
import warcraftMain.World;

public class LandMonster extends Monster {

	/**
	 * Constructeur
	 * @param p position
	 */
	public LandMonster (Position p) {
		super(p , (float)0.055 , (float)0.0025, 125, 3, false);
		
		//Pour les vagues 3 et 5 la vie des LandMonsters est egale a 125+(125/2)
		//Pour les vagues 3 et 5 la vitesse des LandMonsters est egale a 0.0025+(0.0025/5)
		if(World.getCurrentW() == 3 || World.getCurrentW() == 5) {
			life = 187;
			speed = (float)0.0030;
		}
		
		//Pour les vagues 6 et 7 la vie des LandMonsters est egale a 187+(187/2)
		//Pour les vagues 6 et 7 la vitesse des LandMonsters est egale a 0.0030+(0.0030/5)
		if(World.getCurrentW() == 6 || World.getCurrentW() == 7) {
			life = 280;
			speed = (float)0.0036;
		}
	}
	
	/**
	 * Affichage du monstre 
	 */
	public void draw() {
		if(time % 25 < 10) StdDraw.picture(p.getX(), p.getY() + 0.04, "images/Monster/LandMonsterAnimation/0" + time%25 +  ".png", size * 0.6 , size);
		if(time % 25 >= 10) StdDraw.picture(p.getX(), p.getY() + 0.04, "images/Monster/LandMonsterAnimation/" + time%25 +  ".png", size * 0.6 , size);
	}
	
}
