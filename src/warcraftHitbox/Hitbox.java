package warcraftHitbox;

import warcraftMain.Position;

public class Hitbox {

    //bords de la hitBox 
	protected double leftSide;
	protected double rightSide;
	protected double topSide;
	protected double bottomSide;

	//taille de la hitbox 
	protected double size ;
	
	
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
    
    public Hitbox(Position p , double size){
        this.size = size ;
		leftSide = p.getX() - this.size;
		rightSide = p.getX() + this.size; 
		topSide = p.getY() + this.size;
		bottomSide = p.getY() - this.size;
    }

    public boolean hit(Hitbox h){
        return true;
    }
    
}
