package warcraftWave;

import java.util.ArrayList;
import java.util.List;

import warcraftMonster.Monster;
import warcraftMonster.LandMonster;
import warcraftMain.World;

public class wave1 {

	/*
	 * Constructeur de la premiere vague d ennemis
	 */
	public static List<Monster> waveBuild() {
		List<Monster> m = new ArrayList<Monster>();
		for(int i=20; i<=20; i++)
			m.add(new LandMonster(World.getSpawn()));
		
		return m;
	}
	
}
