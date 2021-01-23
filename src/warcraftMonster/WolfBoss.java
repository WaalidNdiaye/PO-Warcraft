package warcraftMonster;

import java.util.Random;
import warcraftMain.*;

public class WolfBoss extends Monster {

    private int lastInvocation = 50;                    // Repere chronologique de la derniere invocation
    private int cooldown = 125 ;                        // Temps de rechargement
    private int nbrInvocation = 0;                      // Nombre d'invocation deja effectu√©

    /**
     * Constructeur
     * @param p position
     */
    public WolfBoss (Position p) {
		super(p , (float)0.04 , (float)0.00225, 600, 35, false);
	}
	
	/**
	 * Affichage du monstre qui avance 
	 */
	public void draw() {
        if(time % 16 < 10)
        	StdDraw.picture(p.getX(), p.getY(), "images/Monster/WolfBossAnimation/0" + time % 16 +  ".png", size * 2, size * 2.5);
        else
        	StdDraw.picture(p.getX(), p.getY(), "images/Monster/WolfBossAnimation/" + time % 16 +  ".png", size * 2, size * 2.5);
    }

    /**
	 * Affichage de l'animation d'invocation du Boss
	 */
    public void drawInvocation(){
        StdDraw.picture(p.getX(), p.getY(), "images/Monster/WolfBossAnimation/" + (time - lastInvocation + 16) +  ".png", size * 2, size * 2.5);
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
        if( time - lastInvocation == 25)
        	invocation();

        // Affichage de l'animation d'invocation du Boss
        if((time - lastInvocation) >= 0 && (time - lastInvocation) < 16)
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
	 * 	- A chaque nouvelle invocation, il invoque un wolfMonster de plus et se regenere de 80 Hp
	 * 	- Il les fait spawn a une position alÈatoire non loin de lui
	 */
    public void invocation (){
        for(int i = 0 ; i <= nbrInvocation ; i++){
            Random random = new Random();
            int nbX = random.nextInt(6);
            int nbY = random.nextInt(6);

            float newX = p.getX() + (float)(0.01 * nbX);
            float newY = p.getY() + (float)(0.01 * nbY) ;

            Position newP = new Position(newX , newY);
            
            Monster m = new WolfMonster(newP);
            m.setNextP(nextP);

            World.getMonsters().add(m);
        }
        if(life <= 550)
        	life += 50;
        else
        	life = 600;

        nbrInvocation++;
    }
    
}
