import java.util.*;
import java.io.*;
/**
 *. Maze starter file (fill in your own info)
 */
public class Maze implements DisplayableMaze {

	/** field storing height of maze grid or number of rows */
	private int height;

	/** field storing width of maze grid or number of columns */
	private int width;

	/** field storing start position of maze grid */
	private MazeLocation start;

	/** field storing finish position of maze grid */
	private MazeLocation finish;

	/** field storing maze grid */
	private MazeContents[][] maze;


	/** @return start location */
	private int[] startPosition(Character[][] mazeArray){
		int[] start = new int[2];
		for (int i = 0; i < mazeArray.length; i++) {
    	for (int j = 0; j < mazeArray[i].length; j++) {
      	if (mazeArray[i][j] == 'S') {
					start[0] = i;
					start[1] = j;
      	}
    	}
 		}
		return start;
	}
	
	/** @return finish location */
	private int[] finishPosition(Character[][] mazeArray){
		int[] finish = new int[2];
		for (int i = 0; i < mazeArray.length; i++) {
    	for (int j = 0; j < mazeArray[i].length; j++) {
      	if (mazeArray[i][j] == 'F') {
					finish[0] = i;
					finish[1] = j;
      	}
    	}
 		}
		return finish;
	}

	/** @return char[][] as MazeContents[][]*/
	private MazeContents[][] mazeArrayToContents(Character[][] mazeArray) {
		MazeContents[][] maze = new MazeContents[mazeArray.length][mazeArray[0].length];
		for (int i = 0; i < mazeArray.length; i++) {
    	for (int j = 0; j < mazeArray[i].length; j++) {
      	char element = mazeArray[i][j];
				if (element == '#') {
					maze[i][j] = MazeContents.WALL;
				} else if (element == '.' || element == 'S' || element == 'F') {
					maze[i][j] = MazeContents.OPEN;
				}
    	}
 		}
		return maze;
	}

	/** constructor for maze */
	public Maze(Character[][] mazeArray) { 
		this.height = mazeArray.length;
		this.width = mazeArray[0].length;
		this.start = new MazeLocation(startPosition(mazeArray)[0], startPosition(mazeArray)[1]);
		this.finish = new MazeLocation(finishPosition(mazeArray)[0], finishPosition(mazeArray)[1]);
		this.maze = mazeArrayToContents(mazeArray);
	}

	/** init */
	
	/** @return height of maze grid */
	public int getHeight() {
		return height;
	}

	/** @return width of maze grid */
	public int getWidth() {
		return width;
	}

	/** @return contents of maze grid at row i, column j */
	public MazeContents getContents(int i, int j) {
		if (i < height && j < width) {
			return maze[i][j];
		} else {
			return MazeContents.WALL;
		}
	}

	/** @return location of maze start point */
	public MazeLocation getStart() {
		return start;
	}

	/** @return location of maze finish point */
	public MazeLocation getFinish() {
		return finish;  
	}

  /**
  * runs the algorithm on the maze and solves it
  * @param 
  * @return boolean that tells you whether the maze is solveable or not
  */
  public boolean mazeAlg(MazeLocation currentPosition)
  {	
		// Delay code to see animation
		try { Thread.sleep(50);	} catch (InterruptedException e) {};
		
		// Base case: if the current postition is at finish point return true
    if (currentPosition.equals(getFinish())) {
      System.out.println("Finished!");
      // Quits program once you are finished and return true.
			return true;
		}
		
		// If NOT, explore neighborhood 
		
		// Check if the current position is explorable, if not go back and choose a different direction.
		if (!maze[currentPosition.getRow()][currentPosition.getCol()].isExplorable) 
		{
			return false;
		}

		// Mark current location as VISITED
		maze[currentPosition.getRow()][currentPosition.getCol()] = MazeContents.VISITED;

		// Since current location is explorable, walking around to find the next place to go

		// Go WEST
		if (currentPosition.getCol() >= 0) // Checks that we can go left, WEST
		{
			// Go WEST
			if (mazeAlg(currentPosition.neighbor(MazeDirection.WEST))) { 
				// Set current position as PATH
				maze[currentPosition.getRow()][currentPosition.getCol()] = MazeContents.PATH; 
				return true;
			}
		}

		// Go EAST
		if (currentPosition.getCol() < width ) // Checks that we can go right, EAST
		{
			// Go EAST
			if (mazeAlg(currentPosition.neighbor(MazeDirection.EAST))) { 
				// Set current position as PATH
				maze[currentPosition.getRow()][currentPosition.getCol()] = MazeContents.PATH;
				return true;
			} else {
				// Set current position as DEAD_END
				maze[currentPosition.getRow()][currentPosition.getCol()] = MazeContents.DEAD_END;
			}
		}

		// Go NORTH
		if (currentPosition.getRow() >= 0) // Check that we can go up, NORTH.
		{
			// Go NORTH
			if (mazeAlg(currentPosition.neighbor(MazeDirection.NORTH))) { 
				// Set current position as PATH
				maze[currentPosition.getRow()][currentPosition.getCol()] = MazeContents.PATH;
				return true;
			} else {
				// Set current position as DEAD_END
				maze[currentPosition.getRow()][currentPosition.getCol()] = MazeContents.DEAD_END;
			}
		}  

		// Go SOUTH
		if (currentPosition.getRow() <  height) // Check that we can go down, SOUTH.
		{
			// Go SOUTH
			if (mazeAlg(currentPosition.neighbor(MazeDirection.SOUTH))) { 
				// Set current position as PATH
				maze[currentPosition.getRow()][currentPosition.getCol()] = MazeContents.PATH;
				return true;
			} else {
				// Set current position as DEAD_END
				maze[currentPosition.getRow()][currentPosition.getCol()] = MazeContents.DEAD_END;
			}
		} 

		// Neighborhood is blocked, backtrack to most recent recursion
		return false;
  }
	
	public void solveMaze() {
		boolean existPath = mazeAlg(start);
		if (existPath) {
			System.out.println("There exist a path!");
		} else {
			System.out.println("No path found");
		}
	}
	
}