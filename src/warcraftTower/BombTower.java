package warcraftTower;
import warcraftMain.StdDraw;
import warcraftMain.World;


import warcraftMain.Position;

public class BombTower extends Tower{
	
	public BombTower(Position p) {
		super(60, 0.2, 20, false, p);
	}
	
	public void draw() {

		double x = p.getX() - (p.getX() % 0.04 );
		double y = p.getY() - (p.getY() % 0.06 );

		System.out.println("Bomb afficher au coordonées " + x + " " + y);
		StdDraw.setPenColor(StdDraw.BLUE);;
		StdDraw.rectangle(x, y, 0.3 , 0.2);
		
	}
	
	public void upgrade() {
		
	}

}
