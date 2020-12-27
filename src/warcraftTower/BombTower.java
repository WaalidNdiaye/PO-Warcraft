package warcraftTower;
import warcraftMain.StdDraw;
import warcraftMain.World;


import warcraftMain.Position;

public class BombTower extends Tower{
	
	public BombTower(Position p) {
		super(60, 0.2, 20, false, p);
	}
	
	public void draw() {

		StdDraw.picture(p.getX() , p.getY(), "images/BombTower.png", (1.0/24.0) , (1.0/15.0) );
		
	}
	
	public void upgrade() {
		
	}

}
