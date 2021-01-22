package warcraftMain;

import java.util.List;
import java.util.ArrayList;

import warcraftMonster.Monster;
import warcraftWave.*;
import warcraftTower.*;
import java.awt.Font;

public class World {
	
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
	private static BuildingTopology building = new BuildingTopology();		// Liste de la postion des cases où un batiment (ou un chemin) est situé
	
	// Informations utilise pour le fonctionnement des vagues
	private static int nbWaves = 1;											// Nombre de vague que le joueur souhaite jouer
	private static int currentW = 1;										// Vague actuelle
	private static int timeWave = 0;										// Repere chronologique exclusive pour l'avance des vagues
	private static boolean endSpawnMonsters = false;						// Indique si on a fini de faire spawn tout les monstres d'une vague
	private static List<Monster> monsters = new ArrayList<Monster>();		// Liste des monstres
	private static List <Tower> towers = new ArrayList<Tower>();			// Liste des tours presentes sur le plateau de jeu
	private static List<Position> path;										// Liste des positions du chemin utilise durant la vague en cours

	// Informations de l inventaire du joueur
	private static int life = 15;											// Nombre de points de vie du joueur
	private static int coin = 105;											// Argent (pour acheter les tours)
	private static List<Infos> infosToDraw = new ArrayList<Infos>();		// Liste des information a afficher 
	
	// Actions du joueur
	private static char key;												// Commande sur laquelle le joueur appuie (sur le clavier)
	private static float mouseX = -1;										// Position X de la souris
	private static float mouseY = -1;										// Position Y de la souris
	private static Position pMouse = new Position(mouseX, mouseY); 			// Postion de la souri (initialisé en dehors du plateau)
	
