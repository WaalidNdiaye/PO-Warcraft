package warcraftWave;

import java.util.ArrayList;
import warcraftMonster.*;
import warcraftMain.*;

public class WaveL8{

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
    }
}
