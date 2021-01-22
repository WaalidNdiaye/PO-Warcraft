package warcraftWave;

import warcraftMonster.*;
import warcraftMain.*;

public class WaveL5{
    
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
        if(World.getTimeWave() == 1640){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new WolfMonster(p));
        }
        if(World.getTimeWave() == 1660){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new WolfMonster(p));
        }
        if(World.getTimeWave() == 1700){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTimeWave() == 1730){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTimeWave() == 1740){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTimeWave() == 1750){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTimeWave() == 1770){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new WolfMonster(p));
        }
        if(World.getTimeWave() == 1830){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTimeWave() == 1860){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTimeWave() == 1870){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTimeWave() == 1880){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTimeWave() == 1900){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new WolfMonster(p));
        }
        if(World.getTimeWave() == 1960){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTimeWave() == 1990){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTimeWave() == 2000){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTimeWave() == 2010){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTimeWave() == 2030){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new WolfMonster(p));
        }
        if(World.getTimeWave() == 2090){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTimeWave() == 2120){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTimeWave() == 2130){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTimeWave() == 2140){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTimeWave() == 2160){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new WolfMonster(p));
        }
        if(World.getTimeWave() == 2220){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTimeWave() == 2250){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTimeWave() == 2260){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTimeWave() == 2270){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTimeWave() == 2290){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new WolfMonster(p));
        }
        if(World.getTimeWave() == 2350){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTimeWave() == 2380){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTimeWave() == 2390){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTimeWave() == 2400){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTimeWave() == 2440){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new WolfMonster(p));
        }
        if(World.getTimeWave() == 2480){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTimeWave() == 2510){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTimeWave() == 2520){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTimeWave() == 2530){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTimeWave() == 2531)
            World.setEndSpawnMonsters(true);
    }
}
