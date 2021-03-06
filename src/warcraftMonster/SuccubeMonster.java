package warcraftMonster;

import warcraftMain.Position;
import warcraftMain.StdDraw;
import warcraftMain.World;

public class SuccubeMonster extends Monster {
	
	/**
	 * Constructeur
	 * @param p position
	 */
	public SuccubeMonster (Position p) {
		super(p , (float)0.04 , (float)0.0030, 110, 5, true);
		
		//Pour les vagues 3 et 5 la vie des FlyingMonsters est egale a 110+(110/2)
		//Pour les vagues 3 et 5 la vitesse des FlyingMonsters est egale a 0.0030+(0.0030/5)
		if(World.getCurrentW() == 3 || World.getCurrentW() == 5) {
			life = 165;
			speed = (float)0.0036;
		}
		
		//Pour les vagues 6 et 7 la vie des FlyingMonsters est egale a 165+(165/2)
		//Pour les vagues 3 et 5 la vitesse des FlyingMonsters est egale a 0.0036+(0.0036/5)
		if(World.getCurrentW() == 6 || World.getCurrentW() == 7) {
			life = 247;
			speed = (float)0.0043;
		}
	}
	
	/**
	 * Affichage du monstre
	 */
	public void draw() {

		if(time % 40 < 10) StdDraw.picture(p.getX(), p.getY() + 0.02, "images/Monster/FlyingMonsterAnimation/0" + time%40 +  ".png", size*2 , size*2.5);
		if(time % 40 >= 10) StdDraw.picture(p.getX(), p.getY()  + 0.02, "images/Monster/FlyingMonsterAnimation/" + time%40 +  ".png", size*2 , size*2.5);
	}
}
