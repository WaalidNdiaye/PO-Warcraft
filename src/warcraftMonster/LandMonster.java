package warcraftMonster;

import warcraftMain.Position;
import warcraftMain.StdDraw;

public class LandMonster extends Monster {

	public LandMonster (Position p) {
		super(p , (float)0.06 , (float)0.002 , 5 , 5);
	}
	
	public void draw() {
		if(time > 24) time = 0;
		if(time == 0) StdDraw.picture(p.getX(), p.getY(), "images/Monster/LandMonsterAnimation/0" + time +  ".png", size * 0.7 , size);
		if(time == 1) StdDraw.picture(p.getX(), p.getY(), "images/Monster/LandMonsterAnimation/0" + time +  ".png", size * 0.7 , size);
		if(time == 2) StdDraw.picture(p.getX(), p.getY(), "images/Monster/LandMonsterAnimation/0" + time +  ".png", size * 0.7 , size);
		if(time == 3) StdDraw.picture(p.getX(), p.getY(), "images/Monster/LandMonsterAnimation/0" + time +  ".png", size * 0.7 , size);
		if(time == 4) StdDraw.picture(p.getX(), p.getY(), "images/Monster/LandMonsterAnimation/0" + time +  ".png", size * 0.7 , size);
		if(time == 5) StdDraw.picture(p.getX(), p.getY(), "images/Monster/LandMonsterAnimation/0" + time +  ".png", size * 0.7 , size);
		if(time == 6) StdDraw.picture(p.getX(), p.getY(), "images/Monster/LandMonsterAnimation/0" + time +  ".png", size * 0.7 , size); 
		if(time == 7) StdDraw.picture(p.getX(), p.getY(), "images/Monster/LandMonsterAnimation/0" + time +  ".png", size * 0.7 , size);
		if(time == 8) StdDraw.picture(p.getX(), p.getY(), "images/Monster/LandMonsterAnimation/0" + time +  ".png", size * 0.7 , size);
		if(time == 9) StdDraw.picture(p.getX(), p.getY(), "images/Monster/LandMonsterAnimation/0" + time +  ".png", size * 0.7 , size);
		if(time == 10) StdDraw.picture(p.getX(), p.getY(), "images/Monster/LandMonsterAnimation/" + time +  ".png", size * 0.7 , size);
		if(time == 11) StdDraw.picture(p.getX(), p.getY(), "images/Monster/LandMonsterAnimation/" + time +  ".png", size * 0.7 , size);
		if(time == 12) StdDraw.picture(p.getX(), p.getY(), "images/Monster/LandMonsterAnimation/" + time +  ".png", size * 0.7 , size);
		if(time == 13) StdDraw.picture(p.getX(), p.getY(), "images/Monster/LandMonsterAnimation/" + time +  ".png", size * 0.7 , size);
		if(time == 14) StdDraw.picture(p.getX(), p.getY(), "images/Monster/LandMonsterAnimation/" + time +  ".png", size * 0.7 , size);
		if(time == 15) StdDraw.picture(p.getX(), p.getY(), "images/Monster/LandMonsterAnimation/" + time +  ".png", size * 0.7 , size);
		if(time == 16) StdDraw.picture(p.getX(), p.getY(), "images/Monster/LandMonsterAnimation/" + time +  ".png", size * 0.7 , size); 
		if(time == 17) StdDraw.picture(p.getX(), p.getY(), "images/Monster/LandMonsterAnimation/" + time +  ".png", size * 0.7 , size);
		if(time == 18) StdDraw.picture(p.getX(), p.getY(), "images/Monster/LandMonsterAnimation/" + time +  ".png", size * 0.7 , size);
		if(time == 19) StdDraw.picture(p.getX(), p.getY(), "images/Monster/LandMonsterAnimation/" + time +  ".png", size * 0.7 , size);
		if(time == 20) StdDraw.picture(p.getX(), p.getY(), "images/Monster/LandMonsterAnimation/" + time +  ".png", size * 0.7 , size);
		if(time == 21) StdDraw.picture(p.getX(), p.getY(), "images/Monster/LandMonsterAnimation/" + time +  ".png", size * 0.7 , size);
		if(time == 22) StdDraw.picture(p.getX(), p.getY(), "images/Monster/LandMonsterAnimation/" + time +  ".png", size * 0.7 , size);
		if(time == 23) StdDraw.picture(p.getX(), p.getY(), "images/Monster/LandMonsterAnimation/" + time +  ".png", size * 0.7 , size);
		if(time == 24) StdDraw.picture(p.getX(), p.getY(), "images/Monster/LandMonsterAnimation/" + time +  ".png", size * 0.7 , size); 
		time++;
	}
}
