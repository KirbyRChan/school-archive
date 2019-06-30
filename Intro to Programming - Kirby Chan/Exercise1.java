import java.io.*;
import java.util.*;
public class Exercise1
{
	public static void main( String args[] ) 
	{
		if (args.length < 1)
		{
			System.out.println("\nYou must enter an input filename on cmd line!\n");
			System.exit(0);
		}
		
		Scanner infile = null;
		boolean valid = false;
		do
		{
			try
			{
				infile = new Scanner( new File( args[0] ) );
				valid = true;
			}
			catch ( FileNotFoundException e )
			{
				System.out.print(args[0] + " not found. Enter a valid filename: ");
				
				Scanner kbd = new Scanner(System.in);
				args[0] = kbd.nextLine();
			}
		} while (!valid);

		while (infile.hasNext())
		{
			String token = infile.next();
			System.out.printf("%s\n", token);
		}
	}
} //END CLASS