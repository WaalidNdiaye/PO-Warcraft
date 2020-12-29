package warcraftTower;

import warcraftMain.StdDraw;
import warcraftMonster.*;
import java.util.ArrayList;
import warcraftMain.Position;
import warcraftProjectile.Bomb;

public class BombTower extends Tower{

	private ArrayList<Bomb> bomb = new ArrayList<Bomb>();
	private int time = 0;

	
	public ArrayList<Bomb> getBomb() {
		return bomb;
	}
	public void setBomb(ArrayList<Bomb> bomb) {
		this.bomb = bomb;
	}
	
	public BombTower(Position p) {
		super(60, (float)0.15, 20, false, p);
		System.out.println("\n--- Nouvelle mortier creer!---");
	}
	
	public void draw() {
		StdDraw.picture(getP().getX() , getP().getY(), "images/BombTower.png", (1.0/24.0) , (1.0/15.0) );
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
		for(int i = 0 ; i < bomb.size() ; i++ ) if(bomb.get(i).getHit()) bomb.remove(bomb.get(i));
		for(int i = 0 ; i < bomb.size() ; i++ ) bomb.get(i).update(monsters);
	}

	public void shoot(Monster monster){
		Position pProjectile = new Position(getP().getX(), getP().getY());
		bomb.add(new Bomb(pProjectile,monster));
	}

}
