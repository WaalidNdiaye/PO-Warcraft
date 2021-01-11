package warcraftMain;

import java.util.List;
import java.util.ArrayList;

import warcraftMonster.Monster;
import warcraftWave.*;
import warcraftTower.*;

public class World {
	/**
	 * Tout le programme utilise des fonction et methode static
	 * cela signifie/permet 2 choses :
	 * 
	 * 		- Il ne peut y avoir qu un seul plateau de jeu de lancer en meme temps (ce qui est ici pas derangeant
	 * 			car un joueur ne lance qu une seule partie a la fois sur son ordinateur et non plusieurs.
	 * 		
	 * 		- Cela permet de contrer le fait que certaines fonctions nous demande elles d etre en static obligatoirement
	 * 			afin d initialiser certaines valeurs par exemple.
	 */
	
	// Information sur le plateau de jeu
	private static List<Position> square;									// Liste des positions de toutes les cases du plateau de jeu (un schema se trouve dans le drive)
	private static int width = 1440;										// Largeur du plateau de jeu
	private static int height = 900;										// Hauteur du plateau de jeu
	private static int nbSquareX = 24;										// Nombre de "case" en X
	private static int nbSquareY = 15;										// Nombre de "case" en Y
	private static float squareWidth = (float)1 / nbSquareX;				// Largeur des cases
	private static float squareHeight = (float)1 / nbSquareY;				// Hauteur des cases
	private static Position spawn;											// Position par laquelle les monstres vont venir (num 8)
	private static Position chateau;										// Position du chateau (num 352)
	private static BuildingTopology building = new BuildingTopology();		// Liste de la postion des cases où un batiment est situé
	
	// Informations utilise pour le fonctionnement des vagues
	private static int nbWaves;												// Nombre de vague que le joueur souhaite jouer
	private static int currentW = 1;										// Vague actuelle
	private static List<Monster> monsters = new ArrayList<Monster>();		// Liste des monstres
	private static List <Tower> towers = new ArrayList<Tower>();			// Liste des tours presentes sur le plateau de jeu
	private static List<Position> path;										// Liste des positions du chemin utilise durant la vague en cours

	// Informations de l inventaire du joueur
	private static int life = 20;											// Nombre de points de vie du joueur
	private static int coin = 1000;											// Argent (pour acheter les tours)
	
	// Actions du joueur
	private static char key;												// Commande sur laquelle le joueur appuie (sur le clavier)
	private static float mouseX = -1;
	private static float mouseY = -1;
	private static Position pMouse = new Position(mouseX, mouseY); 			//Postion de la souri (initialisé en dehors du plateau)
	
	// Partie
	private static boolean start = false;									// Condition pour que la partie commence
	private static boolean pause = false;									// Indique si le jeu est en pause
	private static boolean end = false;										// Condition pour terminer la partie
	private static boolean win = false;										// Indique si le joueur a gagne
	private static boolean lose = false;									//Indique si le joueur a perdu
	private static int time = 0 ;											// Repere chronologique (time incremente de 1 a chaque appel de update())
	
	/**
	 * Getters and Setters
	 */
	public static List<Position> getSquare(){
		return square;
	}
	public static int getNbSquareX() {
		return nbSquareX;
	}
	public static int getNbSquareY() {
		return nbSquareY;
	}
	public static float getSquareWidth() {
		return squareWidth;
	}
	public static float getSquareHeight() {
		return squareHeight;
	}
	public static Position getSpawn() {
		return spawn;
	}
	public static int getCurrentW(){
		return currentW;
	}
	public static int getNbWaves(){
		return nbWaves;
	}
	public static List<Monster> getMonsters(){
		return monsters;
	}
	public static void setMonsters(List<Monster> m){
		monsters = m;
	}
	public static void setTowers(List<Tower> t){
		towers = t;
	}
	public static void setPath(List<Position> p){
		path = p;
	}
	public static int getCoin() {
		return coin;
	}
	public static void setCoin(int newCoin) {
		coin = newCoin;
	}
	public static void setPause(boolean setPause) {
		pause = setPause;
	}
	public static int getTime(){
		return time;
	}
	public static List<Position> getPath(){
		return path ;
	}
	public static BuildingTopology getBuilding() {
		return building;
	}
	public static void setBuilding(BuildingTopology building) {
		World.building = building;
	}
	
