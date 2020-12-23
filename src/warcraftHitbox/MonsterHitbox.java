package warcraftHitbox;

import warcraftMain.Position;

public class MonsterHitbox extends Hitbox {
	
	
	public MonsterHitbox(Position p , double size) {
		super(p , size);
	}
	
	public boolean hit (double x , double y) {
		//renvoi true si la position (x,y) est contenue dans la hitbox 
		if(x < leftSide || x > rightSide) return false ;
		else if(y < bottomSide || y > topSide) return false ;
		else return true ;
	}

	public void move(Position p){
		//met a jour la position de la hitbox
		leftSide = p.getX() - this.size;
		rightSide = p.getX() + this.size; 
		topSide = p.getY() + this.size;
		bottomSide = p.getY() - this.size;
	}

}
