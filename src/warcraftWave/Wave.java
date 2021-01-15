package warcraftWave;

import java.util.List;

import warcraftMain.Position;
import warcraftMain.StdDraw;
import warcraftMain.World;
import warcraftPath.*;

public class Wave {

	private static boolean initW = false;									// Indique si la vague actuelle est initialise ou pas
	private static int timeEnd = initTimeEnd();								// Indique le moment ou le dernier monstre sera ajouter sur la plateau de jeu
	
	/**
	 * Setters
	 */
	public static void setInitW(boolean init){
		initW = init;
	}
	
	/**
	 * Initialise World.Path au debut de chaque vague
	 * 		- avec le Patern1 si c'est la premiere vague
	 * 		- sinon avec un patern au hasard parmis les autres
	 */
	public static void initWave() {
		if(!initW) {
			if(World.getCurrentW() == 1)
				World.setPath(Patern1.pathconstruct());
			else
				World.setPath(randomPath());
		}
		initW = true;
	}
	
	/**
	 * @return une liste  de position représentant un chemin au hasard parmis ceux preset
	 */
	public static List<Position> randomPath() {
		int r = (int)(Math.random() * 6);
		return r == 1 ? Patern2.pathconstruct()
				: r == 2 ? Patern3.pathconstruct()
				: r == 3 ? Patern4.pathconstruct()
				: r == 4 ? Patern5.pathconstruct()
				: r == 5 ? Patern6.pathconstruct()
				: Patern7.pathconstruct();
	}
	
	/**
	 * Verifie si la partie (derniere vague) est finit ou non
	 */
	public static void gameEnd() {
		if(World.getNbWaves() == World.getCurrentW() && World.getTime() >= timeEnd && World.getMonsters().size() == 0) {
			World.updateEnd(true);
			World.setPause(true);
		}
	}
	
	/**
	 * Permet de passer a la vague suivante a la fin d une vague
	 */
	public static void nextWave(){
		switch(World.getCurrentW()) {
		case 1:
			if(World.getNbWaves() > 1 && World.getCurrentW() == 1 && World.getTime() >= 280 && World.getMonsters().size() == 0) {
				StdDraw.picture(0.5, 0.5, "images/wave/wave1.png", 1, 1);
				World.setPause(true);
			}
		case 2:
			if(World.getNbWaves() > 2 && World.getCurrentW() == 2 && World.getTime() >= 610 && World.getMonsters().size() == 0) {
				StdDraw.picture(0.5, 0.5, "images/wave/wave2.png", 1, 1);
				World.setPause(true);
			}
		case 3:
			if(World.getNbWaves() > 3 && World.getCurrentW() == 3 && World.getTime() >= 1140 && World.getMonsters().size() == 0) {
				StdDraw.picture(0.5, 0.5, "images/wave/wave3.png", 1, 1);
				World.setPause(true);
			}
		case 4:
			if(World.getNbWaves() > 4 && World.getCurrentW() == 4 && World.getTime() >= 1540 && World.getMonsters().size() == 0) {
				StdDraw.picture(0.5, 0.5, "images/wave/wave4.png", 1, 1);
				World.setPause(true);
			}
		case 5:
			if(World.getNbWaves() > 5 && World.getCurrentW() == 5 && World.getTime() >= 2530 && World.getMonsters().size() == 0) {
				StdDraw.picture(0.5, 0.5, "images/wave/wave5.png", 1, 1);
				World.setPause(true);
			}
		case 6:
			if(World.getNbWaves() > 6 && World.getCurrentW() == 6 && World.getTime() >= 3250 && World.getMonsters().size() == 0) {
				StdDraw.picture(0.5, 0.5, "images/wave/wave6.png", 1, 1);
				World.setPause(true);
			}
		case 7:
			if(World.getNbWaves() > 7 && World.getCurrentW() == 7 && World.getTime() >= 4830 && World.getMonsters().size() == 0) {
				StdDraw.picture(0.5, 0.5, "images/wave/wave7.png", 1, 1);
				World.setPause(true);
			}
		}
	}
	
	/**
	 * @return le temps au quel spawnera le denrier monstre de la partie
	 */
	public static int initTimeEnd(){
		return World.getNbWaves() == 1 ? 280
				: World.getNbWaves() == 2 ? 610
				: World.getNbWaves() == 3 ? 1140
				: World.getNbWaves() == 4 ? 1540
				: World.getNbWaves() == 5 ? 2530
				: World.getNbWaves() == 6 ? 3250
				: World.getNbWaves() == 7 ? 4830
				: 5010;
	}
}