	/**
	 * Initialisation du plateau de jeu
	 * 		- Initialisation du spawn
	 * 				--> a la case num 8 du plateau de jeu
	 *  	- Initialisation du chateau
	 * 				--> a la case num 352 du plateau de jeu
	 */
	public World() {
		square = Square.setBoard();
		spawn = square.get(8);
		chateau = square.get(352);

		StdDraw.setCanvasSize(width, height);
		StdDraw.enableDoubleBuffering();
	}

					//******************************************************//
					//	//////	   //////	   ////	    //	   ///	    //	//
					//	//	  //   //	//	 //	   //    //   // //   //	//
					//	//	  //   /////     ////////    //   // //   //	//
					//	//	  //   //	//   //	   //	  // //   // //		//
					//	//////	   //	//   //	   //	   ///	   ///		//
					//******************************************************//
	/**
	 * Definit le background du menu principal
	 */
	public static void drawMenu() {
		StdDraw.picture(0.5, 0.5, "images/menu.png", 1, 1);
		StdDraw.picture(Square.normalizedX(mouseX), Square.normalizedY(mouseY), "images/select.png", squareWidth, squareHeight);
	}
	
	/**
	 * Definit le decors du plateau de jeu.
	 */
	public static void drawBackground() {
		StdDraw.picture(0.5, 0.5, "images/background.png", 1, 1);
		StdDraw.picture(0.02, 0.6, "images/Spawner.png", (1.0/24.0) * 4, (1.0/15.0) * 4);
	}

	/**
	 * Affiche differentes informations a l ecran
	 * 		- la vie du joueur (life)
	 * 		- l argent qu il possede dans son inventaire (coin)
	 */
	public static void drawInfos() {
		StdDraw.picture(0.92, 0.92, "images/SupportDrawInfos.png" , 0.13, 0.13);
		drawLife();
		drawCoin();
	}

	/**
	 * Affiche la vie du joueur et une animation de vie 
	 */
	public static void drawLife() {
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(0.91, 0.95, String.valueOf(life + " HP"));

		// Affichage de l'animation de coeur a coter 
		if(life == 20) StdDraw.picture(0.941, 0.951, "images/Animation/HeartAnimation/00.png" , 0.035, 0.06);
		if(life < 20 && life > 15) StdDraw.picture(0.941, 0.951, "images/Animation/HeartAnimation/01.png" , 0.035, 0.06);
		if(life <= 15 && life > 11) StdDraw.picture(0.941, 0.951, "images/Animation/HeartAnimation/02.png" , 0.035, 0.06);
		if(life <= 11 && life > 8) StdDraw.picture(0.941, 0.951, "images/Animation/HeartAnimation/03.png" , 0.035, 0.06);
		if(life <= 8 && life > 4) StdDraw.picture(0.941, 0.951, "images/Animation/HeartAnimation/04.png" , 0.035, 0.06);
		if(life <= 4) StdDraw.picture(0.941, 0.951, "images/Animation/HeartAnimation/05.png" , 0.035, 0.06);
	}
	
	/**
	 * Affiche le nombre de coins du joueur et une animation de coin 
	 */
	public static void drawCoin() {
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(0.91, 0.90 , String.valueOf(coin + " coins "));
		StdDraw.picture(0.95, 0.901, "images/Animation/CoinAnimation/" + time % 6 + ".png" , 0.06, 0.06);
	}

	/**
	 * Comme son nom l'indique, cette fonction permet d'afficher dans le terminal les différentes possibilités
	 * offertes au joueur pour intéragir avec le clavier
	 */
	public static void printCommands() {
		System.out.println("Press A to select Arrow Tower (cost 50g).");
		System.out.println("Press B to select Cannon Tower (cost 60g).");
		System.out.println("Press G to select Arrow Tower (cost 50g).");
		System.out.println("Press E to update a tower (cost 40g).");
		System.out.println("Click on the grass to build it.");
		System.out.println("Press S to start.");
	}

