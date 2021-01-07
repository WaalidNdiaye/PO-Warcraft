package warcraftWave;

import warcraftMonster.*;
import warcraftMain.*;

public class WaveL5{
	
    public static void update(){
        buildWave();
    }
     
    public static void buildWave(){
        if(World.getTime() == 2920){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new VogadorMonster(p));
        }
        if(World.getTime() == 2940){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new VogadorMonster(p));
        }
        if(World.getTime() == 2960){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new VogadorMonster(p));
        }
        if(World.getTime() == 2980){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new VogadorMonster(p));
        }
        if(World.getTime() == 3000){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new VogadorMonster(p));
        }
        if(World.getTime() == 3020){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new VogadorMonster(p));
        }
        if(World.getTime() == 3040){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new VogadorMonster(p));
        }
        if(World.getTime() == 3060){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new VogadorMonster(p));
        }
        if(World.getTime() == 3080){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new VogadorMonster(p));
        }
        if(World.getTime() == 3100){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new VogadorMonster(p));
        }
        if(World.getTime() == 3120){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new VogadorMonster(p));
        }

    }
}
