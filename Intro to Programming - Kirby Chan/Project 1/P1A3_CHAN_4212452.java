import java.util.Scanner;   // Needed for scanner

/**
 Author: Kirby Chan
 Created: September 18, 2017
 Modified: September 27, 2017
This program welcomes the user and prompts them to enter their name. The user is then prompted to enter a number of days and choose what they what they would like to convert the number of days to. The program will output the conversion and ask the user if they would like to perform another conversion.
*/

public class P1A3_CHAN_4212452
{
	public static void main(String[] args)
	{
		// Declare variables
        String Name;    //  User's name
		double Days;    //  Number of days
        int Number;     //  Conversion type
        int Repeat;    //  Allows the program to loop or not
        
		//Creates a scanner for user input
        Scanner keyboard = new Scanner(System.in);
		
        //  Prompts the user to enter their name
		System.out.println("Hello, my name is Kirby and welcome to my conversion program.\n");
        System.out.println("What is your name?");
		Name = keyboard.nextLine();
		
        do
        {
            // Prompts the user to enter a number of days
            System.out.println("\nHello " + Name + ", this program will allow you to convert days into other measurements of time.");
            System.out.println("\nHow many number of days would you like to convert?");
            Days = keyboard.nextDouble();
            
            // Prompts the user to choose a conversion type
            System.out.println("What would you like to convert the number of days too (type its corresponding number)?\n" +
                               "(1) Seconds\n" +
                               "(2) Minutes\n" +
                               "(3) Hours\n" +
                               "(4) Weeks\n" +
                               "(5) Months\n" +
                               "(6) Years\n" +
                               "(7) Decades");
            Number = keyboard.nextInt();

            // Declares a variable and outputs a conversion depending on what the user entered
            if (Number == 1)
            {
                // The user chooses seconds
                double Seconds = Days * 86400;
                System.out.println("\n" + Days + " day(s) is equal to " + Seconds + " second(s).\n");
            }
            else if (Number == 2)
            {
                // The user chooses minutes
                double Minutes = Days * 1440;
                System.out.println("\n" + Days + " days(s) is equal to " + Minutes + " minute(s).\n");
            }
            else if (Number == 3)
            {
                // The user chooses hours
                double Hours = Days * 24;
                System.out.println("\n" + Days + " day(s) is equal to " + Hours + " hour(s).\n");
            }
            else if (Number == 4)
            {
                // The user chooses weeks
                double Weeks = Days / 7;
                System.out.println("\n" + Days + " day(s) is equal to " + Weeks + " week(s).\n");
            }
            else if (Number == 5)
            {
                // The user chooses months
                double Months = Days / 30;
                System.out.println("\n" + Days + " day(s) is equal to " + Months + " months(s).\n");
            }
            else if (Number == 6)
            {
                // The user chooses years
                double Years = Days / 365;
                System.out.println("\n" + Days + " day(s) is equal to " + Years + " year(s).\n");
            }
            else if (Number == 7)
            {
                // The user chooses decades
                double Decades = Days / 3650;
                System.out.println("\n" + Days + " day(s) is equal to " + Decades + " decade(s).\n");
            }
            
            // Outputs an error if the user enters an unspecified number
            else
            {
                System.out.println("\nError, please enter one of the listed numbers.\n");
            }
            
            // Prompts the user to choose whether they want to enter another conversion or exit the program
            System.out.println("Would you like to see another conversion?\n" +
                               "(1) Yes" +
                               "(2) No");
            Repeat = keyboard.nextInt();
            
            // Prompts the user to enter another number if neither (1) or (2) are chosen
            while (Repeat != 1 && Repeat != 2)
            {
                System.out.println("Please choose either (1) Yes or (2) No.");
                Repeat = keyboard.nextInt();
            }
       } while (Repeat == 1);   // Program loops if user chooses yes, program ends if user chooses no
        
        System.out.println("Have a nice day.\n");
	}
}
		
		
