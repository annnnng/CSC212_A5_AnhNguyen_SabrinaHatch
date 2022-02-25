import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) {
    Maze maze = new Maze(MazeReader.mazeElements("maze1.txt"));
    MazeViewer viewer = new MazeViewer(maze);
		//System.out.println(Arrays.deepToString(MazeReader.mazeElements("maze1.txt")));
  }
}