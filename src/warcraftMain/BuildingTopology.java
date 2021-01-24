package warcraftMain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import warcraftPath.*;

public class BuildingTopology {

	private List<Position> building = new ArrayList<Position>();		// Liste des postions des cases contenant batiment(pour afficher les defenceurs dessus)
	/* Liste des postions sur lesquels on ne peut pas poser de défenceur.
	 * (les cases sur lesquels un chemin ou une douve passe et les cases ou est afficher le terminal)
	 */
	private List<Position> canAdd = new LinkedList<Position>();         
	
	

    /*
	 * CONSTRUCTEUR 
	 */
    public BuildingTopology(){
        buildList();
		buildPathList();
		buildMoatList();
		buildTermnalList();
    }

    /*
	 * Construit la liste building en ajoutant chaque case où un batiment est situé 
	 */
    public void buildList(){
        float caseW = (float)(1.0 / 15.0) ;
        float caseH = (float)(1.0 / 24.0);
        float caseWmid = (float)(caseW / 3.0);
        float caseHmid = (float)(caseH / 3.0);

        // Ligne 16 (la ligne tout en haut)
        building.add(new Position((float)((float)(caseH*8.0 )-caseHmid) , (float)((float)(caseW*15.0)-caseWmid)));
        building.add(new Position((float)((float)(caseH*9.0 )-caseHmid) , (float)((float)(caseW*15.0)-caseWmid)));
        building.add(new Position((float)((float)(caseH*13.0)-caseHmid) , (float)((float)(caseW*15.0)-caseWmid)));
        building.add(new Position((float)((float)(caseH*14.0)-caseHmid) , (float)((float)(caseW*15.0)-caseWmid)));
        building.add(new Position((float)((float)(caseH*15.0)-caseHmid) , (float)((float)(caseW*15.0)-caseWmid)));
        building.add(new Position((float)((float)(caseH*16.0)-caseHmid) , (float)((float)(caseW*15.0)-caseWmid)));
        building.add(new Position((float)((float)(caseH*17.0)-caseHmid) , (float)((float)(caseW*15.0)-caseWmid)));
        building.add(new Position((float)((float)(caseH*18.0)-caseHmid) , (float)((float)(caseW*15.0)-caseWmid)));
        building.add(new Position((float)((float)(caseH*19.0)-caseHmid) , (float)((float)(caseW*15.0)-caseWmid)));

        // Ligne 14
        building.add(new Position((float)((float)(caseH*13.0)-caseHmid) , (float)((float)(caseW*14.0)-caseWmid)));
        building.add(new Position((float)((float)(caseH*19.0)-caseHmid) , (float)((float)(caseW*14.0)-caseWmid)));
        building.add(new Position((float)((float)(caseH*22.0)-caseHmid) , (float)((float)(caseW*14.0)-caseWmid)));

        // Ligne 13
        building.add(new Position( (float)((float)(caseH*8.0 )-caseHmid) , (float)((float)(caseW*13.0)-caseWmid)));
        building.add(new Position( (float)((float)(caseH*9.0 )-caseHmid) , (float)((float)(caseW*13.0)-caseWmid)));
        building.add(new Position( (float)((float)(caseH*15.0)-caseHmid) , (float)((float)(caseW*13.0)-caseWmid)));
        building.add(new Position( (float)((float)(caseH*16.0)-caseHmid) , (float)((float)(caseW*13.0)-caseWmid)));
        building.add(new Position( (float)((float)(caseH*17.0)-caseHmid) , (float)((float)(caseW*13.0)-caseWmid)));
        building.add(new Position( (float)((float)(caseH*22.0)-caseHmid) , (float)((float)(caseW*13.0)-caseWmid)));

         // Ligne 12
        building.add(new Position( (float)((float)(caseH*8.0 )-caseHmid) , (float)((float)(caseW*12.0)-caseWmid)));
        building.add(new Position( (float)((float)(caseH*9.0 )-caseHmid) , (float)((float)(caseW*12.0)-caseWmid)));
        building.add(new Position( (float)((float)(caseH*15.0)-caseHmid) , (float)((float)(caseW*12.0)-caseWmid)));
        building.add(new Position( (float)((float)(caseH*16.0)-caseHmid) , (float)((float)(caseW*12.0)-caseWmid)));
        building.add(new Position( (float)((float)(caseH*17.0)-caseHmid) , (float)((float)(caseW*12.0)-caseWmid)));
        building.add(new Position( (float)((float)(caseH*22.0)-caseHmid) , (float)((float)(caseW*12.0)-caseWmid)));

         // Ligne 11
        building.add(new Position( (float)((float)(caseH*8.0 )-caseHmid) , (float)((float)(caseW*11.0)-caseWmid)));
        building.add(new Position( (float)((float)(caseH*9.0 )-caseHmid) , (float)((float)(caseW*11.0)-caseWmid)));
        building.add(new Position( (float)((float)(caseH*19.0)-caseHmid) , (float)((float)(caseW*11.0)-caseWmid)));
        building.add(new Position( (float)((float)(caseH*20.0)-caseHmid) , (float)((float)(caseW*11.0)-caseWmid)));
        building.add(new Position( (float)((float)(caseH*22.0)-caseHmid) , (float)((float)(caseW*11.0)-caseWmid)));

         // Ligne 10
        building.add(new Position( (float)((float)(caseH*8.0 )-caseHmid) , (float)((float)(caseW*10.0)-caseWmid)));
        building.add(new Position( (float)((float)(caseH*9.0 )-caseHmid) , (float)((float)(caseW*10.0)-caseWmid)));
        building.add(new Position( (float)((float)(caseH*10.0)-caseHmid) , (float)((float)(caseW*10.0)-caseWmid)));
        building.add(new Position( (float)((float)(caseH*12.0)-caseHmid) , (float)((float)(caseW*10.0)-caseWmid)));
        building.add(new Position( (float)((float)(caseH*19.0)-caseHmid) , (float)((float)(caseW*10.0)-caseWmid)));
        building.add(new Position( (float)((float)(caseH*20.0)-caseHmid) , (float)((float)(caseW*10.0)-caseWmid)));
        building.add(new Position( (float)((float)(caseH*22.0)-caseHmid) , (float)((float)(caseW*10.0)-caseWmid)));
        building.add(new Position( (float)((float)(caseH*19.0)-caseHmid) , (float)((float)(caseW*10.0)-caseWmid)));

         // Ligne 9
        building.add(new Position( (float)((float)(caseH*4.0 )-caseHmid) , (float)((float)(caseW*9.0)-caseWmid)));
        building.add(new Position( (float)((float)(caseH*5.0 )-caseHmid) , (float)((float)(caseW*9.0)-caseWmid)));
        building.add(new Position( (float)((float)(caseH*8.0 )-caseHmid) , (float)((float)(caseW*9.0)-caseWmid)));
        building.add(new Position( (float)((float)(caseH*9.0 )-caseHmid) , (float)((float)(caseW*9.0)-caseWmid)));
        building.add(new Position( (float)((float)(caseH*10.0)-caseHmid) , (float)((float)(caseW*9.0)-caseWmid)));
        building.add(new Position( (float)((float)(caseH*11.0)-caseHmid) , (float)((float)(caseW*9.0)-caseWmid)));
        building.add(new Position( (float)((float)(caseH*12.0)-caseHmid) , (float)((float)(caseW*9.0)-caseWmid)));
        building.add(new Position( (float)((float)(caseH*19.0)-caseHmid) , (float)((float)(caseW*9.0)-caseWmid)));
        building.add(new Position( (float)((float)(caseH*20.0)-caseHmid) , (float)((float)(caseW*9.0)-caseWmid)));
        building.add(new Position( (float)((float)(caseH*22.0)-caseHmid) , (float)((float)(caseW*9.0)-caseWmid)));

         // Ligne 7
        building.add(new Position( (float)((float)(caseH*8.0 )-caseHmid) , (float)((float)(caseW*7.0)-caseWmid)));
        building.add(new Position( (float)((float)(caseH*10.0)-caseHmid) , (float)((float)(caseW*7.0)-caseWmid)));
        building.add(new Position( (float)((float)(caseH*11.0)-caseHmid) , (float)((float)(caseW*7.0)-caseWmid)));
        building.add(new Position( (float)((float)(caseH*12.0)-caseHmid) , (float)((float)(caseW*7.0)-caseWmid)));
        building.add(new Position( (float)((float)(caseH*19.0)-caseHmid) , (float)((float)(caseW*7.0)-caseWmid)));
        building.add(new Position( (float)((float)(caseH*20.0)-caseHmid) , (float)((float)(caseW*7.0)-caseWmid)));
        building.add(new Position( (float)((float)(caseH*21.0)-caseHmid) , (float)((float)(caseW*7.0)-caseWmid)));

         // Ligne 6
        building.add(new Position( (float)((float)(caseH*8.0 )-caseHmid) , (float)((float)(caseW*6.0)-caseWmid)));
        building.add(new Position( (float)((float)(caseH*10.0)-caseHmid) , (float)((float)(caseW*6.0)-caseWmid)));
        building.add(new Position( (float)((float)(caseH*12.0)-caseHmid) , (float)((float)(caseW*6.0)-caseWmid)));
        building.add(new Position( (float)((float)(caseH*19.0)-caseHmid) , (float)((float)(caseW*6.0)-caseWmid)));
        building.add(new Position( (float)((float)(caseH*20.0)-caseHmid) , (float)((float)(caseW*6.0)-caseWmid)));
        building.add(new Position( (float)((float)(caseH*21.0)-caseHmid) , (float)((float)(caseW*6.0)-caseWmid)));

         // Ligne 5
        building.add(new Position( (float)((float)(caseH*8.0 )-caseHmid) , (float)((float)(caseW*5.0)-caseWmid)));
        building.add(new Position( (float)((float)(caseH*10.0)-caseHmid) , (float)((float)(caseW*5.0)-caseWmid)));
        building.add(new Position( (float)((float)(caseH*11.0)-caseHmid) , (float)((float)(caseW*5.0)-caseWmid)));
        building.add(new Position( (float)((float)(caseH*12.0)-caseHmid) , (float)((float)(caseW*5.0)-caseWmid)));

         // Ligne 4
        building.add(new Position( (float)((float)(caseH*5.0 )-caseHmid) , (float)((float)(caseW*4.0)-caseWmid)));
        building.add(new Position( (float)((float)(caseH*8.0 )-caseHmid) , (float)((float)(caseW*4.0)-caseWmid)));
        building.add(new Position( (float)((float)(caseH*14.0)-caseHmid) , (float)((float)(caseW*4.0)-caseWmid)));
        building.add(new Position( (float)((float)(caseH*15.0)-caseHmid) , (float)((float)(caseW*4.0)-caseWmid)));
        building.add(new Position( (float)((float)(caseH*6.0 )-caseHmid) , (float)((float)(caseW*4.0)-caseWmid)));
        building.add(new Position( (float)((float)(caseH*18.0)-caseHmid) , (float)((float)(caseW*4.0)-caseWmid)));
        building.add(new Position( (float)((float)(caseH*19.0)-caseHmid) , (float)((float)(caseW*4.0)-caseWmid)));
        building.add(new Position( (float)((float)(caseH*20.0)-caseHmid) , (float)((float)(caseW*4.0)-caseWmid)));
        building.add(new Position( (float)((float)(caseH*22.0)-caseHmid) , (float)((float)(caseW*4.0)-caseWmid)));
        
         // Ligne 3
        building.add(new Position( (float)((float)(caseH*5.0 )-caseHmid) , (float)((float)(caseW*3.0)-caseWmid)));
        building.add(new Position( (float)((float)(caseH*11.0)-caseHmid) , (float)((float)(caseW*3.0)-caseWmid)));
        building.add(new Position( (float)((float)(caseH*14.0)-caseHmid) , (float)((float)(caseW*3.0)-caseWmid)));
        building.add(new Position( (float)((float)(caseH*20.0)-caseHmid) , (float)((float)(caseW*3.0)-caseWmid)));
        building.add(new Position( (float)((float)(caseH*22.0)-caseHmid) , (float)((float)(caseW*3.0)-caseWmid)));
        
         // Ligne 2
        building.add(new Position( (float)((float)(caseH*8.0 )-caseHmid) , (float)((float)(caseW*2.0)-caseWmid)));
        building.add(new Position( (float)((float)(caseH*9.0 )-caseHmid) , (float)((float)(caseW*2.0)-caseWmid)));
        building.add(new Position( (float)((float)(caseH*11.0)-caseHmid) , (float)((float)(caseW*2.0)-caseWmid)));
        building.add(new Position( (float)((float)(caseH*22.0)-caseHmid) , (float)((float)(caseW*2.0)-caseWmid)));

         // Ligne 1
        building.add(new Position( (float)((float)(caseH*8.0)-caseHmid) , (float)((float)(caseW*1.0)-caseWmid)));
        building.add(new Position( (float)((float)(caseH*9.0)-caseHmid) , (float)((float)(caseW*1.0)-caseWmid)));
        for (int i = 11 ; i <= 22 ; i++) building.add(new Position((float)((float)(caseH*i)-caseHmid) , (float)((float)(caseW*1.0 )- caseWmid)));
        
    }