	// Partie
	private static boolean sousMenu = false;								// Indique si le sous menu "i" est ouvert ou non
	private static boolean start = false;									// Condition pour que la partie commence
	private static boolean pause = false;									// Indique si le jeu est en pause
	private static boolean end = false;										// Condition pour terminer la partie
	private static boolean win = false;										// Indique si le joueur a gagne
	private static boolean lose = false;									// Indique si le joueur a perdu
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
	public static int getTimeWave(){
		return timeWave;
	}
	public static void setEndSpawnMonsters(boolean end) {
		endSpawnMonsters = end;
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
	 * 
	 * 	- Init de la position du spawn (case 8)
	 * 	- Init de la position du chateau (case 352)
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
	 * Dessine le menu du jeu
	 */
	public static void drawMenu() {
		StdDraw.picture(0.5, 0.5, "images/menu.png", 1, 1);
		
		if(sousMenu)
			StdDraw.picture(0.5, 0.5, "images/i.png", 1, 1);
		
		// Affiche le carre de selection seulement sur les case voulu
		if(Square.compareNormalized(mouseX, square.get(125).getX(), mouseY, square.get(125).getY())
				|| Square.compareNormalized(mouseX, square.get(140).getX(), mouseY, square.get(140).getY())
				|| Square.compareNormalized(mouseX, square.get(155).getX(), mouseY, square.get(155).getY())
				|| Square.compareNormalized(mouseX, square.get(170).getX(), mouseY, square.get(170).getY())
				|| Square.compareNormalized(mouseX, square.get(185).getX(), mouseY, square.get(185).getY())
				|| Square.compareNormalized(mouseX, square.get(200).getX(), mouseY, square.get(200).getY())
				|| Square.compareNormalized(mouseX, square.get(215).getX(), mouseY, square.get(215).getY())
				|| Square.compareNormalized(mouseX, square.get(230).getX(), mouseY, square.get(230).getY()))
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
	 * 
	 * 	- la vie du joueur (life)
	 * 	- l argent qu il possede dans son inventaire (coin)
	 */
	public static void drawInfos() {
		StdDraw.picture(0.92, 0.92, "images/SupportDrawInfos.png" , 0.13, 0.13);
		drawLife();
		drawCoin();
		drawTerminal();
	}

	/**
	 * Affiche la vie du joueur et une animation de vie 
	 */
	public static void drawLife() {
		StdDraw.setPenColor(StdDraw.BLACK);
		Font font = new Font("Sans Serif", Font.PLAIN, 16);
  		StdDraw.setFont(font);
		StdDraw.text(0.91, 0.95, String.valueOf(life + " HP"));

		// Affichage de l'animation de coeur a coter 
		if(life <= 15 && life > 11) StdDraw.picture(0.941, 0.951, "images/Animation/HeartAnimation/00.png" , 0.035, 0.06);
		if(life <= 11 && life > 8) StdDraw.picture(0.941, 0.951, "images/Animation/HeartAnimation/01.png" , 0.035, 0.06);
		if(life <= 8 && life > 4) StdDraw.picture(0.941, 0.951, "images/Animation/HeartAnimation/02.png" , 0.035, 0.06);
		if(life <= 4) StdDraw.picture(0.941, 0.951, "images/Animation/HeartAnimation/03.png" , 0.035, 0.06);
	}
	
	/**
	 * Affiche le nombre de coins du joueur et une animation de coin 
	 */
	public static void drawCoin() {
		StdDraw.setPenColor(StdDraw.BLACK);
		Font font = new Font("Sans Serif", Font.PLAIN, 16);
  		StdDraw.setFont(font);
		StdDraw.text(0.91, 0.90 , String.valueOf(coin + " coins "));
		
		StdDraw.picture(0.95, 0.901, "images/Animation/CoinAnimation/" + time % 6 + ".png" , 0.06, 0.06);
	}

	/**
	 * Affiche les quatres derniers messages destine au joueur (comme dans la console)
	 * 
	 * 	- Affiche les messages sous forme de liste (le dernier en premier, l'avant dernier en second, ect)
	 * 	- Si le message est trop long il est affiche sur deux lignes
	 */
	public static void drawTerminal() {
		Font font = new Font("Average", Font.ITALIC, 14);
		StdDraw.setFont(font);
		
		if((infosToDraw.size() - 1) > -1) {
			if(infosToDraw.get(infosToDraw.size() - 1).getMessage().length() > 35){
				StdDraw.text(0.08, 0.8 , String.valueOf(infosToDraw.get(infosToDraw.size() - 1).getMessage().substring(35)));
				StdDraw.text(0.08, 0.815 , String.valueOf(infosToDraw.get(infosToDraw.size() - 1).getMessage().substring(0 , 35)));
			}
			else StdDraw.text(0.08, 0.815 , String.valueOf(infosToDraw.get(infosToDraw.size() - 1).getMessage()));
		}

		if((infosToDraw.size() - 2) > -1) {
			if(infosToDraw.get(infosToDraw.size() - 2).getMessage().length() > 35){
				StdDraw.text(0.08, 0.835 , String.valueOf(infosToDraw.get(infosToDraw.size() - 2).getMessage().substring(35)));
				StdDraw.text(0.08, 0.85 , String.valueOf(infosToDraw.get(infosToDraw.size() - 2).getMessage().substring(0 , 35)));
			}
			else StdDraw.text(0.08, 0.85 , String.valueOf(infosToDraw.get(infosToDraw.size() - 2).getMessage()));
		}
		
		if((infosToDraw.size() - 3) > -1) {
			if(infosToDraw.get(infosToDraw.size() - 3).getMessage().length() > 35){
				StdDraw.text(0.08, 0.87 , String.valueOf(infosToDraw.get(infosToDraw.size() - 3).getMessage().substring(35)));
				StdDraw.text(0.08, 0.885 , String.valueOf(infosToDraw.get(infosToDraw.size() - 3).getMessage().substring(0 , 35)));
			}
			else StdDraw.text(0.08, 0.885 , String.valueOf(infosToDraw.get(infosToDraw.size() - 3).getMessage()));
		}
		
		if((infosToDraw.size() - 4) > -1) {
			if(infosToDraw.get(infosToDraw.size() - 4).getMessage().length() > 35){
				StdDraw.text(0.08, 0.905 , String.valueOf(infosToDraw.get(infosToDraw.size() - 4).getMessage().substring(35)));
				StdDraw.text(0.08, 0.92 , String.valueOf(infosToDraw.get(infosToDraw.size() - 4).getMessage().substring(0 , 35)));
			}
			else StdDraw.text(0.08, 0.92 , String.valueOf(infosToDraw.get(infosToDraw.size() - 4).getMessage()));
		}
	}

	/**
	 * Recupere le positionnement de la souris et permet d'afficher une image de gardien en temps reel
	 * 
	 * 	- Affiche un gardien archer si le joueur a appuye sur "a"
	 * 	- Affiche un gardien bombardie si le joueur a appuye sur "b"
	 * 	- Affiche un gardien si le joueur a appuye sur "g"
	 * 	- Affiche la porte des gardien si il place son curseur sur celui-ci
	 * 
	 * La condition building.isBuilding(pMouse) renseigne si le defenseur est sur un batiment ou non (influe sur l'affichage)
	 */
	public static void drawMouse() {
		// Hauteur a rajouter pour l'affichage du defenceur 
		float heigth ;
		
		switch (key) {
		case 'a' :
			if(canCreatTower(pMouse, 25, false) && !end && !pause) {
				if(building.isBuilding(pMouse)) heigth = (float) 0.03 ;
				else heigth = (float) 0.01 ;

				if(time % 25 < 10) StdDraw.picture(pMouse.getX() + 0.004, pMouse.getY() + heigth, "images/Tower/ArcheryTower/Level1/ArcherWait/0" + time % 25+ ".png", (1.0/24.0) * 1.5 , (1.0/15.0)  * 1.5 );
				else StdDraw.picture(pMouse.getX() + 0.004, pMouse.getY() + heigth, "images/Tower/ArcheryTower/Level1/ArcherWait/" + time % 25+ ".png", (1.0/24.0) * 1.5 , (1.0/15.0) * 1.5 );
				
				StdDraw.setPenColor(StdDraw.BLACK);
				StdDraw.circle(Square.normalizedX(mouseX), Square.normalizedX(mouseY), 0.2);
			}
			break;
		case 'b' :
			if(canCreatTower(pMouse, 55, false ) && !end && !pause){
				if(building.isBuilding(pMouse)) heigth = (float) 0.015 ;
				else heigth = 0;

				if (time % 12 < 10) StdDraw.picture(pMouse.getX(), pMouse.getY() + heigth, "images/Tower/BombTowerAnimation/0" + time % 12 + ".png", (1.0 / 24.0) / 1.5, (1.0 / 15.0) / 1.5);
				else StdDraw.picture(pMouse.getX(), pMouse.getY() + heigth,"images/Tower/BombTowerAnimation/" + time % 12 + ".png", (1.0 / 24.0) / 1.5, (1.0 / 15.0) / 1.5);

				StdDraw.setPenColor(StdDraw.BLACK);
				StdDraw.circle(Square.normalizedX(mouseX), Square.normalizedX(mouseY), 0.15);
			} 
			break;
		case 'g' :
			if(canCreatTower(pMouse, 100, false ) && !end && !pause && !building.isBuilding(pMouse)){
				// Impossible de poser un gradien sur un batiment 
				if((time % 31) < 10)  StdDraw.picture(Square.normalizedX(mouseX) , Square.normalizedY(mouseY) + 0.01, "images/Tower/GuardianTower/GuardianWait/0"+ time % 31 + ".png", (1.0/24.0)* 1.7  , (1.0/15.0) * 1.7  );
				else StdDraw.picture(Square.normalizedX(mouseX) , Square.normalizedY(mouseY) + 0.01 , "images/Tower/GuardianTower/GuardianWait/"+ time % 31 + ".png", (1.0/24.0) * 1.7  , (1.0/15.0)* 1.7  );
				StdDraw.setPenColor(StdDraw.BLACK);
				StdDraw.circle(Square.normalizedX(mouseX), Square.normalizedX(mouseY), 0.3);
				StdDraw.circle(Square.normalizedX(mouseX), Square.normalizedX(mouseY), 0.1);
			} 
			break;
		}
		
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
	 * 	- le menu
	 * 
	 * sinon
	 * 	- le background
	 * 	- les vagues
	 * 	- la position de la souris
	 * 	- time
	 * 	- timeWave si le dernier monstre de la vague n'a pas spawn
	 * 	- les infos
	 * 	- les listes de monstres et tours
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
				if(!endSpawnMonsters)
					timeWave++;
				drawInfos();
				updateMonsters();
				updateTowers();
				/* NOTE :
				 * Nous avons rajouter une condition  a certain endroit du programe pour limiter les calcules 
				 * de notre programme (sans impacter significativement le jeu)
				 * au lieux de s'executer a chaque update ces instructions s'executent toutes les 10 updates
				 */
				if(time%5 == 0) updateInfo(); 						
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
			WaveL7.update();
			break;
		case 8:
			WaveL8.update();
			break;
		}
		Wave.gameEnd();
		Wave.nextWave();
	}
	
	/**
	 * Cette classe permet un gestion simple des informations a afficher 
	 */
	private static class Infos{
		private int time ;				
		private String message;

		public int getTime() {
			return time;
		}
		public String getMessage() {
			return message;
		}

		public Infos(String message , int time){
			this.time = time ;
			this.message = message ;
		}	
	}
	
	/**
	 * Supprime les messages d'informations au bout de 100 update
	 */
	public static void updateInfo(){
		for(Infos i : infosToDraw){
			if((time - i.getTime()) > 100) {
				infosToDraw.remove(i);
				break;
			}
		}
	}

	/**
	 * Ajoute un message ainsi que le moment auquel il a été émis 
	 * NOTE :
	 * Le message n'est pas ajouté si il a deja été emis lors des 10 dernier update  
	 */
	public static void addInfo(String message){
		boolean add = true ;
		for(Infos i : infosToDraw){
			if(i.getMessage().equals(message) && time - i.getTime() < 10) add = false ; 
		}
		if(add)infosToDraw.add(new Infos(message , time));
	}

	/**
	 * Update chaque Monstre en fonction de ses attribut et de sa position
	 * 
	 * NOTE :
	 * Ici nous utilisons une boucle for qui parcours la liste de monstre a l'envers, cela nous permet d'eviter
	 * un crash du programme lors de la suppression d un monstre au debut de la liste
	 * 
	 * 	- update du monstre
	 * 	- Si le monstre meurt
	 * 		--> Le joueur gagne des coins
	 * 		--> Supprime le monstre
	 * 	- Si le monstre est arrive au chateau
	 * 		--> Enleve 1 point de vie au joueur
	 * 		--> Supprime le monstre
	 * 	- Modifie la position du monstre en fonction de son parametre nextP et la liste Path
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
	 * Verifie si il est possible de creer une tour
	 * @param p position
	 * @param cost prix de la tour
	 * @param drawInfos information a modifier
	 * @return true si une tour peut etre cree sinon false
	 */
	public static boolean canCreatTower(Position p , int cost , boolean drawInfos){
		if(building.onPath(p)){
			if(drawInfos) addInfo("Position impossible ! Vous etes sur le chemin.");
				return false;
		}
		
		for(int i = 0 ; i < towers.size() ; i++){
			if(p.equalsP(towers.get(i).getP()) ) {
				if(drawInfos)  addInfo("Position impossible ! Une tour est deja présente");
				return false ;
			}
		}
		
		if(coin < cost) {
			addInfo("Il vous faut plus d'argent ! ");
			return false ;
		}
		return true;
	}
	
	/**
	 * Verifie si la partie est fini
	 * 	- Si le joueur n'a plus de points de vie
	 * 	- Si la derniere vague a ete remporte
	 * @param endWave indique si la derniere vague est fini
	 */
	public static void updateEnd(boolean endWave) {
		if(life <= 0) {
			StdDraw.picture(0.5, 0.5, "images/wave/lose.png", 1, 1);
			pause = true;
			lose = true;
		}
		
		if(endWave) {
			StdDraw.picture(0.5, 0.5, "images/wave/win.png", 1, 1);
			pause = true;
			win = true;
		}
		endWave = false;
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
	 * 	- 'a' --> tour d archers
	 * 	- 'b' --> tour de bombes
	 * 	- 'g' --> gardien
	 * 	- 'e' --> evoluer une tour
	 * 	- 's' --> start game
	 * 	- 'q' --> quit game
	 * 
	 * @param k touche utilisee par le joueur
	 */
	public static void keyPress(char k) {
		key = Character.toLowerCase(k);
		
		switch (key) {
		case 'a':
			addInfo("Arrow Tower selected (25 coins).");
			break;
		case 'b':
			addInfo("Bomb Tower selected (55 coins).");
			break;
		case 'g':
			addInfo("Guardian selected (100 coins).");
			break;
		case 'e':
			addInfo("Evolution selected (40 coins).");
			break;
		case 's':
			addInfo("Starting game!");
			start = true;
			break;
		case 'q':
			addInfo("Exiting.");
			start = false;
			clear();
			break;
		}
	}

	/**
	 * Verifie lorsque l'utilisateur clique sur sa souris si il peut:
	 * @param x position sur l'axe X de la souris
	 * @param y position sur l'axe Y de la souris
	 */
	public static void mouseClick(float x, float y) {
		/**
		 * 	- Ajouter une tour a la position indiquee par la souris.
		 * 	- Ameliorer une tour existante.
		 * 	- Puis l'ajouter a la liste des tours
		 */
		Position pTower = new Position(Square.normalizedX(x), Square.normalizedY(y));
		
		if(!pause) {
			switch (key) {
			case 'a':
				if(canCreatTower(pTower, 25, true)) {
					towers.add(new ArcheryTower(pTower));
					coin -= 25 ;
				}
				break;
			case 'b':
				if(canCreatTower(pTower, 55, true )) {
					towers.add(new BombTower(pTower));
					coin -= 55;
				}
				break;
			case 'g':
				if(canCreatTower(pTower, 100, true) ) {
					if(!building.isBuilding(pTower)){
						// Limitation des gardiens a 2 
						int nbrGuardian = 0;
						for(Tower t : towers) if(t.getClass().getName() == "warcraftTower.GuardianTower") nbrGuardian++ ;
						if(nbrGuardian < 2){
							towers.add(new GuardianTower(pTower));
							coin -= 80;
						}
						else addInfo("Il est possible de poser que 2 gardien !");
					}
					else {
						addInfo("Il est impossible de poser un gardien sur un batiment !");
					}
				}
				break;
			case 'e':
				for(int i = 0 ; i < towers.size() ; i++){
					if(towers.get(i).getP().equalsP(pTower)){
						if(towers.get(i).getUpgradeCost() <= coin )towers.get(i).upgrade();
						else addInfo("Vous n'avez pas assez d'argent !");
					}
				}
				break;
			}
		}
		
		/**
		 * Si la partie n'a pas commence
		 * 	- permet au joueur d'aller dans le sous menu
		 * 	- initilise le nombre de vague que le joueur jouera en fonction de sa selection
		 */
		if(!start) {
			if(Square.compareNormalized(x, square.get(343).getX(), y, square.get(343).getY())) {
				if(sousMenu)
					sousMenu = false;
				else
					sousMenu = true;
			}
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
		 * Si la partie est en pause (entre chaque vague)
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
				endSpawnMonsters = false;
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
	 * Recupere la touche entree au clavier ainsi que la position de la souris et met a jour le plateau en fonction de ces interractions
	 */
	public void run() {
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
		nbWaves = 1;
		currentW = 1;
		monsters.clear();
		towers.clear();
		path.clear();
		life = 14;
		coin = 105;
		key = 0;
		start = false;
		end = false;
		if(win)
			win = false;
		if(lose)
			lose = false;
		time = 0;
		timeWave = 0;
		Wave.setInitW(false);
		StdDraw.clear();
	}

}
