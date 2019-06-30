import java.util.Scanner;   // Needed for scanner

/**
 Author: Kirby Chan
 Created: September 18, 2017
 Modified: September 27, 2017
This program welcomes the user and prompts them to enter their name. The user is then prompted to enter a number of days which will be converted and displayed.
*/

public class P1A2_CHAN_4212452
{
	public static void main(String[] args)
	{
		// Declare variables
        String name;    // User's name
		double Days;    // Number of days
		
		//Creates a scanner for user input
        Scanner keyboard = new Scanner(System.in);
		
        // Prompts the user to enter their name
		System.out.println("Hello, my name is Kirby and welcome to my conversion program.\n");
		System.out.println("What is your name?");
		name = keyboard.nextLine();
		
        // Prompts the user to enter a number of days
		System.out.println("\nHello " + name + ", this program will allow you to convert days into other measurements of time.\n");
		System.out.println("How many number of days would you like to convert?");
		Days = keyboard.nextDouble();
		
        // Declare variables for all conversion types
		double Seconds = Days * 86400;
		double Minutes = Days * 1440;
		double Hours = Days * 24;
		double Weeks = Days / 7;
		double Months = Days / 30;
		double Years = Days / 365;
		double Decades = Days / 3650;
		
        // Outputs all the conversions
		System.out.println("\nDays:" + Days);
		System.out.println("Seconds:" + Seconds);
		System.out.println("Minutes:" + Minutes);
		System.out.println("Hours:" + Hours);
		System.out.println("Weeks:" + Weeks);
		System.out.println("Months:" + Months);
		System.out.println("Years:" + Years);
		System.out.println("Decades:" + Decades);
	}
}
		
		
