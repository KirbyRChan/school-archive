/*
	Exercise2.java
	- WRITE A SINGLE DO LOOP THAT DOES THE FOLLOWING UNTIL THE USER ENTERS AN INT IN 1..100 INCLUSIVE
	- 	USE TRY CATCH TO READ AN INT FROM THE KBD SUCH THAT IF USER ENTERS "FOO" IT DOES NOT CRACH
	- 	DON'T THROW AN EXCEPTIOn OR ATTEMPT TO CATCH ONE FOR THE CASE OF USER ENTERING AN VALID 
	-		INT THAT HAPPENS TO BE OUT OF RANGE.

*/
import java.io.*;
import java.util.*;

public class Exercise2
{
	public static void main( String args[] )
	{
		// MODIFY, REPLACE, ADD LOOP CODE, ADD TRY CATCH BLOCK(S) AS NEEDED BELOW
		
		Scanner kbd = new Scanner(System.in);
		boolean valid = false;
		int number = 0;
		do
		{
			try
			{
				System.out.print("Enter int in range 1..100 inclusive: ");
				number = kbd.nextInt();

				if (number < 0 || number > 100)
					System.out.println("Number out of range.  Must be in 1..100");
				else
					valid = true;
			}
			catch (InputMismatchException e)
			{
				System.out.println("Input was not an integer");
				kbd.nextLine();
			}
			
		} while(!valid);
		
		System.out.println();
		System.out.format("Thank you. You entered %d\n", number );
		
	} //END main
} //END CLSS