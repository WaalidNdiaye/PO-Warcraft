package warcraftMain;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import warcraftMonster.Monster;
import warcraftPath.Patern1;
import warcraftWave.wave1;
import warcraftTower.*;

public class World {
	// Information sur la taille du plateau de jeu
	private int width;													// Largeur
	private int height;													// Hauteur
	private int nbSquareX;												// Nombre de "case" en X
	private int nbSquareY;												// Nombre de "case" en Y
	private static float squareWidth;									// Largeur des cases
	private static float squareHeight;									// Hauteur des cases

	private ArrayList<Monster> monsters = new ArrayList<Monster>();		// Liste des monstres, pour gerer (notamment) l'affichage
	public List<Position> path;											// Liste des des positions du chemin utilis� durant la vague
	private ArrayList <Tower> tower = new ArrayList<Tower>();			// Liste des tours sur le plateau 
	private static Position spawn;										// Position par laquelle les monstres vont venir
	private Position chateau;											// Position du chateau 
	private int life = 20;												// Nombre de points de vie du joueur
	private char key;													// Commande sur laquelle le joueur appuie (sur le clavier)
	private boolean start = false;
	private boolean end = false;										// Condition pour terminer la partie
	private int coin = 300;												// Argent (pour acheter les tours)
	private float mouseX = -1;
	private float mouseY = -1;
	private Position pMouse = new Position(mouseX, mouseY); 			//Postion de la souri (initialisé en dehors du plateau)
	
