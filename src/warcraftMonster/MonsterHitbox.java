package warcraftMonster;
import warcraftMain.Position;

public class MonsterHitbox {
	
	//bords de la hitBox 
	private double leftSide;
	private double rightSide;
	private double topSide;
	private double bottomSide;
	
	
	public double getLeftSide() {
		return leftSide;
	}
	public void setLeftSide(double leftSide) {
		this.leftSide = leftSide;
	}
	public double getRightSide() {
		return rightSide;
	}
	public void setRightSide(double rightSide) {
		this.rightSide = rightSide;
	}
	public double getTopSide() {
		return topSide;
	}
	public void setTopSide(double topSide) {
		this.topSide = topSide;
	}
	public double getBottomSide() {
		return bottomSide;
	}
	public void setBottomSide(double bottomSide) {
		this.bottomSide = bottomSide;
	}

	
	
	public MonsterHitbox(Position p , double size) {
		//Size est la taille du monstre 
		leftSide = p.getX() - size;
		rightSide = p.getX() + size; 
		topSide = p.getY() + size;
		bottomSide = p.getY() - size;
	}
	
	public boolean hit (double x , double y) {
		//renvoi true si la position (x,y) est contenue dans la hitbox 
		if(x < leftSide || x > rightSide) return false ;
		else if(y < bottomSide || y > topSide) return false ;
		else return true ;
	}

}
