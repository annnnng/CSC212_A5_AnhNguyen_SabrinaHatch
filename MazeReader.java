import java.util.*;
import java.io.*;
/**
 *. Reading maze file and return 2D arrays containing maze contents.
 */
public class MazeReader {
	public static int[] mazeRowAndCol(String filename) 
  {
		Scanner file = null;
		int nrow = 0;
    int ncol = 0;
		try 
		{
			file = new Scanner(new File(filename));
		} 
		catch (FileNotFoundException e) 
		{
			System.err.println("Cannot locate file.");
			System.exit(-1);
		}
		while (file.hasNextLine()) 
		{
			//take each line n CSV and save to line
			String line = file.nextLine();
			nrow = nrow + 1;
			ncol = line.length();
		}
		file.close();
    int[] mazeSize = new int[] {nrow, ncol};
    return mazeSize;
	}
	
  public static char[][] mazeElements(String filename)
  {
		int[] mazeSize = mazeRowAndCol(filename);
    int numRows = mazeSize[0];
    int numCols = mazeSize[1];
    char mazeElements[][] = new char[numRows][numCols];

    Scanner file = null;

    try 
		{
			file = new Scanner(new File(filename));
		} 
		catch (FileNotFoundException e) 
		{
			System.err.println("Cannot locate file.");
			System.exit(-1);
		}
		int currentRow = -1;
		while (file.hasNextLine()) 
		{
			currentRow = currentRow + 1;
			String line = file.nextLine();
			char[] lineElements = new char[numCols];
      for (int i = 0; i < line.length(); i++) {
				lineElements[i] = line.charAt(i);
			}
			mazeElements[currentRow] = lineElements;
		}
    return mazeElements;
  }
}