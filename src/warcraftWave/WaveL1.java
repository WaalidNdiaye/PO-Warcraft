package warcraftWave;

import java.util.ArrayList;
import warcraftMonster.*;
import warcraftMain.*;

public class WaveL1{
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
    }
}
