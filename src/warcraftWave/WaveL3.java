package warcraftWave;

import warcraftMonster.*;
import warcraftMain.*;

public class WaveL3{
	
    public static void update(){
        buildWave();
    }
     
    public static void buildWave(){
        if(World.getTime() == 1190){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 1240){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 1290){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 1340){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 1390){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 1440){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 1490){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 1540){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 1590){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 1640){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 1690){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new  VogadorMonster(p));
        }
        if(World.getTime() == 1740){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTime() == 1790){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTime() == 1840){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTime() == 1990){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTime() == 2040){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 2090){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 2140){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 2190){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 2240){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTime() == 2290){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTime() == 2340){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTime() == 2390){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTime() == 2440){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTime() == 2490){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new  VogadorMonster(p));
        }
    }
}
