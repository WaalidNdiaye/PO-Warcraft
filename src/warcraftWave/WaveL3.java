package warcraftWave;

import warcraftMonster.*;
import warcraftMain.*;

public class WaveL3{
    
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
        if(World.getTimeWave() == 710){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new WolfMonster(p));
        }
        if(World.getTimeWave() == 750){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTimeWave() == 720){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTimeWave() == 750){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTimeWave() == 780){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new WolfMonster(p));
        }
        if(World.getTimeWave() == 840){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTimeWave() == 860){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTimeWave() == 870){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTimeWave() == 940){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTimeWave() == 960){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTimeWave() == 980){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTimeWave() == 990){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTimeWave() == 1020){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new WolfMonster(p));
        }
        if(World.getTimeWave() == 1080){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTimeWave() == 1100){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTimeWave() == 1110){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTimeWave() == 1141)
            World.setEndSpawnMonsters(true);
    }
}