	/**
	 * Fonction qui recupere le positionnement de la souris et permet d'afficher une image de tour en temps reel
	 * cela lorsque le joueur appuis sur une touche specifique :
	 * 
	 * 		- 'a' --> affiche une tour d archers et sa porte
	 * 		- 'b' --> affiche une tour de bombes et sa porte
	 * 		- 'g' --> affiche un gardien et sa porte
	 * 
	 * 		- affiche la porte d une tour si on passe notre souris dessus
	 */
	public static void drawMouse() {
		switch (key) {
		case 'a' :
			if(canCreatTower(pMouse, 50, false) && !end && !pause) {
				// Condition building.isBuilding(pMouse) renseigne si le defenseur est sur un batiment ou non (influe sur l'affichage)
				float heigth ;												// Hauteur a rajouter pour l'affichage du defenceur 
				if(building.isBuilding(pMouse)) heigth = (float) 0.054 ;
				else heigth = (float) 0.025 ;

				if(time % 25 < 10) StdDraw.picture(pMouse.getX() + 0.004, pMouse.getY() + heigth, "images/Tower/ArcheryTower/Level1/ArcherWait/0" + time % 25+ ".png", (1.0/24.0) * 1.5 , (1.0/15.0)  * 1.5 );
				else StdDraw.picture(pMouse.getX() + 0.004, pMouse.getY() + heigth, "images/Tower/ArcheryTower/Level1/ArcherWait/" + time % 25+ ".png", (1.0/24.0) * 1.5 , (1.0/15.0) * 1.5 );
				
				StdDraw.setPenColor(StdDraw.BLACK);
				StdDraw.circle(Square.normalizedX(mouseX), Square.normalizedX(mouseY), 0.2);
			}
			break;
		case 'b' :
			if(canCreatTower(pMouse, 60, false ) && !end && !pause){
				// Condition building.isBuilding(pMouse) renseigne si le defenseur est sur un batiment ou non (influe sur l'affichage)
				float heigth ;												// Hauteur a rajouter pour l'affichage du defenceur 
				if(building.isBuilding(pMouse)) heigth = (float) 0.035 ;
				else heigth = 0;

				if (time % 12 < 10) StdDraw.picture(pMouse.getX(), pMouse.getY() + heigth, "images/Tower/BombTowerAnimation/0" + time % 12 + ".png", (1.0 / 24.0) / 1.5, (1.0 / 15.0) / 1.5);
				else StdDraw.picture(pMouse.getX(), pMouse.getY() + heigth,"images/Tower/BombTowerAnimation/" + time % 12 + ".png", (1.0 / 24.0) / 1.5, (1.0 / 15.0) / 1.5);

				StdDraw.setPenColor(StdDraw.BLACK);
				StdDraw.circle(Square.normalizedX(mouseX), Square.normalizedX(mouseY), 0.15);
			} 
			break;
		case 'g' :
			if(canCreatTower(pMouse, 60, false ) && !end && !pause && !building.isBuilding(pMouse)){
				// Impossible de poser un gradien sur un batiment 
				if((time % 31) < 10)  StdDraw.picture(Square.normalizedX(mouseX) , Square.normalizedY(mouseY) + 0.01, "images/Tower/GuardianTower/GuardianWait/0"+ time % 31 + ".png", (1.0/24.0)* 1.7  , (1.0/15.0) * 1.7  );
				else StdDraw.picture(Square.normalizedX(mouseX) , Square.normalizedY(mouseY) + 0.01 , "images/Tower/GuardianTower/GuardianWait/"+ time % 31 + ".png", (1.0/24.0) * 1.7  , (1.0/15.0)* 1.7  );
				StdDraw.setPenColor(StdDraw.BLACK);
				StdDraw.circle(Square.normalizedX(mouseX), Square.normalizedX(mouseY), 0.3);
				StdDraw.circle(Square.normalizedX(mouseX), Square.normalizedX(mouseY), 0.1);
			} 
			break;
		}
		
		// Affiche la portée de la tour lorsque l'on passe la souris dessus 
		if(towers != null){
			for(Tower t : towers)
				if(pMouse.equalsP(t.getP() )) {
					StdDraw.circle(Square.normalizedX(mouseX), Square.normalizedX(mouseY), t.getRange());
					if(t.getClass().getName() == "warcraftTower.GuardianTower") StdDraw.circle(Square.normalizedX(mouseX), Square.normalizedX(mouseY), 0.1);
				}
		}
	}

