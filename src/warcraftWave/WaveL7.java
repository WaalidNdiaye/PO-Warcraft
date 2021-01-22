package warcraftWave;

import warcraftMonster.*;
import warcraftMain.*;

public class WaveL7{
    
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
        if(World.getTimeWave() == 3650){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTimeWave() == 3670){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTimeWave() == 3690){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTimeWave() == 3710){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTimeWave() == 3730){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new WolfMonster(p));
        }
        if(World.getTimeWave() == 3750){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new WolfMonster(p));
        }
        if(World.getTimeWave() == 3770){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTimeWave() == 3790){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTimeWave() == 3910){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTimeWave() == 3830){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTimeWave() == 3850){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new WolfMonster(p));
        }
        if(World.getTimeWave() == 3870){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new WolfMonster(p));
        }
        if(World.getTimeWave() == 3890){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTimeWave() == 3910){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTimeWave() == 3930){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTimeWave() == 3950){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTimeWave() == 3970){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new WolfMonster(p));
        }
        if(World.getTimeWave() == 3990){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new WolfMonster(p));
        }
        if(World.getTimeWave() == 4010){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTimeWave() == 4030){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTimeWave() == 4050){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTimeWave() == 4070){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTimeWave() == 4090){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new WolfMonster(p));
        }
        if(World.getTimeWave() == 4110){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new WolfMonster(p));
        }
        if(World.getTimeWave() == 4130){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTimeWave() == 4150){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTimeWave() == 4170){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTimeWave() == 4190){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTimeWave() == 4210){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new WolfMonster(p));
        }
        if(World.getTimeWave() == 4230){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new WolfMonster(p));
        }
        if(World.getTimeWave() == 4250){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTimeWave() == 4270){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTimeWave() == 4290){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTimeWave() == 4310){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTimeWave() == 4330){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new WolfMonster(p));
        }
        if(World.getTimeWave() == 4350){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new WolfMonster(p));
        }
        if(World.getTimeWave() == 4370){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTimeWave() == 4390){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTimeWave() == 4410){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTimeWave() == 4430){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTimeWave() == 4450){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new WolfMonster(p));
        }
        if(World.getTimeWave() == 4470){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new WolfMonster(p));
        }
        if(World.getTimeWave() == 4490){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTimeWave() == 4510){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTimeWave() == 4530){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTimeWave() == 4550){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTimeWave() == 4570){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new WolfMonster(p));
        }
        if(World.getTimeWave() == 4590){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new WolfMonster(p));
        }
        if(World.getTimeWave() == 4610){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTimeWave() == 4630){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTimeWave() == 4650){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTimeWave() == 4670){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTimeWave() == 4690){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new WolfMonster(p));
        }
        if(World.getTimeWave() == 4710){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new WolfMonster(p));
        }
        if(World.getTimeWave() == 4730){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTimeWave() == 4750){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new LandMonster(p));
        }
        if(World.getTimeWave() == 4770){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTimeWave() == 4790){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new FlyingMonster(p));
        }
        if(World.getTimeWave() == 4810){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new WolfMonster(p));
        }
        if(World.getTimeWave() == 4830){
            Position p = new Position(World.getSpawn());
            World.getMonsters().add(new WolfMonster(p));
        }
        if(World.getTimeWave() == 4831)
            World.setEndSpawnMonsters(true);
    }
}
