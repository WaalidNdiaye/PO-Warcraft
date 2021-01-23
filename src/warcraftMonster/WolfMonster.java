package warcraftMonster;

import warcraftMain.Position;
import warcraftMain.StdDraw;
import warcraftMain.World;

public class WolfMonster extends Monster {

	/**
	 * Constructeur
	 * @param p position
	 */
	public WolfMonster (Position p) {
		super(p, (float)0.08, (float)0.0035, 145, 8, false);
		
		//Pour les vagues 3 et 5 la vie des WolfMonsters est egale a 145+(145/2)
		if(World.getCurrentW() == 3 || World.getCurrentW() == 5)
			life = 217;
		
		//Pour les vagues 6 et 7 la vie des LandMonsters est egale a 217+(217/2)
		if(World.getCurrentW() == 6 || World.getCurrentW() == 7)
			life = 325;
	}
	
	/**
	 * Affichage du monstre
	 */
	public void draw() {
		StdDraw.picture(p.getX(), p.getY(), "images/Monster/WolfMonsterAnimation/" + time%10 +  ".png", size * 0.6 , size);
	}
}
