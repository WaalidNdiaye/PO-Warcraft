package warcraftMain;

import java.util.List;
import java.util.ArrayList;

import warcraftMonster.Monster;
import warcraftPath.*;
import warcraftWave.*;
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
	private static boolean initW = false;									// Indique si la vague actuelle est initialise ou pas
	private static int currentW = 1;										// Vague actuelle
	private static List<Monster> monsters;									// Liste des monstres
	private static List <Tower> towers;										// Liste des tours presentes sur le plateau de jeu
	private static List<Position> path;										// Liste des positions du chemin utilise durant la vague en cours

	// Informations de l inventaire du joueur
	private static int life = 20;											// Nombre de points de vie du joueur
	private static int coin = 145;											// Argent (pour acheter les tours)
	
	// Actions du joueur
	private char key;														// Commande sur laquelle le joueur appuie (sur le clavier)
	private float mouseX = -1;
	private float mouseY = -1;
	private Position pMouse = new Position(mouseX, mouseY); 			    //Postion de la souri (initialisé en dehors du plateau)
	
	// Partie
	private static boolean start = false;									// Condition pour que la partie commence
	private static boolean pause = false;									// Indique si le jeu est en pause
	private static boolean end = false;										// Condition pour terminer la partie
	private static boolean win = false;										// Indique si le joueur a gagne ou pas
	private static boolean lose = false;
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
	public static int getCoin() {
		return coin;
	}
	public static void setCoin(int newCoin) {
		coin = newCoin;
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
		StdDraw.picture(0.02, 0.6, "images/Spawner.png", (1.0/24.0) * 4, (1.0/15.0) * 4);
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
		StdDraw.picture(0.981, 0.901, "images/Animation/CoinAnimation/" + time % 6 + ".png" , 0.06, 0.06);
		
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
			if(canCreatTower(pMouse, 50 , false) && !end && !pause) {
				StdDraw.picture(Square.normalizedX(mouseX) , Square.normalizedY(mouseY), "images/Tower/Archery Tower Level 1.png", (1.0/24.0) , (1.0/15.0) );
				StdDraw.setPenColor(StdDraw.BLACK);
				// Affiche la portée de la tour 
				StdDraw.circle(Square.normalizedX(mouseX), Square.normalizedX(mouseY), 0.2);
			}
			break;
		case 'b' :
			// Si le joueur appuie sur b alors afficher tour de bombres
			if(canCreatTower(pMouse, 60 , false ) && !end && !pause){
				StdDraw.picture(Square.normalizedX(mouseX) , Square.normalizedY(mouseY), "images/Tower/Bomb Tower Level 1.png", (1.0/24.0) , (1.0/15.0) );
				StdDraw.setPenColor(StdDraw.BLACK);
				// Affiche la portée de la tour 
				StdDraw.circle(Square.normalizedX(mouseX), Square.normalizedX(mouseY), 0.15);
			} 
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
			mouseX = (float) StdDraw.mouseX();
			mouseY = (float) StdDraw.mouseY();
			drawBackground();
			updateWaves(nbWaves);
			if(!pause) {
				time++;
				drawInfos();
				updateMonsters();
				updateTowers();
			}
		}
		updateEnd(false);
		drawMouse();
		return life;
	}
	
	/**
	 * Met a jour les vagues de monstres
	 */
	public void updateWaves(int nbr) {
		// Le joueur a choisi de jouer 1 vague ou plus (la premiere vague a toujours le meme chemin)
		if(nbr >= 1) {
			// Init du chemin de la vague
			if(!initW && currentW == 1) {
				path = Patern1.pathconstruct();
				initW = true;
			}
			//Update la vague si c est la vague courrante
			if(currentW == 1)
				WaveL1.update();
			// Fin de la partie si le joueur a choisi qu une seule vague
			if(nbr == 1 && time >= 550 && monsters.size() == 0) {
				updateEnd(true);
				pause = true;
			}
			// Fin de la vague si le joueur a choisi plus que une vague
			if(nbr > 1 && currentW == 1 && time >= 550 && monsters.size() == 0) {
				StdDraw.picture(0.5, 0.5, "images/wave1.png", 1, 1);
				pause = true;
				coin =+ 25;
			}
			
			//Le joueur a choisi de jouer 2 vagues ou plus
			if(nbr >= 2) {
				if(!initW && currentW == 2) {
					randomPath();
					initW = true;
				}
				if(currentW == 2)
					WaveL2.update();
				if(nbr == 2 && time >= 1040 && monsters.size() == 0) {
					updateEnd(true);
					pause = true;
				}
				if(nbr > 2 && currentW == 2 && time >= 1040 && monsters.size() == 0) {
					StdDraw.picture(0.5, 0.5, "images/wave2.png", 1, 1);
					pause = true;
				}
				
				//Le joueur a choisi de jouer 3 vagues ou plus
				if(nbr >= 3) {
					if(!initW && currentW == 3) {
						randomPath();
						initW = true;
					}
					if(currentW == 3)
						WaveL3.update();
					if(nbr == 3 && time >= 2390 && monsters.size() == 0) {
						updateEnd(true);
						pause = true;
					}
					if(nbr > 3 && currentW == 3 && time >= 2390 && monsters.size() == 0) {
						StdDraw.picture(0.5, 0.5, "images/wave3.png", 1, 1);
						pause = true;
						coin =+ 30;
					}
					
					//Le joueur a choisi de jouer 4 vagues ou plus
					if(nbr >= 4) {
						if(!initW && currentW == 4) {
							randomPath();
							initW = true;
						}
						if(currentW == 4)
							WaveL4.update();
						if(nbr == 4 && time >= 3740 && monsters.size() == 0) {
							updateEnd(true);
							pause = true;
						}
						if(nbr > 4 && currentW == 4 && time >= 3740 && monsters.size() == 0) {
							StdDraw.picture(0.5, 0.5, "images/wave3.png", 1, 1);
							pause = true;
						}
						
						
					}
				}
				
			}
				
		}
	}
	
	// Supprimer les tours et réinitialise les valeurs 
	public static void clear (){
		// Supprime toute les tours 
		towers.clear();

		// Réinitialiser avce les valeurs par défault 
		life = 20 ;
		coin = 145 ;
	}

	/**
	 * Initialise la liste du chemin au hasard qui sera utilise durant la vague en cours
	 */
	public static void randomPath() {
		int r = (int)(Math.random() * 5);
		if(r == 1)
			path = Patern2.pathconstruct();
		if(r == 2)
			path = Patern3.pathconstruct();
		if(r == 3)
			path = Patern4.pathconstruct();
		if(r == 4)
			path = Patern5.pathconstruct();
		if(r == 5)
			path = Patern6.pathconstruct();
	}
	
	/**
	 * Pour chaque monstre de la liste de monstres de la vague, utilise la fonction update() qui appelle les fonctions run() et draw() de Monster
	 * 		- Si la vie du monstre est inferieur ou egale a 0 fait gagner des coin au joueur et supprime le monstre
	 * 		- Enleve 1 point de vie au joueur quand un monstre arrive au chateau
	 * 		- Modifie la position du monstre grace au parametre nextP et en utilisant la liste du chemin
	 */
	public void updateMonsters() {
		// Le sens de lecture de la liste est de la fin ver le debut (pour evité les bugs lié au index lors de la suppresion d'un mosntre).
		for(int i = monsters.size() - 1 ; i >=0 ; i--){
			monsters.get(i).update();
			
			// Si la vie est inferieur ou egale a 0 
			if(monsters.get(i).getLife() <= 0 ){
				coin += monsters.get(i).getDropCoin();
				// Affiche une piece a la mort d'un monstre 
				StdDraw.picture(monsters.get(i).getP().getX(), monsters.get(i).getP().getY() + 0.01, "images/Animation/CoinAnimation/0.png", (1.0/24.0) , (1.0/15.0) );
				// Supprime le monstre 
				monsters.remove(monsters.get(i));
			}
			// Si la position du monstre est egale a celle du chateau (i < monsters.size() empeche de faire monsters.get(i) d'un monstre qui veint d'etre supp )
			if(i < monsters.size() && Square.normalizedX(monsters.get(i).getP().getX()) == Square.normalizedX(chateau.getX())) {
				life--;
				monsters.remove(monsters.indexOf(monsters.get(i)));
			}
			// Si la position suivante existe et qu il a deja ateint sa nextP
			if(i < monsters.size() && path.indexOf(monsters.get(i).getNextP()) < path.size()-1 && Square.pEqualNextP(monsters.get(i))){
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
	
	/**
	 * Si le joueur n a plus de vie alors la partie prend fin
	 */
	public static void updateEnd(boolean endWave) {
		if(life <= 0) {
			StdDraw.picture(0.5, 0.5, "images/perdue.png", 1, 1);
			lose = true;

			// Suprime les tours et réinitialise les valeurs 
			clear();

			endWave = false ;
		}
		
		if(endWave) {
			StdDraw.picture(0.5, 0.5, "images/gagne.png", 1, 1);
			win = true;

			// Suprime les tours et réinitialise les valeurs 
			clear();

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
				initW = false;
				if(win || lose) {
					end = true;
					start = false;
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


}
