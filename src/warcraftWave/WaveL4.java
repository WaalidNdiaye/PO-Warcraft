package warcraftWave;

import warcraftMonster.*;
import warcraftMain.*;

public class WaveL4{
    
	/**
	 * Update la vague en cours en faisant appel a buildWave()
	 */
    public static void update(){
        buildWave();
    }
    
    /**
     * Fait spawn les monstre en fonction de la variable World.time
     */
    public static void buildWave(){
        if(World.getTimeWave() == 1240){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new WolfBoss(p));
        }
        if(World.getTimeWave() == 1241)
            World.setEndSpawnMonsters(true);
    }
}
