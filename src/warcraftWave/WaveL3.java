package warcraftWave;

import java.util.ArrayList;
import warcraftMonster.*;
import warcraftMain.*;

public class WaveL3{

    private static int time = 0;
    private static boolean init = false;

    public static int getTime() {
    	return time;
    }
    
    public static void update(){
    	if(!init) {
    		World.setMonsters(new ArrayList<Monster>());
    		init = true;
    	}
        time++;
        buildWave();
    }
     
    public static void buildWave(){
        if(time == 100){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(time == 150){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(time == 200){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(time == 250){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(time == 300){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(time == 350){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(time == 400){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(time == 450){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(time == 500){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(time == 550){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(time == 600){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new  VogadorMonster(p));
        }
        if(time == 700){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(time == 800){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(time == 900){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(time == 1000){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(time == 1050){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(time == 1070){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(time == 1090){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(time == 1110){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(time == 1130){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(time == 1150){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(time == 1250){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(time == 1350){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(time == 1450){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(time == 1550){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new  VogadorMonster(p));
        }
    }
}
