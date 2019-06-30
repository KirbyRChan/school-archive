import java.util.Scanner;   // Needed for scanner

/**
 Author: Kirby Chan
 Created: September 18, 2017
 Modified: September 27, 2017
This program welcomes the user and prompts them to enter their name. Then, the program will output a description of what the program will do.
*/

public class P1A1_CHAN_4212452
{
	public static void main(String[] args)
	{
		// Declare variables
        String name;    // User's name
		
        // Creates a scanner for user input
		Scanner keyboard = new Scanner(System.in);
		
        // Prompts the user to enter their name
		System.out.println("Hello, my name is Kirby and welcome to my conversion program.\n");
		System.out.println("What is your name?");
		name = keyboard.nextLine();
		
        // Outputs a brief description of the program
		System.out.println("\nHello " + name + ", this program will allow you to convert days into other measurements of time.\n");
	}
}
