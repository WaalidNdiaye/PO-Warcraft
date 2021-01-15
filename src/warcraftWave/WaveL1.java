package warcraftWave;

import warcraftMonster.*;
import warcraftMain.*;

public class WaveL1{
    
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
        if(World.getTime() == 100){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 120){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 140){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 160){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 180){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 200){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 220){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 240){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 260){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 280){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
    }
}
