package warcraftWave;

import warcraftMonster.*;
import warcraftMain.*;

public class WaveL2{
	
    public static void update(){
        buildWave();
    }
     
    public static void buildWave(){
        if(World.getTime() == 650){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 700){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 750){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 800){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 850){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 880){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTime() == 910){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTime() == 940){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 970){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new VogadorMonster(p));
        }
        if(World.getTime() == 990){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 1010){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 1030){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 1050){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTime() == 1070){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTime() == 1090){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
    }
}
