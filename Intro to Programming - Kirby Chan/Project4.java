/* Project 4 Jumble */
import java.util.*;
import java.io.*;

public class Project4
{
	public static void main( String args[] ) throws Exception
	{
		if (args.length < 2)
		{
			System.out.println("\nusage: C:\\> java Lab4 dictionary.txt jumbles.txt\n");
			System.exit(0);
		}

		BufferedReader dList = new BufferedReader( new FileReader(args[0]));
		ArrayList<String> pairs = new ArrayList<String>();

		String word;
		String canon;

		while (dList.ready())
		{
			word = dList.readLine();
			canon = canonical(word);
			pairs.add( canon + " " + word );
		}
		Collections.sort(pairs);

		ArrayList<String> dCanons = new ArrayList<String>();
		ArrayList<String> dWords = new ArrayList<String>();

		for(int i=0; i<pairs.size(); i++)
		{
			word = pairs.get(i);
			String[] pair = word.split("\\s+");

			dCanons.add( pair[0] );
			dWords.add( pair[1] );
		}

		BufferedReader jList = new BufferedReader( new FileReader(args[1]));
		ArrayList<String> jWords = new ArrayList<String>();

		while (jList.ready())
		{
			word = jList.readLine();
			jWords.add(word);
		}
		Collections.sort(jWords);

		for(int i=0; i<jWords.size(); i++)
		{
			word = jWords.get(i);
			System.out.print( word + " ");
			String jCanon = canonical(word);
			int index = Collections.binarySearch( dCanons, jCanon );
			
			if (index >= 0)
			{
				while(jCanon.equals(dCanons.get(index)))
					index--;
				index++;

				for(int j = index; jCanon.equals(dCanons.get(j)); j++)
					System.out.print(dWords.get(j) + " ");
			}
			System.out.print("\n");
		}


	}

	private static String canonical (String word)
	{
		char[] letters = word.toCharArray();
		Arrays.sort(letters);

		return new String(letters);
	}
}