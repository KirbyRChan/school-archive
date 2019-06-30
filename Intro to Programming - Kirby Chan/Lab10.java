import java.io.*;
import java.util.*;

public class Lab10
{
	public static void main(String[] args) throws Exception
	{
		File file = new File(args[0]);
		Scanner fileInput = new Scanner(file);

		HashSet<String> words = new HashSet<String>();
		boolean unique = true;
		
		while (fileInput.hasNextLine() && unique)
			if ( !words.add( fileInput.nextLine() ) )
			{
				System.out.println("NOT UNIQUE");
				unique = false;
			}
		if (unique)
			System.out.println("UNIQUE");
	}
}