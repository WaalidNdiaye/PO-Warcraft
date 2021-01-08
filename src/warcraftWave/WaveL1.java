package warcraftWave;

import warcraftMonster.*;
import warcraftMain.*;

public class WaveL1{
    
    public static void update(){
        buildWave();
    }
     
    public static void buildWave(){
        if(World.getTime() == 100){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new WolfBoss(p));
        }
        if(World.getTime() == 150){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 200){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 250){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 300){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 350){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 400){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 450){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 500){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 550){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
    }
}
