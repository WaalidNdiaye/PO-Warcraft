package warcraftMain;

import java.util.ArrayList;
import java.util.List;

public class BuildingTopology {

    private List<Position> building = new ArrayList<Position>();		// Liste des postion des cases contenant batiment(pour afficher les defenceurs dessus)

    /*
	 * CONSTRUCTEUR 
	 */
    public BuildingTopology(){
        buildList();
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
}
