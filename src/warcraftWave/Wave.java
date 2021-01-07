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
	 * 
	 */
	public static void setInitW(boolean init){
		initW = init;
	}
	
	/**
	 * Init le chemin de la vague
	 * 		- Si 1ere vague alors Patern1
	 * 		- Sinon chemin generer aleatoirement parmis ceux preset
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
	 * choisi un chemin au hasard parmis ceux preset
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
	 * verifie si la partie (derniere vague) est finit ou non
	 */
	public static void gameEnd() {
		if(World.getNbWaves() == World.getCurrentW() && World.getTime() >= timeEnd && World.getMonsters().size() == 0) {
			World.updateEnd(true);
			World.setPause(true);
		}
	}
	
	/**
	 * permet de passer a la prochaine vague a la fin d une vague
	 */
	public static void nextWave(){
		switch(World.getCurrentW()) {
		case 1:
			if(World.getNbWaves() > 1 && World.getCurrentW() == 1 && World.getTime() >= 550 && World.getMonsters().size() == 0) {
				StdDraw.picture(0.5, 0.5, "images/wave1.png", 1, 1);
				World.setPause(true);
				World.setCoin(World.getCoin()+25);
			}
		case 2:
			if(World.getNbWaves() > 2 && World.getCurrentW() == 2 && World.getTime() >= 1090 && World.getMonsters().size() == 0) {
				StdDraw.picture(0.5, 0.5, "images/wave2.png", 1, 1);
				World.setPause(true);
			}
		case 3:
			if(World.getNbWaves() > 3 && World.getCurrentW() == 3 && World.getTime() >= 2490 && World.getMonsters().size() == 0) {
				StdDraw.picture(0.5, 0.5, "images/wave3.png", 1, 1);
				World.setPause(true);
				World.setCoin(World.getCoin()+30);
			}
		case 4:
			if(World.getNbWaves() > 4 && World.getCurrentW() == 4 && World.getTime() >= 2820 && World.getMonsters().size() == 0) {
				StdDraw.picture(0.5, 0.5, "images/wave4.png", 1, 1);
				World.setPause(true);
			}
		case 5:
			if(World.getNbWaves() > 5 && World.getCurrentW() == 5 && World.getTime() >= 3120 && World.getMonsters().size() == 0) {
				StdDraw.picture(0.5, 0.5, "images/wave5.png", 1, 1);
				World.setPause(true);
			}
		case 6:
			if(World.getNbWaves() > 6 && World.getCurrentW() == 6 && World.getTime() >= 3620 && World.getMonsters().size() == 0) {
				StdDraw.picture(0.5, 0.5, "images/wave6.png", 1, 1);
				World.setPause(true);
			}
		}
	}
	
	/**
	 * Initialise la variable timeEnd
	 * @return
	 */
	public static int initTimeEnd(){
		return World.getNbWaves() == 1 ? 550
				: World.getNbWaves() == 2 ? 1090
				: World.getNbWaves() == 3 ? 2490
				: World.getNbWaves() == 4 ? 2820
				: World.getNbWaves() == 5 ? 3120
				: World.getNbWaves() == 6 ? 3620
				: World.getNbWaves() == 7 ? -1
				: -1;
	}
}
