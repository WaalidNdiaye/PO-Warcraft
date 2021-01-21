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
        if(World.getTime() == 710){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new WolfMonster(p));
        }
        if(World.getTime() == 750){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 720){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 740){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 750){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTime() == 760){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTime() == 770){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTime() == 780){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new WolfMonster(p));
        }
        if(World.getTime() == 820){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 840){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 860){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 870){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTime() == 880){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTime() == 890){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTime() == 900){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new WolfMonster(p));
        }
        if(World.getTime() == 940){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 960){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 980){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 990){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTime() == 1000){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTime() == 1010){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTime() == 1020){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new WolfMonster(p));
        }
        if(World.getTime() == 1060){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 1080){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 1100){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 1110){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTime() == 1120){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTime() == 1140){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
    }
}
