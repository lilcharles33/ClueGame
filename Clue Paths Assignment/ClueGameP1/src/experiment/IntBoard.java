// authors: Cameron Kuan and Nathan Beveridge

package experiment;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IntBoard {

	private HashMap<BoardCell, Set<BoardCell>> adjMtx;
	private Set<BoardCell> targets;
	private Set<BoardCell> visited;
	private BoardCell[][] grid;
	private final static int ROWS = 4;
	private final static int COLS = 4;
	
	public IntBoard() {

	}
	
	public void calcAdjacencies() {

	}
	
	public Set<BoardCell> getAdjList(BoardCell cell) {
		return new HashSet<BoardCell>();

	}
	
	public void calcTargets(BoardCell startCell, int pathLength) {
	}
	
	public Set<BoardCell> getTargets() {
		return new HashSet<BoardCell>();
	}

	public BoardCell getCell(int row, int col) {
		return grid[row][col];
	}
}






