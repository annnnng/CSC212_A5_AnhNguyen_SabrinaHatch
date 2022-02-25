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
	private int[] start;

	/** field storing finish position of maze grid */
	private int[] finish;

	/** field storing maze grid */
	private MazeContents[][] maze;

	/** @return start location */
	public int[] startPosition(char[][] mazeArray){
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
	public int[] finishPosition(char[][] mazeArray){
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
	public MazeContents[][] mazeArrayToContents(char[][] mazeArray) {
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
	public Maze(char[][] mazeArray) { 
		this.height = mazeArray.length;
		this.width = mazeArray[0].length;
		this.start = startPosition(mazeArray);
		this.finish = finishPosition(mazeArray);
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
		return new MazeLocation(start[0], start[1]);
	}

	/** @return location of maze finish point */
	public MazeLocation getFinish() {
		return new MazeLocation(finish[0], finish[1]);  
	}
}