					//******************************************************************//
					//	//	  //   /////     //////		  ////     ////////   //////	//
					//	//    //   //   //   //	   //   //	  //      //	  //		//
					//	//    //   /////     //	   //   ////////	  //	  /////		//
					//	//	  //   //		 //	   //   //    //	  //	  //		//
					//	  ////     //		 //////	    //    //	  //	  //////	//
					//******************************************************************//
	/**
	 * Met a jour toutes les informations du plateau de jeu :
	 * 
	 * Si start est faux
	 * 		- le menu
	 * 
	 * sinon
	 * 		- le background
	 * 		- les vagues
	 * 		- la position de la souris
	 * 		- time
	 * 		- les infos
	 * 		- les listes de monstres et tours
	 * 
	 * @return les points de vie restants du joueur
	 */
	public static void update() {
		if(!start)
			drawMenu();
		else {
			drawBackground();
			updateWaves(nbWaves);
			if(!pause) {
				mouseX = (float) StdDraw.mouseX();
				mouseY = (float) StdDraw.mouseY();
			 	pMouse.setX(Square.normalizedX(mouseX));
				pMouse.setY(Square.normalizedY(mouseY));
				time++;
				drawInfos();
				updateMonsters();
				updateTowers();
			}
		}
		drawMouse();
		updateEnd(false);
	}
	
	/**
	 * Met a jour les vagues de monstres
	 */
	public static void updateWaves(int nbr) {
		Wave.initWave();
		switch(currentW){
		case 1:
			WaveL1.update();
			break;
		case 2:
			WaveL2.update();
			break;
		case 3:
			WaveL3.update();
			break;
		case 4:
			WaveL4.update();
			break;
		case 5:
			WaveL5.update();
			break;
		case 6:
			WaveL6.update();
			break;
		case 7:
			//WaveL7.update();
			break;
		case 8:
			WaveL8.update();
			break;
		}
		Wave.gameEnd();
		Wave.nextWave();
	}
	
	/**
	 * Update chaque Monstre en fonction de ses attribut et de sa position
	 * 
	 * NOTE :
	 * Ici nous utilisons une boucle for qui parcours la liste de monstre a l'envers, cela nous permet d'eviter
	 * un crash du programme lors de la suppression d un monstre au debut de la liste
	 * 
	 * 		- update du monstre
	 * 
	 * 		- Si le monstre meurt
	 * 			--> Le joueur gagne des coins
	 * 			--> Supprime le monstre
	 * 
	 * 		- Si le monstre est arrive au chateau
	 * 			--> Enleve 1 point de vie au joueur
	 * 			--> Supprime le monstre
	 * 
	 * 		- Modifie la position du monstre en fonction de son parametre nextP et la liste Path
	 */
	public static void updateMonsters() {
		for(int i = monsters.size() - 1 ; i >=0 ; i--){
			monsters.get(i).update();
			
			if(monsters.get(i).getLife() <= 0 ){
				coin += monsters.get(i).getDropCoin();
				monsters.remove(monsters.get(i));
			}
			
			if(i < monsters.size() && Square.normalizedX(monsters.get(i).getP().getX()) == Square.normalizedX(chateau.getX())) {
				monsters.remove(monsters.get(i));
				life--;
			}

			if(i < monsters.size() && path.indexOf(monsters.get(i).getNextP()) < path.size()-1 && Square.pEqualNextP(monsters.get(i)))
				monsters.get(i).setNextP(path.get(path.indexOf(monsters.get(i).getNextP())+1));
		}
	}
	
	/**
	 * Met a jour les tours
	 * en utilisant un forEach pour parcourir la liste de tours
	 */
	public static void updateTowers(){
		towers.forEach(t ->{
			t.update();
		});
	}
	
	/**
	 * Verifie si il est possible de creer une tour avec les differentes conditions en porametre
	 * @param p 		- a la position p
	 * @param cost 		- avec les coin disponibles dans l inventaire
	 * @param drawInfos - si tel est le cas modifier l affichage des coin
	 * @return
	 */
	public static boolean canCreatTower(Position p , int cost , boolean drawInfos){
		for (int i = 0 ; i < path.size(); i++){
			if(p.equalsP(path.get(i))){
				if(drawInfos) System.out.println("Position impossible ! Vous etes sur le chemin.");
				return false;
			}
		}
		
		for(int i = 0 ; i < towers.size() ; i++){
			if(p.equalsP(towers.get(i).getP()) ) {
				if(drawInfos) System.out.println("Position impossible ! Une tour est deja présente");
				return false ;
			}
		}
		
		if(coin < cost) {
			System.out.println("Il vous faut plus d'argent ! ");
			return false ;
		}
		
		return true;
	}
	
