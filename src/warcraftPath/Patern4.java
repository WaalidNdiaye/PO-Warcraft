package warcraftPath;

import java.util.LinkedList;
import java.util.List;

import warcraftMain.Position;
import warcraftMain.World;

public class Patern4 {
	
	/*
	 * Constructeur du chemin Patern4
	 * chemin des vagues intermediaire, ordre genere aleatoirement
	 */
	public static List<Position> pathconstruct() {
		List<Position> path = new LinkedList<Position>();
		path.add(new Position(0 * World.getSquareWidth() + World.getSquareWidth() / 2, 7 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(1 * World.getSquareWidth() + World.getSquareWidth() / 2, 7 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(2 * World.getSquareWidth() + World.getSquareWidth() / 2, 7 * World.getSquareHeight() + World.getSquareHeight() / 2));
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
		path.add(new Position(21 * World.getSquareWidth() + World.getSquareWidth() / 2, 7 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(22 * World.getSquareWidth() + World.getSquareWidth() / 2, 7 * World.getSquareHeight() + World.getSquareHeight() / 2));
		path.add(new Position(23 * World.getSquareWidth() + World.getSquareWidth() / 2, 7 * World.getSquareHeight() + World.getSquareHeight() / 2));

		return path;
	}
	
}
