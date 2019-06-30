import java.util.Scanner;   // Needed for scanner

/**
 Kirby Chan
 Created: October 2, 2017
 Modified October 20, 2017
 This program welcomes the user and prompts them to enter their name. Then, the program will output a brief description of what the program will do.
*/

public class P2A1_CHAN_4212452
{
    public static void main(String[] args)
    {
        // Declare variables
        String name;    // User's name
        
        // Creates a scanner for user input
        Scanner keyboard = new Scanner(System.in);
        
        // Prompts the user to enter their name
        System.out.println("Hello, my name is Kirby and welcome to my miles per hour conversion program.");
        System.out.print("What is your name?: ");
        name = keyboard.nextLine();
        
        // Outputs a brief description of the program
        System.out.println("Welcome " + name + ", this program will allow you to convert convert miles per hours to other measurements of speed.");
    
    }
}
