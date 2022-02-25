import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) {
    Maze maze = new Maze(MazeReader.mazeElements("maze1.txt"));
    MazeViewer viewer = new MazeViewer(maze);
  }

	public static void testReader() {
		System.out.println(Arrays.deepToString(MazeReader.mazeElements("maze1.txt")));
	}

  public static void testConstructor() 
  {
		Maze testMaze = new Maze(MazeReader.mazeElements("maze1.txt"));
		
		TestCode.beginTest("Mazt Contructor");
    TestCode.subTest("Constructor height", testMaze.getHeight() == 21);
		TestCode.subTest("Constructor weight", testMaze.getWidth() == 27);
    TestCode.concludeTest();
  }

}