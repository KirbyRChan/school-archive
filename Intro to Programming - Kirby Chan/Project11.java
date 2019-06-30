import java.io.*;
import java.util.*;

public class Project11
{
	public static void main( String args[] )
	{
		Scanner kbd = new Scanner(System.in);
		boolean valid = false;
		int number = 0;
		do
		{
			System.out.print("Enter int in range 1..100 inclusive: ");

			try
			{
				number = kbd.nextInt();

				if (number < 0 || number > 100)
					throw new NumberOutOfRangeException();
				else
					valid = true;
			}
			catch (InputMismatchException e)
			{
				System.out.println("Input was not an integer");
				kbd.nextLine();
			}
			catch (NumberOutOfRangeException e)
			{
				kbd.nextLine();
			}
			catch (Exception e)
			{
				System.out.println(e);
				System.exit(0);
			}
			
		} while(!valid);
		
		System.out.println();
		System.out.format("Thank you. You entered %d\n", number );
		
	}
}
class NumberOutOfRangeException extends Exception
{
	public NumberOutOfRangeException()
	{
		System.out.println("Number out of range. Must be in 1..100 ");
	}

}