/* Lab 4 Jumble */
import java.util.*;
import java.io.*;

public class Lab4
{
	public static void main( String args[] ) throws Exception
	{
		if (args.length < 1)
		{
			System.out.println("\nusage: C:\\> java Lab4 jumbles.txt\n");
			System.exit(0);
		}

		BufferedReader inFile = new BufferedReader( new FileReader(args[0]));
		ArrayList<String> words = new ArrayList<String>();

		while (inFile.ready())
		{
			String line = inFile.readLine();
			words.add(line);
		}

		Collections.sort(words);

		for(int i=0; i < words.size(); i++)
		{
			String canonicalForm = canonical(words.get(i));
			System.out.println(words.get(i) + " " + canonicalForm);
		}
	}

	private static String canonical (String word)
	{
		char[] letters = word.toCharArray();
		Arrays.sort(letters);

		return new String(letters);
	}
}