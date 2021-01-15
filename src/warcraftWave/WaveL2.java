package warcraftWave;

import warcraftMonster.*;
import warcraftMain.*;

public class WaveL2{
    
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
        if(World.getTime() == 380){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 400){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 420){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 430){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTime() == 440){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 460){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 480){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 490){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTime() == 500){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 520){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 540){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 550){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTime() == 560){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 580){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 600){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 6100){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
    }
}