	/**
	 * Si le joueur n a plus de vie alors la partie prend fin
	 */
	public static void updateEnd(boolean endWave) {
		if(life <= 0) {
			StdDraw.picture(0.5, 0.5, "images/perdue.png", 1, 1);
			lose = true;
			endWave = false ;
		}
		
		if(endWave) {
			StdDraw.picture(0.5, 0.5, "images/gagne.png", 1, 1);
			win = true;
			endWave = false ;
		}
	}

					//**************************************************************//
					//	  ////       /////   ////////   //	   /////	 //		//	//
					//	//	  //   //			//			 //		//   ////	//	//
					//	////////   //			//		//	 //		//	 //  // //	//
					//	//    //   //			//		//   //		//	 //   ////	//
					//	//    //     /////		//		//	   /////	 //	    //	//
					//**************************************************************//
	/**
	 * Recupere la touche appuyee par l utilisateur effectue l action associe puis affiche les informations pour la touche selectionnee
	 * 
	 * 		- 'a' --> tour d archers
	 * 		- 'b' --> tour de bombes
	 * 		- 'g' --> gardien
	 * 		- 'e' --> evoluer une tour
	 * 		- 's' --> start game
	 * 		- 'q' --> quit game
	 * 
	 * @param key la touche utilisee par le joueur
	 */
	public static void keyPress(char k) {
		key = Character.toLowerCase(k);
		
		switch (key) {
		case 'a':
			System.out.println("Arrow Tower selected (50 coins).");
			break;
		case 'b':
			System.out.println("Bomb Tower selected (60 coins).");
			break;
		case 'g':
			System.out.println("Guardian selected (100 coins).");
			break;
		case 'e':
			System.out.println("Evolution selected (40 coins).");
			break;
		case 's':
			System.out.println("Starting game!");
			start = true;
			break;
		case 'q':
			System.out.println("Exiting.");
			start = false;
			clear();
			break;
		}
	}

