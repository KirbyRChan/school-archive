import java.io.*;
import java.util.*;

// DO NOT!! IMPORT JAVA.LANG

public class Swamp
{
	private static int[][] loadSwamp( String infileName, int[] dropInPt  ) throws Exception
	{
		File swampFile = new File(infileName);
		Scanner swampInput = new Scanner(swampFile);

		String[] s = swampInput.nextLine().split(" ");

		int n = Integer.parseInt(s[0]);
		int[][] swamp = new int[n][n];

		dropInPt[0] = Integer.parseInt(s[1]);
		dropInPt[1] = Integer.parseInt(s[2]);

		for (int r = 0; r < swamp.length; r++)
        {
        	s = swampInput.nextLine().split(" ");
        	
        	for (int c = 0; c < s.length; c++)
            {
            	swamp[r][c] = Integer.parseInt(s[c]);
            }
         }

         swampInput.close();
         return swamp;
	}
	public static void main(String[] args) throws Exception
	{
		int[] dropInPt = new int[2]; // row and col will be on the 2nd line of input file;
		int[][] swamp = loadSwamp( args[0], dropInPt );
		int row=dropInPt[0], col = dropInPt[1];		
		String path = ""; // with each grows to => "[2,3][3,4][3,5][4,6]" etc 
		depthFirstSearch( swamp, row, col, path );
	} // END MAIN

	static void depthFirstSearch( int[][] swamp, int r, int c, String path )
	{
		path = path + "["+r+","+c+"]";
		if (r == 0 || c == 0 || r == swamp.length-1 || c == swamp[r].length-1)
		{
			System.out.println(path);
			return;
		}
		
		if (swamp[r-1][c] == 1)
		{
			swamp[r][c] = -1;
			depthFirstSearch(swamp, r-1, c, path);
			swamp[r][c] = 1;
		}
		if (swamp[r-1][c+1] == 1)
		{
			swamp[r][c] = -1;
			depthFirstSearch(swamp, r-1, c+1, path);
			swamp[r][c] = 1;
		}
		if (swamp[r][c+1] == 1)
		{
			swamp[r][c] = -1;
			depthFirstSearch(swamp, r, c+1, path);
			swamp[r][c] = 1;
		}
		if (swamp[r+1][c+1] == 1)
		{
			swamp[r][c] = -1;
			depthFirstSearch(swamp, r+1, c+1, path);
			swamp[r][c] = 1;
		}
		if (swamp[r+1][c] == 1)
		{
			swamp[r][c] = -1;
			depthFirstSearch(swamp, r+1, c, path);
			swamp[r][c] = 1;
		}
		if (swamp[r+1][c-1] == 1)
		{
			swamp[r][c] = -1;
			depthFirstSearch(swamp, r+1, c-1, path);
			swamp[r][c] = 1;
		}
		if (swamp[r][c-1] == 1)
		{
			swamp[r][c] = -1;
			depthFirstSearch(swamp, r, c-1, path);
			swamp[r][c] = 1;
		}
		if (swamp[r-1][c-1] == 1)
		{
			swamp[r][c] = -1;
			depthFirstSearch(swamp, r-1, c-1, path);
			swamp[r][c] = 1;
		}
		return;
	} // END DFS
}