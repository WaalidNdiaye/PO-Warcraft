package warcraftPath;

import java.util.LinkedList;
import java.util.List;

import warcraftMain.Position;
import warcraftMain.World;

public class Patern1 {
	
	/*
	 * Constructeur du chemin Patern1
	 * chemin de premiere vague
	 */
	public static List<Position> pathconstruct() {
		List<Position> path = new LinkedList<Position>();
		for(int i=0; i<24; i++)
			path.add(new Position(i * World.getSquareWidth() + World.getSquareWidth() / 2, 7 * World.getSquareHeight() + World.getSquareHeight() / 2));
		return path;
	}
	
}
