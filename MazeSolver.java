import java.util.*;
import java.io.*;

public class MazeSolver {
	public static void main(String[] args){
		if (args.length == 0) {
			Scanner file = new Scanner(System.in);
			Character[][] mazeArray = MazeReader.mazeElements(file);
			System.out.println(Arrays.deepToString(mazeArray));
		} else {
			Scanner file = null;
	    try 
			{
				file = new Scanner(new File(args[0]));
			} 
			catch (FileNotFoundException e) 
			{
				System.err.println("Cannot locate file.");
				System.exit(-1);
			}
			Character[][] mazeArray = MazeReader.mazeElements(file);
			System.out.println(Arrays.deepToString(mazeArray));
		}
	}
}