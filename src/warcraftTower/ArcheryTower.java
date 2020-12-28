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
		super(50, 0.2, 15, true, p);
		System.out.println("\n--- Nouvelle tour d'archer creer!---");
	}
	
	public void draw() {
		StdDraw.picture(getP().getX(), getP().getY(), "images/ArcheryTower.jpg", (1.0/24.0) , (1.0/15.0) );
	}
	
	//Amelioration de la tour
	public void upgrade() {
		level++;
		range += 0.005;
		cooldown =- 2;
	}

	/**
	 * Calcul le monstre le plus proche 
	 * @return le monstre le plus proche a porté ou null si aucun monstre n'est a porté
	 */
	public Monster activate(ArrayList <Monster> monsters){

		double distanceMin = range + 0.01;
		Monster closest = null;
		for(int i = 0 ; i < monsters.size() ; i++){

			double AB = monsters.get(i).getP().getX() - getP().getX();
			double BC = monsters.get(i).getP().getY()  - getP().getY();
			// Mesure la distance entre la tour et le monstre (AC2 = AB2 + BC2)
			double distance = Math.sqrt ( Math.pow(AB, 2) + Math.pow(BC, 2) );
			if(distanceMin > distance) {
				distanceMin = distance; 
				closest = monsters.get(i);
			}
		} 
		if(distanceMin < range) {
			System.out.println("....Monstre a porté....");
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
		for(int i = 0 ; i < arrow.size() ; i++ ) arrow.get(i).update();
	}

	public void shoot(Monster monster){
		Position pProjectile = new Position(getP().getX(), getP().getY());
		arrow.add(new Arrow(pProjectile,monster));
	}

}

