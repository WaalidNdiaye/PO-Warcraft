package warcraftMain;

import java.util.List;
import java.util.ArrayList;

import warcraftMonster.Monster;
import warcraftPath.Patern1;
import warcraftWave.WaveL1;
import warcraftTower.*;

public class World {
	// Information sur le plateau de jeu
	private static List<Position> square;									// Liste des positions de toutes les cases du plateau de jeu (un schema se trouve dans le drive)
	private static int width = 1440;										// Largeur du plateau de jeu
	private static int height = 900;										// Hauteur du plateau de jeu
	private static int nbSquareX = 24;										// Nombre de "case" en X
	private static int nbSquareY = 15;										// Nombre de "case" en Y
	private static float squareWidth = (float)1 / nbSquareX;				// Largeur des cases
	private static float squareHeight = (float)1 / nbSquareY;				// Hauteur des cases
		//Square num 7
	private static Position spawn;											// Position par laquelle les monstres vont venir
		//Square num 352
	private static Position chateau;										// Position du chateau 
	
	// Informations utilise pour le fonctionnement des vagues
	private static int nbWaves;												// Nombre de vague que le joueur souhaite jouer
	private static boolean initT = false;									// Indique si la liste des tours a ete initialise
	private static List<Monster> monsters;									// Liste des monstres
	private static List <Tower> towers;										// Liste des tours presentes sur le plateau de jeu
	private static List<Position> path;										// Liste des positions du chemin utilise durant la vague en cours

	// Informations de l inventaire du joueur
	private static int life = 20;											// Nombre de points de vie du joueur
	private static int coin = 300;											// Argent (pour acheter les tours)
	
	// Actions du joueur
	private char key;												// Commande sur laquelle le joueur appuie (sur le clavier)
	private float mouseX = -1;
	private float mouseY = -1;
	private Position pMouse = new Position(mouseX, mouseY); 			    //Postion de la souri (initialisé en dehors du plateau)
	
	// Partie
	private static boolean start = false;									// Condition pour que la partie commence
	private static boolean end = false;										// Condition pour terminer la partie
	private int time = 0 ;													// Repere chronologique 
	
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
	public static List<Monster> getMonsters(){
		return monsters;
	}
	public static void setMonsters(List<Monster> m){
		monsters = m;
	}
	public static void setTowers(List<Tower> t){
		towers = t;
	}
	
