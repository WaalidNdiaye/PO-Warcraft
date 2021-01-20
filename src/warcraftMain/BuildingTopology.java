package warcraftMain;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class BuildingTopology {

    private List<Position> building = new ArrayList<Position>();		// Liste des postion des cases contenant batiment(pour afficher les defenceurs dessus)
    private Set<Position> path = new LinkedHashSet<Position>();               // Liste des postion des cases sur lesquels un chemin passe (pour bloquer l'affichage des defenceurs )

    /*
	 * CONSTRUCTEUR 
	 */
    public BuildingTopology(){
        buildList();
        buildPathList();
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
     * 
     */
    public void buildPathList(){

        // Chemin 1
        for(int i=1; i<24; i++){
            path.add(new Position(i * World.getSquareWidth() + World.getSquareWidth() / (float)2.0, 7 * World.getSquareHeight() + World.getSquareHeight() / (float)2.0));
        }

        // Chemin 2
        path.add(new Position(0 * World.getSquareWidth() + World.getSquareWidth() / 2, 7 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(1 * World.getSquareWidth() + World.getSquareWidth() / 2, 7 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(2 * World.getSquareWidth() + World.getSquareWidth() / 2, 7 * World.getSquareHeight() + World.getSquareHeight() / 2));
        path.add(new Position(2 * World.getSquareWidth() + World.getSquareWidth() / 2, 9 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(2 * World.getSquareWidth() + World.getSquareWidth() / 2, 10 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(3 * World.getSquareWidth() + World.getSquareWidth() / 2, 10 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(4 * World.getSquareWidth() + World.getSquareWidth() / 2, 10 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(4 * World.getSquareWidth() + World.getSquareWidth() / 2, 11 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(4 * World.getSquareWidth() + World.getSquareWidth() / 2, 12 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(4 * World.getSquareWidth() + World.getSquareWidth() / 2, 13 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(5 * World.getSquareWidth() + World.getSquareWidth() / 2, 13 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(6 * World.getSquareWidth() + World.getSquareWidth() / 2, 13 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(7 * World.getSquareWidth() + World.getSquareWidth() / 2, 13 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(8 * World.getSquareWidth() + World.getSquareWidth() / 2, 13 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(9 * World.getSquareWidth() + World.getSquareWidth() / 2, 13 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(9 * World.getSquareWidth() + World.getSquareWidth() / 2, 12 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(9 * World.getSquareWidth() + World.getSquareWidth() / 2, 11 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(9 * World.getSquareWidth() + World.getSquareWidth() / 2, 10 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(10 * World.getSquareWidth() + World.getSquareWidth() / 2, 10 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(11 * World.getSquareWidth() + World.getSquareWidth() / 2, 10 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(12 * World.getSquareWidth() + World.getSquareWidth() / 2, 10 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(12 * World.getSquareWidth() + World.getSquareWidth() / 2, 11 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(12 * World.getSquareWidth() + World.getSquareWidth() / 2, 12 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(13 * World.getSquareWidth() + World.getSquareWidth() / 2, 12 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(13 * World.getSquareWidth() + World.getSquareWidth() / 2, 13 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(13 * World.getSquareWidth() + World.getSquareWidth() / 2, 13 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(14 * World.getSquareWidth() + World.getSquareWidth() / 2, 13 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(15 * World.getSquareWidth() + World.getSquareWidth() / 2, 13 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(16 * World.getSquareWidth() + World.getSquareWidth() / 2, 13 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(17 * World.getSquareWidth() + World.getSquareWidth() / 2, 13 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(17 * World.getSquareWidth() + World.getSquareWidth() / 2, 12 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(17 * World.getSquareWidth() + World.getSquareWidth() / 2, 11 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(17 * World.getSquareWidth() + World.getSquareWidth() / 2, 10 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(17 * World.getSquareWidth() + World.getSquareWidth() / 2, 9 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(17 * World.getSquareWidth() + World.getSquareWidth() / 2, 8 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(17 * World.getSquareWidth() + World.getSquareWidth() / 2, 7 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(17 * World.getSquareWidth() + World.getSquareWidth() / 2, 7 * World.getSquareHeight() + World.getSquareHeight() / 2));
        path.add(new Position(18 * World.getSquareWidth() + World.getSquareWidth() / 2, 7 * World.getSquareHeight() + World.getSquareHeight() / 2));
        path.add(new Position(19 * World.getSquareWidth() + World.getSquareWidth() / 2, 7 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(20 * World.getSquareWidth() + World.getSquareWidth() / 2, 7 * World.getSquareHeight() + World.getSquareHeight() / 2));
        path.add(new Position(21 * World.getSquareWidth() + World.getSquareWidth() / 2, 7 * World.getSquareHeight() + World.getSquareHeight() / 2));
        path.add(new Position(22 * World.getSquareWidth() + World.getSquareWidth() / 2, 7 * World.getSquareHeight() + World.getSquareHeight() / 2));
        path.add(new Position(23 * World.getSquareWidth() + World.getSquareWidth() / 2, 7 * World.getSquareHeight() + World.getSquareHeight() / 2));
        

        // Chemin 3
		path.add(new Position(3 * World.getSquareWidth() + World.getSquareWidth() / 2, 7 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(4 * World.getSquareWidth() + World.getSquareWidth() / 2, 7 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(5 * World.getSquareWidth() + World.getSquareWidth() / 2, 7 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(5 * World.getSquareWidth() + World.getSquareWidth() / 2, 8 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(5 * World.getSquareWidth() + World.getSquareWidth() / 2, 9 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(5 * World.getSquareWidth() + World.getSquareWidth() / 2, 10 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(9 * World.getSquareWidth() + World.getSquareWidth() / 2, 13 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(9 * World.getSquareWidth() + World.getSquareWidth() / 2, 12 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(9 * World.getSquareWidth() + World.getSquareWidth() / 2, 11 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(9 * World.getSquareWidth() + World.getSquareWidth() / 2, 10 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(9 * World.getSquareWidth() + World.getSquareWidth() / 2, 10 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(10 * World.getSquareWidth() + World.getSquareWidth() / 2, 10 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(11 * World.getSquareWidth() + World.getSquareWidth() / 2, 10 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(12 * World.getSquareWidth() + World.getSquareWidth() / 2, 10 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(13 * World.getSquareWidth() + World.getSquareWidth() / 2, 10 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(14 * World.getSquareWidth() + World.getSquareWidth() / 2, 10 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(15 * World.getSquareWidth() + World.getSquareWidth() / 2, 10 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(16 * World.getSquareWidth() + World.getSquareWidth() / 2, 10 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(17 * World.getSquareWidth() + World.getSquareWidth() / 2, 10 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(17 * World.getSquareWidth() + World.getSquareWidth() / 2, 11 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(17 * World.getSquareWidth() + World.getSquareWidth() / 2, 12 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(18 * World.getSquareWidth() + World.getSquareWidth() / 2, 12 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(19 * World.getSquareWidth() + World.getSquareWidth() / 2, 12 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(19 * World.getSquareWidth() + World.getSquareWidth() / 2, 11 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(20 * World.getSquareWidth() + World.getSquareWidth() / 2, 11 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(20 * World.getSquareWidth() + World.getSquareWidth() / 2, 11 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(20 * World.getSquareWidth() + World.getSquareWidth() / 2, 10 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(20 * World.getSquareWidth() + World.getSquareWidth() / 2, 9 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(20 * World.getSquareWidth() + World.getSquareWidth() / 2, 8 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(20 * World.getSquareWidth() + World.getSquareWidth() / 2, 7 * World.getSquareHeight() + World.getSquareHeight() / 2));
		
        
        // Chemin 4
		path.add(new Position(3 * World.getSquareWidth() + World.getSquareWidth() / 2, 7 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(4 * World.getSquareWidth() + World.getSquareWidth() / 2, 7 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(4 * World.getSquareWidth() + World.getSquareWidth() / 2, 6 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(4 * World.getSquareWidth() + World.getSquareWidth() / 2, 5 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(4 * World.getSquareWidth() + World.getSquareWidth() / 2, 4 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(3 * World.getSquareWidth() + World.getSquareWidth() / 2, 4 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(2 * World.getSquareWidth() + World.getSquareWidth() / 2, 4 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(1 * World.getSquareWidth() + World.getSquareWidth() / 2, 4 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(1 * World.getSquareWidth() + World.getSquareWidth() / 2, 3 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(1 * World.getSquareWidth() + World.getSquareWidth() / 2, 2 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(1 * World.getSquareWidth() + World.getSquareWidth() / 2, 1 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(1 * World.getSquareWidth() + World.getSquareWidth() / 2, 1 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(2 * World.getSquareWidth() + World.getSquareWidth() / 2, 1 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(3 * World.getSquareWidth() + World.getSquareWidth() / 2, 1 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(4 * World.getSquareWidth() + World.getSquareWidth() / 2, 1 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(5 * World.getSquareWidth() + World.getSquareWidth() / 2, 1 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(5 * World.getSquareWidth() + World.getSquareWidth() / 2, 2 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(6 * World.getSquareWidth() + World.getSquareWidth() / 2, 2 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(7 * World.getSquareWidth() + World.getSquareWidth() / 2, 2 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(8 * World.getSquareWidth() + World.getSquareWidth() / 2, 2 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(8 * World.getSquareWidth() + World.getSquareWidth() / 2, 3 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(8 * World.getSquareWidth() + World.getSquareWidth() / 2, 4 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(8 * World.getSquareWidth() + World.getSquareWidth() / 2, 5 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(8 * World.getSquareWidth() + World.getSquareWidth() / 2, 6 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(8 * World.getSquareWidth() + World.getSquareWidth() / 2, 7 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(9 * World.getSquareWidth() + World.getSquareWidth() / 2, 7 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(10 * World.getSquareWidth() + World.getSquareWidth() / 2, 7 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(11 * World.getSquareWidth() + World.getSquareWidth() / 2, 7 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(12 * World.getSquareWidth() + World.getSquareWidth() / 2, 7 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(12 * World.getSquareWidth() + World.getSquareWidth() / 2, 6 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(12 * World.getSquareWidth() + World.getSquareWidth() / 2, 5 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(12 * World.getSquareWidth() + World.getSquareWidth() / 2, 4 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(12 * World.getSquareWidth() + World.getSquareWidth() / 2, 3 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(11 * World.getSquareWidth() + World.getSquareWidth() / 2, 3 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(11 * World.getSquareWidth() + World.getSquareWidth() / 2, 2 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(11 * World.getSquareWidth() + World.getSquareWidth() / 2, 1 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(12 * World.getSquareWidth() + World.getSquareWidth() / 2, 1 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(13 * World.getSquareWidth() + World.getSquareWidth() / 2, 1 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(14 * World.getSquareWidth() + World.getSquareWidth() / 2, 1 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(15 * World.getSquareWidth() + World.getSquareWidth() / 2, 1 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(15 * World.getSquareWidth() + World.getSquareWidth() / 2, 2 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(15 * World.getSquareWidth() + World.getSquareWidth() / 2, 3 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(15 * World.getSquareWidth() + World.getSquareWidth() / 2, 4 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(16 * World.getSquareWidth() + World.getSquareWidth() / 2, 4 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(17 * World.getSquareWidth() + World.getSquareWidth() / 2, 4 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(18 * World.getSquareWidth() + World.getSquareWidth() / 2, 4 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(19 * World.getSquareWidth() + World.getSquareWidth() / 2, 4 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(20 * World.getSquareWidth() + World.getSquareWidth() / 2, 4 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(21 * World.getSquareWidth() + World.getSquareWidth() / 2, 4 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(21 * World.getSquareWidth() + World.getSquareWidth() / 2, 5 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(21 * World.getSquareWidth() + World.getSquareWidth() / 2, 6 * World.getSquareHeight() + World.getSquareHeight() / 2));
		
		
		// Chemin 5
		path.add(new Position(3 * World.getSquareWidth() + World.getSquareWidth() / 2, 7 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(4 * World.getSquareWidth() + World.getSquareWidth() / 2, 7 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(5 * World.getSquareWidth() + World.getSquareWidth() / 2, 7 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(6 * World.getSquareWidth() + World.getSquareWidth() / 2, 7 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(7 * World.getSquareWidth() + World.getSquareWidth() / 2, 7 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(8 * World.getSquareWidth() + World.getSquareWidth() / 2, 7 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(9 * World.getSquareWidth() + World.getSquareWidth() / 2, 7 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(10 * World.getSquareWidth() + World.getSquareWidth() / 2, 7 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(11 * World.getSquareWidth() + World.getSquareWidth() / 2, 7 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(12 * World.getSquareWidth() + World.getSquareWidth() / 2, 7 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(12 * World.getSquareWidth() + World.getSquareWidth() / 2, 8 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(12 * World.getSquareWidth() + World.getSquareWidth() / 2, 9 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(12 * World.getSquareWidth() + World.getSquareWidth() / 2, 10 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(13 * World.getSquareWidth() + World.getSquareWidth() / 2, 10 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(14 * World.getSquareWidth() + World.getSquareWidth() / 2, 10 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(15 * World.getSquareWidth() + World.getSquareWidth() / 2, 10 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(16 * World.getSquareWidth() + World.getSquareWidth() / 2, 10 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(17 * World.getSquareWidth() + World.getSquareWidth() / 2, 10 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(17 * World.getSquareWidth() + World.getSquareWidth() / 2, 9 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(17 * World.getSquareWidth() + World.getSquareWidth() / 2, 8 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(17 * World.getSquareWidth() + World.getSquareWidth() / 2, 7 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(17 * World.getSquareWidth() + World.getSquareWidth() / 2, 6 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(17 * World.getSquareWidth() + World.getSquareWidth() / 2, 5 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(17 * World.getSquareWidth() + World.getSquareWidth() / 2, 4 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(16 * World.getSquareWidth() + World.getSquareWidth() / 2, 4 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(15 * World.getSquareWidth() + World.getSquareWidth() / 2, 4 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(15 * World.getSquareWidth() + World.getSquareWidth() / 2, 3 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(15 * World.getSquareWidth() + World.getSquareWidth() / 2, 2 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(16 * World.getSquareWidth() + World.getSquareWidth() / 2, 2 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(17 * World.getSquareWidth() + World.getSquareWidth() / 2, 2 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(17 * World.getSquareWidth() + World.getSquareWidth() / 2, 1 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(18 * World.getSquareWidth() + World.getSquareWidth() / 2, 1 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(19 * World.getSquareWidth() + World.getSquareWidth() / 2, 1 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(20 * World.getSquareWidth() + World.getSquareWidth() / 2, 1 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(20 * World.getSquareWidth() + World.getSquareWidth() / 2, 2 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(20 * World.getSquareWidth() + World.getSquareWidth() / 2, 3 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(20 * World.getSquareWidth() + World.getSquareWidth() / 2, 4 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(21 * World.getSquareWidth() + World.getSquareWidth() / 2, 4 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(21 * World.getSquareWidth() + World.getSquareWidth() / 2, 5 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(21 * World.getSquareWidth() + World.getSquareWidth() / 2, 6 * World.getSquareHeight() + World.getSquareHeight() / 2));
		
		
        // Chemin 6
		path.add(new Position(2 * World.getSquareWidth() + World.getSquareWidth() / 2, 8 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(5 * World.getSquareWidth() + World.getSquareWidth() / 2, 10 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(5 * World.getSquareWidth() + World.getSquareWidth() / 2, 9 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(5 * World.getSquareWidth() + World.getSquareWidth() / 2, 8 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(5 * World.getSquareWidth() + World.getSquareWidth() / 2, 7 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(4 * World.getSquareWidth() + World.getSquareWidth() / 2, 7 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(4 * World.getSquareWidth() + World.getSquareWidth() / 2, 7 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(4 * World.getSquareWidth() + World.getSquareWidth() / 2, 6 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(4 * World.getSquareWidth() + World.getSquareWidth() / 2, 5 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(4 * World.getSquareWidth() + World.getSquareWidth() / 2, 4 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(5 * World.getSquareWidth() + World.getSquareWidth() / 2, 4 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(5 * World.getSquareWidth() + World.getSquareWidth() / 2, 3 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(5 * World.getSquareWidth() + World.getSquareWidth() / 2, 2 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(6 * World.getSquareWidth() + World.getSquareWidth() / 2, 2 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(7 * World.getSquareWidth() + World.getSquareWidth() / 2, 2 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(8 * World.getSquareWidth() + World.getSquareWidth() / 2, 2 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(8 * World.getSquareWidth() + World.getSquareWidth() / 2, 3 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(8 * World.getSquareWidth() + World.getSquareWidth() / 2, 3 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(9 * World.getSquareWidth() + World.getSquareWidth() / 2, 3 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(10 * World.getSquareWidth() + World.getSquareWidth() / 2, 3 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(11 * World.getSquareWidth() + World.getSquareWidth() / 2, 3 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(12 * World.getSquareWidth() + World.getSquareWidth() / 2, 3 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(12 * World.getSquareWidth() + World.getSquareWidth() / 2, 4 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(13 * World.getSquareWidth() + World.getSquareWidth() / 2, 4 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(14 * World.getSquareWidth() + World.getSquareWidth() / 2, 4 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(15 * World.getSquareWidth() + World.getSquareWidth() / 2, 4 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(16 * World.getSquareWidth() + World.getSquareWidth() / 2, 4 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(17 * World.getSquareWidth() + World.getSquareWidth() / 2, 4 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(17 * World.getSquareWidth() + World.getSquareWidth() / 2, 4 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(17 * World.getSquareWidth() + World.getSquareWidth() / 2, 5 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(17 * World.getSquareWidth() + World.getSquareWidth() / 2, 6 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(17 * World.getSquareWidth() + World.getSquareWidth() / 2, 7 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(20 * World.getSquareWidth() + World.getSquareWidth() / 2, 7 * World.getSquareHeight() + World.getSquareHeight() / 2));
		
        
        // Chemin 7
		path.add(new Position(9 * World.getSquareWidth() + World.getSquareWidth() / 2, 13 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(9 * World.getSquareWidth() + World.getSquareWidth() / 2, 12 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(9 * World.getSquareWidth() + World.getSquareWidth() / 2, 11 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(9 * World.getSquareWidth() + World.getSquareWidth() / 2, 10 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(10 * World.getSquareWidth() + World.getSquareWidth() / 2, 10 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(11 * World.getSquareWidth() + World.getSquareWidth() / 2, 10 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(12 * World.getSquareWidth() + World.getSquareWidth() / 2, 10 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(13 * World.getSquareWidth() + World.getSquareWidth() / 2, 10 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(14 * World.getSquareWidth() + World.getSquareWidth() / 2, 10 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(15 * World.getSquareWidth() + World.getSquareWidth() / 2, 10 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(16 * World.getSquareWidth() + World.getSquareWidth() / 2, 10 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(17 * World.getSquareWidth() + World.getSquareWidth() / 2, 10 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(17 * World.getSquareWidth() + World.getSquareWidth() / 2, 9 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(17 * World.getSquareWidth() + World.getSquareWidth() / 2, 8 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(17 * World.getSquareWidth() + World.getSquareWidth() / 2, 7 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(17 * World.getSquareWidth() + World.getSquareWidth() / 2, 6 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(17 * World.getSquareWidth() + World.getSquareWidth() / 2, 5 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(17 * World.getSquareWidth() + World.getSquareWidth() / 2, 4 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(16 * World.getSquareWidth() + World.getSquareWidth() / 2, 4 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(15 * World.getSquareWidth() + World.getSquareWidth() / 2, 4 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(14 * World.getSquareWidth() + World.getSquareWidth() / 2, 4 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(13 * World.getSquareWidth() + World.getSquareWidth() / 2, 4 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(12 * World.getSquareWidth() + World.getSquareWidth() / 2, 4 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(12 * World.getSquareWidth() + World.getSquareWidth() / 2, 3 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(11 * World.getSquareWidth() + World.getSquareWidth() / 2, 3 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(10 * World.getSquareWidth() + World.getSquareWidth() / 2, 3 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(9 * World.getSquareWidth() + World.getSquareWidth() / 2, 3 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(8 * World.getSquareWidth() + World.getSquareWidth() / 2, 3 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(8 * World.getSquareWidth() + World.getSquareWidth() / 2, 4 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(8 * World.getSquareWidth() + World.getSquareWidth() / 2, 5 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(8 * World.getSquareWidth() + World.getSquareWidth() / 2, 6 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(8 * World.getSquareWidth() + World.getSquareWidth() / 2, 7 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(9 * World.getSquareWidth() + World.getSquareWidth() / 2, 7 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(10 * World.getSquareWidth() + World.getSquareWidth() / 2, 7 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(11 * World.getSquareWidth() + World.getSquareWidth() / 2, 7 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(12 * World.getSquareWidth() + World.getSquareWidth() / 2, 7 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(12 * World.getSquareWidth() + World.getSquareWidth() / 2, 8 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(12 * World.getSquareWidth() + World.getSquareWidth() / 2, 9 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(12 * World.getSquareWidth() + World.getSquareWidth() / 2, 10 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(13 * World.getSquareWidth() + World.getSquareWidth() / 2, 10 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(14 * World.getSquareWidth() + World.getSquareWidth() / 2, 10 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(15 * World.getSquareWidth() + World.getSquareWidth() / 2, 10 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(16 * World.getSquareWidth() + World.getSquareWidth() / 2, 10 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(17 * World.getSquareWidth() + World.getSquareWidth() / 2, 10 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(17 * World.getSquareWidth() + World.getSquareWidth() / 2, 11 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(17 * World.getSquareWidth() + World.getSquareWidth() / 2, 12 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(18 * World.getSquareWidth() + World.getSquareWidth() / 2, 12 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(19 * World.getSquareWidth() + World.getSquareWidth() / 2, 12 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(19 * World.getSquareWidth() + World.getSquareWidth() / 2, 11 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(20 * World.getSquareWidth() + World.getSquareWidth() / 2, 11 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(20 * World.getSquareWidth() + World.getSquareWidth() / 2, 10 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(20 * World.getSquareWidth() + World.getSquareWidth() / 2, 9 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(20 * World.getSquareWidth() + World.getSquareWidth() / 2, 8 * World.getSquareHeight() + World.getSquareHeight() / 2));
        path.add(new Position(20 * World.getSquareWidth() + World.getSquareWidth() / 2, 7 * World.getSquareHeight() + World.getSquareHeight() / 2));
        

        // Douve devant le chateau 
        for(int i=1; i<15; i++){
            path.add(new Position(22 * World.getSquareWidth() + World.getSquareWidth() / (float)2.0, i * World.getSquareHeight() + World.getSquareHeight() / (float)2.0));
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
	 * Verifie si un batiement est present a la position p
	 * @param p 		- a la position p
	 * @return          - true si un batiment est present a cette position sinon false 
	 */
    public boolean onPath(Position p){
        boolean onPath = false ;
        for(Position pPath : this.path){
            // if(p.equalsP(pPath)) isPath = true ;
            if (p.getX() >= pPath.getX()-0.03 && p.getX() <= pPath.getX() + 0.03){
                if(p.getY() >= pPath.getY()-0.03 && p.getY() <= pPath.getY() + 0.03) onPath = true ;
            }
        }
        return onPath ;
    }
}
