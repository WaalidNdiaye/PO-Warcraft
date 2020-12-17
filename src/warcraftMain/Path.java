package warcraftMain;

import java.util.LinkedList;
import java.util.List;

public class Path {
	
	public List <Position> path = new LinkedList<Position>();
	
	public Path(Position p) {
		path.add(p);
	}
	
}
