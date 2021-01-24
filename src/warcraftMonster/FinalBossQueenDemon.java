package warcraftMonster;

import java.util.Random;
import warcraftMain.*;

public class FinalBossQueenDemon extends Monster {

    private int lastInvocation = 50;                    // Repere chronologique de la derniere invocation
    private int cooldown = 125 ;                        // Temps de rechargement
    private int nbrInvocation = 0;                      // Nombre d'invocation deja effectué
    private Random random = new Random();               // Classe pour generer des nombres aleatoire
    private float healRange = (float)0.1;               // Portée de sa capacité a soigner les monstres autours 

    /**
     * Constructeur
     * @param p position
     */
    public FinalBossQueenDemon (Position p) {
		super(p , (float)0.06 , (float)0.001875, 1000, 0, true);
	}
	
	/**
	 * Affichage du monstre 
	 */
	public void draw() {
        if(time % 14 < 10)
        	StdDraw.picture(p.getX(), p.getY(), "images/Monster/FinalBossAnimation/0" + time % 14 +  ".png", size * 2, size * 2.5);
        else
        	StdDraw.picture(p.getX(), p.getY(), "images/Monster/FinalBossAnimation/" + time % 14 +  ".png", size * 2, size * 2.5);
    }

    /**
	 * Affichage de l'animation d'invocation du Boss
	 */
    public void drawInvocation(){
        StdDraw.picture(p.getX(), p.getY(), "images/Monster/FinalBossAnimation/" + (time - lastInvocation + 14) +  ".png", size * 2, size * 2.5);
    }
    

     /**
	 * Surcharge de la fonction update() de warcarftMonster.Monster
	 */
    @Override
    public void update(){
        time++;
        
        // Chargement & declenchement de l'Invocation
        if((time - lastInvocation) > cooldown)
        	chargeInvocation();
        if(time - lastInvocation == 17)
        	heal();
        if( time - lastInvocation == 32)
        	invocation();

        // Affichage de l'animation d'invocation du Boss
        if((time - lastInvocation) >= 0 && (time - lastInvocation) < 40)
        	drawInvocation();
        else{
            move();
	    	draw();
        }

		drawLife();
		checkpoint++;
    }

    /**
	 * Marque un repere chronologique pour declecher l'invocation
	 */
    public void chargeInvocation(){
        lastInvocation = time ;
    }

    /**
	 * Invocation
	 * 	- A chaque nouvelle invocation, il invoque un monstre (al�atoire) de plus et se regenere de 80 Hp
	 * 	- Il les fait spawn a une position al�atoire non loin de lui
	 */
    public void invocation (){
        for(int i = 0 ; i <= nbrInvocation ; i++){
            int type = random.nextInt(4);

            //Spawn LandMonster
            if(type == 1){
                Position newP1 = generatP();
                Position newP2 = generatP();
                
                Monster m1 = new LandMonster(newP1);
                m1.setNextP(nextP);
                World.getMonsters().add(m1);

                Monster m2 = new LandMonster(newP2);
                m2.setNextP(nextP);
                World.getMonsters().add(m2);
            }
            
            //Spawn SuccubeMonster
            if(type == 2){
                Position newP1 = generatP();
                Position newP2 = generatP();

                Monster m1 = new SuccubeMonster(newP1);
                m1.setNextP(nextP);
                World.getMonsters().add(m1);

                Monster m2 = new SuccubeMonster(newP2);
                m2.setNextP(nextP);
                World.getMonsters().add(m2);
            }
            
            //Spawn WolfMonster
            if(type == 3){
                Position newP = generatP();

                Monster m = new WolfMonster(newP);
                m.setNextP(nextP);
                World.getMonsters().add(m);

            }
        }
        if(life <= 910)
        	life += 90;
        else
        	life += 1000 ;

        nbrInvocation++;
    }

    /**
	 * Soigne et renforce les monstres a portee de ca capacite 
	 */
    public void heal(){
        for(Monster m : World.getMonsters()){
            if(p.dist(m.getP()) <= healRange  && m.getClass().getName() != "warcraftMonster.FinalBoss")
            	m.setLife(m.getLife() + 80);
        }
    }

    /**
	 * Genere aletoirement une position non loin de FINALBOSS
	 */
    public Position generatP(){
        int nbX = random.nextInt(7);
        int nbY = random.nextInt(7);

        float newX = p.getX() + (float)(0.01 * nbX);
        float newY = p.getY() + (float)(0.01 * nbY) ;

        return new Position(newX , newY);
    }
    
}
