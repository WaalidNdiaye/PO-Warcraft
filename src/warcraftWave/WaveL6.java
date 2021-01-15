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
        if(World.getTime() == 2630){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new VogadorMonster(p));
        }
        if(World.getTime() == 2650){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new VogadorMonster(p));
        }
        if(World.getTime() == 2670){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new VogadorMonster(p));
        }
        if(World.getTime() == 2690){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new VogadorMonster(p));
        }
        if(World.getTime() == 2710){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new VogadorMonster(p));
        }
        if(World.getTime() == 2730){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTime() == 2750){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTime() == 2770){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTime() == 2790){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new VogadorMonster(p));
        }
        if(World.getTime() == 2810){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new VogadorMonster(p));
        }
        if(World.getTime() == 2830){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new VogadorMonster(p));
        }
        if(World.getTime() == 2850){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new VogadorMonster(p));
        }
        if(World.getTime() == 2870){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new VogadorMonster(p));
        }
        if(World.getTime() == 2890){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTime() == 2910){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTime() == 2930){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTime() == 2950){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new VogadorMonster(p));
        }
        if(World.getTime() == 2970){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new VogadorMonster(p));
        }
        if(World.getTime() == 2990){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new VogadorMonster(p));
        }
        if(World.getTime() == 3010){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new VogadorMonster(p));
        }
        if(World.getTime() == 3030){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new VogadorMonster(p));
        }
        if(World.getTime() == 3050){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTime() == 3070){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTime() == 3090){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTime() == 3110){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new VogadorMonster(p));
        }
        if(World.getTime() == 3130){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new VogadorMonster(p));
        }
        if(World.getTime() == 3150){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new VogadorMonster(p));
        }
        if(World.getTime() == 3170){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new VogadorMonster(p));
        }
        if(World.getTime() == 3190){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new VogadorMonster(p));
        }
        if(World.getTime() == 3210){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTime() == 3230){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTime() == 3250){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
    }
}