    /** 
     * Construction de la liste en ajoutant chaque case ou un chemin est situé (pour empecher les defenceurs de se poser dessus)
     */
    public void buildPathList(){
		for(Position pi : Patern1.pathconstruct()) canAdd.add( new Position(pi) );
		for(Position pi : Patern2.pathconstruct()) canAdd.add( new Position(pi) );
		for(Position pi : Patern3.pathconstruct()) canAdd.add( new Position(pi) );
		for(Position pi : Patern4.pathconstruct()) canAdd.add( new Position(pi) );
		for(Position pi : Patern5.pathconstruct()) canAdd.add( new Position(pi) );
		for(Position pi : Patern6.pathconstruct()) canAdd.add( new Position(pi) );
		for(Position pi : Patern7.pathconstruct()) canAdd.add( new Position(pi) );

	}
	
	/** 
     * Construction de la liste en ajoutant chaque case ou une douve est situé (pour empecher les defenceurs de se poser dessus)
     */
    public void buildMoatList(){
		for(int i=1; i<15; i++){
            canAdd.add(new Position(22 * World.getSquareWidth() + World.getSquareWidth() / (float)2.0, i * World.getSquareHeight() + World.getSquareHeight() / (float)2.0));
        }
	}

	/** 
     * Construction de la liste en ajoutant chaque case du terminal (pour empecher les defenceurs de se poser dessus)
     */
    public void buildTermnalList(){
		for(int i=11; i<15; i++){
			for(int u=0; u<4; u++){
				canAdd.add(new Position(u * World.getSquareWidth() + World.getSquareWidth() / (float)2.0, i * World.getSquareHeight() + World.getSquareHeight() / (float)2.0));
			}
        }
	}
    
    
     /**
	 * Verifie si un batiement est present a la position p
	 * @param p 		- a la position p
	 * @return          - true si un batiment est present a cette position sinon false 
	 */
    public boolean isBuilding(Position p){
        boolean isBuilding = false ;
        for(Position pBuilding : this.building){
            // if(p.equalsP(pBuilding)) isBuilding = true ;
            if (p.getX() >= pBuilding.getX()-0.03 && p.getX() <= pBuilding.getX() + 0.03){
                if(p.getY() >= pBuilding.getY()-0.03 && p.getY() <= pBuilding.getY() + 0.03) isBuilding = true ;
            }
        }
        return isBuilding ;
    }

    /**
	 * Verifie si on peut poser un défenceur a la position p
	 * @param p 		- a la position p
	 * @return          - true si on peut poser un défenceur a cette position sinon false 
	 */
    public boolean canAdd(Position p){
		boolean canAdd = true;
        for(Position pi : this.canAdd){
            if (p.getX() >= pi.getX()-0.03 && p.getX() <= pi.getX() + 0.03){
                if(p.getY() >= pi.getY()-0.03 && p.getY() <= pi.getY() + 0.03) canAdd = false ;
			}
        }
        return canAdd ;
    }
}
