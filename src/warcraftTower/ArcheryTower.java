package warcraftTower;

import warcraftMain.StdDraw;

import java.util.ArrayList;
import warcraftMonster.*;
import warcraftProjectile.Arrow;
import warcraftMain.Position;

public class ArcheryTower extends Tower {

	private ArrayList<Arrow> arrow = new ArrayList<Arrow>();
	private int time = 0;

	public ArrayList<Arrow> getArrow() {
		return arrow;
	}
	public void setArrow(ArrayList<Arrow> arrow) {
		this.arrow = arrow;
	}

	public ArcheryTower(Position p) {
		super(50, (float)0.2, 15, true, p);
		System.out.println("\n--- Nouvelle tour d'archer creer!---");
	}
	
	public void draw() {
		if(level == 1 ) 	StdDraw.picture(getP().getX(), getP().getY(), "images/Tower/Archery Tower Level 1.png", (1.0/24.0) , (1.0/15.0) );
		else if(level == 2) 	StdDraw.picture(getP().getX(), getP().getY(), "images/Tower/Archery Tower Level 2.png", (1.0/24.0) , (1.0/15.0) );
	}
	
	//Amelioration de la tour
	public void upgrade() {
		if(level < levelMax){
			level++;
			range += 0.01;
			cooldown =- 3;
			upgradeCost = upgradeCost * 2;
		}
		else System.out.println("Cet tour est deja au niveau max !");
	}

	/**
	 * Calcul le monstre le plus proche 
	 * @return le monstre le plus proche a porté ou null si aucun monstre n'est a porté
	 */
	public Monster activate(ArrayList <Monster> monsters){

		float distanceMin = (float) (range + 0.01);
		Monster closest = null;
		for(int i = 0 ; i < monsters.size() ; i++){

			float AB = monsters.get(i).getP().getX() - getP().getX();
			float BC = monsters.get(i).getP().getY()  - getP().getY();
			// Mesure la distance entre la tour et le monstre (AC2 = AB2 + BC2)
			float distance = (float) (Math.sqrt ( Math.pow(AB, 2) + Math.pow(BC, 2)));
			if(distanceMin > distance) {
				distanceMin = distance; 
				closest = monsters.get(i);
			}
		} 
		if(distanceMin < range) {
			return closest;
		}
		else return null;
		
	}

	public void update(ArrayList <Monster> monsters){
		draw();
		Monster m = activate(monsters);
		if( m != null){ 
			time ++;
			if(time % cooldown == 0 ) shoot(m);
		}
		for(int i = 0 ; i < arrow.size() ; i++ ) if(arrow.get(i).getHit()) arrow.remove(arrow.get(i));
		for(int i = 0 ; i < arrow.size() ; i++ ) arrow.get(i).update(monsters);
	}

	public void shoot(Monster monster){
		Position pProjectile = new Position(getP().getX(), getP().getY());
		arrow.add(new Arrow(pProjectile,monster));
	}

}

