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
		grid = new BoardCell[ROWS][COLS];
		for(int i = 0; i < ROWS; i++) {
			for(int j = 0; j < COLS; j++) {
				grid[i][j] = new BoardCell(i,j);
			}
		}
		adjMtx = new HashMap<BoardCell, Set<BoardCell>>();
		targets = new HashSet<BoardCell>();
		visited = new HashSet<BoardCell>();
	}
	
	public void calcAdjacencies() {
		for(int i = 0; i < ROWS; i++) {
			for(int j = 0; j < COLS; j++) {
				Set<BoardCell> grid2 = new HashSet<BoardCell>();
				if(i + 1 <= 3) {
					grid2.add(grid[i + 1][j]);
				}
				if(j + 1 <= 3) {
					grid2.add(grid[i][j + 1]);
				}
				if(i - 1 >= 0) {
					grid2.add(grid[i - 1][j]);
				}
				if(j - 1 >= 0) {
					grid2.add(grid[i][j - 1]);
				}
				adjMtx.put(grid[i][j], grid2);
			}
		}
	}
	
	public Set<BoardCell> getAdjList(BoardCell cell) {
		return adjMtx.get(cell);
	}
	
	public void calcTargets(BoardCell startCell, int pathLength) {
		visited.add(startCell);
		if(pathLength == 0) {
			targets.add(startCell);
			return;
		}
		Set<BoardCell> grid3 = new HashSet<BoardCell>();
		grid3 = adjMtx.get(startCell);
		for(BoardCell b : grid3) {
			if(visited.contains(b)) {
				continue;
			}
			visited.add(b);
			calcTargets(b, pathLength - 1);
			visited.remove(b);
		}
	}
	
	public Set<BoardCell> getTargets() {
		return targets;
	}

	public BoardCell getCell(int row, int col) {
		return grid[row][col];
	}
}






