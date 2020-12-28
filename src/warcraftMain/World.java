package warcraftMain;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import warcraftMonster.BaseMonster;
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
	private static double squareWidth;									// Largeur des cases
	private static double squareHeight;									// Hauteur des cases

	private ArrayList<Monster> monsters = new ArrayList<Monster>();		// Liste des monstres, pour gerer (notamment) l'affichage
	public List<Position> path;											// Liste des des positions du chemin utilis� durant la vague
	private ArrayList <Tower> tower = new ArrayList<Tower>();			// Liste des tours sur le plateau 
	private static Position spawn;										// Position par laquelle les monstres vont venir
	private Position chateau;											// Position du chateau 
	private int life = 20;												// Nombre de points de vie du joueur
	private char key;													// Commande sur laquelle le joueur appuie (sur le clavier)
	private boolean end = false;										// Condition pour terminer la partie
	private int coin = 150;												// Argent (pour acheter les tours)

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
	public static double getSquareWidth() {
		return squareWidth;
	}
	public static double getSquareHeight() {
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
		squareWidth = (double) 1 / nbSquareX;
		squareHeight = (double) 1 / nbSquareY;

		spawn = new Position(startSquareX * squareWidth + squareWidth / 2, startSquareY * squareHeight + squareHeight / 2);
		chateau = new Position(chateauX * squareWidth + squareWidth / 2, chateauY * squareHeight + squareHeight / 2);

		StdDraw.setCanvasSize(width, height);
		StdDraw.enableDoubleBuffering();
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
	public void waveBuilder() {
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
		StdDraw.text(0.95, 0.95, String.valueOf(life));
	}
	public void drawCoin() {
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(0.95, 0.90 , String.valueOf(coin));
	}

	/**
	 * Fonction qui récupère le positionnement de la souris et permet d'afficher une image de tour en temps réél
	 *	lorsque le joueur appuie sur une des touches permettant la construction d'une tour.
	 */
	public void drawMouse() {
		double normalizedX = (int)(StdDraw.mouseX() / squareWidth) * squareWidth + squareWidth / 2;
		double normalizedY = (int)(StdDraw.mouseY() / squareHeight) * squareHeight + squareHeight / 2;
		String image = null;
		switch (key) {
		case 'a' :
			// TODO Ajouter une image pour représenter une tour d'archers
			break;
		case 'b' :
			// TODO Ajouter une image pour représenter une tour à canon
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
			if(path.indexOf(m.getNextP()) < path.size()-1)
				m.setNextP(path.get(path.indexOf(m.getNextP())+1));
			if(m.getP().getX() >= chateau.getX()) {
				life--;
				monsters.remove(monsters.indexOf(m));
			}
		}
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
		drawBackground();
		drawInfos();
		updateMonsters();
		updateTowers();
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
			System.out.println("Arrow Tower selected (50g).");
			break;
		case 'b':
			System.out.println("Bomb Tower selected (60g).");
			break;
		case 'e':
			System.out.println("Evolution selected (40g).");
			break;
		case 's':
			System.out.println("Starting game!");
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
	public void mouseClick(double x, double y) {
		//dimension d'une case
		double caseWidth = (1.0/24.0);
		double caseHeigth = (1.0/15.0);

		y = y - 0.04;

		//coordonée du centre de la tour (ici un rectangle)
		double normalizedX = x - (x % caseWidth ) + caseWidth / 2.0;
		double normalizedY = y  - (y % caseHeigth ) + caseHeigth / 2.0  ;

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
			System.out.println("Ici il est possible de faire évolué une des tours");
			break;
		}
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
		waveBuilder();
		printCommands();
		System.out.println(wave1.waveBuild());
		while(!end) {

			StdDraw.clear();
			if (StdDraw.hasNextKeyTyped()) {
				keyPress(StdDraw.nextKeyTyped());
			}

			if (StdDraw.isMousePressed()) {
				mouseClick(StdDraw.mouseX(), StdDraw.mouseY());
				StdDraw.pause(50);
			}

			update();
			StdDraw.show();
			StdDraw.pause(20);
		}
	}


}
