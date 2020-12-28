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
		leftSide = p.getX() - (this.size / 2);
		rightSide = p.getX() + (this.size / 2); 
		topSide = p.getY() + (this.size / 2);
		bottomSide = p.getY() - (this.size /2);
    }

	//Renvoi true si les deux hitboxs se touche sinon renvoi false  
    public boolean hit(Hitbox h){
		System.out.println("Bord : " + this.getLeftSide() +","+ this.getRightSide() +","+ this.getBottomSide()  +","+ this.getTopSide());
		System.out.println("Bord : " + h.getLeftSide() +","+ h.getRightSide() +","+ h.getBottomSide()  +","+ h.getTopSide());
		if(this.getLeftSide() > h.getRightSide()) return false;
		else if(this.getRightSide() < h.getLeftSide()) return false ;
		else if(this.getBottomSide() > h.getTopSide()) return false;
		else if(this.getTopSide() < h.getBottomSide()) return false ;
		else return true ;
	}
	
	//Met a jour la position de la hitbox
	public void move(Position p){
		leftSide = p.getX() - (this.size / 2);
		rightSide = p.getX() + (this.size / 2); 
		topSide = p.getY() + (this.size / 2);
		bottomSide = p.getY() - (this.size /2);
	}
    
}