	/*
	 * GETTERS AND SETTERS
	 */
	public List<Monster> getMonsters() {
		return monsters;
	}
	public void setMonsters(ArrayList<Monster> monsters) {
		this.monsters = monsters;
	}
	public static Position getSpawn() {
		return spawn;
	}
	public void setSpawn(Position spawn) {
		this.spawn = spawn;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getNbSquareX() {
		return nbSquareX;
	}
	public void setNbSquareX(int nbSquareX) {
		this.nbSquareX = nbSquareX;
	}
	public int getNbSquareY() {
		return nbSquareY;
	}
	public void setNbSquareY(int nbSquareY) {
		this.nbSquareY = nbSquareY;
	}
	public static float getSquareWidth() {
		return squareWidth;
	}
	public static float getSquareHeight() {
		return squareHeight;
	}
	public int getLife() {
		return life;
	}
	public void setLife(int life) {
		this.life = life;
	}
	public char getKey() {
		return key;
	}
	public void setKey(char key) {
		this.key = key;
	}
	public boolean isEnd() {
		return end;
	}
	public void setEnd(boolean end) {
		this.end = end;
	}
	public int getCoin() {
		return coin;
	}
	public void setCoin(int coin) {
		this.coin = coin;
	}


	/**
	 * Initialisation du monde en fonction de la largeur, la hauteur et le nombre de cases données
	 * @param width
	 * @param height
	 * @param nbSquareX
	 * @param nbSquareY
	 * @param startSquareX
	 * @param startSquareY
	 */
	public World(int width, int height, int nbSquareX, int nbSquareY, int startSquareX, int startSquareY, int chateauX, int chateauY) {
		this.width = width;
		this.height = height;
		this.nbSquareX = nbSquareX;
		this.nbSquareY = nbSquareY;
		squareWidth = (float) 1 / nbSquareX;
		squareHeight = (float) 1 / nbSquareY;

		spawn = new Position(startSquareX * squareWidth + squareWidth / 2, startSquareY * squareHeight + squareHeight / 2);
		chateau = new Position(chateauX * squareWidth + squareWidth / 2, chateauY * squareHeight + squareHeight / 2);

		StdDraw.setCanvasSize(width, height);
		StdDraw.enableDoubleBuffering();
	}

	/*
	 * Definit le background du menu principal du jeu
	 */
	public void drawMenu() {
		StdDraw.picture(0.5, 0.5, "images/menu.png", 1, 1);
		StdDraw.picture(normalizedX(mouseX), normalizedY(mouseY), "images/select.png", squareWidth, squareHeight);
	}
	
	/**
	 * Definit le decors du plateau de jeu.
	 * Represente un village.
	 * --> "images/background.png" est utlise ici.
	 * --> 0.5, 0.5 repr�sente la position.
	 * --> 1, 1 repr�sente la taille.
	 */
	public void drawBackground() {
		StdDraw.picture(0.5, 0.5, "images/background.png", 1, 1);
	}

	/**
	 * Initialise la liste du chemin sur un chemin au hasard parmis la liste de chemins preset.
	 */
	public void randomPath() {
		path = Patern1.pathconstruct();
	}

	/**
	 * Initialise les vagues de monstres.
	 */
	public void waveBuilder(int nbr) {
		monsters = wave1.waveBuild();
	}

	/**
	 * Affiche certaines informations sur l'écran telles que les points de vie du joueur ou son or
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
	}

	/**
	 * Fonction qui récupère le positionnement de la souris et permet d'afficher une image de tour en temps réél
	 *	lorsque le joueur appuie sur une des touches permettant la construction d'une tour.
	 */
	public void drawMouse() {
		float normalizedX = (int)(StdDraw.mouseX() / squareWidth) * squareWidth + squareWidth / 2;
		float normalizedY = (int)(StdDraw.mouseY() / squareHeight) * squareHeight + squareHeight / 2;
		String image = null;
		if(start){
			pMouse.setX(normalizedX);
			pMouse.setY(normalizedY);
		}
		switch (key) {
		case 'a' :
			// TODO Ajouter une image pour représenter une tour d'archers
			if(canCreatTower(pMouse, 50)) StdDraw.picture(normalizedX , normalizedY, "images/Tower/Archery Tower Level 1.png", (1.0/24.0) , (1.0/15.0) );
			break;
		case 'b' :
			// TODO Ajouter une image pour représenter une tour à canon
			if(canCreatTower(pMouse, 60)) StdDraw.picture(normalizedX , normalizedY, "images/Tower/Bomb Tower Level 1.png", (1.0/24.0) , (1.0/15.0) );
			break;
		}
		if (image != null)
			StdDraw.picture(normalizedX, normalizedY, image, squareWidth, squareHeight);
	}

	/**
	 * Pour chaque monstre de la liste de monstres de la vague, utilise la fonction update() qui appelle les fonctions run() et draw() de Monster
	 * --> Modifie la position du monstre grace au parametre nextP et en utilisant la liste du chemin
	 * --> Enleve 1 point de vie au joueur quand un monstre arrive au chateau
	 */
	public void updateMonsters() {
		Iterator<Monster> i = monsters.iterator();
		Monster m;
		while (monsters.size() > 0 && i.hasNext()) {
			m = i.next();
			if(m.getLife() <= 0 ){
				coin += m.getDropCoin();
				monsters.remove(m);
			}
			
			m.update();
			if(path.indexOf(m.getNextP()) < path.size()-1 && casePosition(m))
				m.setNextP(path.get(path.indexOf(m.getNextP())+1));
			if(m.getP().getX() >= chateau.getX()) {
				life--;
				monsters.remove(monsters.indexOf(m));
			}
		}
	}
	
	public boolean casePosition(Monster m) {
	    float mCaseX = (float) (m.getP().getX() - (m.getP().getX() % squareWidth ) + squareWidth / 2.0 );
	    float mCaseY = (float) (m.getP().getY() - (m.getP().getY() % squareHeight ) + squareHeight / 2.0 );
	    Position posM = new Position(mCaseX, mCaseY);

	    float mCaseNextX = (float) (m.getNextP().getX() - (m.getNextP().getX() % squareWidth ) + squareWidth / 2.0);
	    float mCaseNextY = (float) (m.getNextP().getY() - (m.getNextP().getY() % squareHeight ) + squareHeight / 2.0);
	    Position nextPosM = new Position(mCaseNextX, mCaseNextY);
	    
	    if(posM.getX() == nextPosM.getX() && posM.getY() == nextPosM.getY())
	    	return true;
	    return false;
	}
	
	//Met a jour les tours 
	public void updateTowers(){
		for(int i = 0 ; i < tower.size() ; i++){
			tower.get(i).update(monsters);
		}
	}

	/**
	 * Met à jour toutes les informations du plateau de jeu ainsi que les déplacements des monstres et les attaques des tours
	 * @return les points de vie restants du joueur
	 */
	public int update() {
		if(!start) {
			drawMenu();
		}else {
			drawBackground();
			drawInfos();
			updateMonsters();
			updateTowers();
		}
		drawMouse();
		return life;
	}

	/**
	 * Récupère la touche appuyée par l'utilisateur et affiche les informations pour la touche séléctionnée
	 * @param key la touche utilisée par le joueur
	 */
	public void keyPress(char key) {
		key = Character.toLowerCase(key);
		this.key = key;
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
	//verifi qu'il est possible de poser un tour
	public boolean canCreatTower(Position p , int cost){
		for (int i = 0 ; i < path.size(); i++){
			if(p.equalsP(path.get(i))){
				System.out.println("Position impossible ! Vous etes sur le chemin.");
				return false;
			}
		}
		for(int i = 0 ; i < tower.size() ; i++){
			if(p.equalsP(tower.get(i).getP()) ) {
				System.out.println("Position impossible ! Une tour est deja présente");
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
	 * Vérifie lorsque l'utilisateur clique sur sa souris qu'il peut:
	 * 		- Ajouter une tour à la position indiquée par la souris.
	 * 		- Améliorer une tour existante.
	 * Puis l'ajouter à la liste des tours
	 * @param x
	 * @param y
	 */
	public void mouseClick(float x, float y) {
		//dimension d'une case
		float caseWidth = (float)(1.0/24.0);
		float caseHeigth = (float)(1.0/15.0);

		//coordonée du centre de la tour (ici un rectangle)
		float normalizedX = (float) (x - (x % caseWidth) + caseWidth / 2.0);
		float normalizedY = (float) (y  - (y % caseHeigth ) + caseHeigth / 2.0);

		Position pTower = new Position(normalizedX, normalizedY);
		switch (key) {
		case 'a':
			System.out.println("l faut ajouter une tour d'archers si l'utilisateur à de l'or !!");
			if(canCreatTower(pTower, 50)) {
				tower.add(new ArcheryTower(pTower));
				this.coin -= 50 ;
			}
			break;
		case 'b':
			System.out.println("Ici il faut ajouter une tour de bombes");
			if(canCreatTower(pTower, 60)) {
				tower.add(new BombTower(pTower));
				this.coin -= 60;
			}
			break;
		case 'e':
			for(int i = 0 ; i < tower.size() ; i++){
				if(tower.get(i).getP().equalsP(pTower)){
					if(tower.get(i).getUpgradeCost() <= coin )tower.get(i).upgrade();
					else System.out.println("Vous n'avez pas assez d'argent !");
				}
			}
			System.out.println("Ici il est possible de faire évolué une des tours");
			break;
		}
		
		//MOUSE CLICK DANS LE MENU AVANT QUE LA PARTIE DEMARRE
		if(!start) {
			StdDraw.setPenColor(183, 38, 80);
			if(compareNormalized(normalizedX(x), normalizedX(8 * World.getSquareWidth() + World.getSquareWidth() / 2), normalizedY(y), normalizedY(8 * World.getSquareWidth() + World.getSquareWidth() / 2))) {
				mouseX = x;
				mouseY = y;
			} else if(compareNormalized(normalizedX(x), normalizedX(9 * World.getSquareWidth() + World.getSquareWidth() / 2), normalizedY(y), normalizedY(8 * World.getSquareWidth() + World.getSquareWidth() / 2))) {
				mouseX = x;
				mouseY = y;
			} else if(compareNormalized(normalizedX(x), normalizedX(10 * World.getSquareWidth() + World.getSquareWidth() / 2), normalizedY(y), normalizedY(8 * World.getSquareWidth() + World.getSquareWidth() / 2))) {
				mouseX = x;
				mouseY = y;
			} else if(compareNormalized(normalizedX(x), normalizedX(11 * World.getSquareWidth() + World.getSquareWidth() / 2), normalizedY(y), normalizedY(8 * World.getSquareWidth() + World.getSquareWidth() / 2))) {
				mouseX = x;
				mouseY = y;
			} else if(compareNormalized(normalizedX(x), normalizedX(12 * World.getSquareWidth() + World.getSquareWidth() / 2), normalizedY(y), normalizedY(8 * World.getSquareWidth() + World.getSquareWidth() / 2))) {
				mouseX = x;
				mouseY = y;
			} else if(compareNormalized(normalizedX(x), normalizedX(13 * World.getSquareWidth() + World.getSquareWidth() / 2), normalizedY(y), normalizedY(8 * World.getSquareWidth() + World.getSquareWidth() / 2))) {
				mouseX = x;
				mouseY = y;
			} else if(compareNormalized(normalizedX(x), normalizedX(14 * World.getSquareWidth() + World.getSquareWidth() / 2), normalizedY(y), normalizedY(8 * World.getSquareWidth() + World.getSquareWidth() / 2))) {
				mouseX = x;
				mouseY = y;
			} else if(compareNormalized(normalizedX(x), normalizedX(15 * World.getSquareWidth() + World.getSquareWidth() / 2), normalizedY(y), normalizedY(8 * World.getSquareWidth() + World.getSquareWidth() / 2))) {
				mouseX = x;
				mouseY = y;
			}
		}
	}
	
	public float normalizedX(float x) {
		float normalized = (float) (x - (x % squareWidth) + squareWidth / 2.0);
		return normalized;
	}
	
	public float normalizedY(float y) {
		float normalized = (float) (y  - (y % squareHeight ) + squareHeight / 2.0);
		return normalized;
	}

	public boolean compareNormalized(float x, float x2, float y, float y2){
		if(x == x2 && y == y2)
			return true;
		return false;
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
	 * Récupère la touche entrée au clavier ainsi que la position de la souris et met à jour le plateau en fonction de ces interractions
	 */
	public void run() {
		randomPath();
		waveBuilder(1);
		printCommands();
		
		while(!end) {
			
			StdDraw.clear();
			update();
			
			if (StdDraw.hasNextKeyTyped()) {
				keyPress(StdDraw.nextKeyTyped());
			}

			if (StdDraw.isMousePressed()) {
				mouseClick((float)StdDraw.mouseX(),(float)StdDraw.mouseY());
				StdDraw.pause(50);
			}

			StdDraw.show();
		}
	}


}
