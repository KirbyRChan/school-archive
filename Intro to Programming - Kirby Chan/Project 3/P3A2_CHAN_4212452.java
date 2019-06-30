import java.util.Scanner;
import java.util.Random;

/**
 Author: Kirby Chan
 Created: October 23, 2017
 Modified: November 11, 2017
 This program simulates a dice game called "Zig, Zag, Zoom." The user is prompted to enter their name and are then given a description of the program does. The game will then begin and generate a random number with four dice. Depending on what number they rolled, they will either win, lose, or continue to roll. Once the game ends, the program asks the user if they would like to play again.
 */

public class P3A2_CHAN_4212452
{
    public static void main(String[] args)
    {
        //Creates a scanner object
        Scanner kbd = new Scanner(System.in);
    
        int replay;     //To replay the game
        
        //Prompts the user to enter their name
        System.out.print("Welcome to Zig, Zag, Zoom! What is your name?: ");
        String name = kbd.nextLine();
        
        //Calls the Welcome method
        Welcome(name);
        
        //Repeats if the user chooses to play the game again
        do
        {
            //Calls the method for the dice game
            diceGame();
            
            //Asks the user if they want to play the game again
            System.out.println("Would you like to play again?" +
                               "\n(1)Yes" +
                               "\n(2)No");
            replay = kbd.nextInt();
        } while (replay == 1);
        
        System.out.println("Have a good day.");
    }
    
    //Outputs a description of the game
    public static void Welcome(String user)
    {
        System.out.println("Welcome " + user + "! My name is Kirby and in this game, you will testing your luck in a game of dice. You will start by rolling 4 dice.\nIf you roll a 6, 12, 18, or 24, you win!\nIf you roll a 9, 11, 17, 19, or 23, you lose.\nIf you didn't roll any of the previously mentioned numbers, you will continue to roll the dice until you roll your original number to win the game or roll an 11 to lose.");
    }
    
    //Actual dice game
    public static void diceGame()
    {
        //Creates a scanner object and random object to generate dice rolls
        Scanner enter = new Scanner(System.in);
        Random rdm = new Random();
        
        System.out.println("Press enter to start.");
        enter.nextLine();
        
        int startRoll;      //Starting roll
        int roll;           //Dice rolls after the first
        
        //Generates four random dice rolls and adds them together for the starting roll
        startRoll = rdm.nextInt(6) + rdm.nextInt(6) + rdm.nextInt(6) + rdm.nextInt(6) + 4;
        
        //If the starting roll is a 6, 12, 18, 24, the user wins
        if (startRoll == 6 || startRoll == 12 || startRoll == 18 || startRoll == 24)
        {
            System.out.println("You rolled a(n) " + startRoll + ", you win!");
        }
        
        //If the starting roll is a 9, 11, 17, 18, or 23, the user loses
        else if (startRoll == 9 || startRoll == 11 || startRoll == 17 || startRoll == 19 || startRoll == 23)
        {
            System.out.println("You rolled a(n) " + startRoll + ", you lose.");
        }
        
        //If the starting roll isn't a winning roll, the user continues to roll
        else
        {
            System.out.println("You rolled a(n) " + startRoll + ". You will have to roll another " + startRoll + " to win.");
            System.out.println("Press enter to continue.");
            enter.nextLine();
            
            //Continues to loop until the user wins or loses
            do
            {
                //Generates four random dice rolls and adds them together for a roll
                roll = rdm.nextInt(6) + rdm.nextInt(6) + rdm.nextInt(6) + rdm.nextInt(6) + 4;
                
                //If the roll is the same as the starting roll, the user wins
                if (roll == startRoll)
                {
                    System.out.println("You rolled a(n) " + roll + ", you win!");
                }
                
                //If the roll is 11, the user loses
                else if (roll == 11)
                {
                    System.out.println("You rolled an 11, you lose.");
                }
                
                //If the roll isn't the same as the starting roll or 11, the user rolls again
                else
                {
                    System.out.println("You rolled a " + roll + ", you are aiming for " + startRoll + ".");
                    System.out.println("Press enter to continue.");
                    enter.nextLine();
                }
            } while (roll != 11 && roll != startRoll);
        }
    }
}
