import java.util.Scanner;   // Needed for scanner

/**
 Kirby Chan
 Created: October 2, 2017
 Modified October 20, 2017
 This program welcomes the user and prompts them to enter their name. Then, the program will output a brief description of what the program will do. The program will convert the inputed mph to barleycorns/day, furlongs/fortnight, mach number, and speed of light.
 */

public class P2A2_CHAN_4212452
{
    public static void main(String[] args)
    {
        // Declare variables
        String Name;    // User's name
        double mph;     // Miles per hour
        
        // Creates a scanner for user input
        Scanner keyboard = new Scanner(System.in);
        
        // Prompts the user to enter their name
        System.out.println("Hello, my name is Kirby and welcome to my miles per hour conversion program.");
        System.out.print("What is your name? ");
        Name = keyboard.nextLine();
        
        // Outputs a brief description of the program
        System.out.println("Welcome " + Name + ", this program will allow you to convert convert miles per hours to other measurements of speed.");
        
        // Prompts the user to enter a value for miles per hour
        System.out.print("How many miles per hour would you like to convert?: ");
        mph = keyboard.nextDouble();
        
        double bpd = mph * 1609.34 * 24 * 117.647;  // Barleycorns/day
        double flfn = mph * 1760 * 24 * 7 * 2 * (1/220.0); // Furlongs/fortnight
        double mn = mph * 5280 * (1/60.0) * (1/60.0) * (1/1130.0);   // Mach number
        double sol = mph * 1609.34 * (1/60.0) * (1/60.0) * (1/299792458.0);  // % of Speed of light
        
        // Outputs all the conversions
        System.out.println("Days = " + bpd + " barleycorns/day");
        System.out.println("Days = " + flfn + " furlongs/fortnight");
        System.out.println("Days = Mach " + mn);
        System.out.println("Days = " + sol + "%");
    
    }
}

