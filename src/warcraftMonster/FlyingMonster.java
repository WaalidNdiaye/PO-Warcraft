package warcraftMonster;

import warcraftMain.Position;
import warcraftMain.StdDraw;

public class FlyingMonster extends Monster {
	
	public FlyingMonster (Position p) {
		super(p , (float)0.03 , (float)0.001, 3, 8);
		this.flying = true;
	}
	
	public void draw() {
		if(time > 8) time = 0;
		if(time == 0) StdDraw.picture(p.getX(), p.getY(), "images/Monster/FlyingMonsterAnimated/" + time +  ".png", size * 0.7 , size);
		if(time == 1) StdDraw.picture(p.getX(), p.getY(), "images/Monster/FlyingMonsterAnimated/" + time +  ".png", size * 0.7 , size);
		if(time == 2) StdDraw.picture(p.getX(), p.getY(), "images/Monster/FlyingMonsterAnimated/" + time +  ".png", size * 0.7 , size);
		if(time == 3) StdDraw.picture(p.getX(), p.getY(), "images/Monster/FlyingMonsterAnimated/" + time +  ".png", size * 0.7 , size);
		if(time == 4) StdDraw.picture(p.getX(), p.getY(), "images/Monster/FlyingMonsterAnimated/" + time +  ".png", size * 0.7 , size);
		if(time == 5) StdDraw.picture(p.getX(), p.getY(), "images/Monster/FlyingMonsterAnimated/" + time +  ".png", size * 0.7 , size);
		if(time == 6) StdDraw.picture(p.getX(), p.getY(), "images/Monster/FlyingMonsterAnimated/" + time +  ".png", size * 0.7 , size); 
		if(time == 7) StdDraw.picture(p.getX(), p.getY(), "images/Monster/FlyingMonsterAnimated/" + time +  ".png", size * 0.7 , size);
		if(time == 8) StdDraw.picture(p.getX(), p.getY(), "images/Monster/FlyingMonsterAnimated/" + time +  ".png", size * 0.7 , size);
		
		time++;
	}

}
