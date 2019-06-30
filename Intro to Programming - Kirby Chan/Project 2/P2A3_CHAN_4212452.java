import java.util.Scanner;   // Needed for scanner

/**
 Kirby Chan
 Created: October 2, 2017
 Modified October 20, 2017
 This program welcomes the user and prompts them to enter their name. Then, the program will output a brief description of what the program will do. The user will be prompted to enter a value for mph and choose what they would like to convert the inputed mph to. The program will then prompt the user to make another conversion or exit the program.
 */

public class P2A3_CHAN_4212452
{
    public static void main(String[] args)
    {
        // Declare variables
        String Name;    // User's name
        double mph;     // Miles per hour
        int Number;     // Conversion Type
        int Repeat;     // Allows the program to loop or not
        
        // Creates a scanner for user input
        Scanner keyboard = new Scanner(System.in);
        
        // Prompts the user to enter their name
        System.out.println("Hello, my name is Kirby and welcome to my miles per hour conversion program.");
        System.out.print("What is your name? ");
        Name = keyboard.nextLine();
        
        // Outputs a brief description of the program
        System.out.println("Welcome " + Name + ", this program will allow you to convert convert miles per hours to other measurements of speed.");
        do
        {
            // Prompts the user to enter a value for miles per hour
            System.out.print("How many miles per hour would you like to convert?: ");
            mph = keyboard.nextDouble();
            
            // Prompts the user to choose a conversion type
            System.out.println("What would you like to convert the number of days to (type its corresponding number)?\n" +
                               "(1) Barleycorns/Day\n" +
                               "(2) Furlongs/Fortnight\n" +
                               "(3) Mach Number\n" +
                               "(4) Speed of Light %");
            Number = keyboard.nextInt();
            
            // Declares a variable and outputs a conversion depending on what the user entered
            if (Number == 1)
            {
                // The user chooses barleycorns/day
                double bpd = mph * 1609.34 * 24 * 117.647;
                System.out.println("Days = " + bpd + " barleycorns/day");
            }
            else if (Number == 2)
            {
                // The user chooses furlongs/fortnight
                double flfn = mph * 1760 * 24 * 7 * 2 * (1/220.0);
                System.out.println("Days = " + flfn + " furlongs/fortnight");
            }
            else if (Number == 3)
            {
                // The user chooses mach number
                double mn = mph * 5280 * (1/60.0) * (1/60.0) * (1/1130.0);
                System.out.println("Days = Mach " + mn);
            }
            else if (Number == 4)
            {
                // The user chooses speed of light %
                double sol = mph * 1609.34 * (1/60.0) * (1/60.0) * (1/299792458.0);
                System.out.println("Days = " + sol + "%");
            }
            // Prompts the user to choose whether they want to enter another conversion or exit the program
            System.out.print("Would you like to see another conversion?\n" +
                               "(1) Yes or (2) No: " );
            Repeat = keyboard.nextInt();
            
            // Prompts the user to enter another number if neither (1) or (2) are chosen
            while (Repeat != 1 && Repeat != 2)
            {
                System.out.print("Please choose either (1) Yes or (2) No: ");
                Repeat = keyboard.nextInt();
            }
        } while (Repeat == 1);
        
        System.out.println("Have a nice day.");
    }
}

