package warcraftWave;

import warcraftMonster.*;
import warcraftMain.*;

public class WaveL8{
    
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
        if(World.getTime() == 4930){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new WolfBoss(p));
        }
        if(World.getTime() == 5030){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FinalBoss(p));
        }
        if(World.getTime() == 5130){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new WolfBoss(p));
        }
    }
}
