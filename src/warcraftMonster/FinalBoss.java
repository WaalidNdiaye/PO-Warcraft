package warcraftMonster;

import java.util.Random;
import warcraftMain.*;

public class FinalBoss extends Monster {

    private int lastInvocation = 50;                    // Repere chronologique de la derniere invocation
    private int cooldown = 125 ;                        // Temps de rechargement
    private int nbrInvocation = 0;                      // Nombre d'invocation deja effectué
    private Random random = new Random();               // Classe pour generer des nombres aleatoire
    private float healRange = (float)0.1;               // Portée de sa capacité a soigner les monstres autours 

    public FinalBoss (Position p) {
		super(p , (float)0.06 , (float)0.0015, 700, 105, true);
	}
	
	/**
	 * Affichage du monstre qui avance 
	 */
	public void draw() {
        if(time % 14 < 10) StdDraw.picture(p.getX(), p.getY(), "images/Monster/FinalBossAnimation/0" + time % 14 +  ".png", size * 2, size * 2.5);
        else  StdDraw.picture(p.getX(), p.getY(), "images/Monster/FinalBossAnimation/" + time % 14 +  ".png", size * 2, size * 2.5);
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
        if((time - lastInvocation) > cooldown) chargeInvocation();
        if(time - lastInvocation == 9) heal();
        if( time - lastInvocation == 32) invocation();

        // Affichage de l'animation d'invocation du Boss
        if((time - lastInvocation) >= 0 && (time - lastInvocation) < 40)  drawInvocation();
        else{
            move();
	    	draw();
        }

		drawLife();
		checkpoint++;
    }

    /**
	 * Marque un repère chronologique pour declecher l'invocation
	 */
    public void chargeInvocation(){
        lastInvocation = time ;
    }

    /**
	 * Invocation 
	 */
    public void invocation (){

        // A chaque nouvelle invocation, il invoque un monstre de plus et se regenere de 80 Hp
        for(int i = 0 ; i <= nbrInvocation ; i++){

            // Creation d'un nouveau monstre (choisi aleatoirement)
            int type = random.nextInt(4);

            if(type == 1){
                 // Genere 2 nouvelle position non loin de FinalMonster
                Position newP1 = generatP();
                Position newP2 = generatP();
                
                // Creation de 2 LandMonster 
                Monster m1 = new LandMonster(newP1);
                m1.setNextP(nextP);
                World.getMonsters().add(m1);

                Monster m2 = new LandMonster(newP2);
                m2.setNextP(nextP);
                World.getMonsters().add(m2);
            }
            if(type == 2){
                // Genere 2 nouvelle position non loin de FinalMonster
                Position newP1 = generatP();
                Position newP2 = generatP();

                // Creation de 2 FlyingMonster
                Monster m1 = new FlyingMonster(newP1);
                m1.setNextP(nextP);
                World.getMonsters().add(m1);

                Monster m2 = new FlyingMonster(newP2);
                m2.setNextP(nextP);
                World.getMonsters().add(m2);
            }
            if(type == 3){
                 // Genere une nouvelle position non loin de FinalMonster
                Position newP = generatP();

                // Creation de 1 VogadorMonster
                Monster m = new FlyingMonster(newP);
                m.setNextP(nextP);
                World.getMonsters().add(m);

            }

        }

        if(life <= 640) life += 60;
        else life += 700 ;

        nbrInvocation++;

    }

    /**
	 * Soigne & et renforce les monstres a portée de ca capacité 
	 */
    public void heal(){
        for(Monster m : World.getMonsters()){
            if(p.dist(m.getP()) <= healRange) m.setLife(m.getLife() + 80 );
        }
    }


    /**
	 * Genere aletoirement une position non loin FinalBoss 
	 */
    public Position generatP(){
        // Genere aleatoirement une nouvelle position pas loin de la position de WolfBoss, pour le nouveau monstre 
        int nbX = random.nextInt(7);
        int nbY = random.nextInt(7);

        float newX = p.getX() + (float)(0.01 * nbX);
        float newY = p.getY() + (float)(0.01 * nbY) ;

        return new Position(newX , newY);
    }
}
