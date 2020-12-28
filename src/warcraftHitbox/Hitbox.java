package warcraftHitbox;

import warcraftMain.Position;

public class Hitbox {

    //bords de la hitBox 
	protected float leftSide;
	protected float rightSide;
	protected float topSide;
	protected float bottomSide;

	//taille de la hitbox 
	protected float size ;
	
	
	public float getLeftSide() {
		return leftSide;
	}
	public void setLeftSide(float leftSide) {
		this.leftSide = leftSide;
	}
	public float getRightSide() {
		return rightSide;
	}
	public void setRightSide(float rightSide) {
		this.rightSide = rightSide;
	}
	public float getTopSide() {
		return topSide;
	}
	public void setTopSide(float topSide) {
		this.topSide = topSide;
	}
	public float getBottomSide() {
		return bottomSide;
	}
	public void setBottomSide(float bottomSide) {
		this.bottomSide = bottomSide;
    }
    
    public Hitbox(Position p , float size){
        this.size = size ;
		leftSide = p.getX() - (this.size / 2);
		rightSide = p.getX() + (this.size / 2); 
		topSide = p.getY() + (this.size / 2);
		bottomSide = p.getY() - (this.size /2);
    }

	//Renvoi true si les deux hitboxs se touche sinon renvoi false  
    public boolean hit(Hitbox h){
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
