package warcraftTower;
import warcraftMain.StdDraw;

import java.util.ArrayList;

import warcraftMain.*;
import warcraftMonster.*;
import warcraftProjectile.Arrow;
import warcraftMain.Position;

public class ArcheryTower extends Tower {

	private ArrayList<Arrow> arrow = new ArrayList<Arrow>();

	public ArrayList<Arrow> getArrow() {
		return arrow;
	}
	public void setArrow(ArrayList<Arrow> arrow) {
		this.arrow = arrow;
	}

	public ArcheryTower(Position p) {
		super(50, 0.3, 15, true, p);
	}
	
	public void draw() {
		StdDraw.picture(p.getX() , p.getY(), "images/ArcheryTower.jpg", (1.0/24.0) , (1.0/15.0) );
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
		double distanceMin = 0.0;
		Monster closest ;
		for(int i = 0 ; i < monsters.size() ; i++){

			double AB = monsters.get(i).getP().getX() - p.getX();
			double BC = monsters.get(i).getP().getY()  - p.getY();
			// Mesure la distance entre la tour et le monstre (AC2 = AB2 + BC2)
			double distance = Math.sqrt ( Math.pow(AB, 2) + Math.pow(BC, 2) );
			if(distanceMin > distance) {
				distanceMin = distance; 
				closest = monsters.get(i);
			}
		} 
		if(distanceMin < range) return closest;
		else return null;
		
	}

	public void update(ArrayList <Monster> monsters){
		draw();
		if(activate(monsters) !=  null){
			
		}
	}

	public void shoot(Monster monster){
		arrow.add(new Arrow(p,monster));
	}

}

