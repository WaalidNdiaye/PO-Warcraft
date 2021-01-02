package warcraftTower;

import warcraftMain.StdDraw;
import warcraftMain.World;
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
		if(level == 1) StdDraw.picture(getP().getX() , getP().getY(), "images/Tower/Bomb Tower Level 1.png", (1.0/24.0) , (1.0/15.0) );
		else if(level == 2) StdDraw.picture(getP().getX() , getP().getY(), "images/Tower/Bomb Tower Level 2.png", (1.0/24.0) , (1.0/15.0) );
	}

	//Amelioration de la tour
	public void upgrade() {
		if(level < levelMax){
			level++;
			range += 0.02;
			cooldown -= 2;
			upgradeCost = upgradeCost * 2;
		}
		else System.out.println("Cet tour est deja au niveau max !");
	}

	/**
	 * Calcul le monstre le plus proche 
	 * @return le monstre le plus proche a porté ou null si aucun monstre n'est a porté
	 */
	public Monster activate(){

		float distanceMin = (float) (range + 0.01);
		Monster closest = null;
		for(int i = 0 ; i < World.getMonsters().size() ; i++){

			float AB = World.getMonsters().get(i).getP().getX() - getP().getX();
			float BC = World.getMonsters().get(i).getP().getY()  - getP().getY();
			// Mesure la distance entre la tour et le monstre (AC2 = AB2 + BC2)
			float distance = (float) (Math.sqrt ( Math.pow(AB, 2) + Math.pow(BC, 2)));
			// Cherche le monstre terrestre le plus proche 
			if(distanceMin > distance && !World.getMonsters().get(i).isFlying()) {
				distanceMin = distance; 
				closest = World.getMonsters().get(i);
			}
		} 
		if(distanceMin < range) {
			return closest;
		}
		else return null;
		
	}

	public void update(){
		draw();
		Monster m = activate();
		if( m != null){ 
			time ++;
			if(time % cooldown == 0 ) shoot(m);
		}
		for(int i = 0 ; i < bomb.size() ; i++ ) if(bomb.get(i).getHit()) bomb.remove(bomb.get(i));
		for(int i = 0 ; i < bomb.size() ; i++ ) bomb.get(i).update();
	}

	public void shoot(Monster monster){
		Position pProjectile = new Position(getP().getX(), getP().getY());
		bomb.add(new Bomb(pProjectile,monster));
	}

}
