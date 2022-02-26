import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) {
		Scanner file = null;
		try 
		{
			file = new Scanner(new File("maze2.txt"));
		} 
		catch (FileNotFoundException e) 
		{
			System.err.println("Cannot locate file.");
			System.exit(-1);
		}
    Maze maze = new Maze(MazeReader.mazeElements(file));
    MazeViewer viewer = new MazeViewer(maze);
		maze.solveMaze();
  }
}