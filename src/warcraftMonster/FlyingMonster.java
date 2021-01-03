package warcraftMonster;

import warcraftMain.Position;
import warcraftMain.StdDraw;

public class FlyingMonster extends Monster {
	
	public FlyingMonster (Position p) {
		super(p , (float)0.05 , (float)0.003, 3, 8);
		this.flying = true;
	}
	
	public void draw() {
		if(time >= 16) time = 0;
		if(time >= 0 && time < 2) StdDraw.picture(p.getX(), p.getY(), "images/Monster/FlyingMonsterAnimation/" + 1 +  ".png", size * 2, size * 2.5);
		if(time >= 2 && time < 4) StdDraw.picture(p.getX(), p.getY(), "images/Monster/FlyingMonsterAnimation/" + 2 +  ".png", size * 2, size * 2.5);
		if(time >= 4 && time < 6) StdDraw.picture(p.getX(), p.getY(), "images/Monster/FlyingMonsterAnimation/" + 3 +  ".png", size * 2, size * 2.5);
		if(time >= 6 && time < 8) StdDraw.picture(p.getX(), p.getY(), "images/Monster/FlyingMonsterAnimation/" + 4 +  ".png", size * 2, size * 2.5);
		if(time >= 8 && time < 10) StdDraw.picture(p.getX(), p.getY(), "images/Monster/FlyingMonsterAnimation/" + 5 +  ".png", size * 2, size * 2.5);
		if(time >= 10 && time < 12) StdDraw.picture(p.getX(), p.getY(), "images/Monster/FlyingMonsterAnimation/" + 6 +  ".png", size * 2, size * 2.5);
		if(time >= 12 && time < 14) StdDraw.picture(p.getX(), p.getY(), "images/Monster/FlyingMonsterAnimation/" + 7 +  ".png", size * 2, size * 2.5); 
		if(time >= 14 && time < 16) StdDraw.picture(p.getX(), p.getY(), "images/Monster/FlyingMonsterAnimation/" + 8 +  ".png", size * 2, size * 2.5);
		
		
		time++;
	}

}
