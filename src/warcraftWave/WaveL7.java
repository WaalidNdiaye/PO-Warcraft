package warcraftWave;

import warcraftMonster.*;
import warcraftMain.*;

public class WaveL7{
	
    public static void update(){
        buildWave();
    }
     
    public static void buildWave(){
        if(World.getTime() == 3620){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }

    }
}
