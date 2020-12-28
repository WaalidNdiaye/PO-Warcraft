package warcraftTower;

import warcraftMain.StdDraw;
import warcraftMonster.*;
import java.util.ArrayList;
import warcraftMain.Position;

public class BombTower extends Tower{
	
	public BombTower(Position p) {
		super(60, 0.2, 20, false, p);
	}
	
	public void draw() {
		StdDraw.picture(getP().getX() , getP().getY(), "images/BombTower.png", (1.0/24.0) , (1.0/15.0) );
	}

	public void activate(ArrayList <Monster> monsters){
		for(int i = 0 ; i < monsters.size() ; i++){

			double AB = monsters.get(i).getP().getX() - getP().getX();
			double BC = monsters.get(i).getP().getY()  - getP().getY();
			// Mesure la distance entre la tour et le monstre (AC2 = AB2 + BC2)
			double distance = Math.sqrt ( Math.pow(AB, 2) + Math.pow(BC, 2) );
			if(distance < range && !monsters.get(i).isFlying());
			
		} 
	}
	public void update(ArrayList <Monster> monsters){
		draw();
		activate(monsters);

	}
	
	public void upgrade() {
		
	}

}
