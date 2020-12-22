package warcraftMain;

import warcraftMonster.BaseMonster;
import warcraftMonster.Monster;

public class Main {

	public static void main(String[] args) {
		// Information sur la taille du plateau de jeu
		int width = 1440;
		int height = 900;
		int nbSquareX = 24;
		int nbSquareY = 15;
		int startX = 0;
		int startY = 7;
		
		//Init du monde "plateau de jeu"
		World w = new World(width, height, nbSquareX, nbSquareY, startX, startY);
		
		//Ajout d un monstre a  la mains pour afficher comment un monstre se deplace. Vous ne devez pas faire pareil, mais ajouter une vague comportant plusieurs monstres 
		Monster monster = new BaseMonster(w.getSpawn());
		monster.setNextP(new Position(1 * World.getSquareWidth() + World.getSquareWidth() / 2, 7 * World.getSquareHeight() + World.getSquareHeight() / 2));
		monster.setSpeed(0.01);
		w.getMonsters().add(monster);
		
		//Lancement de la boucle principale du jeu
		w.run();
	}
}

