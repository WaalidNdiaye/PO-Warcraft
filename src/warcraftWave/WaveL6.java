package warcraftWave;

import warcraftMonster.*;
import warcraftMain.*;

public class WaveL6{
    
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
        if(World.getTimeWave() == 2630){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new WolfMonster(p));
        }
        if(World.getTimeWave() == 2650){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new WolfMonster(p));
        }
        if(World.getTimeWave() == 2670){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new WolfMonster(p));
        }
        if(World.getTimeWave() == 2690){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new WolfMonster(p));
        }
        if(World.getTimeWave() == 2730){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTimeWave() == 2750){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTimeWave() == 2790){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new WolfMonster(p));
        }
        if(World.getTimeWave() == 2810){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new WolfMonster(p));
        }
        if(World.getTimeWave() == 2830){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new WolfMonster(p));
        }
        if(World.getTimeWave() == 2850){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new WolfMonster(p));
        }
        if(World.getTimeWave() == 2910){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTimeWave() == 2930){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTimeWave() == 2950){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new WolfMonster(p));
        }
        if(World.getTimeWave() == 2970){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new WolfMonster(p));
        }
        if(World.getTimeWave() == 2990){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new WolfMonster(p));
        }
        if(World.getTimeWave() == 3010){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new WolfMonster(p));
        }
        if(World.getTimeWave() == 3070){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTimeWave() == 3090){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTimeWave() == 3110){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new WolfMonster(p));
        }
        if(World.getTimeWave() == 3130){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new WolfMonster(p));
        }
        if(World.getTimeWave() == 3150){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new WolfMonster(p));
        }
        if(World.getTimeWave() == 3170){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new WolfMonster(p));
        }
        if(World.getTimeWave() == 3230){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTimeWave() == 3250){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTimeWave() == 3251)
            World.setEndSpawnMonsters(true);
    }
}