	/**
	 * Verifie lorsque l'utilisateur clique sur sa souris si il peut:
	 * @param x
	 * @param y
	 */
	public static void mouseClick(float x, float y) {
		/**
		 * 	- Ajouter une tour a la position indiquee par la souris.
		 * 	- Ameliorer une tour existante.
		 * 	- Puis l ajouter a� la liste des tours
		 */
		Position pTower = new Position(Square.normalizedX(x), Square.normalizedY(y));
		
		if(!pause) {
			switch (key) {
			case 'a':
				System.out.println("l faut ajouter une tour d'archers si l'utilisateur a�de l'or !!");
				if(canCreatTower(pTower, 25 , true)) {
					towers.add(new ArcheryTower(pTower));
					coin -= 25 ;
				}
				break;
			case 'b':
				System.out.println("Ici il faut ajouter une tour de bombes");
				if(canCreatTower(pTower, 55 , true )) {
					towers.add(new BombTower(pTower));
					coin -= 55;
				}
				break;
			case 'g':
				System.out.println("Ici il faut ajouter un gardien");
				if(canCreatTower(pTower,80 , true) ) {
					if(!building.isBuilding(pTower)){
						// Limitation des gardiens a 2 
						int nbrGuardian = 0;
						for(Tower t : towers) if(t.getClass().getName() == "warcraftTower.GuardianTower") nbrGuardian++ ;
						if(nbrGuardian < 2){
							towers.add(new GuardianTower(pTower));
							coin -= 80;
						}
						else System.out.println("Il est possible de poser que 2 gardien !");
					}
					else {
						System.out.println("Il est impossible de poser un gardien sur un batiment !");
					}
				}
				break;
			case 'e':
				for(int i = 0 ; i < towers.size() ; i++){
					if(towers.get(i).getP().equalsP(pTower)){
						if(towers.get(i).getUpgradeCost() <= coin )towers.get(i).upgrade();
						else System.out.println("Vous n'avez pas assez d'argent !");
					}
				}
				System.out.println("Ici il est possible de faire evolue une des tours");
				break;
			}
		}
		
		/**
		 * 	- Si la partie n a pas commence
		 * 	- initilise le nombre de vague que le joueur jouera en fonction de sa selection
		 */
		if(!start) {
			if(Square.compareNormalized(x, square.get(125).getX(), y, square.get(125).getY())) {
				mouseX = x; mouseY = y;
				nbWaves = 1;
			} else if(Square.compareNormalized(x, square.get(140).getX(), y, square.get(140).getY())) {
				mouseX = x; mouseY = y;
				nbWaves = 2;
			} else if(Square.compareNormalized(x, square.get(155).getX(), y, square.get(155).getY())) {
				mouseX = x; mouseY = y;
				nbWaves = 3;
			} else if(Square.compareNormalized(x, square.get(170).getX(), y, square.get(170).getY())) {
				mouseX = x; mouseY = y;
				nbWaves = 4;
			} else if(Square.compareNormalized(x, square.get(185).getX(), y, square.get(185).getY())) {
				mouseX = x; mouseY = y;
				nbWaves = 5;
			} else if(Square.compareNormalized(x, square.get(200).getX(), y, square.get(200).getY())) {
				mouseX = x; mouseY = y;
				nbWaves = 6;
			} else if(Square.compareNormalized(x, square.get(215).getX(), y, square.get(215).getY())) {
				mouseX = x; mouseY = y;
				nbWaves = 7;
			} else if(Square.compareNormalized(x, square.get(230).getX(), y, square.get(230).getY())) {
				mouseX = x; mouseY = y;
				nbWaves = 8;
			}
		}
		
		/**
		 * 	- Si la partie est en pause (entre chaque vague)
		 * 	- cliquer sur le bouton indique sur le plateau de jeu pour continuer
		 */
		if(pause) {
			if(Square.compareNormalized(x, square.get(125).getX(), y, square.get(125).getY())
					|| Square.compareNormalized(x, square.get(126).getX(), y, square.get(126).getY())
					|| Square.compareNormalized(x, square.get(140).getX(), y, square.get(140).getY())
					|| Square.compareNormalized(x, square.get(141).getX(), y, square.get(141).getY())
					|| Square.compareNormalized(x, square.get(155).getX(), y, square.get(155).getY())
					|| Square.compareNormalized(x, square.get(156).getX(), y, square.get(156).getY())
					|| Square.compareNormalized(x, square.get(170).getX(), y, square.get(170).getY())
					|| Square.compareNormalized(x, square.get(171).getX(), y, square.get(171).getY())
					|| Square.compareNormalized(x, square.get(185).getX(), y, square.get(185).getY())
					|| Square.compareNormalized(x, square.get(186).getX(), y, square.get(186).getY())
					|| Square.compareNormalized(x, square.get(200).getX(), y, square.get(200).getY())
					|| Square.compareNormalized(x, square.get(201).getX(), y, square.get(201).getY())
					|| Square.compareNormalized(x, square.get(215).getX(), y, square.get(215).getY())
					|| Square.compareNormalized(x, square.get(216).getX(), y, square.get(216).getY())
					|| Square.compareNormalized(x, square.get(230).getX(), y, square.get(230).getY())
					|| Square.compareNormalized(x, square.get(231).getX(), y, square.get(231).getY())) {
				pause = false;
				currentW++;
				Wave.setInitW(false);
				if(win || lose) {
					end = true;
					start = false;
					clear();
				}
			}
		}
	}

	/**
	 * Recupere la touche entree au clavier ainsi que la position de la souris et met e�jour le plateau en fonction de ces interractions
	 */
	public void run() {
		printCommands();
		
		while(true) {
			StdDraw.clear();
			update();
			
			// Touches clavier
			if (StdDraw.hasNextKeyTyped()) {
				keyPress(StdDraw.nextKeyTyped());
			}
			
			// Cliques souris
			if (StdDraw.isMousePressed()) {
				mouseClick((float)StdDraw.mouseX(),(float)StdDraw.mouseY());
				StdDraw.pause(50);
			}
			
			// Affiche toutes les fonctions draw (attention elles sont affichees dans l ordre d appelle)
			StdDraw.show();
		}
	}

	/**
	 * reinitialise les valeurs par default
	 */
	public static void clear (){
		currentW = 1;
		monsters.clear();
		towers.clear();
		path.clear();
		life = 20;
		coin = 145;
		key = 0;
		start = false;
		end = false;
		if(win)
			win = false;
		if(lose)
			lose = false;
		time = 0;
		StdDraw.clear();
	}

}