	/**
	 * Initialisation du plateau de jeu
	 */
	public World() {
		square = Square.setBoard();
		// Initialisation du spawn a la case numero 8 du plateau de jeu
		spawn = square.get(8);
		// Initialisation du chateau a la case numero 192 du plateau de jeu
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
	public void drawMenu() {
		StdDraw.picture(0.5, 0.5, "images/menu.png", 1, 1);
		StdDraw.picture(Square.normalizedX(mouseX), Square.normalizedY(mouseY), "images/select.png", squareWidth, squareHeight);
	}
	
	/**
	 * Definit le decors du plateau de jeu.
	 */
	public void drawBackground() {
		StdDraw.picture(0.5, 0.5, "images/background.png", 1, 1);
	}

	/**
	 * Affiche differentes informations a l ecran
	 * 		- la vie du joueur (life)
	 * 		- l argent qu il possede dans son inventaire (coin)
	 */
	public void drawInfos() {
		drawLife();
		drawCoin();
	}

	public void drawLife() {
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(0.95, 0.95, String.valueOf(life + " HP"));
	}
	
	public void drawCoin() {
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(0.95, 0.90 , String.valueOf(coin + " coins "));
		StdDraw.picture(0.981, 0.901, "images/Animation/CoinAnimated/" + time % 6 + ".png" , 0.06, 0.06);
		
	}

	/**
	 * Comme son nom l'indique, cette fonction permet d'afficher dans le terminal les différentes possibilités
	 * offertes au joueur pour intéragir avec le clavier
	 */
	public void printCommands() {
		System.out.println("Press A to select Arrow Tower (cost 50g).");
		System.out.println("Press B to select Cannon Tower (cost 60g).");
		System.out.println("Press E to update a tower (cost 40g).");
		System.out.println("Click on the grass to build it.");
		System.out.println("Press S to start.");
		System.out.println(path);
	}

	/**
	 * Fonction qui recupere le positionnement de la souris et permet d'afficher une image de tour en temps reel
	 * lorsque le joueur appuie sur une des touches permettant la construction d'une tour.
	 */
	public void drawMouse() {
		 if(start){
		 	pMouse.setX(Square.normalizedX(mouseX));
			pMouse.setY(Square.normalizedY(mouseY));
		}
		
		switch (key) {
		case 'a' :
			// Si le joueur appuie sur a alors afficher tour d archers
			if(canCreatTower(pMouse, 50 , false)) StdDraw.picture(Square.normalizedX(mouseX) , Square.normalizedY(mouseY), "images/Tower/Archery Tower Level 1.png", (1.0/24.0) , (1.0/15.0) );
			break;
		case 'b' :
			// Si le joueur appuie sur b alors afficher tour de bombres
			if(canCreatTower(pMouse, 60 , false )) StdDraw.picture(Square.normalizedX(mouseX) , Square.normalizedY(mouseY), "images/Tower/Bomb Tower Level 1.png", (1.0/24.0) , (1.0/15.0) );
			break;
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
	 * Met a� jour toutes les informations du plateau de jeu ainsi que les deplacements des monstres et les attaques des tours
	 * @return les points de vie restants du joueur
	 */
	public int update() {
		if(!start) {
			drawMenu();
		}
		else {
			time++;
			mouseX = (float) StdDraw.mouseX();
			mouseY = (float) StdDraw.mouseY();
			drawBackground();
			drawInfos();
			updateWaves(nbWaves);
			updateMonsters();
			updateTowers();
		}
		drawMouse();
		return life;
	}
	
	/**
	 * Met a jour les vagues de monstres
	 */
	public void updateWaves(int nbr) {
		if(nbr == 1) {
			WaveL1.update();
		}
	}
	
	/**
	 * Initialise la liste du chemin au hasard qui sera utilise durant la vague en cours
	 */
	public void randomPath() {
		path = Patern1.pathconstruct();
	}
	
	/**
	 * Pour chaque monstre de la liste de monstres de la vague, utilise la fonction update() qui appelle les fonctions run() et draw() de Monster
	 * 		- Si la vie du monstre est inferieur ou egale a 0 fait gagner des coin au joueur et supprime le monstre
	 * 		- Enleve 1 point de vie au joueur quand un monstre arrive au chateau
	 * 		- Modifie la position du monstre grace au parametre nextP et en utilisant la liste du chemin
	 */
	public void updateMonsters() {

		for(int i = 0 ; i < monsters.size() ; i++){
			monsters.get(i).update();
			
			// Si la vie est inferieur ou egale a 0 
			if(monsters.get(i).getLife() <= 0 ){
				coin += monsters.get(i).getDropCoin();
				monsters.remove(monsters.get(i));
			}
			// Si la position du monstre est egale a celle du chateau
			if(Square.normalizedX(monsters.get(i).getP().getX()) == Square.normalizedX(chateau.getX())) {
				life--;
				monsters.remove(monsters.indexOf(monsters.get(i)));
			}
			// Si la position suivante existe et qu il a deja ateint sa nextP
			if(path.indexOf(monsters.get(i).getNextP()) < path.size()-1 && Square.pEqualNextP(monsters.get(i))){
				monsters.get(i).setNextP(path.get(path.indexOf(monsters.get(i).getNextP())+1));
			}
		}
	}
	
	/**
	 * Met a jour les tours 
	 */
	public void updateTowers(){
		if(!initT) {
			setTowers(new ArrayList<Tower>());
    		initT = true;
		}
		for(int i = 0 ; i < towers.size() ; i++)
			towers.get(i).update();
	}
	
	/**
	 * Verifie si il est possible de creer une tour avec les differentes conditions en porametre
	 * @param p 		- a la position p
	 * @param cost 		- avec les coin disponibles dans l inventaire
	 * @param drawInfos - si tel est le cas modifier l affichage des coin
	 * @return
	 */
	public boolean canCreatTower(Position p , int cost , boolean drawInfos){
		for (int i = 0 ; i < path.size(); i++){
			if(p.equalsP(path.get(i))){
				//Permet d'afficher le probleme si souhaiter 
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

					//**************************************************************//
					//	  ////       /////   ////////   //	   /////	 //		//	//
					//	//	  //   //			//			 //		//   ////	//	//
					//	////////   //			//		//	 //		//	 //  // //	//
					//	//    //   //			//		//   //		//	 //   ////	//
					//	//    //     /////		//		//	   /////	 //	    //	//
					//**************************************************************//
	/**
	 * Recupere la touche appuyee par l utilisateur et affiche les informations pour la touche selectionnee
	 * @param key la touche utilisee par le joueur
	 */
	public void keyPress(char k) {
		k = Character.toLowerCase(k);
		key = k;
		switch (key) {
		case 'a':
			System.out.println("Arrow Tower selected (50c).");
			break;
		case 'b':
			System.out.println("Bomb Tower selected (60c).");
			break;
		case 'e':
			System.out.println("Evolution selected (40c).");
			break;
		case 's':
			System.out.println("Starting game!");
			start = true;
		case 'q':
			System.out.println("Exiting.");
		}
	}

	/**
	 * Verifie lorsque l'utilisateur clique sur sa souris qu'il peut:
	 * @param x
	 * @param y
	 */
	public void mouseClick(float x, float y) {
		/**
		 * 	- Ajouter une tour a� la position indiquee par la souris.
		 * 	- Ameliorer une tour existante.
		 * 	- Puis l'ajouter à la liste des tours
		 */
		Position pTower = new Position(Square.normalizedX(x), Square.normalizedY(y));
		
		switch (key) {
		case 'a':
			System.out.println("l faut ajouter une tour d'archers si l'utilisateur a�de l'or !!");
			if(canCreatTower(pTower, 50 , true)) {
				towers.add(new ArcheryTower(pTower));
				coin -= 50 ;
			}
			break;
		case 'b':
			System.out.println("Ici il faut ajouter une tour de bombes");
			if(canCreatTower(pTower, 60 , true )) {
				towers.add(new BombTower(pTower));
				coin -= 60;
			}
			break;
		case 'e':
			for(int i = 0 ; i < towers.size() ; i++){
				if(towers.get(i).getP().equalsP(pTower)){
					if(towers.get(i).getUpgradeCost() <= coin )towers.get(i).upgrade();
					else System.out.println("Vous n'avez pas assez d'argent !");
				}
			}
			System.out.println("Ici il est possible de faire évolué une des tours");
			break;
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
	}

	/**
	 * Recupere la touche entree au clavier ainsi que la position de la souris et met e�jour le plateau en fonction de ces interractions
	 */
	public void run() {
		randomPath();
		printCommands();
		
		while(!end) {
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


}
