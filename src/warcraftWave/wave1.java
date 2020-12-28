package warcraftWave;

import java.util.ArrayList;

import warcraftMonster.Monster;
import warcraftMonster.LandMonster;
import warcraftMain.World;

public class wave1 {

	/*
	 * Constructeur de la premiere vague d ennemis
	 */
	public static ArrayList<Monster> waveBuild() {
		ArrayList<Monster> m = new ArrayList<Monster>();
		for(int i=20; i<=20; i++)
			m.add(new LandMonster(World.getSpawn()));
		
		return m;
	}
	
}
