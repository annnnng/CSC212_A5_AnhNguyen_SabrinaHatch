/**
 *. Maze starter file (fill in your own info)
 */
public class Maze implements DisplayableMaze {

	/** field storing height of maze grid */
	private int height;

	/** field storing width of maze grid */
	private int width;

	/** field storing start position of maze grid */
	private int[] start;

	/** field storing finish position of maze grid */
	private int[] finish;

	/** field storing maze grid */
	private char[][] maze;

	/** constructor for maze */
	public Maze(char[][] mazeArray) { 
		this.height = mazeArray.length;
		this.width = mazeArray[0].length;
		this.start = new int[] {0, 0};
		this.finish = new int[] {12,12};
		this.maze = mazeArray;
	}

	/** @return start location */

	/** @return finish location */
	
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
		if (j < height-1) {
			return MazeContents.OPEN;
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