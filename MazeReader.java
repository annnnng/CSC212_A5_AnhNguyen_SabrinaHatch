import java.util.*;
/**
 *. Reading maze file and return 2D arrays containing maze contents.
 */
public class MazeReader {
	
	public static Character[][] mazeElements(Scanner file)
  {
   ArrayList<Character[]> mazeList = new ArrayList<Character[]>();
		
		while (file.hasNextLine()) 
		{
			String line = file.nextLine();
			ArrayList<Character> mazeRow = new ArrayList<Character>();
      for (int i = 0; i < line.length(); i++) {
				mazeRow.add(line.charAt(i));
			}
			Character[] arrayRow = mazeRow.toArray(new Character[mazeRow.size()]);
			mazeList.add(arrayRow);
		}
		Character[][] arrayMatrix = mazeList.toArray(new Character[mazeList.size()][]);
    return arrayMatrix;
  }
}