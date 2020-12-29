package warcraftWave;

import java.util.ArrayList;

import warcraftMonster.*;
import warcraftMain.*;

public class WaveLevel1 {

    private int time = 0;

    public void update(ArrayList<Monster> monsters){
        time++;
        buildWave(monsters);
    }
    public void buildWave(ArrayList<Monster> monsters){

        if(time == 50){
            Position p = new Position(World.getSpawn());
            monsters.add(new LandMonster(p));
        }
        if(time == 70){
            Position p = new Position(World.getSpawn());
            monsters.add(new LandMonster(p));
        }
        if(time == 100){
            Position p = new Position(World.getSpawn());
            monsters.add(new LandMonster(p));
        }
        if(time == 150){
            Position p = new Position(World.getSpawn());
            monsters.add(new FlyingMonster(p));
        }
    }
    
}
